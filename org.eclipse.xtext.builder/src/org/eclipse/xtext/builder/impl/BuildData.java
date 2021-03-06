/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Collection;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuildData {

	private final ToBeBuilt toBeBuilt;
	private final QueuedBuildData queuedBuildData;
	private final String projectName;
	private final ResourceSet resourceSet;
	private final boolean indexingOnly;
	private final SourceLevelURICache sourceLevelURICache;
	
	/**
	 * Encapsulates how a builder can trigger a rebuild.
	 * @since 2.17
	 */
	private final Runnable buildRequestor;
	
	public BuildData(String projectName, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData) {
		this(projectName, resourceSet, toBeBuilt, queuedBuildData, false);
	}
	
	public BuildData(String projectName, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData, boolean indexingOnly) {
		this(projectName, resourceSet, toBeBuilt, queuedBuildData, indexingOnly, BuildManagerAccess::requestBuild);
	}
	
	/**
	 * @since 2.17
	 */
	public BuildData(String projectName, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData, boolean indexingOnly, Runnable buildRequestor) {
		this.projectName = projectName;
		this.resourceSet = resourceSet;
		this.toBeBuilt = toBeBuilt;
		this.queuedBuildData = queuedBuildData;
		this.indexingOnly = indexingOnly;
		this.sourceLevelURICache = new SourceLevelURICache();
		this.buildRequestor = buildRequestor;
	}

	public boolean isEmpty() {
		return getToBeDeleted().isEmpty() && getToBeUpdated().isEmpty() && queuedBuildData.isEmpty(projectName);
	}
	
	public boolean isIndexingOnly() {
		return indexingOnly;
	}

	public Set<URI> getToBeDeleted() {
		return toBeBuilt.getToBeDeleted();
	}

	public Set<URI> getToBeUpdated() {
		return toBeBuilt.getToBeUpdated();
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Set<URI> getAndRemoveToBeDeleted() {
		Set<URI> result = toBeBuilt.getAndRemoveToBeDeleted();
        return result;
	}

	public void queueURI(URI uri) {
		queuedBuildData.queueURI(uri);
	}

	public Collection<IResourceDescription.Delta> getAndRemovePendingDeltas() {
		return queuedBuildData.getAndRemovePendingDeltas();
	}

	public Queue<URI> getURIQueue() {
		return queuedBuildData.getQueue(projectName);
	}
	
	public Iterable<URI> getAllRemainingURIs() {
		return queuedBuildData.getAllRemainingURIs();
	}
	
	public String getProjectName() {
		return projectName;
	}

	public SourceLevelURICache getSourceLevelURICache() {
		return sourceLevelURICache;
	}
	
	/**
	 * @since 2.17
	 */
	public void requestRebuild() {
		buildRequestor.run();
	}
}

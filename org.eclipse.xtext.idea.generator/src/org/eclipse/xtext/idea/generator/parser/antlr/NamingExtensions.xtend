/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.generator.parser.antlr

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming
import static extension org.eclipse.xtext.GrammarUtil.*

@Singleton
class NamingExtensions {

	@Inject
	extension Naming
	
	def String getGrammarFileName(Grammar it, String prefix) 
		'''«parserPackage».«prefix»Internal«getSimpleName(it)»'''
		
	def String getInternalParserClassName(Grammar it)
		'''«parserPackage».Internal«getSimpleName(it)»Parser'''
		
	def String getParserPackage(Grammar it)
		'''«basePackageRuntime».idea.parser.antlr.internal'''

}

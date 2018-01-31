/*
 * generated by Xtext */
package org.eclipse.xtext.example.homeautomation.ui;

import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.example.homeautomation.ui.internal.HomeautomationActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class RuleEngineExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(HomeautomationActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		HomeautomationActivator activator = HomeautomationActivator.getInstance();
		return activator != null ? activator.getInjector(HomeautomationActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_HOMEAUTOMATION_RULEENGINE) : null;
	}

}
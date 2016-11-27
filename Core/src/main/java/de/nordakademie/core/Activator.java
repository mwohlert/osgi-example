package de.nordakademie.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    Core core;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("CoreActivator::start");
        core = new Core(context);
        core.startThread();

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("CoreActivator stopped");
        core.stopThread();
    }

}

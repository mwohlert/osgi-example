package de.nordakademie.messageimpl;

import de.nordakademie.message.Message;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("MessageImpl2Activator::start");
        context.registerService(Message.class.getName(), new MessageImpl(), null);
        System.out.println("MessageImpl2Activator::registration of Hello service successful");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        context.ungetService(context.getServiceReference(Message.class.getName()));
        System.out.println("MessageImpl2Activator stopped");
    }

}

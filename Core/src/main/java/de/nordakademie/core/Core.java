package de.nordakademie.core;

import de.nordakademie.message.Message;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class Core {

    private BundleContext context;
    private Thread backgroundThread;

    public Core(BundleContext context){
        this.context = context;
    }


    public void startThread(){
        backgroundThread = new Thread(() -> {
            while(!this.backgroundThread.isInterrupted()) {
                System.out.println("\n---\nLOOP START\n---\n");
                try {
                    ServiceReference<Message>[] serviceReferences = (ServiceReference<Message>[]) context.getServiceReferences(Message.class.getName(), null);
                    if (serviceReferences != null) {
                        for (ServiceReference<Message> serviceReference : serviceReferences) {
                            System.out.println(((Message) context.getService(serviceReference)).getMessage());
                        }
                    }
                } catch (InvalidSyntaxException e) {
                    e.printStackTrace();
                }
                System.out.println("\n---\nLOOP END\n---\n");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignore) {
                }
            }
        });
        backgroundThread.start();
    }

    public void stopThread(){
        this.backgroundThread.interrupt();
    }
}

package fr.inria.phoenix.diasuite.framework.controller.transportercontroller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.bike_availability.Bike_availabilityValue;

/**
 * <pre>
controller TransporterController{
 * 	when provided Bike_availability
 * 	do SendMessage on Mailer;    
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractTransporterController extends Service {
    
    public AbstractTransporterController(ServiceConfiguration serviceConfiguration) {
        super("/Controller/TransporterController/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("bike_availability", "/Context/Bike_availability/"); // subscribe to Bike_availability context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("bike_availability") && source.isCompatible("/Context/Bike_availability/")) {
            Bike_availabilityValue bike_availabilityValue = new Bike_availabilityValue((java.lang.String) value);
            
            onBike_availability(bike_availabilityValue, new DiscoverForBike_availability());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>Bike_availability</code> context publishes a value.
     * 
     * <pre>
     * when provided Bike_availability
     * 	do SendMessage on Mailer;
     * </pre>
     * 
     * @param bike_availability the value of the <code>Bike_availability</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onBike_availability(Bike_availabilityValue bike_availability, DiscoverForBike_availability discover);
    
    // End of interaction contract implementation
    
    // Discover object for Bike_availability
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided Bike_availability
     * 	do SendMessage on Mailer;
     * </code>
     */
    protected final class DiscoverForBike_availability {
        private final MailerDiscovererForBike_availability mailerDiscoverer = new MailerDiscovererForBike_availability(AbstractTransporterController.this);
        
        /**
         * @return a {@link MailerDiscovererForBike_availability} object to discover <code>Mailer</code> devices
         */
        public MailerDiscovererForBike_availability mailers() {
            return mailerDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Mailer</code> devices to execute action on for the
     * <code>when provided Bike_availability</code> interaction contract.
    
    <pre>
    device Mailer extends CommunicationService {
     * }
    </pre>
     */
    protected final static class MailerDiscovererForBike_availability {
        private Service serviceParent;
        
        private MailerDiscovererForBike_availability(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private MailerCompositeForBike_availability instantiateComposite() {
            return new MailerCompositeForBike_availability(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Mailer</code> devices
         * 
         * @return a {@link MailerCompositeForBike_availability} object composed of all discoverable <code>Mailer</code>
         */
        public MailerCompositeForBike_availability all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Mailer</code> devices
         * 
         * @return a {@link MailerProxyForBike_availability} object pointing to a random discoverable <code>Mailer</code> device
         */
        public MailerProxyForBike_availability anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Mailer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link MailerCompositeForBike_availability} object composed of all matching <code>Mailer</code> devices
         */
        public MailerCompositeForBike_availability whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Mailer</code> devices to execute action on for the
     * <code>when provided Bike_availability</code> interaction contract.
    
    <pre>
    device Mailer extends CommunicationService {
     * }
    </pre>
     */
    protected final static class MailerCompositeForBike_availability extends fr.inria.diagen.core.service.composite.Composite<MailerProxyForBike_availability> {
        private MailerCompositeForBike_availability(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/CommunicationService/Mailer/");
        }
        
        @Override
        protected MailerProxyForBike_availability instantiateProxy(RemoteServiceInfo rsi) {
            return new MailerProxyForBike_availability(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link MailerCompositeForBike_availability}, filtered using the attribute <code>id</code>.
         */
        public MailerCompositeForBike_availability andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Executes the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> action's method on all devices of this composite.
         * 
         * @param to the <code>to</code> parameter of the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> method.
         * @param title the <code>title</code> parameter of the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> method.
         * @param content the <code>content</code> parameter of the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> method.
         * @param attachments the <code>attachments</code> parameter of the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> method.
         */
        public void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) throws InvocationException {
            launchDiscovering();
            for (MailerProxyForBike_availability proxy : proxies) {
                proxy.sendMessage(to, title, content, attachments);
            }
        }
        
        /**
         * Executes the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> action's method on all devices of this composite.
         * 
         * @param to the <code>to</code> parameter of the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> method.
         * @param title the <code>title</code> parameter of the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> method.
         * @param content the <code>content</code> parameter of the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> method.
         * @param image the <code>image</code> parameter of the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> method.
         */
        public void sendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.lang.String image) throws InvocationException {
            launchDiscovering();
            for (MailerProxyForBike_availability proxy : proxies) {
                proxy.sendMessageWithImage(to, title, content, image);
            }
        }
    }
    
    /**
     * A proxy to one <code>Mailer</code> device to execute action on for the
     * <code>when provided Bike_availability</code> interaction contract.
    
    <pre>
    device Mailer extends CommunicationService {
     * }
    </pre>
     */
    protected final static class MailerProxyForBike_availability extends Proxy {
        private MailerProxyForBike_availability(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> action's method on this device.
         * 
         * @param to the <code>to</code> parameter of the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> method.
         * @param title the <code>title</code> parameter of the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> method.
         * @param content the <code>content</code> parameter of the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> method.
         * @param attachments the <code>attachments</code> parameter of the <code>sendMessage(to as Contact, title as String, content as String, attachments as File[])</code> method.
         */
        public void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) throws InvocationException {
            callOrder("sendMessage", to, title, content, attachments);
        }
        
        /**
         * Executes the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> action's method on this device.
         * 
         * @param to the <code>to</code> parameter of the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> method.
         * @param title the <code>title</code> parameter of the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> method.
         * @param content the <code>content</code> parameter of the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> method.
         * @param image the <code>image</code> parameter of the <code>sendMessageWithImage(to as Contact, title as String, content as String, image as String)</code> method.
         */
        public void sendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.lang.String image) throws InvocationException {
            callOrder("sendMessageWithImage", to, title, content, image);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover object for Bike_availability
}

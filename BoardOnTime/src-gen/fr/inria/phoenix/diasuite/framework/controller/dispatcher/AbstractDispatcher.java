package fr.inria.phoenix.diasuite.framework.controller.dispatcher;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.incidentdetection.IncidentDetectionValue;
import fr.inria.phoenix.diasuite.framework.context.journeyselection.JourneySelectionValue;

/**
 * BoardOnTime controller

<pre>
controller Dispatcher {
 * 	when provided  JourneySelection
 * 	do SendMessage on Messenger;  
 * 	when provided  IncidentDetection
 * 	do Notification on Notifier;     
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractDispatcher extends Service {
    
    public AbstractDispatcher(ServiceConfiguration serviceConfiguration) {
        super("/Controller/Dispatcher/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("incidentDetection", "/Context/IncidentDetection/"); // subscribe to IncidentDetection context
        subscribeValue("journeySelection", "/Context/JourneySelection/"); // subscribe to JourneySelection context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("incidentDetection") && source.isCompatible("/Context/IncidentDetection/")) {
            IncidentDetectionValue incidentDetectionValue = new IncidentDetectionValue((java.lang.Boolean) value);
            
            onIncidentDetection(incidentDetectionValue, new DiscoverForIncidentDetection());
        }
        if (eventName.equals("journeySelection") && source.isCompatible("/Context/JourneySelection/")) {
            JourneySelectionValue journeySelectionValue = new JourneySelectionValue((java.lang.String) value);
            
            onJourneySelection(journeySelectionValue, new DiscoverForJourneySelection());
        }
    }
    // End of methods from the Service class
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>JourneySelection</code> context publishes a value.
     * 
     * <pre>
     * when provided  JourneySelection
     * 	do SendMessage on Messenger;
     * </pre>
     * 
     * @param journeySelection the value of the <code>JourneySelection</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onJourneySelection(JourneySelectionValue journeySelection, DiscoverForJourneySelection discover);
    
    /**
     * This method is called when the <code>IncidentDetection</code> context publishes a value.
     * 
     * <pre>
     * when provided  IncidentDetection
     * 	do Notification on Notifier;
     * </pre>
     * 
     * @param incidentDetection the value of the <code>IncidentDetection</code> context.
     * @param discover a discover object to get context values and action methods
     */
    protected abstract void onIncidentDetection(IncidentDetectionValue incidentDetection, DiscoverForIncidentDetection discover);
    
    // End of interaction contract implementation
    
    // Discover object for JourneySelection
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided  JourneySelection
     * 	do SendMessage on Messenger;
     * </code>
     */
    protected final class DiscoverForJourneySelection {
        private final MessengerDiscovererForJourneySelection messengerDiscoverer = new MessengerDiscovererForJourneySelection(AbstractDispatcher.this);
        
        /**
         * @return a {@link MessengerDiscovererForJourneySelection} object to discover <code>Messenger</code> devices
         */
        public MessengerDiscovererForJourneySelection messengers() {
            return messengerDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Messenger</code> devices to execute action on for the
     * <code>when provided JourneySelection</code> interaction contract.
    <p>
    ------------------
    MESSENGERS
    ------------------------------------
    attribute modality as Modality;
    
    <pre>
    device Messenger extends PhysicalDevice {
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerDiscovererForJourneySelection {
        private Service serviceParent;
        
        private MessengerDiscovererForJourneySelection(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private MessengerCompositeForJourneySelection instantiateComposite() {
            return new MessengerCompositeForJourneySelection(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices
         * 
         * @return a {@link MessengerCompositeForJourneySelection} object composed of all discoverable <code>Messenger</code>
         */
        public MessengerCompositeForJourneySelection all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Messenger</code> devices
         * 
         * @return a {@link MessengerProxyForJourneySelection} object pointing to a random discoverable <code>Messenger</code> device
         */
        public MessengerProxyForJourneySelection anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link MessengerCompositeForJourneySelection} object composed of all matching <code>Messenger</code> devices
         */
        public MessengerCompositeForJourneySelection whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link MessengerCompositeForJourneySelection} object composed of all matching <code>Messenger</code> devices
         */
        public MessengerCompositeForJourneySelection whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Messenger</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link MessengerCompositeForJourneySelection} object composed of all matching <code>Messenger</code> devices
         */
        public MessengerCompositeForJourneySelection whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Messenger</code> devices to execute action on for the
     * <code>when provided JourneySelection</code> interaction contract.
    <p>
    ------------------
    MESSENGERS
    ------------------------------------
    attribute modality as Modality;
    
    <pre>
    device Messenger extends PhysicalDevice {
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerCompositeForJourneySelection extends fr.inria.diagen.core.service.composite.Composite<MessengerProxyForJourneySelection> {
        private MessengerCompositeForJourneySelection(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Messenger/");
        }
        
        @Override
        protected MessengerProxyForJourneySelection instantiateProxy(RemoteServiceInfo rsi) {
            return new MessengerProxyForJourneySelection(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link MessengerCompositeForJourneySelection}, filtered using the attribute <code>id</code>.
         */
        public MessengerCompositeForJourneySelection andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link MessengerCompositeForJourneySelection}, filtered using the attribute <code>location</code>.
         */
        public MessengerCompositeForJourneySelection andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link MessengerCompositeForJourneySelection}, filtered using the attribute <code>user</code>.
         */
        public MessengerCompositeForJourneySelection andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
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
            for (MessengerProxyForJourneySelection proxy : proxies) {
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
            for (MessengerProxyForJourneySelection proxy : proxies) {
                proxy.sendMessageWithImage(to, title, content, image);
            }
        }
    }
    
    /**
     * A proxy to one <code>Messenger</code> device to execute action on for the
     * <code>when provided JourneySelection</code> interaction contract.
    <p>
    ------------------
    MESSENGERS
    ------------------------------------
    attribute modality as Modality;
    
    <pre>
    device Messenger extends PhysicalDevice {
     * 	action SendMessage;
     * }
    </pre>
     */
    protected final static class MessengerProxyForJourneySelection extends Proxy {
        private MessengerProxyForJourneySelection(Service service, RemoteServiceInfo remoteServiceInfo) {
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
        
        /**
         * @return the value of the <code>location</code> attribute
         */
        public java.lang.String location() {
            return (java.lang.String) callGetValue("location");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
    // End of discover object for JourneySelection
    
    // Discover object for IncidentDetection
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided  IncidentDetection
     * 	do Notification on Notifier;
     * </code>
     */
    protected final class DiscoverForIncidentDetection {
        private final NotifierDiscovererForIncidentDetection notifierDiscoverer = new NotifierDiscovererForIncidentDetection(AbstractDispatcher.this);
        
        /**
         * @return a {@link NotifierDiscovererForIncidentDetection} object to discover <code>Notifier</code> devices
         */
        public NotifierDiscovererForIncidentDetection notifiers() {
            return notifierDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>Notifier</code> devices to execute action on for the
     * <code>when provided IncidentDetection</code> interaction contract.
    
    <pre>
    device Notifier extends PhysicalDevice {
     * 	action Notification;	
     * }
    </pre>
     */
    protected final static class NotifierDiscovererForIncidentDetection {
        private Service serviceParent;
        
        private NotifierDiscovererForIncidentDetection(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NotifierCompositeForIncidentDetection instantiateComposite() {
            return new NotifierCompositeForIncidentDetection(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierCompositeForIncidentDetection} object composed of all discoverable <code>Notifier</code>
         */
        public NotifierCompositeForIncidentDetection all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Notifier</code> devices
         * 
         * @return a {@link NotifierProxyForIncidentDetection} object pointing to a random discoverable <code>Notifier</code> device
         */
        public NotifierProxyForIncidentDetection anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NotifierCompositeForIncidentDetection} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForIncidentDetection whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link NotifierCompositeForIncidentDetection} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForIncidentDetection whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Notifier</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link NotifierCompositeForIncidentDetection} object composed of all matching <code>Notifier</code> devices
         */
        public NotifierCompositeForIncidentDetection whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Notifier</code> devices to execute action on for the
     * <code>when provided IncidentDetection</code> interaction contract.
    
    <pre>
    device Notifier extends PhysicalDevice {
     * 	action Notification;	
     * }
    </pre>
     */
    protected final static class NotifierCompositeForIncidentDetection extends fr.inria.diagen.core.service.composite.Composite<NotifierProxyForIncidentDetection> {
        private NotifierCompositeForIncidentDetection(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Notifier/");
        }
        
        @Override
        protected NotifierProxyForIncidentDetection instantiateProxy(RemoteServiceInfo rsi) {
            return new NotifierProxyForIncidentDetection(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NotifierCompositeForIncidentDetection}, filtered using the attribute <code>id</code>.
         */
        public NotifierCompositeForIncidentDetection andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link NotifierCompositeForIncidentDetection}, filtered using the attribute <code>location</code>.
         */
        public NotifierCompositeForIncidentDetection andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link NotifierCompositeForIncidentDetection}, filtered using the attribute <code>user</code>.
         */
        public NotifierCompositeForIncidentDetection andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Executes the <code>notify(level as NotificationLevel)</code> action's method on all devices of this composite.
         * 
         * @param level the <code>level</code> parameter of the <code>notify(level as NotificationLevel)</code> method.
         */
        public void notify(fr.inria.phoenix.diasuite.framework.datatype.notificationlevel.NotificationLevel level) throws InvocationException {
            launchDiscovering();
            for (NotifierProxyForIncidentDetection proxy : proxies) {
                proxy.notify(level);
            }
        }
    }
    
    /**
     * A proxy to one <code>Notifier</code> device to execute action on for the
     * <code>when provided IncidentDetection</code> interaction contract.
    
    <pre>
    device Notifier extends PhysicalDevice {
     * 	action Notification;	
     * }
    </pre>
     */
    protected final static class NotifierProxyForIncidentDetection extends Proxy {
        private NotifierProxyForIncidentDetection(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Executes the <code>notify(level as NotificationLevel)</code> action's method on this device.
         * 
         * @param level the <code>level</code> parameter of the <code>notify(level as NotificationLevel)</code> method.
         */
        public void notify(fr.inria.phoenix.diasuite.framework.datatype.notificationlevel.NotificationLevel level) throws InvocationException {
            callOrder("notify", level);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>location</code> attribute
         */
        public java.lang.String location() {
            return (java.lang.String) callGetValue("location");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
    // End of discover object for IncidentDetection
}

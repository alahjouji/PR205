package fr.inria.phoenix.diasuite.framework.context.journeycomputer;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.device.prompter.AnswerFromPrompter;

/**
 * context 1

<pre>
context JourneyComputer as Sending {
 *     when provided answer from Prompter
 *     get GpsConversion, journeys from NavitiaWS
 *     always publish;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractJourneyComputer extends Service {
    
    public AbstractJourneyComputer(ServiceConfiguration serviceConfiguration) {
        super("/Context/JourneyComputer/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @Override
    protected void postInitialize() {
        // Default implementation of post initialize: subscribe to all required devices
        discoverPrompterForSubscribe.all().subscribeAnswer(); // subscribe to answer from all Prompter devices
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("answer") && source.isCompatible("/Device/Device/PhysicalDevice/Prompter/")) {
            AnswerFromPrompter answerFromPrompter = new AnswerFromPrompter(this, source, (java.lang.String) value,
                    (java.lang.String) indexes[0]);
            
            setJourneyComputer(onAnswerFromPrompter(answerFromPrompter, new DiscoverForAnswerFromPrompter()));
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("journeyComputer")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private fr.inria.phoenix.diasuite.framework.datatype.sending.Sending contextValue;
    
    private void setJourneyComputer(fr.inria.phoenix.diasuite.framework.datatype.sending.Sending newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "journeyComputer", newContextValue);
    }
    
    /**
     * Get the last value of the context
     * 
     * @return the latest value published by the context
     */
    protected final fr.inria.phoenix.diasuite.framework.datatype.sending.Sending getLastValue() {
        return contextValue;
    }
    // End of code relative to the return value of the context
    
    // Interaction contract implementation
    /**
     * This method is called when a <code>Prompter</code> device on which we have subscribed publish on its <code>answer</code> source.
    
    <pre>
    when provided answer from Prompter
     *     get GpsConversion, journeys from NavitiaWS
     *     always publish;
    </pre>
     * 
     * @param answerFromPrompter the value of the <code>answer</code> source and the <code>Prompter</code> device that published the value.
     * @param discover a discover object to get value from devices and contexts
     * @return the value to publish
     */
    protected abstract fr.inria.phoenix.diasuite.framework.datatype.sending.Sending onAnswerFromPrompter(AnswerFromPrompter answerFromPrompter, DiscoverForAnswerFromPrompter discover);
    
    // End of interaction contract implementation
    
    // Discover part for Prompter devices
    /**
     * Use this object to discover Prompter devices.
    
    <pre>
    device Prompter extends PhysicalDevice {
     * 	action AskQuestion;
     * 	source answer as String indexed by questionId as String;
     * }
    </pre>
     * 
     * @see PrompterDiscoverer
     */
    protected final PrompterDiscoverer discoverPrompterForSubscribe = new PrompterDiscoverer(this);
    
    /**
     * Discover object that will exposes the <code>Prompter</code> devices that can be discovered
    
    <pre>
    device Prompter extends PhysicalDevice {
     * 	action AskQuestion;
     * 	source answer as String indexed by questionId as String;
     * }
    </pre>
     */
    protected final static class PrompterDiscoverer {
        private Service serviceParent;
        
        private PrompterDiscoverer(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private PrompterComposite instantiateComposite() {
            return new PrompterComposite(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Prompter</code> devices
         * 
         * @return a {@link PrompterComposite} object composed of all discoverable <code>Prompter</code>
         */
        public PrompterComposite all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Prompter</code> devices
         * 
         * @return a {@link PrompterProxy} object pointing to a random discoverable <code>Prompter</code> device
         */
        public PrompterProxy anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Prompter</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link PrompterComposite} object composed of all matching <code>Prompter</code> devices
         */
        public PrompterComposite whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
        
        /**
         * Returns a composite of all accessible <code>Prompter</code> devices whose attribute <code>location</code> matches a given value.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return a {@link PrompterComposite} object composed of all matching <code>Prompter</code> devices
         */
        public PrompterComposite whereLocation(java.lang.String location) throws CompositeException {
            return instantiateComposite().andLocation(location);
        }
        
        /**
         * Returns a composite of all accessible <code>Prompter</code> devices whose attribute <code>user</code> matches a given value.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return a {@link PrompterComposite} object composed of all matching <code>Prompter</code> devices
         */
        public PrompterComposite whereUser(java.lang.String user) throws CompositeException {
            return instantiateComposite().andUser(user);
        }
    }
    
    /**
     * A composite of several <code>Prompter</code> devices
    
    <pre>
    device Prompter extends PhysicalDevice {
     * 	action AskQuestion;
     * 	source answer as String indexed by questionId as String;
     * }
    </pre>
     */
    protected final static class PrompterComposite extends fr.inria.diagen.core.service.composite.Composite<PrompterProxy> {
        private PrompterComposite(Service serviceParent) {
            super(serviceParent, "/Device/Device/PhysicalDevice/Prompter/");
        }
        
        @Override
        protected PrompterProxy instantiateProxy(RemoteServiceInfo rsi) {
            return new PrompterProxy(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link PrompterComposite}, filtered using the attribute <code>id</code>.
         */
        public PrompterComposite andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>location</code>.
         * 
         * @param location The <code>location<code> attribute value to match.
         * @return this {@link PrompterComposite}, filtered using the attribute <code>location</code>.
         */
        public PrompterComposite andLocation(java.lang.String location) throws CompositeException {
            filterByAttribute("location", location);
            return this;
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>user</code>.
         * 
         * @param user The <code>user<code> attribute value to match.
         * @return this {@link PrompterComposite}, filtered using the attribute <code>user</code>.
         */
        public PrompterComposite andUser(java.lang.String user) throws CompositeException {
            filterByAttribute("user", user);
            return this;
        }
        
        /**
         * Subscribes to the <code>answer</code> source. After a call to this method, the context will be notified when a
         * <code>Prompter</code> device of this composite publishes a value on its <code>answer</code> source.
         */
        public void subscribeAnswer() {
            subscribeValue("answer");
        }
        
        /**
         * Unsubscribes from the <code>answer</code> source. After a call to this method, the context will no more be notified
         * when a <code>Prompter</code> device of this composite publishes a value on its <code>answer</code> source.
         */
        public void unsubscribeAnswer() {
            unsubscribeValue("answer");
        }
    }
    
    /**
     * A proxy to one <code>Prompter</code> device
    
    <pre>
    device Prompter extends PhysicalDevice {
     * 	action AskQuestion;
     * 	source answer as String indexed by questionId as String;
     * }
    </pre>
     */
    protected final static class PrompterProxy extends Proxy {
        private PrompterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subscribes to the <code>answer</code> source. After a call to this method, the context will be notified when the
         * <code>Prompter</code> device of this proxy publishes a value on its <code>answer</code> source.
         */
        public void subscribeAnswer() {
            subscribeValue("answer");
        }
        
        /**
         * Unsubscribes from the <code>answer</code> source. After a call to this method, the context will no more be notified
         * when the <code>Prompter</code> device of this proxy publishes a value on its <code>answer</code> source.
         */
        public void unsubscribeAnswer() {
            unsubscribeValue("answer");
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
    // End of discover part for Prompter devices
    
    // Discover object for answer from Prompter
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided answer from Prompter
     *     get GpsConversion, journeys from NavitiaWS
     *     always publish;
     * </code>
     */
    protected final class DiscoverForAnswerFromPrompter {
        private final NavitiaWSDiscovererForAnswerFromPrompter navitiaWSDiscoverer = new NavitiaWSDiscovererForAnswerFromPrompter(AbstractJourneyComputer.this);
        private final fr.inria.diagen.core.service.filter.service.ServiceFilter gpsConversionFilter = new fr.inria.diagen.core.service.filter.service.ServiceFilter("/Context/GpsConversion/");
        
        private RemoteServiceInfo getGpsConversionRsi() {
            return getProcessor().discoverComponents(getOutProperties(), gpsConversionFilter).get(0);
        }
        
        /**
         * @return a {@link NavitiaWSDiscovererForAnswerFromPrompter} object to discover <code>NavitiaWS</code> devices
         */
        public NavitiaWSDiscovererForAnswerFromPrompter navitiaWSs() {
            return navitiaWSDiscoverer;
        }
        
        /**
         * Get the value of the <code>GpsConversion</code> context
         * 
         * @return the value of the <code>GpsConversion</code> context
         */
        public fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates gpsConversion() {
            return (fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates) getProcessor().callGetValue(getOutProperties(), getGpsConversionRsi(), "gpsConversion");
        }
    }
    
    /**
     * Discover object that will exposes the <code>NavitiaWS</code> devices to get their sources for the
     * <code>when provided answer from Prompter</code> interaction contract.
    
    <pre>
    device NavitiaWS extends Device {
     * 	source journeys as Sending indexed by filter as String;
     * }
    </pre>
     */
    protected final static class NavitiaWSDiscovererForAnswerFromPrompter {
        private Service serviceParent;
        
        private NavitiaWSDiscovererForAnswerFromPrompter(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private NavitiaWSCompositeForAnswerFromPrompter instantiateComposite() {
            return new NavitiaWSCompositeForAnswerFromPrompter(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>NavitiaWS</code> devices
         * 
         * @return a {@link NavitiaWSCompositeForAnswerFromPrompter} object composed of all discoverable <code>NavitiaWS</code>
         */
        public NavitiaWSCompositeForAnswerFromPrompter all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>NavitiaWS</code> devices
         * 
         * @return a {@link NavitiaWSProxyForAnswerFromPrompter} object pointing to a random discoverable <code>NavitiaWS</code> device
         */
        public NavitiaWSProxyForAnswerFromPrompter anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>NavitiaWS</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link NavitiaWSCompositeForAnswerFromPrompter} object composed of all matching <code>NavitiaWS</code> devices
         */
        public NavitiaWSCompositeForAnswerFromPrompter whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>NavitiaWS</code> devices to get their sources for the
     * <code>when provided answer from Prompter</code> interaction contract.
    
    <pre>
    device NavitiaWS extends Device {
     * 	source journeys as Sending indexed by filter as String;
     * }
    </pre>
     */
    protected final static class NavitiaWSCompositeForAnswerFromPrompter extends fr.inria.diagen.core.service.composite.Composite<NavitiaWSProxyForAnswerFromPrompter> {
        private NavitiaWSCompositeForAnswerFromPrompter(Service serviceParent) {
            super(serviceParent, "/Device/Device/NavitiaWS/");
        }
        
        @Override
        protected NavitiaWSProxyForAnswerFromPrompter instantiateProxy(RemoteServiceInfo rsi) {
            return new NavitiaWSProxyForAnswerFromPrompter(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link NavitiaWSCompositeForAnswerFromPrompter}, filtered using the attribute <code>id</code>.
         */
        public NavitiaWSCompositeForAnswerFromPrompter andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
    }
    
    /**
     * A proxy to one <code>NavitiaWS</code> device to get its sources for the
     * <code>when provided answer from Prompter</code> interaction contract.
    
    <pre>
    device NavitiaWS extends Device {
     * 	source journeys as Sending indexed by filter as String;
     * }
    </pre>
     */
    protected final static class NavitiaWSProxyForAnswerFromPrompter extends Proxy {
        private NavitiaWSProxyForAnswerFromPrompter(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Returns the value of the <code>journeys</code> source of this <code>NavitiaWS</code> device
         * 
         * @param filter the value of the <code>filter</code> index.
         * @return the value of the <code>journeys</code> source
         */
        public fr.inria.phoenix.diasuite.framework.datatype.sending.Sending getJourneys(java.lang.String filter) throws InvocationException {
            return (fr.inria.phoenix.diasuite.framework.datatype.sending.Sending) callGetValue("journeys", filter);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover object for answer from Prompter
}

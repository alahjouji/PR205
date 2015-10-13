package fr.inria.phoenix.diasuite.framework.context.bike_availability;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.bikechecker.BikeCheckerValue;

/**
 * context 4

<pre>
context Bike_availability as String{
 *     when provided BikeChecker
 *     get bikes from BordeauxMetropole
 *     maybe publish;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractBike_availability extends Service {
    
    public AbstractBike_availability(ServiceConfiguration serviceConfiguration) {
        super("/Context/Bike_availability/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("bikeChecker", "/Context/BikeChecker/"); // subscribe to BikeChecker context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("bikeChecker") && source.isCompatible("/Context/BikeChecker/")) {
            BikeCheckerValue bikeCheckerValue = new BikeCheckerValue((java.lang.String) value);
            
            Bike_availabilityValuePublishable returnValue = onBikeChecker(bikeCheckerValue, new DiscoverForBikeChecker());
            if(returnValue != null && returnValue.doPublish()) {
                setBike_availability(returnValue.getValue());
            }
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("bike_availability")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private java.lang.String contextValue;
    
    private void setBike_availability(java.lang.String newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "bike_availability", newContextValue);
    }
    
    /**
     * Get the last value of the context
     * 
     * @return the latest value published by the context
     */
    protected final java.lang.String getLastValue() {
        return contextValue;
    }
    
    /**
     * A class that represents a value that might be published for the <code>Bike_availability</code> context. It is used by
     * event methods that might or might not publish values for this context.
     */
    protected final static class Bike_availabilityValuePublishable {
        
        // The value of the context
        private java.lang.String value;
        // Whether the value should be published or not
        private boolean doPublish;
        
        public Bike_availabilityValuePublishable(java.lang.String value, boolean doPublish) {
            this.value = value;
            this.doPublish = doPublish;
        }
        
        /**
         * @return the value of the context that might be published
         */
        public java.lang.String getValue() {
            return value;
        }
        
        /**
         * Sets the value that might be published
         * 
         * @param value the value that will be published if {@link #doPublish()} returns true
         */
        public void setValue(java.lang.String value) {
            this.value = value;
        }
        
        /**
         * @return true if the value should be published
         */
        public boolean doPublish() {
            return doPublish;
        }
        
        /**
         * Set the value to be publishable or not
         * 
         * @param doPublish if true, the value will be published
         */
        public void setDoPublish(boolean doPublish) {
            this.doPublish = doPublish;
        }
    }
    // End of code relative to the return value of the context
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>BikeChecker</code> context publishes a value.
    
    <pre>
    when provided BikeChecker
     *     get bikes from BordeauxMetropole
     *     maybe publish;
    </pre>
     * 
     * @param bikeCheckerValue the value of the <code>BikeChecker</code> context.
     * @param discover a discover object to get value from devices and contexts
     * @return a {@link Bike_availabilityValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract Bike_availabilityValuePublishable onBikeChecker(BikeCheckerValue bikeCheckerValue, DiscoverForBikeChecker discover);
    
    // End of interaction contract implementation
    
    // Discover object for BikeChecker
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided BikeChecker
     *     get bikes from BordeauxMetropole
     *     maybe publish;
     * </code>
     */
    protected final class DiscoverForBikeChecker {
        private final BordeauxMetropoleDiscovererForBikeChecker bordeauxMetropoleDiscoverer = new BordeauxMetropoleDiscovererForBikeChecker(AbstractBike_availability.this);
        
        /**
         * @return a {@link BordeauxMetropoleDiscovererForBikeChecker} object to discover <code>BordeauxMetropole</code> devices
         */
        public BordeauxMetropoleDiscovererForBikeChecker bordeauxMetropoles() {
            return bordeauxMetropoleDiscoverer;
        }
    }
    
    /**
     * Discover object that will exposes the <code>BordeauxMetropole</code> devices to get their sources for the
     * <code>when provided BikeChecker</code> interaction contract.
    
    <pre>
    device BordeauxMetropole extends Device {
     * 	source real_time_schedules as Cross;
     * 	source theoretical_schedules as Cross;
     * 	source bikes as Bikes indexed by filter as BikesAv;
     * }
    </pre>
     */
    protected final static class BordeauxMetropoleDiscovererForBikeChecker {
        private Service serviceParent;
        
        private BordeauxMetropoleDiscovererForBikeChecker(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private BordeauxMetropoleCompositeForBikeChecker instantiateComposite() {
            return new BordeauxMetropoleCompositeForBikeChecker(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>BordeauxMetropole</code> devices
         * 
         * @return a {@link BordeauxMetropoleCompositeForBikeChecker} object composed of all discoverable <code>BordeauxMetropole</code>
         */
        public BordeauxMetropoleCompositeForBikeChecker all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>BordeauxMetropole</code> devices
         * 
         * @return a {@link BordeauxMetropoleProxyForBikeChecker} object pointing to a random discoverable <code>BordeauxMetropole</code> device
         */
        public BordeauxMetropoleProxyForBikeChecker anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>BordeauxMetropole</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link BordeauxMetropoleCompositeForBikeChecker} object composed of all matching <code>BordeauxMetropole</code> devices
         */
        public BordeauxMetropoleCompositeForBikeChecker whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>BordeauxMetropole</code> devices to get their sources for the
     * <code>when provided BikeChecker</code> interaction contract.
    
    <pre>
    device BordeauxMetropole extends Device {
     * 	source real_time_schedules as Cross;
     * 	source theoretical_schedules as Cross;
     * 	source bikes as Bikes indexed by filter as BikesAv;
     * }
    </pre>
     */
    protected final static class BordeauxMetropoleCompositeForBikeChecker extends fr.inria.diagen.core.service.composite.Composite<BordeauxMetropoleProxyForBikeChecker> {
        private BordeauxMetropoleCompositeForBikeChecker(Service serviceParent) {
            super(serviceParent, "/Device/Device/BordeauxMetropole/");
        }
        
        @Override
        protected BordeauxMetropoleProxyForBikeChecker instantiateProxy(RemoteServiceInfo rsi) {
            return new BordeauxMetropoleProxyForBikeChecker(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link BordeauxMetropoleCompositeForBikeChecker}, filtered using the attribute <code>id</code>.
         */
        public BordeauxMetropoleCompositeForBikeChecker andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
    }
    
    /**
     * A proxy to one <code>BordeauxMetropole</code> device to get its sources for the
     * <code>when provided BikeChecker</code> interaction contract.
    
    <pre>
    device BordeauxMetropole extends Device {
     * 	source real_time_schedules as Cross;
     * 	source theoretical_schedules as Cross;
     * 	source bikes as Bikes indexed by filter as BikesAv;
     * }
    </pre>
     */
    protected final static class BordeauxMetropoleProxyForBikeChecker extends Proxy {
        private BordeauxMetropoleProxyForBikeChecker(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Returns the value of the <code>bikes</code> source of this <code>BordeauxMetropole</code> device
         * 
         * @param filter the value of the <code>filter</code> index.
         * @return the value of the <code>bikes</code> source
         */
        public fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes getBikes(fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv filter) throws InvocationException {
            return (fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes) callGetValue("bikes", filter);
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover object for BikeChecker
}

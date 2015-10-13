package fr.inria.phoenix.diasuite.framework.context.incidentdetection;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.service.composite.CompositeException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;

/**
 * context 3

<pre>
context IncidentDetection as Boolean {
 *     when provided timerTriggered from Timer 
 *     get JourneySelection, real_time_schedules from BordeauxMetropole, theoretical_schedules from BordeauxMetropole
 *     maybe publish;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractIncidentDetection extends Service {
    
    public AbstractIncidentDetection(ServiceConfiguration serviceConfiguration) {
        super("/Context/IncidentDetection/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @Override
    protected void postInitialize() {
        // Default implementation of post initialize: subscribe to all required devices
        discoverTimerForSubscribe.all().subscribeTimerTriggered(); // subscribe to timerTriggered from all Timer devices
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("timerTriggered") && source.isCompatible("/Device/Device/Service/BuiltIn/Timer/")) {
            TimerTriggeredFromTimer timerTriggeredFromTimer = new TimerTriggeredFromTimer(this, source, (java.lang.String) value,
                    (java.lang.String) indexes[0]);
            
            IncidentDetectionValuePublishable returnValue = onTimerTriggeredFromTimer(timerTriggeredFromTimer, new DiscoverForTimerTriggeredFromTimer());
            if(returnValue != null && returnValue.doPublish()) {
                setIncidentDetection(returnValue.getValue());
            }
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("incidentDetection")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private java.lang.Boolean contextValue;
    
    private void setIncidentDetection(java.lang.Boolean newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "incidentDetection", newContextValue);
    }
    
    /**
     * Get the last value of the context
     * 
     * @return the latest value published by the context
     */
    protected final java.lang.Boolean getLastValue() {
        return contextValue;
    }
    
    /**
     * A class that represents a value that might be published for the <code>IncidentDetection</code> context. It is used by
     * event methods that might or might not publish values for this context.
     */
    protected final static class IncidentDetectionValuePublishable {
        
        // The value of the context
        private java.lang.Boolean value;
        // Whether the value should be published or not
        private boolean doPublish;
        
        public IncidentDetectionValuePublishable(java.lang.Boolean value, boolean doPublish) {
            this.value = value;
            this.doPublish = doPublish;
        }
        
        /**
         * @return the value of the context that might be published
         */
        public java.lang.Boolean getValue() {
            return value;
        }
        
        /**
         * Sets the value that might be published
         * 
         * @param value the value that will be published if {@link #doPublish()} returns true
         */
        public void setValue(java.lang.Boolean value) {
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
     * This method is called when a <code>Timer</code> device on which we have subscribed publish on its <code>timerTriggered</code> source.
    <p>
    ??
    
    <pre>
    when provided timerTriggered from Timer 
     *     get JourneySelection, real_time_schedules from BordeauxMetropole, theoretical_schedules from BordeauxMetropole
     *     maybe publish;
    </pre>
     * 
     * @param timerTriggeredFromTimer the value of the <code>timerTriggered</code> source and the <code>Timer</code> device that published the value.
     * @param discover a discover object to get value from devices and contexts
     * @return a {@link IncidentDetectionValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract IncidentDetectionValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer, DiscoverForTimerTriggeredFromTimer discover);
    
    // End of interaction contract implementation
    
    // Discover part for Timer devices
    /**
     * Use this object to discover Timer devices.
    
    <pre>
    device Timer extends BuiltIn {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;	
     * }
    </pre>
     * 
     * @see TimerDiscoverer
     */
    protected final TimerDiscoverer discoverTimerForSubscribe = new TimerDiscoverer(this);
    
    /**
     * Discover object that will exposes the <code>Timer</code> devices that can be discovered
    
    <pre>
    device Timer extends BuiltIn {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;	
     * }
    </pre>
     */
    protected final static class TimerDiscoverer {
        private Service serviceParent;
        
        private TimerDiscoverer(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private TimerComposite instantiateComposite() {
            return new TimerComposite(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerComposite} object composed of all discoverable <code>Timer</code>
         */
        public TimerComposite all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>Timer</code> devices
         * 
         * @return a {@link TimerProxy} object pointing to a random discoverable <code>Timer</code> device
         */
        public TimerProxy anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>Timer</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link TimerComposite} object composed of all matching <code>Timer</code> devices
         */
        public TimerComposite whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>Timer</code> devices
    
    <pre>
    device Timer extends BuiltIn {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;	
     * }
    </pre>
     */
    protected final static class TimerComposite extends fr.inria.diagen.core.service.composite.Composite<TimerProxy> {
        private TimerComposite(Service serviceParent) {
            super(serviceParent, "/Device/Device/Service/BuiltIn/Timer/");
        }
        
        @Override
        protected TimerProxy instantiateProxy(RemoteServiceInfo rsi) {
            return new TimerProxy(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link TimerComposite}, filtered using the attribute <code>id</code>.
         */
        public TimerComposite andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
        
        /**
         * Subscribes to the <code>timerTriggered</code> source. After a call to this method, the context will be notified when a
         * <code>Timer</code> device of this composite publishes a value on its <code>timerTriggered</code> source.
         */
        public void subscribeTimerTriggered() {
            subscribeValue("timerTriggered");
        }
        
        /**
         * Unsubscribes from the <code>timerTriggered</code> source. After a call to this method, the context will no more be notified
         * when a <code>Timer</code> device of this composite publishes a value on its <code>timerTriggered</code> source.
         */
        public void unsubscribeTimerTriggered() {
            unsubscribeValue("timerTriggered");
        }
    }
    
    /**
     * A proxy to one <code>Timer</code> device
    
    <pre>
    device Timer extends BuiltIn {
     * 	source timerTriggered as String indexed by timerId as String;
     * 	action ScheduleTimer;	
     * }
    </pre>
     */
    protected final static class TimerProxy extends Proxy {
        private TimerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subscribes to the <code>timerTriggered</code> source. After a call to this method, the context will be notified when the
         * <code>Timer</code> device of this proxy publishes a value on its <code>timerTriggered</code> source.
         */
        public void subscribeTimerTriggered() {
            subscribeValue("timerTriggered");
        }
        
        /**
         * Unsubscribes from the <code>timerTriggered</code> source. After a call to this method, the context will no more be notified
         * when the <code>Timer</code> device of this proxy publishes a value on its <code>timerTriggered</code> source.
         */
        public void unsubscribeTimerTriggered() {
            unsubscribeValue("timerTriggered");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover part for Timer devices
    
    // Discover object for timerTriggered from Timer
    /**
     * An object to discover devices and contexts for the following interaction contract:
     * 
     * <code>
     * when provided timerTriggered from Timer 
     *     get JourneySelection, real_time_schedules from BordeauxMetropole, theoretical_schedules from BordeauxMetropole
     *     maybe publish;
     * </code>
     */
    protected final class DiscoverForTimerTriggeredFromTimer {
        private final BordeauxMetropoleDiscovererForTimerTriggeredFromTimer bordeauxMetropoleDiscoverer = new BordeauxMetropoleDiscovererForTimerTriggeredFromTimer(AbstractIncidentDetection.this);
        private final fr.inria.diagen.core.service.filter.service.ServiceFilter journeySelectionFilter = new fr.inria.diagen.core.service.filter.service.ServiceFilter("/Context/JourneySelection/");
        
        private RemoteServiceInfo getJourneySelectionRsi() {
            return getProcessor().discoverComponents(getOutProperties(), journeySelectionFilter).get(0);
        }
        
        /**
         * @return a {@link BordeauxMetropoleDiscovererForTimerTriggeredFromTimer} object to discover <code>BordeauxMetropole</code> devices
         */
        public BordeauxMetropoleDiscovererForTimerTriggeredFromTimer bordeauxMetropoles() {
            return bordeauxMetropoleDiscoverer;
        }
        
        /**
         * Get the value of the <code>JourneySelection</code> context
         * 
         * @return the value of the <code>JourneySelection</code> context
         */
        public java.lang.String journeySelection() {
            return (java.lang.String) getProcessor().callGetValue(getOutProperties(), getJourneySelectionRsi(), "journeySelection");
        }
    }
    
    /**
     * Discover object that will exposes the <code>BordeauxMetropole</code> devices to get their sources for the
     * <code>when provided timerTriggered from Timer</code> interaction contract.
    
    <pre>
    device BordeauxMetropole extends Device {
     * 	source real_time_schedules as Cross;
     * 	source theoretical_schedules as Cross;
     * 	source bikes as Bikes indexed by filter as BikesAv;
     * }
    </pre>
     */
    protected final static class BordeauxMetropoleDiscovererForTimerTriggeredFromTimer {
        private Service serviceParent;
        
        private BordeauxMetropoleDiscovererForTimerTriggeredFromTimer(Service serviceParent) {
            super();
            this.serviceParent = serviceParent;
        }
        
        private BordeauxMetropoleCompositeForTimerTriggeredFromTimer instantiateComposite() {
            return new BordeauxMetropoleCompositeForTimerTriggeredFromTimer(serviceParent);
        }
        
        /**
         * Returns a composite of all accessible <code>BordeauxMetropole</code> devices
         * 
         * @return a {@link BordeauxMetropoleCompositeForTimerTriggeredFromTimer} object composed of all discoverable <code>BordeauxMetropole</code>
         */
        public BordeauxMetropoleCompositeForTimerTriggeredFromTimer all() {
            return instantiateComposite();
        }
        
        /**
         * Returns a proxy to one out of all accessible <code>BordeauxMetropole</code> devices
         * 
         * @return a {@link BordeauxMetropoleProxyForTimerTriggeredFromTimer} object pointing to a random discoverable <code>BordeauxMetropole</code> device
         */
        public BordeauxMetropoleProxyForTimerTriggeredFromTimer anyOne() {
            return all().anyOne();
        }
        
        /**
         * Returns a composite of all accessible <code>BordeauxMetropole</code> devices whose attribute <code>id</code> matches a given value.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return a {@link BordeauxMetropoleCompositeForTimerTriggeredFromTimer} object composed of all matching <code>BordeauxMetropole</code> devices
         */
        public BordeauxMetropoleCompositeForTimerTriggeredFromTimer whereId(java.lang.String id) throws CompositeException {
            return instantiateComposite().andId(id);
        }
    }
    
    /**
     * A composite of several <code>BordeauxMetropole</code> devices to get their sources for the
     * <code>when provided timerTriggered from Timer</code> interaction contract.
    
    <pre>
    device BordeauxMetropole extends Device {
     * 	source real_time_schedules as Cross;
     * 	source theoretical_schedules as Cross;
     * 	source bikes as Bikes indexed by filter as BikesAv;
     * }
    </pre>
     */
    protected final static class BordeauxMetropoleCompositeForTimerTriggeredFromTimer extends fr.inria.diagen.core.service.composite.Composite<BordeauxMetropoleProxyForTimerTriggeredFromTimer> {
        private BordeauxMetropoleCompositeForTimerTriggeredFromTimer(Service serviceParent) {
            super(serviceParent, "/Device/Device/BordeauxMetropole/");
        }
        
        @Override
        protected BordeauxMetropoleProxyForTimerTriggeredFromTimer instantiateProxy(RemoteServiceInfo rsi) {
            return new BordeauxMetropoleProxyForTimerTriggeredFromTimer(service, rsi);
        }
        
        /**
         * Returns this composite in which a filter was set to the attribute <code>id</code>.
         * 
         * @param id The <code>id<code> attribute value to match.
         * @return this {@link BordeauxMetropoleCompositeForTimerTriggeredFromTimer}, filtered using the attribute <code>id</code>.
         */
        public BordeauxMetropoleCompositeForTimerTriggeredFromTimer andId(java.lang.String id) throws CompositeException {
            filterByAttribute("id", id);
            return this;
        }
    }
    
    /**
     * A proxy to one <code>BordeauxMetropole</code> device to get its sources for the
     * <code>when provided timerTriggered from Timer</code> interaction contract.
    
    <pre>
    device BordeauxMetropole extends Device {
     * 	source real_time_schedules as Cross;
     * 	source theoretical_schedules as Cross;
     * 	source bikes as Bikes indexed by filter as BikesAv;
     * }
    </pre>
     */
    protected final static class BordeauxMetropoleProxyForTimerTriggeredFromTimer extends Proxy {
        private BordeauxMetropoleProxyForTimerTriggeredFromTimer(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Returns the value of the <code>real_time_schedules</code> source of this <code>BordeauxMetropole</code> device
         * 
         * @return the value of the <code>real_time_schedules</code> source
         */
        public fr.inria.phoenix.diasuite.framework.datatype.cross.Cross getReal_time_schedules() throws InvocationException {
            return (fr.inria.phoenix.diasuite.framework.datatype.cross.Cross) callGetValue("real_time_schedules");
        }
        
        /**
         * Returns the value of the <code>theoretical_schedules</code> source of this <code>BordeauxMetropole</code> device
         * 
         * @return the value of the <code>theoretical_schedules</code> source
         */
        public fr.inria.phoenix.diasuite.framework.datatype.cross.Cross getTheoretical_schedules() throws InvocationException {
            return (fr.inria.phoenix.diasuite.framework.datatype.cross.Cross) callGetValue("theoretical_schedules");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
    // End of discover object for timerTriggered from Timer
}

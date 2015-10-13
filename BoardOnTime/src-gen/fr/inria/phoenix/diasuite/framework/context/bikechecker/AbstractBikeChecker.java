package fr.inria.phoenix.diasuite.framework.context.bikechecker;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.journeyselection.JourneySelectionValue;

/**
 * context 2bis

<pre>
context BikeChecker as String {
 * 	when provided JourneySelection
 * 	maybe publish;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractBikeChecker extends Service {
    
    public AbstractBikeChecker(ServiceConfiguration serviceConfiguration) {
        super("/Context/BikeChecker/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("journeySelection", "/Context/JourneySelection/"); // subscribe to JourneySelection context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("journeySelection") && source.isCompatible("/Context/JourneySelection/")) {
            JourneySelectionValue journeySelectionValue = new JourneySelectionValue((java.lang.String) value);
            
            BikeCheckerValuePublishable returnValue = onJourneySelection(journeySelectionValue);
            if(returnValue != null && returnValue.doPublish()) {
                setBikeChecker(returnValue.getValue());
            }
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("bikeChecker")) {
            return getLastValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private java.lang.String contextValue;
    
    private void setBikeChecker(java.lang.String newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "bikeChecker", newContextValue);
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
     * A class that represents a value that might be published for the <code>BikeChecker</code> context. It is used by
     * event methods that might or might not publish values for this context.
     */
    protected final static class BikeCheckerValuePublishable {
        
        // The value of the context
        private java.lang.String value;
        // Whether the value should be published or not
        private boolean doPublish;
        
        public BikeCheckerValuePublishable(java.lang.String value, boolean doPublish) {
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
     * This method is called when the <code>JourneySelection</code> context publishes a value.
    
    <pre>
    when provided JourneySelection
     * 	maybe publish;
    </pre>
     * 
     * @param journeySelectionValue the value of the <code>JourneySelection</code> context.
     * @return a {@link BikeCheckerValuePublishable} that says if the context should publish a value and which value it should publish
     */
    protected abstract BikeCheckerValuePublishable onJourneySelection(JourneySelectionValue journeySelectionValue);
    
    // End of interaction contract implementation
}

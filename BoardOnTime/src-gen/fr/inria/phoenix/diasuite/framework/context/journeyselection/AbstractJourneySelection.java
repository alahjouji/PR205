package fr.inria.phoenix.diasuite.framework.context.journeyselection;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.context.journeycomputer.JourneyComputerValue;

/**
 * context 2

<pre>
context JourneySelection as String {
 * 	when provided JourneyComputer
 * 	always publish; 
 * 	when required;
 * }
</pre>
 */
@SuppressWarnings("all")
public abstract class AbstractJourneySelection extends Service {
    
    public AbstractJourneySelection(ServiceConfiguration serviceConfiguration) {
        super("/Context/JourneySelection/", serviceConfiguration);
    }
    
    // Methods from the Service class
    @Override
    protected final void internalPostInitialize() {
        subscribeValue("journeyComputer", "/Context/JourneyComputer/"); // subscribe to JourneyComputer context
        postInitialize();
    }
    
    @Override
    public final void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
        if (eventName.equals("journeyComputer") && source.isCompatible("/Context/JourneyComputer/")) {
            JourneyComputerValue journeyComputerValue = new JourneyComputerValue((fr.inria.phoenix.diasuite.framework.datatype.sending.Sending) value);
            
            setJourneySelection(onJourneyComputer(journeyComputerValue));
        }
    }
    
    @Override
    public final Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String valueName,
            Object... indexes) throws Exception {
        if (valueName.equals("journeySelection")) {
            return getValue();
        }
        throw new InvocationException("Unsupported method call: " + valueName);
    }
    // End of methods from the Service class
    
    // Code relative to the return value of the context
    private java.lang.String contextValue;
    
    private void setJourneySelection(java.lang.String newContextValue) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "journeySelection", newContextValue);
    }
    
    /**
     * Get the last value of the context
     * 
     * @return the latest value published by the context
     */
    protected final java.lang.String getLastValue() {
        return contextValue;
    }
    // End of code relative to the return value of the context
    
    // Interaction contract implementation
    /**
     * This method is called when the <code>JourneyComputer</code> context publishes a value.
    
    <pre>
    when provided JourneyComputer
     * 	always publish;
    </pre>
     * 
     * @param journeyComputerValue the value of the <code>JourneyComputer</code> context.
     * @return the value to publish
     */
    protected abstract java.lang.String onJourneyComputer(JourneyComputerValue journeyComputerValue);
    
    /**
     * This method is called when the value of this context is required.
    <p>
    Always publish? pour les contx 3 et controleur 1 et maybe publish pour //contx 4
    
    <pre>
    when required;
    </pre>
    
    @return the value of the context to return
     */
    protected abstract java.lang.String getValue();
    
    // End of interaction contract implementation
}

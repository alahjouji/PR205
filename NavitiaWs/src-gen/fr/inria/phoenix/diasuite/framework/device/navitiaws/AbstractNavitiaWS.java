package fr.inria.phoenix.diasuite.framework.device.navitiaws;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device NavitiaWS extends Device {
 * 	source journeys as Sending indexed by filter as String;
 * }
</pre>
 */
public abstract class AbstractNavitiaWS extends Service {
    
    public AbstractNavitiaWS(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/NavitiaWS/", serviceConfiguration);
        updateId(idValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("journeys")) {
            return getJourneys((java.lang.String) args[0]);
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source journeys from device NavitiaWS
    private java.util.HashMap<JourneysIndices, fr.inria.phoenix.diasuite.framework.datatype.sending.Sending> _journeys = new java.util.HashMap<JourneysIndices, fr.inria.phoenix.diasuite.framework.datatype.sending.Sending>();
    
    /**
     * Publish the value of source <code>journeys</code> from device <code>NavitiaWS</code>.
    
    <pre>
    source journeys as Sending indexed by filter as String;
    </pre>
    @param newJourneysValue the new value for the source <code>journeys</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishJourneys(fr.inria.phoenix.diasuite.framework.datatype.sending.Sending newJourneysValue,
            java.lang.String filter) {
        JourneysIndices _indices_ = new JourneysIndices(filter);
        _journeys.put(_indices_, newJourneysValue);
        getProcessor().publishValue(getOutProperties(), "journeys", newJourneysValue, filter); 
    }
    
    /**
     * Returns the value of source <code>journeys</code> from device <code>NavitiaWS</code>.
    
    <pre>
    source journeys as Sending indexed by filter as String;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>journeys</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.sending.Sending getJourneys(java.lang.String filter) throws Exception {
        return _journeys.get(new JourneysIndices(filter));
    }
    // End of code for source journeys from device NavitiaWS
}

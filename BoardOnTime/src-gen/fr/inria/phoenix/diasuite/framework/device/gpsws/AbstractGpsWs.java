package fr.inria.phoenix.diasuite.framework.device.gpsws;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device GpsWs extends Device {
 * 	source destCoordinates as GpsCoordinates indexed by filter as String;
 * }
</pre>
 */
public abstract class AbstractGpsWs extends Service {
    
    public AbstractGpsWs(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/GpsWs/", serviceConfiguration);
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
        if (orderName.equals("destCoordinates")) {
            return getDestCoordinates((java.lang.String) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
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
    
    // Code for source destCoordinates from device GpsWs
    private java.util.HashMap<DestCoordinatesIndices, fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates> _destCoordinates = new java.util.HashMap<DestCoordinatesIndices, fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates>();
    
    /**
     * Publish the value of source <code>destCoordinates</code> from device <code>GpsWs</code>.
    
    <pre>
    source destCoordinates as GpsCoordinates indexed by filter as String;
    </pre>
    @param newDestCoordinatesValue the new value for the source <code>destCoordinates</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishDestCoordinates(fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates newDestCoordinatesValue,
            java.lang.String filter) {
        DestCoordinatesIndices _indices_ = new DestCoordinatesIndices(filter);
        _destCoordinates.put(_indices_, newDestCoordinatesValue);
        getProcessor().publishValue(getOutProperties(), "destCoordinates", newDestCoordinatesValue, filter); 
    }
    
    /**
     * Returns the value of source <code>destCoordinates</code> from device <code>GpsWs</code>.
    
    <pre>
    source destCoordinates as GpsCoordinates indexed by filter as String;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>destCoordinates</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates getDestCoordinates(java.lang.String filter) throws Exception {
        return _destCoordinates.get(new DestCoordinatesIndices(filter));
    }
    // End of code for source destCoordinates from device GpsWs
    
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
}

package fr.inria.phoenix.diasuite.framework.device.modalarm;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device ModAlarm extends Alarm {
 * 	attribute modality as Modality;
 * }
</pre>
 */
public abstract class AbstractModAlarm extends Service {
    
    public AbstractModAlarm(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue,
            fr.inria.phoenix.diasuite.framework.datatype.modality.Modality modalityValue) {
        super("/Device/Device/PhysicalDevice/Appliance/Alarm/ModAlarm/", serviceConfiguration);
        updateId(idValue);
        updateLocation(locationValue);
        updateUser(userValue);
        updateModality(modalityValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("location", _location);
        attributes.put("modality", _modality);
        attributes.put("user", _user);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("off")) {
            off();
            return null;
        }
        if (orderName.equals("on")) {
            on();
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("location")) {
            return _location;
        }
        if (orderName.equals("modality")) {
            return _modality;
        }
        if (orderName.equals("user")) {
            return _user;
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
    
    // Code for the attribute location from device PhysicalDevice
    private java.lang.String _location;
    
    /**
     * Set the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @param newLocationValue the new value of <code>location</code>
     */
    protected void updateLocation(java.lang.String newLocationValue) {
        if (_location != newLocationValue) {
            _location = newLocationValue;
            updateAttribute("location", newLocationValue);
        }
    }
    
    /**
     * Returns the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @return the value of <code>location</code>
     */
    public java.lang.String getLocation() {
        return _location;
    }
    // End of code for the attribute location from device PhysicalDevice
    
    // Code for the attribute modality from device ModAlarm
    private fr.inria.phoenix.diasuite.framework.datatype.modality.Modality _modality;
    
    /**
     * Set the value of the <code>modality</code> attribute from device <code>ModAlarm</code>.
    
    <pre>
    attribute modality as Modality;
    </pre>
    @param newModalityValue the new value of <code>modality</code>
     */
    protected void updateModality(fr.inria.phoenix.diasuite.framework.datatype.modality.Modality newModalityValue) {
        if (_modality != newModalityValue) {
            _modality = newModalityValue;
            updateAttribute("modality", newModalityValue);
        }
    }
    
    /**
     * Returns the value of the <code>modality</code> attribute from device <code>ModAlarm</code>.
    
    <pre>
    attribute modality as Modality;
    </pre>
    @return the value of <code>modality</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.modality.Modality getModality() {
        return _modality;
    }
    // End of code for the attribute modality from device ModAlarm
    
    // Code for the attribute user from device PhysicalDevice
    private java.lang.String _user;
    
    /**
     * Set the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @param newUserValue the new value of <code>user</code>
     */
    protected void updateUser(java.lang.String newUserValue) {
        if (_user != newUserValue) {
            _user = newUserValue;
            updateAttribute("user", newUserValue);
        }
    }
    
    /**
     * Returns the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @return the value of <code>user</code>
     */
    public java.lang.String getUser() {
        return _user;
    }
    // End of code for the attribute user from device PhysicalDevice
    
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
    
    /**
     * Implement this method to define the <code>off</code> order from the <code>Off</code> action
     * defined in device Appliance.
     * 
    
    <pre>
    off();
    </pre>
     */
    protected abstract void off() throws Exception;
    
    /**
     * Implement this method to define the <code>on</code> order from the <code>On</code> action
     * defined in device Appliance.
     * 
    
    <pre>
    on();
    </pre>
     */
    protected abstract void on() throws Exception;
}

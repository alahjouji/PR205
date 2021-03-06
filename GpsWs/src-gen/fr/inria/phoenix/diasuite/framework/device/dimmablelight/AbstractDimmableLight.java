package fr.inria.phoenix.diasuite.framework.device.dimmablelight;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device DimmableLight extends Light {
 * 	action VariationControl;
 * 	source level as Float;
 * }
</pre>
 */
public abstract class AbstractDimmableLight extends Service {
    
    public AbstractDimmableLight(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        super("/Device/Device/PhysicalDevice/Appliance/Light/DimmableLight/", serviceConfiguration);
        updateId(idValue);
        updateLocation(locationValue);
        updateUser(userValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("location", _location);
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
        if (orderName.equals("decrease")) {
            decrease();
            return null;
        }
        if (orderName.equals("increase")) {
            increase();
            return null;
        }
        if (orderName.equals("off")) {
            off();
            return null;
        }
        if (orderName.equals("on")) {
            on();
            return null;
        }
        if (orderName.equals("setValue")) {
            setValue((java.lang.Float) args[0]);
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
        if (orderName.equals("user")) {
            return _user;
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("level")) {
            return getLevel();
        }
        if (orderName.equals("status")) {
            return getStatus();
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
    
    // Code for source level from device DimmableLight
    private java.lang.Float _level;
    
    /**
     * Publish the value of source <code>level</code> from device <code>DimmableLight</code>.
    
    <pre>
    source level as Float;
    </pre>
    @param newLevelValue the new value for the source <code>level</code>
     */
    protected void publishLevel(java.lang.Float newLevelValue) {
        _level = newLevelValue;
        getProcessor().publishValue(getOutProperties(), "level", newLevelValue); 
    }
    
    /**
     * Returns the value of source <code>level</code> from device <code>DimmableLight</code>.
    
    <pre>
    source level as Float;
    </pre>
    @return the value of the source <code>level</code>
     */
    protected java.lang.Float getLevel() throws Exception {
        return _level;
    }
    // End of code for source level from device DimmableLight
    
    // Code for source status from device Light
    private fr.inria.phoenix.diasuite.framework.datatype.state.State _status;
    
    /**
     * Publish the value of source <code>status</code> from device <code>Light</code>.
    
    <pre>
    source status as State;
    </pre>
    @param newStatusValue the new value for the source <code>status</code>
     */
    protected void publishStatus(fr.inria.phoenix.diasuite.framework.datatype.state.State newStatusValue) {
        _status = newStatusValue;
        getProcessor().publishValue(getOutProperties(), "status", newStatusValue); 
    }
    
    /**
     * Returns the value of source <code>status</code> from device <code>Light</code>.
    
    <pre>
    source status as State;
    </pre>
    @return the value of the source <code>status</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.state.State getStatus() throws Exception {
        return _status;
    }
    // End of code for source status from device Light
    
    /**
     * Implement this method to define the <code>decrease</code> order from the <code>VariationControl</code> action
     * defined in device DimmableLight.
     * 
    
    <pre>
    decrease();
    </pre>
     */
    protected abstract void decrease() throws Exception;
    
    /**
     * Implement this method to define the <code>increase</code> order from the <code>VariationControl</code> action
     * defined in device DimmableLight.
     * 
    
    <pre>
    increase();
    </pre>
     */
    protected abstract void increase() throws Exception;
    
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
    
    /**
     * Implement this method to define the <code>setValue</code> order from the <code>VariationControl</code> action
     * defined in device DimmableLight.
     * 
    
    <pre>
    setValue(value as Float);
    </pre>
     * @param value parameter 1 of the order.
     */
    protected abstract void setValue(java.lang.Float value) throws Exception;
}

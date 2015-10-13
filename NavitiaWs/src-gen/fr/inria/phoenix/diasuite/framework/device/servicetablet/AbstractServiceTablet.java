package fr.inria.phoenix.diasuite.framework.device.servicetablet;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device ServiceTablet extends PhysicalDevice {
 * 	action PushContacts;
 * 	source tabletMode as ServiceTabletMode;
 * 	source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
 * }
</pre>
 */
public abstract class AbstractServiceTablet extends Service {
    
    public AbstractServiceTablet(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        super("/Device/Device/PhysicalDevice/ServiceTablet/", serviceConfiguration);
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
        if (orderName.equals("pushContacts")) {
            pushContacts((java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile>) args[0]);
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
        if (orderName.equals("tabletAction")) {
            return getTabletAction((fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile) args[0]);
        }
        if (orderName.equals("tabletMode")) {
            return getTabletMode();
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
    
    // Code for source tabletAction from device ServiceTablet
    private java.util.HashMap<TabletActionIndices, fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode> _tabletAction = new java.util.HashMap<TabletActionIndices, fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode>();
    
    /**
     * Publish the value of source <code>tabletAction</code> from device <code>ServiceTablet</code>.
    
    <pre>
    source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
    </pre>
    @param newTabletActionValue the new value for the source <code>tabletAction</code>
    @param profile the value of the index <code>profile</code>
     */
    protected void publishTabletAction(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletActionValue,
            fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
        TabletActionIndices _indices_ = new TabletActionIndices(profile);
        _tabletAction.put(_indices_, newTabletActionValue);
        getProcessor().publishValue(getOutProperties(), "tabletAction", newTabletActionValue, profile); 
    }
    
    /**
     * Returns the value of source <code>tabletAction</code> from device <code>ServiceTablet</code>.
    
    <pre>
    source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
    </pre>
    @param profile the value of the index <code>profile</code>
    @return the value of the source <code>tabletAction</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode getTabletAction(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) throws Exception {
        return _tabletAction.get(new TabletActionIndices(profile));
    }
    // End of code for source tabletAction from device ServiceTablet
    
    // Code for source tabletMode from device ServiceTablet
    private fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode _tabletMode;
    
    /**
     * Publish the value of source <code>tabletMode</code> from device <code>ServiceTablet</code>.
    
    <pre>
    source tabletMode as ServiceTabletMode;
    </pre>
    @param newTabletModeValue the new value for the source <code>tabletMode</code>
     */
    protected void publishTabletMode(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletModeValue) {
        _tabletMode = newTabletModeValue;
        getProcessor().publishValue(getOutProperties(), "tabletMode", newTabletModeValue); 
    }
    
    /**
     * Returns the value of source <code>tabletMode</code> from device <code>ServiceTablet</code>.
    
    <pre>
    source tabletMode as ServiceTabletMode;
    </pre>
    @return the value of the source <code>tabletMode</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode getTabletMode() throws Exception {
        return _tabletMode;
    }
    // End of code for source tabletMode from device ServiceTablet
    
    /**
     * Implement this method to define the <code>pushContacts</code> order from the <code>PushContacts</code> action
     * defined in device ServiceTablet.
     * 
    
    <pre>
    pushContacts(profiles as PersonalProfile[]);
    </pre>
     * @param profiles parameter 1 of the order.
     */
    protected abstract void pushContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> profiles) throws Exception;
}

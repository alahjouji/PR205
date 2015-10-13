package fr.inria.phoenix.diasuite.framework.device.personaladdressbook;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device PersonalAddressBook extends UserService {
 * 	source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
 * }
</pre>
 */
public abstract class AbstractPersonalAddressBook extends Service {
    
    public AbstractPersonalAddressBook(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String userValue) {
        super("/Device/Device/Service/UserService/PersonalAddressBook/", serviceConfiguration);
        updateId(idValue);
        updateUser(userValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
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
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("user")) {
            return _user;
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("profiles")) {
            return getProfiles((fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile) args[0]);
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
    
    // Code for the attribute user from device UserService
    private java.lang.String _user;
    
    /**
     * Set the value of the <code>user</code> attribute from device <code>UserService</code>.
    
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
     * Returns the value of the <code>user</code> attribute from device <code>UserService</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @return the value of <code>user</code>
     */
    public java.lang.String getUser() {
        return _user;
    }
    // End of code for the attribute user from device UserService
    
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
    
    // Code for source profiles from device PersonalAddressBook
    private java.util.HashMap<ProfilesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile>> _profiles = new java.util.HashMap<ProfilesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile>>();
    
    /**
     * Publish the value of source <code>profiles</code> from device <code>PersonalAddressBook</code>.
    
    <pre>
    source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
    </pre>
    @param newProfilesValue the new value for the source <code>profiles</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishProfiles(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> newProfilesValue,
            fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
        ProfilesIndices _indices_ = new ProfilesIndices(filter);
        _profiles.put(_indices_, newProfilesValue);
        getProcessor().publishValue(getOutProperties(), "profiles", newProfilesValue, filter); 
    }
    
    /**
     * Returns the value of source <code>profiles</code> from device <code>PersonalAddressBook</code>.
    
    <pre>
    source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>profiles</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> getProfiles(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) throws Exception {
        return _profiles.get(new ProfilesIndices(filter));
    }
    // End of code for source profiles from device PersonalAddressBook
}

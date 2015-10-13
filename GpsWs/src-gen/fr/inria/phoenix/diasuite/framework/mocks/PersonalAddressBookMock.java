package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.personaladdressbook.AbstractPersonalAddressBook;
import fr.inria.phoenix.diasuite.framework.device.personaladdressbook.ProfilesIndices;

// @internal
public final class PersonalAddressBookMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractPersonalAddressBook {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String userValue) {
            super(serviceConfiguration, idValue, userValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        public void _updateUser(java.lang.String newUserValue) {
            updateUser(newUserValue);
        }
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> getProfiles(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> result = __profiles.get(new ProfilesIndices(filter));
            if(result == null)
                return super.getProfiles(filter);
            return result;
        }
        
        public void _publishProfiles(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> newProfilesValue,
                fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
            publishProfiles(newProfilesValue,
                filter);
        }
    }
    
    Proxy proxy;
    
    PersonalAddressBookMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String userValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, userValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
    @return this for fluent interface
     */
    public PersonalAddressBookMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute user from device UserService
    /**
     * Set the value of the <code>user</code> attribute from device <code>UserService</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @param newUserValue the new value of <code>user</code>
    @return this for fluent interface
     */
    public PersonalAddressBookMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device UserService
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public PersonalAddressBookMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public PersonalAddressBookMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source profiles from device PersonalAddressBook
    /**
     * Publish the value of source <code>profiles</code> from device <code>PersonalAddressBook</code>.
    
    <pre>
    source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
    </pre>
    @param newProfilesValue the new value for the source <code>profiles</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public PersonalAddressBookMock profiles(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> newProfilesValue,
            fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
        proxy._publishProfiles(newProfilesValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<ProfilesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile>> __profiles = new java.util.HashMap<ProfilesIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile>>();
    /**
     * Set the value (without publication) of source <code>profiles</code> from device <code>PersonalAddressBook</code>.
    
    <pre>
    source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
    </pre>
    @param newProfilesValue the new value for the source <code>profiles</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public PersonalAddressBookMock setProfiles(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> newProfilesValue,
            fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
        ProfilesIndices _indices_ = new ProfilesIndices(filter);
        __profiles.put(_indices_, newProfilesValue);
        return this;
    }
    // End of code for source profiles from device PersonalAddressBook
}

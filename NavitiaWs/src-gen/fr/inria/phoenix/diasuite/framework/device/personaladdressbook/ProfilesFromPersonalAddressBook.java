package fr.inria.phoenix.diasuite.framework.device.personaladdressbook;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>profiles</code> of the device <code>PersonalAddressBook</code>.
 *
 * <pre>
 * device PersonalAddressBook extends UserService {
 * 	source profiles as PersonalProfile[] indexed by filter as PersonalProfile;
 * }
 * </pre>
 */
public final class ProfilesFromPersonalAddressBook implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> value;
    
    /**
     * Get the value of the source <code>profiles</code>
     * 
     * @return the value of the source <code>profiles</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> value() {
        return value;
    }
    
    private ProfilesIndices indices;
    
    /**
     * Get the value of the indices of the source <code>profiles</code>
     * 
     * @return the value of the indices
     */
    public ProfilesIndices indices() {
        return indices;
    }
    
    public ProfilesFromPersonalAddressBook(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> value, ProfilesIndices indices) {
        this.sender = new PersonalAddressBookProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public ProfilesFromPersonalAddressBook(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> value,
            fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
        this.sender = new PersonalAddressBookProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new ProfilesIndices(filter);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((indices == null) ? 0 : indices.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProfilesFromPersonalAddressBook other = (ProfilesFromPersonalAddressBook) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (indices == null) {
            if (other.indices != null)
                return false;
        } else if (!indices.equals(other.indices))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private PersonalAddressBookProxy sender;
    
    /**
     * Get the sender of the source <code>profiles</code>. I.e., the <code>PersonalAddressBook</code> device that published the source.
     * 
     * @return A proxy to the <code>PersonalAddressBook</code> that triggered the source
     */
    public PersonalAddressBookProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>PersonalAddressBook</code> that discloses subscription/unsubscription methods.
     */
    public class PersonalAddressBookProxy extends Proxy {
        private PersonalAddressBookProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>profiles</code> from this <code>PersonalAddressBook</code>.
         */
        public void subscribeProfiles() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "profiles");
        }
        
        /**
         * Unsubcribes from publication of source <code>profiles</code> from this <code>PersonalAddressBook</code>.
         */
        public void unsubscribeProfiles() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "profiles");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
}

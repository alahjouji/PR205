package fr.inria.phoenix.diasuite.framework.device.addressbook;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>contacts</code> of the device <code>AddressBook</code>.
 *
 * <pre>
 * device AddressBook extends HomeService {
 * 	attribute owner as String;
 * 	source contacts as Contact[] indexed by filter as Contact;
 * 	action AddressBookAction;
 * }
 * </pre>
 */
public final class ContactsFromAddressBook implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value;
    
    /**
     * Get the value of the source <code>contacts</code>
     * 
     * @return the value of the source <code>contacts</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value() {
        return value;
    }
    
    private ContactsIndices indices;
    
    /**
     * Get the value of the indices of the source <code>contacts</code>
     * 
     * @return the value of the indices
     */
    public ContactsIndices indices() {
        return indices;
    }
    
    public ContactsFromAddressBook(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value, ContactsIndices indices) {
        this.sender = new AddressBookProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public ContactsFromAddressBook(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
        this.sender = new AddressBookProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new ContactsIndices(filter);
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
        ContactsFromAddressBook other = (ContactsFromAddressBook) obj;
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
    private AddressBookProxy sender;
    
    /**
     * Get the sender of the source <code>contacts</code>. I.e., the <code>AddressBook</code> device that published the source.
     * 
     * @return A proxy to the <code>AddressBook</code> that triggered the source
     */
    public AddressBookProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>AddressBook</code> that discloses subscription/unsubscription methods.
     */
    public class AddressBookProxy extends Proxy {
        private AddressBookProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>contacts</code> from this <code>AddressBook</code>.
         */
        public void subscribeContacts() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "contacts");
        }
        
        /**
         * Unsubcribes from publication of source <code>contacts</code> from this <code>AddressBook</code>.
         */
        public void unsubscribeContacts() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "contacts");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>owner</code> attribute
         */
        public java.lang.String owner() {
            return (java.lang.String) callGetValue("owner");
        }
    }
}

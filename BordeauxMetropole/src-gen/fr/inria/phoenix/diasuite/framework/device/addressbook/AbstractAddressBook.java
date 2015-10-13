package fr.inria.phoenix.diasuite.framework.device.addressbook;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device AddressBook extends HomeService {
 * 	attribute owner as String;
 * 	source contacts as Contact[] indexed by filter as Contact;
 * 	action AddressBookAction;
 * }
</pre>
 */
public abstract class AbstractAddressBook extends Service {
    
    public AbstractAddressBook(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String ownerValue) {
        super("/Device/Device/Service/HomeService/AddressBook/", serviceConfiguration);
        updateId(idValue);
        updateOwner(ownerValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("owner", _owner);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("addContact")) {
            addContact((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0]);
            return null;
        }
        if (orderName.equals("removeContact")) {
            removeContact((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0]);
            return null;
        }
        if (orderName.equals("replaceContact")) {
            replaceContact((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[1]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("owner")) {
            return _owner;
        }
        if (orderName.equals("contacts")) {
            return getContacts((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact) args[0]);
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
    
    // Code for the attribute owner from device AddressBook
    private java.lang.String _owner;
    
    /**
     * Set the value of the <code>owner</code> attribute from device <code>AddressBook</code>.
    
    <pre>
    attribute owner as String;
    </pre>
    @param newOwnerValue the new value of <code>owner</code>
     */
    protected void updateOwner(java.lang.String newOwnerValue) {
        if (_owner != newOwnerValue) {
            _owner = newOwnerValue;
            updateAttribute("owner", newOwnerValue);
        }
    }
    
    /**
     * Returns the value of the <code>owner</code> attribute from device <code>AddressBook</code>.
    
    <pre>
    attribute owner as String;
    </pre>
    @return the value of <code>owner</code>
     */
    public java.lang.String getOwner() {
        return _owner;
    }
    // End of code for the attribute owner from device AddressBook
    
    // Code for source contacts from device AddressBook
    private java.util.HashMap<ContactsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact>> _contacts = new java.util.HashMap<ContactsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact>>();
    
    /**
     * Publish the value of source <code>contacts</code> from device <code>AddressBook</code>.
    
    <pre>
    source contacts as Contact[] indexed by filter as Contact;
    </pre>
    @param newContactsValue the new value for the source <code>contacts</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newContactsValue,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
        ContactsIndices _indices_ = new ContactsIndices(filter);
        _contacts.put(_indices_, newContactsValue);
        getProcessor().publishValue(getOutProperties(), "contacts", newContactsValue, filter); 
    }
    
    /**
     * Returns the value of source <code>contacts</code> from device <code>AddressBook</code>.
    
    <pre>
    source contacts as Contact[] indexed by filter as Contact;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>contacts</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> getContacts(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) throws Exception {
        return _contacts.get(new ContactsIndices(filter));
    }
    // End of code for source contacts from device AddressBook
    
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
     * Implement this method to define the <code>addContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook.
     * 
    
    <pre>
    addContact(contact as Contact);
    </pre>
     * @param contact parameter 1 of the order.
     */
    protected abstract void addContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) throws Exception;
    
    /**
     * Implement this method to define the <code>removeContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook.
     * 
    
    <pre>
    removeContact(contact as Contact);
    </pre>
     * @param contact parameter 1 of the order.
     */
    protected abstract void removeContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) throws Exception;
    
    /**
     * Implement this method to define the <code>replaceContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook.
     * 
    
    <pre>
    replaceContact(oldContact as Contact, newContact as Contact);
    </pre>
     * @param oldContact parameter 1 of the order.
     * @param newContact parameter 2 of the order.
     */
    protected abstract void replaceContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact oldContact,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newContact) throws Exception;
}

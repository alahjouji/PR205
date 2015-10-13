package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.addressbook.AbstractAddressBook;
import fr.inria.phoenix.diasuite.framework.device.addressbook.ContactsIndices;

// @internal
public final class AddressBookMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractAddressBook {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String ownerValue) {
            super(serviceConfiguration, idValue, ownerValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        public void _updateOwner(java.lang.String newOwnerValue) {
            updateOwner(newOwnerValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> getContacts(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> result = __contacts.get(new ContactsIndices(filter));
            if(result == null)
                return super.getContacts(filter);
            return result;
        }
        
        public void _publishContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newContactsValue,
                fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
            publishContacts(newContactsValue,
                filter);
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
        
        protected void addContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addContact");
                __action.add(contact);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removeContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removeContact");
                __action.add(contact);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void replaceContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact oldContact,
                fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newContact) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("replaceContact");
                __action.add(oldContact);
                __action.add(newContact);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    AddressBookMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String ownerValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, ownerValue);
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
    public AddressBookMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute owner from device AddressBook
    /**
     * Set the value of the <code>owner</code> attribute from device <code>AddressBook</code>.
    
    <pre>
    attribute owner as String;
    </pre>
    @param newOwnerValue the new value of <code>owner</code>
    @return this for fluent interface
     */
    public AddressBookMock owner(java.lang.String newOwnerValue) {
        proxy._updateOwner(newOwnerValue);
        return this;
    }
    // End of code for the attribute owner from device AddressBook
    
    // Code for source contacts from device AddressBook
    /**
     * Publish the value of source <code>contacts</code> from device <code>AddressBook</code>.
    
    <pre>
    source contacts as Contact[] indexed by filter as Contact;
    </pre>
    @param newContactsValue the new value for the source <code>contacts</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public AddressBookMock contacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newContactsValue,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
        proxy._publishContacts(newContactsValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<ContactsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact>> __contacts = new java.util.HashMap<ContactsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact>>();
    /**
     * Set the value (without publication) of source <code>contacts</code> from device <code>AddressBook</code>.
    
    <pre>
    source contacts as Contact[] indexed by filter as Contact;
    </pre>
    @param newContactsValue the new value for the source <code>contacts</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public AddressBookMock setContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newContactsValue,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
        ContactsIndices _indices_ = new ContactsIndices(filter);
        __contacts.put(_indices_, newContactsValue);
        return this;
    }
    // End of code for source contacts from device AddressBook
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public AddressBookMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public AddressBookMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>addContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook was called.
     * 
    
    <pre>
    addContact(contact as Contact);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddContact() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addContact".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook was called.
     * 
    
    <pre>
    addContact(contact as Contact);
    </pre>
     * @param contact parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addContact".equals(__action.poll())))
                    return false;
                if(!contact.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removeContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook was called.
     * 
    
    <pre>
    removeContact(contact as Contact);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemoveContact() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeContact".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removeContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook was called.
     * 
    
    <pre>
    removeContact(contact as Contact);
    </pre>
     * @param contact parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemoveContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeContact".equals(__action.poll())))
                    return false;
                if(!contact.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>replaceContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook was called.
     * 
    
    <pre>
    replaceContact(oldContact as Contact, newContact as Contact);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectReplaceContact() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("replaceContact".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>replaceContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook was called.
     * 
    
    <pre>
    replaceContact(oldContact as Contact, newContact as Contact);
    </pre>
     * @param oldContact parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectReplaceContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact oldContact) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("replaceContact".equals(__action.poll())))
                    return false;
                if(!oldContact.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>replaceContact</code> order from the <code>AddressBookAction</code> action
     * defined in device AddressBook was called.
     * 
    
    <pre>
    replaceContact(oldContact as Contact, newContact as Contact);
    </pre>
     * @param oldContact parameter 1 of the order.
     * @param newContact parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectReplaceContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact oldContact,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newContact) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("replaceContact".equals(__action.poll())))
                    return false;
                if(!oldContact.equals(__action.poll()))
                    return false;
                if(!newContact.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

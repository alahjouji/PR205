package fr.inria.phoenix.diasuite.framework.device.keypad;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>isLocked</code> of the device <code>KeyPad</code>.
 *
 * <pre>
 * device KeyPad extends PhysicalDevice {
 * 	action UpdateLockStatus;
 * 	source isLocked as Boolean;
 * }
 * </pre>
 */
public final class IsLockedFromKeyPad implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>isLocked</code>
     * 
     * @return the value of the source <code>isLocked</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public IsLockedFromKeyPad(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value) {
        this.sender = new KeyPadProxy(service, remoteServiceInfo);
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        IsLockedFromKeyPad other = (IsLockedFromKeyPad) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private KeyPadProxy sender;
    
    /**
     * Get the sender of the source <code>isLocked</code>. I.e., the <code>KeyPad</code> device that published the source.
     * 
     * @return A proxy to the <code>KeyPad</code> that triggered the source
     */
    public KeyPadProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>KeyPad</code> that discloses subscription/unsubscription methods.
     */
    public class KeyPadProxy extends Proxy {
        private KeyPadProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>isLocked</code> from this <code>KeyPad</code>.
         */
        public void subscribeIsLocked() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "isLocked");
        }
        
        /**
         * Unsubcribes from publication of source <code>isLocked</code> from this <code>KeyPad</code>.
         */
        public void unsubscribeIsLocked() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "isLocked");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>location</code> attribute
         */
        public java.lang.String location() {
            return (java.lang.String) callGetValue("location");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
}

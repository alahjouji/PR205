package fr.inria.phoenix.diasuite.framework.device.bluetoothidentifier;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>present</code> of the device <code>BluetoothIdentifier</code>.
 *
 * <pre>
 * device BluetoothIdentifier extends Identifier {
 * }
 * </pre>
 */
public final class PresentFromBluetoothIdentifier implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>present</code>
     * 
     * @return the value of the source <code>present</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    private PresentIndices indices;
    
    /**
     * Get the value of the indices of the source <code>present</code>
     * 
     * @return the value of the indices
     */
    public PresentIndices indices() {
        return indices;
    }
    
    public PresentFromBluetoothIdentifier(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value, PresentIndices indices) {
        this.sender = new BluetoothIdentifierProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public PresentFromBluetoothIdentifier(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value,
            java.lang.String id) {
        this.sender = new BluetoothIdentifierProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new PresentIndices(id);
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
        PresentFromBluetoothIdentifier other = (PresentFromBluetoothIdentifier) obj;
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
    private BluetoothIdentifierProxy sender;
    
    /**
     * Get the sender of the source <code>present</code>. I.e., the <code>BluetoothIdentifier</code> device that published the source.
     * 
     * @return A proxy to the <code>BluetoothIdentifier</code> that triggered the source
     */
    public BluetoothIdentifierProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>BluetoothIdentifier</code> that discloses subscription/unsubscription methods.
     */
    public class BluetoothIdentifierProxy extends Proxy {
        private BluetoothIdentifierProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>present</code> from this <code>BluetoothIdentifier</code>.
         */
        public void subscribePresent() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "present");
        }
        
        /**
         * Unsubcribes from publication of source <code>present</code> from this <code>BluetoothIdentifier</code>.
         */
        public void unsubscribePresent() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "present");
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

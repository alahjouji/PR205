package fr.inria.phoenix.diasuite.framework.device.builtin;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>isAlive</code> of the device <code>BuiltIn</code>.
 *
 * <pre>
 * device BuiltIn extends Service {
 * }
 * </pre>
 */
public final class IsAliveFromBuiltIn implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>isAlive</code>
     * 
     * @return the value of the source <code>isAlive</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public IsAliveFromBuiltIn(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value) {
        this.sender = new BuiltInProxy(service, remoteServiceInfo);
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
        IsAliveFromBuiltIn other = (IsAliveFromBuiltIn) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private BuiltInProxy sender;
    
    /**
     * Get the sender of the source <code>isAlive</code>. I.e., the <code>BuiltIn</code> device that published the source.
     * 
     * @return A proxy to the <code>BuiltIn</code> that triggered the source
     */
    public BuiltInProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>BuiltIn</code> that discloses subscription/unsubscription methods.
     */
    public class BuiltInProxy extends Proxy {
        private BuiltInProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>isAlive</code> from this <code>BuiltIn</code>.
         */
        public void subscribeIsAlive() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "isAlive");
        }
        
        /**
         * Unsubcribes from publication of source <code>isAlive</code> from this <code>BuiltIn</code>.
         */
        public void unsubscribeIsAlive() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "isAlive");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

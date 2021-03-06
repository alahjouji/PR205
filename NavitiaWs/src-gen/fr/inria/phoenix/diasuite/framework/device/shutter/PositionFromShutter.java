package fr.inria.phoenix.diasuite.framework.device.shutter;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>position</code> of the device <code>Shutter</code>.
 *
 * <pre>
 * device Shutter extends PhysicalDevice {
 * 	action Open;
 * 	action Close;
 * 	action SetShutterPosition;
 * 	source position as Float;
 * }
 * </pre>
 */
public final class PositionFromShutter implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Float value;
    
    /**
     * Get the value of the source <code>position</code>
     * 
     * @return the value of the source <code>position</code>
     */
    public java.lang.Float value() {
        return value;
    }
    
    public PositionFromShutter(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Float value) {
        this.sender = new ShutterProxy(service, remoteServiceInfo);
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
        PositionFromShutter other = (PositionFromShutter) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private ShutterProxy sender;
    
    /**
     * Get the sender of the source <code>position</code>. I.e., the <code>Shutter</code> device that published the source.
     * 
     * @return A proxy to the <code>Shutter</code> that triggered the source
     */
    public ShutterProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Shutter</code> that discloses subscription/unsubscription methods.
     */
    public class ShutterProxy extends Proxy {
        private ShutterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>position</code> from this <code>Shutter</code>.
         */
        public void subscribePosition() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "position");
        }
        
        /**
         * Unsubcribes from publication of source <code>position</code> from this <code>Shutter</code>.
         */
        public void unsubscribePosition() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "position");
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

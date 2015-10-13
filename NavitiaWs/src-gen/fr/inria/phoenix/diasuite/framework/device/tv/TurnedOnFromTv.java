package fr.inria.phoenix.diasuite.framework.device.tv;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>turnedOn</code> of the device <code>Tv</code>.
 *
 * <pre>
 * device Tv extends PhysicalDevice {
 * 	action ChannelControl;
 * 	action VolumeControl;
 * 	source currentChannel as String;
 * 	source currentVolume as Float;
 * 	source mute as Boolean;
 * 	source turnedOn as Boolean;
 * }
 * </pre>
 */
public final class TurnedOnFromTv implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>turnedOn</code>
     * 
     * @return the value of the source <code>turnedOn</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public TurnedOnFromTv(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value) {
        this.sender = new TvProxy(service, remoteServiceInfo);
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
        TurnedOnFromTv other = (TurnedOnFromTv) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private TvProxy sender;
    
    /**
     * Get the sender of the source <code>turnedOn</code>. I.e., the <code>Tv</code> device that published the source.
     * 
     * @return A proxy to the <code>Tv</code> that triggered the source
     */
    public TvProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Tv</code> that discloses subscription/unsubscription methods.
     */
    public class TvProxy extends Proxy {
        private TvProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>turnedOn</code> from this <code>Tv</code>.
         */
        public void subscribeTurnedOn() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "turnedOn");
        }
        
        /**
         * Unsubcribes from publication of source <code>turnedOn</code> from this <code>Tv</code>.
         */
        public void unsubscribeTurnedOn() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "turnedOn");
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

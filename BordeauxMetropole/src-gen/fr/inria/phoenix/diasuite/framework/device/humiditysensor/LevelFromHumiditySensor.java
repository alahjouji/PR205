package fr.inria.phoenix.diasuite.framework.device.humiditysensor;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>level</code> of the device <code>HumiditySensor</code>.
 *
 * <pre>
 * device HumiditySensor extends Sensor {
 * 	source level as Integer;
 * }
 * </pre>
 */
public final class LevelFromHumiditySensor implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Integer value;
    
    /**
     * Get the value of the source <code>level</code>
     * 
     * @return the value of the source <code>level</code>
     */
    public java.lang.Integer value() {
        return value;
    }
    
    public LevelFromHumiditySensor(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Integer value) {
        this.sender = new HumiditySensorProxy(service, remoteServiceInfo);
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
        LevelFromHumiditySensor other = (LevelFromHumiditySensor) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private HumiditySensorProxy sender;
    
    /**
     * Get the sender of the source <code>level</code>. I.e., the <code>HumiditySensor</code> device that published the source.
     * 
     * @return A proxy to the <code>HumiditySensor</code> that triggered the source
     */
    public HumiditySensorProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>HumiditySensor</code> that discloses subscription/unsubscription methods.
     */
    public class HumiditySensorProxy extends Proxy {
        private HumiditySensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>level</code> from this <code>HumiditySensor</code>.
         */
        public void subscribeLevel() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "level");
        }
        
        /**
         * Unsubcribes from publication of source <code>level</code> from this <code>HumiditySensor</code>.
         */
        public void unsubscribeLevel() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "level");
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

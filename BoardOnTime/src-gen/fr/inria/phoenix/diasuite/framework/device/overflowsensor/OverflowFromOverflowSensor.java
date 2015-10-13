package fr.inria.phoenix.diasuite.framework.device.overflowsensor;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>overflow</code> of the device <code>OverflowSensor</code>.
 *
 * <pre>
 * device OverflowSensor extends Sensor {
 * 	source overflow as Boolean;
 * }
 * </pre>
 */
public final class OverflowFromOverflowSensor implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>overflow</code>
     * 
     * @return the value of the source <code>overflow</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public OverflowFromOverflowSensor(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value) {
        this.sender = new OverflowSensorProxy(service, remoteServiceInfo);
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
        OverflowFromOverflowSensor other = (OverflowFromOverflowSensor) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private OverflowSensorProxy sender;
    
    /**
     * Get the sender of the source <code>overflow</code>. I.e., the <code>OverflowSensor</code> device that published the source.
     * 
     * @return A proxy to the <code>OverflowSensor</code> that triggered the source
     */
    public OverflowSensorProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>OverflowSensor</code> that discloses subscription/unsubscription methods.
     */
    public class OverflowSensorProxy extends Proxy {
        private OverflowSensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>overflow</code> from this <code>OverflowSensor</code>.
         */
        public void subscribeOverflow() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "overflow");
        }
        
        /**
         * Unsubcribes from publication of source <code>overflow</code> from this <code>OverflowSensor</code>.
         */
        public void unsubscribeOverflow() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "overflow");
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

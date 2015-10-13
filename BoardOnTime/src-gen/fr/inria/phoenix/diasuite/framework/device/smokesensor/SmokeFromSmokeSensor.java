package fr.inria.phoenix.diasuite.framework.device.smokesensor;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>smoke</code> of the device <code>SmokeSensor</code>.
 *
 * <pre>
 * device SmokeSensor extends Sensor {
 * 	source smoke as Boolean;
 * }
 * </pre>
 */
public final class SmokeFromSmokeSensor implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>smoke</code>
     * 
     * @return the value of the source <code>smoke</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public SmokeFromSmokeSensor(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value) {
        this.sender = new SmokeSensorProxy(service, remoteServiceInfo);
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
        SmokeFromSmokeSensor other = (SmokeFromSmokeSensor) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private SmokeSensorProxy sender;
    
    /**
     * Get the sender of the source <code>smoke</code>. I.e., the <code>SmokeSensor</code> device that published the source.
     * 
     * @return A proxy to the <code>SmokeSensor</code> that triggered the source
     */
    public SmokeSensorProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>SmokeSensor</code> that discloses subscription/unsubscription methods.
     */
    public class SmokeSensorProxy extends Proxy {
        private SmokeSensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>smoke</code> from this <code>SmokeSensor</code>.
         */
        public void subscribeSmoke() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "smoke");
        }
        
        /**
         * Unsubcribes from publication of source <code>smoke</code> from this <code>SmokeSensor</code>.
         */
        public void unsubscribeSmoke() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "smoke");
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

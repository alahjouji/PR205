package fr.inria.phoenix.diasuite.framework.device.battery;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>batteryState</code> of the device <code>Battery</code>.
 *
 * <pre>
 * device Battery extends PhysicalDevice{
 * 	source batteryState as Integer;
 * }
 * </pre>
 */
public final class BatteryStateFromBattery implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Integer value;
    
    /**
     * Get the value of the source <code>batteryState</code>
     * 
     * @return the value of the source <code>batteryState</code>
     */
    public java.lang.Integer value() {
        return value;
    }
    
    public BatteryStateFromBattery(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Integer value) {
        this.sender = new BatteryProxy(service, remoteServiceInfo);
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
        BatteryStateFromBattery other = (BatteryStateFromBattery) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private BatteryProxy sender;
    
    /**
     * Get the sender of the source <code>batteryState</code>. I.e., the <code>Battery</code> device that published the source.
     * 
     * @return A proxy to the <code>Battery</code> that triggered the source
     */
    public BatteryProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Battery</code> that discloses subscription/unsubscription methods.
     */
    public class BatteryProxy extends Proxy {
        private BatteryProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>batteryState</code> from this <code>Battery</code>.
         */
        public void subscribeBatteryState() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "batteryState");
        }
        
        /**
         * Unsubcribes from publication of source <code>batteryState</code> from this <code>Battery</code>.
         */
        public void unsubscribeBatteryState() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "batteryState");
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

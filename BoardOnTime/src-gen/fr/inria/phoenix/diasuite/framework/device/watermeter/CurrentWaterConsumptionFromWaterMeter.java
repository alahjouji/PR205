package fr.inria.phoenix.diasuite.framework.device.watermeter;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>currentWaterConsumption</code> of the device <code>WaterMeter</code>.
 *
 * <pre>
 * device WaterMeter extends EnergyMeter {
 * 	source currentWaterConsumption as Float;
 * }
 * </pre>
 */
public final class CurrentWaterConsumptionFromWaterMeter implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Float value;
    
    /**
     * Get the value of the source <code>currentWaterConsumption</code>
     * 
     * @return the value of the source <code>currentWaterConsumption</code>
     */
    public java.lang.Float value() {
        return value;
    }
    
    public CurrentWaterConsumptionFromWaterMeter(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Float value) {
        this.sender = new WaterMeterProxy(service, remoteServiceInfo);
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
        CurrentWaterConsumptionFromWaterMeter other = (CurrentWaterConsumptionFromWaterMeter) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private WaterMeterProxy sender;
    
    /**
     * Get the sender of the source <code>currentWaterConsumption</code>. I.e., the <code>WaterMeter</code> device that published the source.
     * 
     * @return A proxy to the <code>WaterMeter</code> that triggered the source
     */
    public WaterMeterProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>WaterMeter</code> that discloses subscription/unsubscription methods.
     */
    public class WaterMeterProxy extends Proxy {
        private WaterMeterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>currentWaterConsumption</code> from this <code>WaterMeter</code>.
         */
        public void subscribeCurrentWaterConsumption() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentWaterConsumption");
        }
        
        /**
         * Unsubcribes from publication of source <code>currentWaterConsumption</code> from this <code>WaterMeter</code>.
         */
        public void unsubscribeCurrentWaterConsumption() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentWaterConsumption");
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

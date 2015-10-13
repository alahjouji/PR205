package fr.inria.phoenix.diasuite.framework.device.thermostat;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>targetTemperature</code> of the device <code>Thermostat</code>.
 *
 * <pre>
 * device Thermostat extends Appliance {
 * 	action SetTemperature;
 * 	source targetTemperature as Temperature;
 * }
 * </pre>
 */
public final class TargetTemperatureFromThermostat implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature value;
    
    /**
     * Get the value of the source <code>targetTemperature</code>
     * 
     * @return the value of the source <code>targetTemperature</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature value() {
        return value;
    }
    
    public TargetTemperatureFromThermostat(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature value) {
        this.sender = new ThermostatProxy(service, remoteServiceInfo);
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
        TargetTemperatureFromThermostat other = (TargetTemperatureFromThermostat) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private ThermostatProxy sender;
    
    /**
     * Get the sender of the source <code>targetTemperature</code>. I.e., the <code>Thermostat</code> device that published the source.
     * 
     * @return A proxy to the <code>Thermostat</code> that triggered the source
     */
    public ThermostatProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Thermostat</code> that discloses subscription/unsubscription methods.
     */
    public class ThermostatProxy extends Proxy {
        private ThermostatProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>targetTemperature</code> from this <code>Thermostat</code>.
         */
        public void subscribeTargetTemperature() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "targetTemperature");
        }
        
        /**
         * Unsubcribes from publication of source <code>targetTemperature</code> from this <code>Thermostat</code>.
         */
        public void unsubscribeTargetTemperature() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "targetTemperature");
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

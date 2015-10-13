package fr.inria.phoenix.diasuite.framework.device.electricmeter;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>currentElectricConsumption</code> of the device <code>ElectricMeter</code>.
 *
 * <pre>
 * device ElectricMeter extends EnergyMeter {
 * 	source currentElectricConsumption as State;
 * }
 * </pre>
 */
public final class CurrentElectricConsumptionFromElectricMeter implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.state.State value;
    
    /**
     * Get the value of the source <code>currentElectricConsumption</code>
     * 
     * @return the value of the source <code>currentElectricConsumption</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.state.State value() {
        return value;
    }
    
    public CurrentElectricConsumptionFromElectricMeter(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.state.State value) {
        this.sender = new ElectricMeterProxy(service, remoteServiceInfo);
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
        CurrentElectricConsumptionFromElectricMeter other = (CurrentElectricConsumptionFromElectricMeter) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private ElectricMeterProxy sender;
    
    /**
     * Get the sender of the source <code>currentElectricConsumption</code>. I.e., the <code>ElectricMeter</code> device that published the source.
     * 
     * @return A proxy to the <code>ElectricMeter</code> that triggered the source
     */
    public ElectricMeterProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>ElectricMeter</code> that discloses subscription/unsubscription methods.
     */
    public class ElectricMeterProxy extends Proxy {
        private ElectricMeterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>currentElectricConsumption</code> from this <code>ElectricMeter</code>.
         */
        public void subscribeCurrentElectricConsumption() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentElectricConsumption");
        }
        
        /**
         * Unsubcribes from publication of source <code>currentElectricConsumption</code> from this <code>ElectricMeter</code>.
         */
        public void unsubscribeCurrentElectricConsumption() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentElectricConsumption");
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

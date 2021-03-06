package fr.inria.phoenix.diasuite.framework.device.clock;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>tickHour</code> of the device <code>Clock</code>.
 *
 * <pre>
 * device Clock extends BuiltIn {
 * 	source tickSecond as Integer;
 * 	source tickMinute as Integer;
 * 	source tickHour as Integer;
 * }
 * </pre>
 */
public final class TickHourFromClock implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Integer value;
    
    /**
     * Get the value of the source <code>tickHour</code>
     * 
     * @return the value of the source <code>tickHour</code>
     */
    public java.lang.Integer value() {
        return value;
    }
    
    public TickHourFromClock(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Integer value) {
        this.sender = new ClockProxy(service, remoteServiceInfo);
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
        TickHourFromClock other = (TickHourFromClock) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private ClockProxy sender;
    
    /**
     * Get the sender of the source <code>tickHour</code>. I.e., the <code>Clock</code> device that published the source.
     * 
     * @return A proxy to the <code>Clock</code> that triggered the source
     */
    public ClockProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Clock</code> that discloses subscription/unsubscription methods.
     */
    public class ClockProxy extends Proxy {
        private ClockProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>tickHour</code> from this <code>Clock</code>.
         */
        public void subscribeTickHour() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tickHour");
        }
        
        /**
         * Unsubcribes from publication of source <code>tickHour</code> from this <code>Clock</code>.
         */
        public void unsubscribeTickHour() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tickHour");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

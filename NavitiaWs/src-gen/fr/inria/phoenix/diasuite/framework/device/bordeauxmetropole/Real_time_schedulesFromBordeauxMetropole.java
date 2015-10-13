package fr.inria.phoenix.diasuite.framework.device.bordeauxmetropole;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>real_time_schedules</code> of the device <code>BordeauxMetropole</code>.
 *
 * <pre>
 * device BordeauxMetropole extends Device {
 * 	source real_time_schedules as Cross;
 * 	source theoretical_schedules as Cross;
 * 	source bikes as Bikes indexed by filter as BikesAv;
 * }
 * </pre>
 */
public final class Real_time_schedulesFromBordeauxMetropole implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.cross.Cross value;
    
    /**
     * Get the value of the source <code>real_time_schedules</code>
     * 
     * @return the value of the source <code>real_time_schedules</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.cross.Cross value() {
        return value;
    }
    
    public Real_time_schedulesFromBordeauxMetropole(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.cross.Cross value) {
        this.sender = new BordeauxMetropoleProxy(service, remoteServiceInfo);
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
        Real_time_schedulesFromBordeauxMetropole other = (Real_time_schedulesFromBordeauxMetropole) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private BordeauxMetropoleProxy sender;
    
    /**
     * Get the sender of the source <code>real_time_schedules</code>. I.e., the <code>BordeauxMetropole</code> device that published the source.
     * 
     * @return A proxy to the <code>BordeauxMetropole</code> that triggered the source
     */
    public BordeauxMetropoleProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>BordeauxMetropole</code> that discloses subscription/unsubscription methods.
     */
    public class BordeauxMetropoleProxy extends Proxy {
        private BordeauxMetropoleProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>real_time_schedules</code> from this <code>BordeauxMetropole</code>.
         */
        public void subscribeReal_time_schedules() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "real_time_schedules");
        }
        
        /**
         * Unsubcribes from publication of source <code>real_time_schedules</code> from this <code>BordeauxMetropole</code>.
         */
        public void unsubscribeReal_time_schedules() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "real_time_schedules");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

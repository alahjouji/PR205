package fr.inria.phoenix.diasuite.framework.device.bordeauxmetropole;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>bikes</code> of the device <code>BordeauxMetropole</code>.
 *
 * <pre>
 * device BordeauxMetropole extends Device {
 * 	source real_time_schedules as Cross;
 * 	source theoretical_schedules as Cross;
 * 	source bikes as Bikes indexed by filter as BikesAv;
 * }
 * </pre>
 */
public final class BikesFromBordeauxMetropole implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes value;
    
    /**
     * Get the value of the source <code>bikes</code>
     * 
     * @return the value of the source <code>bikes</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes value() {
        return value;
    }
    
    private BikesIndices indices;
    
    /**
     * Get the value of the indices of the source <code>bikes</code>
     * 
     * @return the value of the indices
     */
    public BikesIndices indices() {
        return indices;
    }
    
    public BikesFromBordeauxMetropole(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes value, BikesIndices indices) {
        this.sender = new BordeauxMetropoleProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public BikesFromBordeauxMetropole(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes value,
            fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv filter) {
        this.sender = new BordeauxMetropoleProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new BikesIndices(filter);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((indices == null) ? 0 : indices.hashCode());
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
        BikesFromBordeauxMetropole other = (BikesFromBordeauxMetropole) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (indices == null) {
            if (other.indices != null)
                return false;
        } else if (!indices.equals(other.indices))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private BordeauxMetropoleProxy sender;
    
    /**
     * Get the sender of the source <code>bikes</code>. I.e., the <code>BordeauxMetropole</code> device that published the source.
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
         * Subcribes to publication of source <code>bikes</code> from this <code>BordeauxMetropole</code>.
         */
        public void subscribeBikes() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "bikes");
        }
        
        /**
         * Unsubcribes from publication of source <code>bikes</code> from this <code>BordeauxMetropole</code>.
         */
        public void unsubscribeBikes() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "bikes");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

package fr.inria.phoenix.diasuite.framework.device.navitiaws;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>journeys</code> of the device <code>NavitiaWS</code>.
 *
 * <pre>
 * device NavitiaWS extends Device {
 * 	source journeys as Sending indexed by filter as String;
 * }
 * </pre>
 */
public final class JourneysFromNavitiaWS implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.sending.Sending value;
    
    /**
     * Get the value of the source <code>journeys</code>
     * 
     * @return the value of the source <code>journeys</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.sending.Sending value() {
        return value;
    }
    
    private JourneysIndices indices;
    
    /**
     * Get the value of the indices of the source <code>journeys</code>
     * 
     * @return the value of the indices
     */
    public JourneysIndices indices() {
        return indices;
    }
    
    public JourneysFromNavitiaWS(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.sending.Sending value, JourneysIndices indices) {
        this.sender = new NavitiaWSProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public JourneysFromNavitiaWS(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.sending.Sending value,
            java.lang.String filter) {
        this.sender = new NavitiaWSProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new JourneysIndices(filter);
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
        JourneysFromNavitiaWS other = (JourneysFromNavitiaWS) obj;
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
    private NavitiaWSProxy sender;
    
    /**
     * Get the sender of the source <code>journeys</code>. I.e., the <code>NavitiaWS</code> device that published the source.
     * 
     * @return A proxy to the <code>NavitiaWS</code> that triggered the source
     */
    public NavitiaWSProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>NavitiaWS</code> that discloses subscription/unsubscription methods.
     */
    public class NavitiaWSProxy extends Proxy {
        private NavitiaWSProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>journeys</code> from this <code>NavitiaWS</code>.
         */
        public void subscribeJourneys() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "journeys");
        }
        
        /**
         * Unsubcribes from publication of source <code>journeys</code> from this <code>NavitiaWS</code>.
         */
        public void unsubscribeJourneys() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "journeys");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

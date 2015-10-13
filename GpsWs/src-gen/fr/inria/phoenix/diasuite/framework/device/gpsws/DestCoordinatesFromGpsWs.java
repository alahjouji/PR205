package fr.inria.phoenix.diasuite.framework.device.gpsws;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>destCoordinates</code> of the device <code>GpsWs</code>.
 *
 * <pre>
 * device GpsWs extends Device {
 * 	source destCoordinates as GpsCoordinates indexed by filter as String;
 * }
 * </pre>
 */
public final class DestCoordinatesFromGpsWs implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates value;
    
    /**
     * Get the value of the source <code>destCoordinates</code>
     * 
     * @return the value of the source <code>destCoordinates</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates value() {
        return value;
    }
    
    private DestCoordinatesIndices indices;
    
    /**
     * Get the value of the indices of the source <code>destCoordinates</code>
     * 
     * @return the value of the indices
     */
    public DestCoordinatesIndices indices() {
        return indices;
    }
    
    public DestCoordinatesFromGpsWs(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates value, DestCoordinatesIndices indices) {
        this.sender = new GpsWsProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public DestCoordinatesFromGpsWs(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates value,
            java.lang.String filter) {
        this.sender = new GpsWsProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new DestCoordinatesIndices(filter);
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
        DestCoordinatesFromGpsWs other = (DestCoordinatesFromGpsWs) obj;
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
    private GpsWsProxy sender;
    
    /**
     * Get the sender of the source <code>destCoordinates</code>. I.e., the <code>GpsWs</code> device that published the source.
     * 
     * @return A proxy to the <code>GpsWs</code> that triggered the source
     */
    public GpsWsProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>GpsWs</code> that discloses subscription/unsubscription methods.
     */
    public class GpsWsProxy extends Proxy {
        private GpsWsProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>destCoordinates</code> from this <code>GpsWs</code>.
         */
        public void subscribeDestCoordinates() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "destCoordinates");
        }
        
        /**
         * Unsubcribes from publication of source <code>destCoordinates</code> from this <code>GpsWs</code>.
         */
        public void unsubscribeDestCoordinates() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "destCoordinates");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

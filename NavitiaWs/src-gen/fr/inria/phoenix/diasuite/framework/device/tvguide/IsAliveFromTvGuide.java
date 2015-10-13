package fr.inria.phoenix.diasuite.framework.device.tvguide;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>isAlive</code> of the device <code>TvGuide</code>.
 *
 * <pre>
 * device TvGuide extends HomeService {
 * 	source availableChannels as Channel[];
 * 	source currentProgram as TvSchedule indexed by channelId as String;
 * 	source nextProgram as TvSchedule indexed by channelId as String;
 * 	source programs as TvSchedule[] indexed by filter as TvSchedule;
 * }
 * </pre>
 */
public final class IsAliveFromTvGuide implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the source <code>isAlive</code>
     * 
     * @return the value of the source <code>isAlive</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public IsAliveFromTvGuide(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.Boolean value) {
        this.sender = new TvGuideProxy(service, remoteServiceInfo);
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
        IsAliveFromTvGuide other = (IsAliveFromTvGuide) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private TvGuideProxy sender;
    
    /**
     * Get the sender of the source <code>isAlive</code>. I.e., the <code>TvGuide</code> device that published the source.
     * 
     * @return A proxy to the <code>TvGuide</code> that triggered the source
     */
    public TvGuideProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>TvGuide</code> that discloses subscription/unsubscription methods.
     */
    public class TvGuideProxy extends Proxy {
        private TvGuideProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>isAlive</code> from this <code>TvGuide</code>.
         */
        public void subscribeIsAlive() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "isAlive");
        }
        
        /**
         * Unsubcribes from publication of source <code>isAlive</code> from this <code>TvGuide</code>.
         */
        public void unsubscribeIsAlive() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "isAlive");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

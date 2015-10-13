package fr.inria.phoenix.diasuite.framework.device.telephonygateway;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>missedCalls</code> of the device <code>TelephonyGateway</code>.
 *
 * <pre>
 * device TelephonyGateway extends HomeService {
 * 	action TelephonyGatewayConfiguration;
 * 	source redirectionNumberOut as String;
 * 	source redirectionNumberIn as String;
 * 	source currentCall as Call;
 * 	source missedCalls as MissedCall[];
 * 	source lastMissedCall as MissedCall;
 * }
 * </pre>
 */
public final class MissedCallsFromTelephonyGateway implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> value;
    
    /**
     * Get the value of the source <code>missedCalls</code>
     * 
     * @return the value of the source <code>missedCalls</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> value() {
        return value;
    }
    
    public MissedCallsFromTelephonyGateway(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> value) {
        this.sender = new TelephonyGatewayProxy(service, remoteServiceInfo);
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
        MissedCallsFromTelephonyGateway other = (MissedCallsFromTelephonyGateway) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private TelephonyGatewayProxy sender;
    
    /**
     * Get the sender of the source <code>missedCalls</code>. I.e., the <code>TelephonyGateway</code> device that published the source.
     * 
     * @return A proxy to the <code>TelephonyGateway</code> that triggered the source
     */
    public TelephonyGatewayProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>TelephonyGateway</code> that discloses subscription/unsubscription methods.
     */
    public class TelephonyGatewayProxy extends Proxy {
        private TelephonyGatewayProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>missedCalls</code> from this <code>TelephonyGateway</code>.
         */
        public void subscribeMissedCalls() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "missedCalls");
        }
        
        /**
         * Unsubcribes from publication of source <code>missedCalls</code> from this <code>TelephonyGateway</code>.
         */
        public void unsubscribeMissedCalls() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "missedCalls");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

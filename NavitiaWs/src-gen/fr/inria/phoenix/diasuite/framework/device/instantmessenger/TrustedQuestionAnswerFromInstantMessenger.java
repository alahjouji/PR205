package fr.inria.phoenix.diasuite.framework.device.instantmessenger;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>trustedQuestionAnswer</code> of the device <code>InstantMessenger</code>.
 *
 * <pre>
 * device InstantMessenger extends CommunicationService {
 * }
 * </pre>
 */
public final class TrustedQuestionAnswerFromInstantMessenger implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the source <code>trustedQuestionAnswer</code>
     * 
     * @return the value of the source <code>trustedQuestionAnswer</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    private TrustedQuestionAnswerIndices indices;
    
    /**
     * Get the value of the indices of the source <code>trustedQuestionAnswer</code>
     * 
     * @return the value of the indices
     */
    public TrustedQuestionAnswerIndices indices() {
        return indices;
    }
    
    public TrustedQuestionAnswerFromInstantMessenger(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, TrustedQuestionAnswerIndices indices) {
        this.sender = new InstantMessengerProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public TrustedQuestionAnswerFromInstantMessenger(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value,
            java.lang.String questionId) {
        this.sender = new InstantMessengerProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new TrustedQuestionAnswerIndices(questionId);
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
        TrustedQuestionAnswerFromInstantMessenger other = (TrustedQuestionAnswerFromInstantMessenger) obj;
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
    private InstantMessengerProxy sender;
    
    /**
     * Get the sender of the source <code>trustedQuestionAnswer</code>. I.e., the <code>InstantMessenger</code> device that published the source.
     * 
     * @return A proxy to the <code>InstantMessenger</code> that triggered the source
     */
    public InstantMessengerProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>InstantMessenger</code> that discloses subscription/unsubscription methods.
     */
    public class InstantMessengerProxy extends Proxy {
        private InstantMessengerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>trustedQuestionAnswer</code> from this <code>InstantMessenger</code>.
         */
        public void subscribeTrustedQuestionAnswer() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "trustedQuestionAnswer");
        }
        
        /**
         * Unsubcribes from publication of source <code>trustedQuestionAnswer</code> from this <code>InstantMessenger</code>.
         */
        public void unsubscribeTrustedQuestionAnswer() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "trustedQuestionAnswer");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

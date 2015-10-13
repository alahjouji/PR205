package fr.inria.phoenix.diasuite.framework.device.smssender;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>questionAnswer</code> of the device <code>SMSSender</code>.
 *
 * <pre>
 * device SMSSender extends CommunicationService {
 * }
 * </pre>
 */
public final class QuestionAnswerFromSMSSender implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the source <code>questionAnswer</code>
     * 
     * @return the value of the source <code>questionAnswer</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    private QuestionAnswerIndices indices;
    
    /**
     * Get the value of the indices of the source <code>questionAnswer</code>
     * 
     * @return the value of the indices
     */
    public QuestionAnswerIndices indices() {
        return indices;
    }
    
    public QuestionAnswerFromSMSSender(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, QuestionAnswerIndices indices) {
        this.sender = new SMSSenderProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public QuestionAnswerFromSMSSender(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value,
            java.lang.String questionId) {
        this.sender = new SMSSenderProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new QuestionAnswerIndices(questionId);
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
        QuestionAnswerFromSMSSender other = (QuestionAnswerFromSMSSender) obj;
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
    private SMSSenderProxy sender;
    
    /**
     * Get the sender of the source <code>questionAnswer</code>. I.e., the <code>SMSSender</code> device that published the source.
     * 
     * @return A proxy to the <code>SMSSender</code> that triggered the source
     */
    public SMSSenderProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>SMSSender</code> that discloses subscription/unsubscription methods.
     */
    public class SMSSenderProxy extends Proxy {
        private SMSSenderProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>questionAnswer</code> from this <code>SMSSender</code>.
         */
        public void subscribeQuestionAnswer() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "questionAnswer");
        }
        
        /**
         * Unsubcribes from publication of source <code>questionAnswer</code> from this <code>SMSSender</code>.
         */
        public void unsubscribeQuestionAnswer() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "questionAnswer");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

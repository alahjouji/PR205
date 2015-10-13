package fr.inria.phoenix.diasuite.framework.device.communicationservice;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>lastMessage</code> of the device <code>CommunicationService</code>.
 *
 * <pre>
 * device CommunicationService extends Service {
 * 	action SendMessage;
 * 	action AskQuestion;
 * 	source questionAnswer as String indexed by questionId as String;
 * 	source lastMessage as Message;
 * 	action SendTrustedMessage; 
 * 	action AskTrustedQuestion; 
 * 	source trustedQuestionAnswer as String indexed by questionId as String;
 * 	source lastTrustedMessage as Message;
 * 	source safeContacts as Contact[];
 * }
 * </pre>
 */
public final class LastMessageFromCommunicationService implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.message.Message value;
    
    /**
     * Get the value of the source <code>lastMessage</code>
     * 
     * @return the value of the source <code>lastMessage</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.message.Message value() {
        return value;
    }
    
    public LastMessageFromCommunicationService(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.message.Message value) {
        this.sender = new CommunicationServiceProxy(service, remoteServiceInfo);
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
        LastMessageFromCommunicationService other = (LastMessageFromCommunicationService) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private CommunicationServiceProxy sender;
    
    /**
     * Get the sender of the source <code>lastMessage</code>. I.e., the <code>CommunicationService</code> device that published the source.
     * 
     * @return A proxy to the <code>CommunicationService</code> that triggered the source
     */
    public CommunicationServiceProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>CommunicationService</code> that discloses subscription/unsubscription methods.
     */
    public class CommunicationServiceProxy extends Proxy {
        private CommunicationServiceProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>lastMessage</code> from this <code>CommunicationService</code>.
         */
        public void subscribeLastMessage() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "lastMessage");
        }
        
        /**
         * Unsubcribes from publication of source <code>lastMessage</code> from this <code>CommunicationService</code>.
         */
        public void unsubscribeLastMessage() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "lastMessage");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

package fr.inria.phoenix.diasuite.framework.device.initiator;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>answer2</code> of the device <code>Initiator</code>.
 *
 * <pre>
 * device Initiator extends PhysicalDevice {
 * 	source answer1 as String;
 * 	source answer2 as String;
 * }
 * </pre>
 */
public final class Answer2FromInitiator implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the source <code>answer2</code>
     * 
     * @return the value of the source <code>answer2</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    public Answer2FromInitiator(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value) {
        this.sender = new InitiatorProxy(service, remoteServiceInfo);
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
        Answer2FromInitiator other = (Answer2FromInitiator) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private InitiatorProxy sender;
    
    /**
     * Get the sender of the source <code>answer2</code>. I.e., the <code>Initiator</code> device that published the source.
     * 
     * @return A proxy to the <code>Initiator</code> that triggered the source
     */
    public InitiatorProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Initiator</code> that discloses subscription/unsubscription methods.
     */
    public class InitiatorProxy extends Proxy {
        private InitiatorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>answer2</code> from this <code>Initiator</code>.
         */
        public void subscribeAnswer2() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "answer2");
        }
        
        /**
         * Unsubcribes from publication of source <code>answer2</code> from this <code>Initiator</code>.
         */
        public void unsubscribeAnswer2() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "answer2");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>location</code> attribute
         */
        public java.lang.String location() {
            return (java.lang.String) callGetValue("location");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
}

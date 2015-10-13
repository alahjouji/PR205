package fr.inria.phoenix.diasuite.framework.device.screenprompter;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>answer</code> of the device <code>ScreenPrompter</code>.
 *
 * <pre>
 * device ScreenPrompter extends Prompter {
 * }
 * </pre>
 */
public final class AnswerFromScreenPrompter implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the source <code>answer</code>
     * 
     * @return the value of the source <code>answer</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    private AnswerIndices indices;
    
    /**
     * Get the value of the indices of the source <code>answer</code>
     * 
     * @return the value of the indices
     */
    public AnswerIndices indices() {
        return indices;
    }
    
    public AnswerFromScreenPrompter(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, AnswerIndices indices) {
        this.sender = new ScreenPrompterProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public AnswerFromScreenPrompter(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value,
            java.lang.String questionId) {
        this.sender = new ScreenPrompterProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new AnswerIndices(questionId);
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
        AnswerFromScreenPrompter other = (AnswerFromScreenPrompter) obj;
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
    private ScreenPrompterProxy sender;
    
    /**
     * Get the sender of the source <code>answer</code>. I.e., the <code>ScreenPrompter</code> device that published the source.
     * 
     * @return A proxy to the <code>ScreenPrompter</code> that triggered the source
     */
    public ScreenPrompterProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>ScreenPrompter</code> that discloses subscription/unsubscription methods.
     */
    public class ScreenPrompterProxy extends Proxy {
        private ScreenPrompterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>answer</code> from this <code>ScreenPrompter</code>.
         */
        public void subscribeAnswer() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "answer");
        }
        
        /**
         * Unsubcribes from publication of source <code>answer</code> from this <code>ScreenPrompter</code>.
         */
        public void unsubscribeAnswer() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "answer");
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

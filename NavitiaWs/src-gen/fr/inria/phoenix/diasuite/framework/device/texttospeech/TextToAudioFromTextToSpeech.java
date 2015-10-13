package fr.inria.phoenix.diasuite.framework.device.texttospeech;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>textToAudio</code> of the device <code>TextToSpeech</code>.
 *
 * <pre>
 * device TextToSpeech extends PhysicalDevice {
 * 	source textToAudio as File indexed by text as String;
 * }
 * </pre>
 */
public final class TextToAudioFromTextToSpeech implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.file.File value;
    
    /**
     * Get the value of the source <code>textToAudio</code>
     * 
     * @return the value of the source <code>textToAudio</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File value() {
        return value;
    }
    
    private TextToAudioIndices indices;
    
    /**
     * Get the value of the indices of the source <code>textToAudio</code>
     * 
     * @return the value of the indices
     */
    public TextToAudioIndices indices() {
        return indices;
    }
    
    public TextToAudioFromTextToSpeech(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value, TextToAudioIndices indices) {
        this.sender = new TextToSpeechProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public TextToAudioFromTextToSpeech(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value,
            java.lang.String text) {
        this.sender = new TextToSpeechProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new TextToAudioIndices(text);
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
        TextToAudioFromTextToSpeech other = (TextToAudioFromTextToSpeech) obj;
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
    private TextToSpeechProxy sender;
    
    /**
     * Get the sender of the source <code>textToAudio</code>. I.e., the <code>TextToSpeech</code> device that published the source.
     * 
     * @return A proxy to the <code>TextToSpeech</code> that triggered the source
     */
    public TextToSpeechProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>TextToSpeech</code> that discloses subscription/unsubscription methods.
     */
    public class TextToSpeechProxy extends Proxy {
        private TextToSpeechProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>textToAudio</code> from this <code>TextToSpeech</code>.
         */
        public void subscribeTextToAudio() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "textToAudio");
        }
        
        /**
         * Unsubcribes from publication of source <code>textToAudio</code> from this <code>TextToSpeech</code>.
         */
        public void unsubscribeTextToAudio() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "textToAudio");
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

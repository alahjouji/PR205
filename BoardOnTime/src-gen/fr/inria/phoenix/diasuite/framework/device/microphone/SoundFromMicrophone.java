package fr.inria.phoenix.diasuite.framework.device.microphone;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>sound</code> of the device <code>Microphone</code>.
 *
 * <pre>
 * device Microphone extends PhysicalDevice {
 * 	action StartStopRecording;
 * 	source sound as File;
 * }
 * </pre>
 */
public final class SoundFromMicrophone implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.file.File value;
    
    /**
     * Get the value of the source <code>sound</code>
     * 
     * @return the value of the source <code>sound</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File value() {
        return value;
    }
    
    public SoundFromMicrophone(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value) {
        this.sender = new MicrophoneProxy(service, remoteServiceInfo);
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
        SoundFromMicrophone other = (SoundFromMicrophone) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private MicrophoneProxy sender;
    
    /**
     * Get the sender of the source <code>sound</code>. I.e., the <code>Microphone</code> device that published the source.
     * 
     * @return A proxy to the <code>Microphone</code> that triggered the source
     */
    public MicrophoneProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Microphone</code> that discloses subscription/unsubscription methods.
     */
    public class MicrophoneProxy extends Proxy {
        private MicrophoneProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>sound</code> from this <code>Microphone</code>.
         */
        public void subscribeSound() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "sound");
        }
        
        /**
         * Unsubcribes from publication of source <code>sound</code> from this <code>Microphone</code>.
         */
        public void unsubscribeSound() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "sound");
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

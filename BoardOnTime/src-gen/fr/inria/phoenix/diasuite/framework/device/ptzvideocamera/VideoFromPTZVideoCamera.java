package fr.inria.phoenix.diasuite.framework.device.ptzvideocamera;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>video</code> of the device <code>PTZVideoCamera</code>.
 *
 * <pre>
 * device PTZVideoCamera extends VideoCamera {
 * 	action PTZ;
 * 	source panAngle as Float;
 * 	source tiltAngle as Float;
 * 	source zoom as Float;
 * }
 * </pre>
 */
public final class VideoFromPTZVideoCamera implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.file.File value;
    
    /**
     * Get the value of the source <code>video</code>
     * 
     * @return the value of the source <code>video</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File value() {
        return value;
    }
    
    public VideoFromPTZVideoCamera(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value) {
        this.sender = new PTZVideoCameraProxy(service, remoteServiceInfo);
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
        VideoFromPTZVideoCamera other = (VideoFromPTZVideoCamera) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private PTZVideoCameraProxy sender;
    
    /**
     * Get the sender of the source <code>video</code>. I.e., the <code>PTZVideoCamera</code> device that published the source.
     * 
     * @return A proxy to the <code>PTZVideoCamera</code> that triggered the source
     */
    public PTZVideoCameraProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>PTZVideoCamera</code> that discloses subscription/unsubscription methods.
     */
    public class PTZVideoCameraProxy extends Proxy {
        private PTZVideoCameraProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>video</code> from this <code>PTZVideoCamera</code>.
         */
        public void subscribeVideo() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "video");
        }
        
        /**
         * Unsubcribes from publication of source <code>video</code> from this <code>PTZVideoCamera</code>.
         */
        public void unsubscribeVideo() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "video");
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

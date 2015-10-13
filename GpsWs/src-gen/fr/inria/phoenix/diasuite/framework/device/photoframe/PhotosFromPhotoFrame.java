package fr.inria.phoenix.diasuite.framework.device.photoframe;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>photos</code> of the device <code>PhotoFrame</code>.
 *
 * <pre>
 * device PhotoFrame extends PhysicalDevice {
 * 	source photos as File[];
 * 	action PhotoFrameManagement;
 * }
 * </pre>
 */
public final class PhotosFromPhotoFrame implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> value;
    
    /**
     * Get the value of the source <code>photos</code>
     * 
     * @return the value of the source <code>photos</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> value() {
        return value;
    }
    
    public PhotosFromPhotoFrame(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> value) {
        this.sender = new PhotoFrameProxy(service, remoteServiceInfo);
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
        PhotosFromPhotoFrame other = (PhotosFromPhotoFrame) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private PhotoFrameProxy sender;
    
    /**
     * Get the sender of the source <code>photos</code>. I.e., the <code>PhotoFrame</code> device that published the source.
     * 
     * @return A proxy to the <code>PhotoFrame</code> that triggered the source
     */
    public PhotoFrameProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>PhotoFrame</code> that discloses subscription/unsubscription methods.
     */
    public class PhotoFrameProxy extends Proxy {
        private PhotoFrameProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>photos</code> from this <code>PhotoFrame</code>.
         */
        public void subscribePhotos() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "photos");
        }
        
        /**
         * Unsubcribes from publication of source <code>photos</code> from this <code>PhotoFrame</code>.
         */
        public void unsubscribePhotos() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "photos");
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
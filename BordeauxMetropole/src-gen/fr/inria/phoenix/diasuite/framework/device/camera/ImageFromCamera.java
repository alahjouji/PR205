package fr.inria.phoenix.diasuite.framework.device.camera;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>image</code> of the device <code>Camera</code>.
 *
 * <pre>
 * device Camera extends PhysicalDevice {
 * 	source image as File;
 * }
 * </pre>
 */
public final class ImageFromCamera implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.file.File value;
    
    /**
     * Get the value of the source <code>image</code>
     * 
     * @return the value of the source <code>image</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File value() {
        return value;
    }
    
    public ImageFromCamera(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value) {
        this.sender = new CameraProxy(service, remoteServiceInfo);
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
        ImageFromCamera other = (ImageFromCamera) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private CameraProxy sender;
    
    /**
     * Get the sender of the source <code>image</code>. I.e., the <code>Camera</code> device that published the source.
     * 
     * @return A proxy to the <code>Camera</code> that triggered the source
     */
    public CameraProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Camera</code> that discloses subscription/unsubscription methods.
     */
    public class CameraProxy extends Proxy {
        private CameraProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>image</code> from this <code>Camera</code>.
         */
        public void subscribeImage() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "image");
        }
        
        /**
         * Unsubcribes from publication of source <code>image</code> from this <code>Camera</code>.
         */
        public void unsubscribeImage() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "image");
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

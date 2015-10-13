package fr.inria.phoenix.diasuite.framework.device.photolibrary;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>albums</code> of the device <code>PhotoLibrary</code>.
 *
 * <pre>
 * device PhotoLibrary extends Device {
 * 	attribute owner as String;
 * 	source photos as Photo [] indexed by filter as PhotoFilter;
 * 	source albums as PhotoAlbum [] indexed by filter as PhotoAlbumFilter;
 * 	action AddPhoto;
 * 	action AddPhotoToAlbum;
 * 	action RemovePhoto;
 * 	action RemovePhotoFromAlbum;
 * }
 * </pre>
 */
public final class AlbumsFromPhotoLibrary implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> value;
    
    /**
     * Get the value of the source <code>albums</code>
     * 
     * @return the value of the source <code>albums</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> value() {
        return value;
    }
    
    private AlbumsIndices indices;
    
    /**
     * Get the value of the indices of the source <code>albums</code>
     * 
     * @return the value of the indices
     */
    public AlbumsIndices indices() {
        return indices;
    }
    
    public AlbumsFromPhotoLibrary(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> value, AlbumsIndices indices) {
        this.sender = new PhotoLibraryProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public AlbumsFromPhotoLibrary(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photoalbum.PhotoAlbum> value,
            fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter.PhotoAlbumFilter filter) {
        this.sender = new PhotoLibraryProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new AlbumsIndices(filter);
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
        AlbumsFromPhotoLibrary other = (AlbumsFromPhotoLibrary) obj;
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
    private PhotoLibraryProxy sender;
    
    /**
     * Get the sender of the source <code>albums</code>. I.e., the <code>PhotoLibrary</code> device that published the source.
     * 
     * @return A proxy to the <code>PhotoLibrary</code> that triggered the source
     */
    public PhotoLibraryProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>PhotoLibrary</code> that discloses subscription/unsubscription methods.
     */
    public class PhotoLibraryProxy extends Proxy {
        private PhotoLibraryProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>albums</code> from this <code>PhotoLibrary</code>.
         */
        public void subscribeAlbums() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "albums");
        }
        
        /**
         * Unsubcribes from publication of source <code>albums</code> from this <code>PhotoLibrary</code>.
         */
        public void unsubscribeAlbums() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "albums");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>owner</code> attribute
         */
        public java.lang.String owner() {
            return (java.lang.String) callGetValue("owner");
        }
    }
}

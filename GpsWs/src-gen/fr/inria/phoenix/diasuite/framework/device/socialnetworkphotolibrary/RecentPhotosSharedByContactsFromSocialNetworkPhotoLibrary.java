package fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>recentPhotosSharedByContacts</code> of the device <code>SocialNetworkPhotoLibrary</code>.
 *
 * <pre>
 * device SocialNetworkPhotoLibrary extends PhotoLibrary {
 * 	source recentPhotosSharedByContacts as Photo [] indexed by filter as PhotoFilter;
 * 	source tags as Tag [] indexed by photoID as String;
 * 	source comments as Comment [] indexed by photoID as String;
 * }
 * </pre>
 */
public final class RecentPhotosSharedByContactsFromSocialNetworkPhotoLibrary implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> value;
    
    /**
     * Get the value of the source <code>recentPhotosSharedByContacts</code>
     * 
     * @return the value of the source <code>recentPhotosSharedByContacts</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> value() {
        return value;
    }
    
    private RecentPhotosSharedByContactsIndices indices;
    
    /**
     * Get the value of the indices of the source <code>recentPhotosSharedByContacts</code>
     * 
     * @return the value of the indices
     */
    public RecentPhotosSharedByContactsIndices indices() {
        return indices;
    }
    
    public RecentPhotosSharedByContactsFromSocialNetworkPhotoLibrary(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> value, RecentPhotosSharedByContactsIndices indices) {
        this.sender = new SocialNetworkPhotoLibraryProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public RecentPhotosSharedByContactsFromSocialNetworkPhotoLibrary(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> value,
            fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
        this.sender = new SocialNetworkPhotoLibraryProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new RecentPhotosSharedByContactsIndices(filter);
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
        RecentPhotosSharedByContactsFromSocialNetworkPhotoLibrary other = (RecentPhotosSharedByContactsFromSocialNetworkPhotoLibrary) obj;
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
    private SocialNetworkPhotoLibraryProxy sender;
    
    /**
     * Get the sender of the source <code>recentPhotosSharedByContacts</code>. I.e., the <code>SocialNetworkPhotoLibrary</code> device that published the source.
     * 
     * @return A proxy to the <code>SocialNetworkPhotoLibrary</code> that triggered the source
     */
    public SocialNetworkPhotoLibraryProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>SocialNetworkPhotoLibrary</code> that discloses subscription/unsubscription methods.
     */
    public class SocialNetworkPhotoLibraryProxy extends Proxy {
        private SocialNetworkPhotoLibraryProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>recentPhotosSharedByContacts</code> from this <code>SocialNetworkPhotoLibrary</code>.
         */
        public void subscribeRecentPhotosSharedByContacts() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "recentPhotosSharedByContacts");
        }
        
        /**
         * Unsubcribes from publication of source <code>recentPhotosSharedByContacts</code> from this <code>SocialNetworkPhotoLibrary</code>.
         */
        public void unsubscribeRecentPhotosSharedByContacts() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "recentPhotosSharedByContacts");
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

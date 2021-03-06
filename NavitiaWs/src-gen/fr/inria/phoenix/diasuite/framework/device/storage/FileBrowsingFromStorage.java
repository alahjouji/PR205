package fr.inria.phoenix.diasuite.framework.device.storage;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>fileBrowsing</code> of the device <code>Storage</code>.
 *
 * <pre>
 * device Storage extends PhysicalDevice {
 * 	attribute name as String;
 * 	source file as File indexed by info as FileInfo;
 * 	source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
 * 	action StoragePutAction;
 * 	action StorageDeleteAction;
 * }
 * </pre>
 */
public final class FileBrowsingFromStorage implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> value;
    
    /**
     * Get the value of the source <code>fileBrowsing</code>
     * 
     * @return the value of the source <code>fileBrowsing</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> value() {
        return value;
    }
    
    private FileBrowsingIndices indices;
    
    /**
     * Get the value of the indices of the source <code>fileBrowsing</code>
     * 
     * @return the value of the indices
     */
    public FileBrowsingIndices indices() {
        return indices;
    }
    
    public FileBrowsingFromStorage(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> value, FileBrowsingIndices indices) {
        this.sender = new StorageProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public FileBrowsingFromStorage(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> value,
            fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
        this.sender = new StorageProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new FileBrowsingIndices(directory, filter);
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
        FileBrowsingFromStorage other = (FileBrowsingFromStorage) obj;
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
    private StorageProxy sender;
    
    /**
     * Get the sender of the source <code>fileBrowsing</code>. I.e., the <code>Storage</code> device that published the source.
     * 
     * @return A proxy to the <code>Storage</code> that triggered the source
     */
    public StorageProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>Storage</code> that discloses subscription/unsubscription methods.
     */
    public class StorageProxy extends Proxy {
        private StorageProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>fileBrowsing</code> from this <code>Storage</code>.
         */
        public void subscribeFileBrowsing() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "fileBrowsing");
        }
        
        /**
         * Unsubcribes from publication of source <code>fileBrowsing</code> from this <code>Storage</code>.
         */
        public void unsubscribeFileBrowsing() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "fileBrowsing");
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
        
        /**
         * @return the value of the <code>name</code> attribute
         */
        public java.lang.String name() {
            return (java.lang.String) callGetValue("name");
        }
    }
}

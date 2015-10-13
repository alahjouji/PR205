package fr.inria.phoenix.diasuite.framework.device.networkstorage;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>file</code> of the device <code>NetworkStorage</code>.
 *
 * <pre>
 * device NetworkStorage extends Storage {
 * }
 * </pre>
 */
public final class FileFromNetworkStorage implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.file.File value;
    
    /**
     * Get the value of the source <code>file</code>
     * 
     * @return the value of the source <code>file</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File value() {
        return value;
    }
    
    private FileIndices indices;
    
    /**
     * Get the value of the indices of the source <code>file</code>
     * 
     * @return the value of the indices
     */
    public FileIndices indices() {
        return indices;
    }
    
    public FileFromNetworkStorage(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value, FileIndices indices) {
        this.sender = new NetworkStorageProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public FileFromNetworkStorage(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value,
            fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
        this.sender = new NetworkStorageProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new FileIndices(info);
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
        FileFromNetworkStorage other = (FileFromNetworkStorage) obj;
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
    private NetworkStorageProxy sender;
    
    /**
     * Get the sender of the source <code>file</code>. I.e., the <code>NetworkStorage</code> device that published the source.
     * 
     * @return A proxy to the <code>NetworkStorage</code> that triggered the source
     */
    public NetworkStorageProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>NetworkStorage</code> that discloses subscription/unsubscription methods.
     */
    public class NetworkStorageProxy extends Proxy {
        private NetworkStorageProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>file</code> from this <code>NetworkStorage</code>.
         */
        public void subscribeFile() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "file");
        }
        
        /**
         * Unsubcribes from publication of source <code>file</code> from this <code>NetworkStorage</code>.
         */
        public void unsubscribeFile() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "file");
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

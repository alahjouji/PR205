package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.localstorage.AbstractLocalStorage;
import fr.inria.phoenix.diasuite.framework.device.localstorage.FileBrowsingIndices;
import fr.inria.phoenix.diasuite.framework.device.localstorage.FileIndices;

// @internal
public final class LocalStorageMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractLocalStorage {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String locationValue,
                java.lang.String userValue,
                java.lang.String nameValue) {
            super(serviceConfiguration, idValue, locationValue, userValue, nameValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        public void _updateLocation(java.lang.String newLocationValue) {
            updateLocation(newLocationValue);
        }
        
        public void _updateUser(java.lang.String newUserValue) {
            updateUser(newUserValue);
        }
        
        public void _updateName(java.lang.String newNameValue) {
            updateName(newNameValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getFile(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.file.File result = __file.get(new FileIndices(info));
            if(result == null)
                return super.getFile(info);
            return result;
        }
        
        public void _publishFile(fr.inria.phoenix.diasuite.framework.datatype.file.File newFileValue,
                fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
            publishFile(newFileValue,
                info);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> getFileBrowsing(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory,
                fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> result = __fileBrowsing.get(new FileBrowsingIndices(directory, filter));
            if(result == null)
                return super.getFileBrowsing(directory, filter);
            return result;
        }
        
        public void _publishFileBrowsing(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> newFileBrowsingValue,
                fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory,
                fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
            publishFileBrowsing(newFileBrowsingValue,
                directory,
                filter);
        }
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected void delete(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo file) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("delete");
                __action.add(file);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void put(fr.inria.phoenix.diasuite.framework.datatype.file.File file) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("put");
                __action.add(file);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    LocalStorageMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue,
            java.lang.String nameValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, locationValue, userValue, nameValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
    @return this for fluent interface
     */
    public LocalStorageMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute location from device PhysicalDevice
    /**
     * Set the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @param newLocationValue the new value of <code>location</code>
    @return this for fluent interface
     */
    public LocalStorageMock location(java.lang.String newLocationValue) {
        proxy._updateLocation(newLocationValue);
        return this;
    }
    // End of code for the attribute location from device PhysicalDevice
    
    // Code for the attribute user from device PhysicalDevice
    /**
     * Set the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @param newUserValue the new value of <code>user</code>
    @return this for fluent interface
     */
    public LocalStorageMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for the attribute name from device Storage
    /**
     * Set the value of the <code>name</code> attribute from device <code>Storage</code>.
    
    <pre>
    attribute name as String;
    </pre>
    @param newNameValue the new value of <code>name</code>
    @return this for fluent interface
     */
    public LocalStorageMock name(java.lang.String newNameValue) {
        proxy._updateName(newNameValue);
        return this;
    }
    // End of code for the attribute name from device Storage
    
    // Code for source file from device Storage
    /**
     * Publish the value of source <code>file</code> from device <code>Storage</code>.
    
    <pre>
    source file as File indexed by info as FileInfo;
    </pre>
    @param newFileValue the new value for the source <code>file</code>
    @param info the value of the index <code>info</code>
    @return this for fluent interface
     */
    public LocalStorageMock file(fr.inria.phoenix.diasuite.framework.datatype.file.File newFileValue,
            fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
        proxy._publishFile(newFileValue,
            info);
        return this;
    }
    
    private java.util.HashMap<FileIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File> __file = new java.util.HashMap<FileIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File>();
    /**
     * Set the value (without publication) of source <code>file</code> from device <code>Storage</code>.
    
    <pre>
    source file as File indexed by info as FileInfo;
    </pre>
    @param newFileValue the new value for the source <code>file</code>
    @param info the value of the index <code>info</code>
    @return this for fluent interface
     */
    public LocalStorageMock setFile(fr.inria.phoenix.diasuite.framework.datatype.file.File newFileValue,
            fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
        FileIndices _indices_ = new FileIndices(info);
        __file.put(_indices_, newFileValue);
        return this;
    }
    // End of code for source file from device Storage
    
    // Code for source fileBrowsing from device Storage
    /**
     * Publish the value of source <code>fileBrowsing</code> from device <code>Storage</code>.
    
    <pre>
    source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
    </pre>
    @param newFileBrowsingValue the new value for the source <code>fileBrowsing</code>
    @param directory the value of the index <code>directory</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public LocalStorageMock fileBrowsing(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> newFileBrowsingValue,
            fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
        proxy._publishFileBrowsing(newFileBrowsingValue,
            directory,
            filter);
        return this;
    }
    
    private java.util.HashMap<FileBrowsingIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo>> __fileBrowsing = new java.util.HashMap<FileBrowsingIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo>>();
    /**
     * Set the value (without publication) of source <code>fileBrowsing</code> from device <code>Storage</code>.
    
    <pre>
    source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
    </pre>
    @param newFileBrowsingValue the new value for the source <code>fileBrowsing</code>
    @param directory the value of the index <code>directory</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public LocalStorageMock setFileBrowsing(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> newFileBrowsingValue,
            fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
        FileBrowsingIndices _indices_ = new FileBrowsingIndices(directory, filter);
        __fileBrowsing.put(_indices_, newFileBrowsingValue);
        return this;
    }
    // End of code for source fileBrowsing from device Storage
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public LocalStorageMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public LocalStorageMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>delete</code> order from the <code>StorageDeleteAction</code> action
     * defined in device Storage was called.
     * 
    
    <pre>
    delete(file as FileInfo);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectDelete() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("delete".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>delete</code> order from the <code>StorageDeleteAction</code> action
     * defined in device Storage was called.
     * 
    
    <pre>
    delete(file as FileInfo);
    </pre>
     * @param file parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectDelete(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo file) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("delete".equals(__action.poll())))
                    return false;
                if(!file.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>put</code> order from the <code>StoragePutAction</code> action
     * defined in device Storage was called.
     * 
    
    <pre>
    put(file as File);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectPut() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("put".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>put</code> order from the <code>StoragePutAction</code> action
     * defined in device Storage was called.
     * 
    
    <pre>
    put(file as File);
    </pre>
     * @param file parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectPut(fr.inria.phoenix.diasuite.framework.datatype.file.File file) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("put".equals(__action.poll())))
                    return false;
                if(!file.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

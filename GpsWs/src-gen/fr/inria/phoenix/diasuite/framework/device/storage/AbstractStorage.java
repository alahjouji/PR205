package fr.inria.phoenix.diasuite.framework.device.storage;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * ------------------
Storages
------------------------------------

<pre>
device Storage extends PhysicalDevice {
 * 	attribute name as String;
 * 	source file as File indexed by info as FileInfo;
 * 	source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
 * 	action StoragePutAction;
 * 	action StorageDeleteAction;
 * }
</pre>
 */
public abstract class AbstractStorage extends Service {
    
    public AbstractStorage(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue,
            java.lang.String nameValue) {
        super("/Device/Device/PhysicalDevice/Storage/", serviceConfiguration);
        updateId(idValue);
        updateLocation(locationValue);
        updateUser(userValue);
        updateName(nameValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("location", _location);
        attributes.put("name", _name);
        attributes.put("user", _user);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("delete")) {
            delete((fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo) args[0]);
            return null;
        }
        if (orderName.equals("put")) {
            put((fr.inria.phoenix.diasuite.framework.datatype.file.File) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("location")) {
            return _location;
        }
        if (orderName.equals("name")) {
            return _name;
        }
        if (orderName.equals("user")) {
            return _user;
        }
        if (orderName.equals("file")) {
            return getFile((fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo) args[0]);
        }
        if (orderName.equals("fileBrowsing")) {
            return getFileBrowsing((fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType) args[1]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for the attribute location from device PhysicalDevice
    private java.lang.String _location;
    
    /**
     * Set the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @param newLocationValue the new value of <code>location</code>
     */
    protected void updateLocation(java.lang.String newLocationValue) {
        if (_location != newLocationValue) {
            _location = newLocationValue;
            updateAttribute("location", newLocationValue);
        }
    }
    
    /**
     * Returns the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @return the value of <code>location</code>
     */
    public java.lang.String getLocation() {
        return _location;
    }
    // End of code for the attribute location from device PhysicalDevice
    
    // Code for the attribute name from device Storage
    private java.lang.String _name;
    
    /**
     * Set the value of the <code>name</code> attribute from device <code>Storage</code>.
    
    <pre>
    attribute name as String;
    </pre>
    @param newNameValue the new value of <code>name</code>
     */
    protected void updateName(java.lang.String newNameValue) {
        if (_name != newNameValue) {
            _name = newNameValue;
            updateAttribute("name", newNameValue);
        }
    }
    
    /**
     * Returns the value of the <code>name</code> attribute from device <code>Storage</code>.
    
    <pre>
    attribute name as String;
    </pre>
    @return the value of <code>name</code>
     */
    public java.lang.String getName() {
        return _name;
    }
    // End of code for the attribute name from device Storage
    
    // Code for the attribute user from device PhysicalDevice
    private java.lang.String _user;
    
    /**
     * Set the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @param newUserValue the new value of <code>user</code>
     */
    protected void updateUser(java.lang.String newUserValue) {
        if (_user != newUserValue) {
            _user = newUserValue;
            updateAttribute("user", newUserValue);
        }
    }
    
    /**
     * Returns the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @return the value of <code>user</code>
     */
    public java.lang.String getUser() {
        return _user;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source file from device Storage
    private java.util.HashMap<FileIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File> _file = new java.util.HashMap<FileIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File>();
    
    /**
     * Publish the value of source <code>file</code> from device <code>Storage</code>.
    
    <pre>
    source file as File indexed by info as FileInfo;
    </pre>
    @param newFileValue the new value for the source <code>file</code>
    @param info the value of the index <code>info</code>
     */
    protected void publishFile(fr.inria.phoenix.diasuite.framework.datatype.file.File newFileValue,
            fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
        FileIndices _indices_ = new FileIndices(info);
        _file.put(_indices_, newFileValue);
        getProcessor().publishValue(getOutProperties(), "file", newFileValue, info); 
    }
    
    /**
     * Returns the value of source <code>file</code> from device <code>Storage</code>.
    
    <pre>
    source file as File indexed by info as FileInfo;
    </pre>
    @param info the value of the index <code>info</code>
    @return the value of the source <code>file</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.file.File getFile(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) throws Exception {
        return _file.get(new FileIndices(info));
    }
    // End of code for source file from device Storage
    
    // Code for source fileBrowsing from device Storage
    private java.util.HashMap<FileBrowsingIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo>> _fileBrowsing = new java.util.HashMap<FileBrowsingIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo>>();
    
    /**
     * Publish the value of source <code>fileBrowsing</code> from device <code>Storage</code>.
    
    <pre>
    source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
    </pre>
    @param newFileBrowsingValue the new value for the source <code>fileBrowsing</code>
    @param directory the value of the index <code>directory</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishFileBrowsing(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> newFileBrowsingValue,
            fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
        FileBrowsingIndices _indices_ = new FileBrowsingIndices(directory, filter);
        _fileBrowsing.put(_indices_, newFileBrowsingValue);
        getProcessor().publishValue(getOutProperties(), "fileBrowsing", newFileBrowsingValue, directory, filter); 
    }
    
    /**
     * Returns the value of source <code>fileBrowsing</code> from device <code>Storage</code>.
    
    <pre>
    source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
    </pre>
    @param directory the value of the index <code>directory</code>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>fileBrowsing</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> getFileBrowsing(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) throws Exception {
        return _fileBrowsing.get(new FileBrowsingIndices(directory, filter));
    }
    // End of code for source fileBrowsing from device Storage
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    /**
     * Implement this method to define the <code>delete</code> order from the <code>StorageDeleteAction</code> action
     * defined in device Storage.
     * 
    
    <pre>
    delete(file as FileInfo);
    </pre>
     * @param file parameter 1 of the order.
     */
    protected abstract void delete(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo file) throws Exception;
    
    /**
     * Implement this method to define the <code>put</code> order from the <code>StoragePutAction</code> action
     * defined in device Storage.
     * 
    
    <pre>
    put(file as File);
    </pre>
     * @param file parameter 1 of the order.
     */
    protected abstract void put(fr.inria.phoenix.diasuite.framework.datatype.file.File file) throws Exception;
}

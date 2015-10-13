package fr.inria.phoenix.diasuite.framework.device.tvrecorder;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device TvRecorder extends PhysicalDevice {
 * 	action TvRecording;
 * 	source recordedProgram as File indexed by name as String;
 * }
</pre>
 */
public abstract class AbstractTvRecorder extends Service {
    
    public AbstractTvRecorder(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        super("/Device/Device/PhysicalDevice/TvRecorder/", serviceConfiguration);
        updateId(idValue);
        updateLocation(locationValue);
        updateUser(userValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("location", _location);
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
        if (orderName.equals("record")) {
            record((java.lang.String) args[0],
                    (java.lang.String) args[1],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[2],
                    (fr.inria.phoenix.diasuite.framework.datatype.date.Date) args[3]);
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
        if (orderName.equals("user")) {
            return _user;
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("recordedProgram")) {
            return getRecordedProgram((java.lang.String) args[0]);
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
    
    // Code for source recordedProgram from device TvRecorder
    private java.util.HashMap<RecordedProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File> _recordedProgram = new java.util.HashMap<RecordedProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File>();
    
    /**
     * Publish the value of source <code>recordedProgram</code> from device <code>TvRecorder</code>.
    
    <pre>
    source recordedProgram as File indexed by name as String;
    </pre>
    @param newRecordedProgramValue the new value for the source <code>recordedProgram</code>
    @param name the value of the index <code>name</code>
     */
    protected void publishRecordedProgram(fr.inria.phoenix.diasuite.framework.datatype.file.File newRecordedProgramValue,
            java.lang.String name) {
        RecordedProgramIndices _indices_ = new RecordedProgramIndices(name);
        _recordedProgram.put(_indices_, newRecordedProgramValue);
        getProcessor().publishValue(getOutProperties(), "recordedProgram", newRecordedProgramValue, name); 
    }
    
    /**
     * Returns the value of source <code>recordedProgram</code> from device <code>TvRecorder</code>.
    
    <pre>
    source recordedProgram as File indexed by name as String;
    </pre>
    @param name the value of the index <code>name</code>
    @return the value of the source <code>recordedProgram</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.file.File getRecordedProgram(java.lang.String name) throws Exception {
        return _recordedProgram.get(new RecordedProgramIndices(name));
    }
    // End of code for source recordedProgram from device TvRecorder
    
    /**
     * Implement this method to define the <code>record</code> order from the <code>TvRecording</code> action
     * defined in device TvRecorder.
     * 
    
    <pre>
    record(name as String, channel as String, startDate as Date, endDate as Date);
    </pre>
     * @param name parameter 1 of the order.
     * @param channel parameter 2 of the order.
     * @param startDate parameter 3 of the order.
     * @param endDate parameter 4 of the order.
     */
    protected abstract void record(java.lang.String name,
            java.lang.String channel,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception;
}

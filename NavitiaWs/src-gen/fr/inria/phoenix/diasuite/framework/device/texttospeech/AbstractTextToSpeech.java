package fr.inria.phoenix.diasuite.framework.device.texttospeech;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device TextToSpeech extends PhysicalDevice {
 * 	source textToAudio as File indexed by text as String;
 * }
</pre>
 */
public abstract class AbstractTextToSpeech extends Service {
    
    public AbstractTextToSpeech(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        super("/Device/Device/PhysicalDevice/TextToSpeech/", serviceConfiguration);
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
        if (orderName.equals("textToAudio")) {
            return getTextToAudio((java.lang.String) args[0]);
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
    
    // Code for source textToAudio from device TextToSpeech
    private java.util.HashMap<TextToAudioIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File> _textToAudio = new java.util.HashMap<TextToAudioIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File>();
    
    /**
     * Publish the value of source <code>textToAudio</code> from device <code>TextToSpeech</code>.
    
    <pre>
    source textToAudio as File indexed by text as String;
    </pre>
    @param newTextToAudioValue the new value for the source <code>textToAudio</code>
    @param text the value of the index <code>text</code>
     */
    protected void publishTextToAudio(fr.inria.phoenix.diasuite.framework.datatype.file.File newTextToAudioValue,
            java.lang.String text) {
        TextToAudioIndices _indices_ = new TextToAudioIndices(text);
        _textToAudio.put(_indices_, newTextToAudioValue);
        getProcessor().publishValue(getOutProperties(), "textToAudio", newTextToAudioValue, text); 
    }
    
    /**
     * Returns the value of source <code>textToAudio</code> from device <code>TextToSpeech</code>.
    
    <pre>
    source textToAudio as File indexed by text as String;
    </pre>
    @param text the value of the index <code>text</code>
    @return the value of the source <code>textToAudio</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.file.File getTextToAudio(java.lang.String text) throws Exception {
        return _textToAudio.get(new TextToAudioIndices(text));
    }
    // End of code for source textToAudio from device TextToSpeech
}

package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.texttospeech.AbstractTextToSpeech;
import fr.inria.phoenix.diasuite.framework.device.texttospeech.TextToAudioIndices;

// @internal
public final class TextToSpeechMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTextToSpeech {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue,
                java.lang.String locationValue,
                java.lang.String userValue) {
            super(serviceConfiguration, idValue, locationValue, userValue);
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
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getTextToAudio(java.lang.String text) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.file.File result = __textToAudio.get(new TextToAudioIndices(text));
            if(result == null)
                return super.getTextToAudio(text);
            return result;
        }
        
        public void _publishTextToAudio(fr.inria.phoenix.diasuite.framework.datatype.file.File newTextToAudioValue,
                java.lang.String text) {
            publishTextToAudio(newTextToAudioValue,
                text);
        }
    }
    
    Proxy proxy;
    
    TextToSpeechMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue, locationValue, userValue);
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
    public TextToSpeechMock id(java.lang.String newIdValue) {
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
    public TextToSpeechMock location(java.lang.String newLocationValue) {
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
    public TextToSpeechMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public TextToSpeechMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public TextToSpeechMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source textToAudio from device TextToSpeech
    /**
     * Publish the value of source <code>textToAudio</code> from device <code>TextToSpeech</code>.
    
    <pre>
    source textToAudio as File indexed by text as String;
    </pre>
    @param newTextToAudioValue the new value for the source <code>textToAudio</code>
    @param text the value of the index <code>text</code>
    @return this for fluent interface
     */
    public TextToSpeechMock textToAudio(fr.inria.phoenix.diasuite.framework.datatype.file.File newTextToAudioValue,
            java.lang.String text) {
        proxy._publishTextToAudio(newTextToAudioValue,
            text);
        return this;
    }
    
    private java.util.HashMap<TextToAudioIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File> __textToAudio = new java.util.HashMap<TextToAudioIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File>();
    /**
     * Set the value (without publication) of source <code>textToAudio</code> from device <code>TextToSpeech</code>.
    
    <pre>
    source textToAudio as File indexed by text as String;
    </pre>
    @param newTextToAudioValue the new value for the source <code>textToAudio</code>
    @param text the value of the index <code>text</code>
    @return this for fluent interface
     */
    public TextToSpeechMock setTextToAudio(fr.inria.phoenix.diasuite.framework.datatype.file.File newTextToAudioValue,
            java.lang.String text) {
        TextToAudioIndices _indices_ = new TextToAudioIndices(text);
        __textToAudio.put(_indices_, newTextToAudioValue);
        return this;
    }
    // End of code for source textToAudio from device TextToSpeech
}

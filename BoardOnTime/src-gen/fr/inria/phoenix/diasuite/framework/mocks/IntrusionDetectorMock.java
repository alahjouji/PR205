package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.intrusiondetector.AbstractIntrusionDetector;

// @internal
public final class IntrusionDetectorMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractIntrusionDetector {
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
        
        protected java.lang.Boolean getIntrusionDetected() throws Exception {
            java.lang.Boolean result = __intrusionDetected;
            if(result == null)
                return super.getIntrusionDetected();
            return result;
        }
        
        public void _publishIntrusionDetected(java.lang.Boolean newIntrusionDetectedValue) {
            publishIntrusionDetected(newIntrusionDetectedValue);
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
    }
    
    Proxy proxy;
    
    IntrusionDetectorMock(ServiceConfiguration serviceConfiguration,
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
    public IntrusionDetectorMock id(java.lang.String newIdValue) {
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
    public IntrusionDetectorMock location(java.lang.String newLocationValue) {
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
    public IntrusionDetectorMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source intrusionDetected from device IntrusionDetector
    /**
     * Publish the value of source <code>intrusionDetected</code> from device <code>IntrusionDetector</code>.
    
    <pre>
    source intrusionDetected as Boolean;
    </pre>
    @param newIntrusionDetectedValue the new value for the source <code>intrusionDetected</code>
    @return this for fluent interface
     */
    public IntrusionDetectorMock intrusionDetected(java.lang.Boolean newIntrusionDetectedValue) {
        proxy._publishIntrusionDetected(newIntrusionDetectedValue);
        return this;
    }
    
    private java.lang.Boolean __intrusionDetected = null;
    /**
     * Set the value (without publication) of source <code>intrusionDetected</code> from device <code>IntrusionDetector</code>.
    
    <pre>
    source intrusionDetected as Boolean;
    </pre>
    @param newIntrusionDetectedValue the new value for the source <code>intrusionDetected</code>
    @return this for fluent interface
     */
    public IntrusionDetectorMock setIntrusionDetected(java.lang.Boolean newIntrusionDetectedValue) {
        __intrusionDetected = newIntrusionDetectedValue;
        return this;
    }
    // End of code for source intrusionDetected from device IntrusionDetector
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public IntrusionDetectorMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public IntrusionDetectorMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
}

package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.initiator.AbstractInitiator;

// @internal
public final class InitiatorMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractInitiator {
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
        
        protected java.lang.String getAnswer1() throws Exception {
            java.lang.String result = __answer1;
            if(result == null)
                return super.getAnswer1();
            return result;
        }
        
        public void _publishAnswer1(java.lang.String newAnswer1Value) {
            publishAnswer1(newAnswer1Value);
        }
        
        protected java.lang.String getAnswer2() throws Exception {
            java.lang.String result = __answer2;
            if(result == null)
                return super.getAnswer2();
            return result;
        }
        
        public void _publishAnswer2(java.lang.String newAnswer2Value) {
            publishAnswer2(newAnswer2Value);
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
    
    InitiatorMock(ServiceConfiguration serviceConfiguration,
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
    public InitiatorMock id(java.lang.String newIdValue) {
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
    public InitiatorMock location(java.lang.String newLocationValue) {
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
    public InitiatorMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source answer1 from device Initiator
    /**
     * Publish the value of source <code>answer1</code> from device <code>Initiator</code>.
    
    <pre>
    source answer1 as String;
    </pre>
    @param newAnswer1Value the new value for the source <code>answer1</code>
    @return this for fluent interface
     */
    public InitiatorMock answer1(java.lang.String newAnswer1Value) {
        proxy._publishAnswer1(newAnswer1Value);
        return this;
    }
    
    private java.lang.String __answer1 = null;
    /**
     * Set the value (without publication) of source <code>answer1</code> from device <code>Initiator</code>.
    
    <pre>
    source answer1 as String;
    </pre>
    @param newAnswer1Value the new value for the source <code>answer1</code>
    @return this for fluent interface
     */
    public InitiatorMock setAnswer1(java.lang.String newAnswer1Value) {
        __answer1 = newAnswer1Value;
        return this;
    }
    // End of code for source answer1 from device Initiator
    
    // Code for source answer2 from device Initiator
    /**
     * Publish the value of source <code>answer2</code> from device <code>Initiator</code>.
    
    <pre>
    source answer2 as String;
    </pre>
    @param newAnswer2Value the new value for the source <code>answer2</code>
    @return this for fluent interface
     */
    public InitiatorMock answer2(java.lang.String newAnswer2Value) {
        proxy._publishAnswer2(newAnswer2Value);
        return this;
    }
    
    private java.lang.String __answer2 = null;
    /**
     * Set the value (without publication) of source <code>answer2</code> from device <code>Initiator</code>.
    
    <pre>
    source answer2 as String;
    </pre>
    @param newAnswer2Value the new value for the source <code>answer2</code>
    @return this for fluent interface
     */
    public InitiatorMock setAnswer2(java.lang.String newAnswer2Value) {
        __answer2 = newAnswer2Value;
        return this;
    }
    // End of code for source answer2 from device Initiator
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public InitiatorMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public InitiatorMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
}

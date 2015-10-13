package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.rfididentifier.AbstractRfidIdentifier;
import fr.inria.phoenix.diasuite.framework.device.rfididentifier.PresentIndices;

// @internal
public final class RfidIdentifierMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractRfidIdentifier {
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
        
        protected java.lang.Boolean getPresent(java.lang.String id) throws Exception {
            java.lang.Boolean result = __present.get(new PresentIndices(id));
            if(result == null)
                return super.getPresent(id);
            return result;
        }
        
        public void _publishPresent(java.lang.Boolean newPresentValue,
                java.lang.String id) {
            publishPresent(newPresentValue,
                id);
        }
    }
    
    Proxy proxy;
    
    RfidIdentifierMock(ServiceConfiguration serviceConfiguration,
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
    public RfidIdentifierMock id(java.lang.String newIdValue) {
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
    public RfidIdentifierMock location(java.lang.String newLocationValue) {
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
    public RfidIdentifierMock user(java.lang.String newUserValue) {
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
    public RfidIdentifierMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public RfidIdentifierMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source present from device Identifier
    /**
     * Publish the value of source <code>present</code> from device <code>Identifier</code>.
    
    <pre>
    source present as Boolean indexed by id as String;
    </pre>
    @param newPresentValue the new value for the source <code>present</code>
    @param id the value of the index <code>id</code>
    @return this for fluent interface
     */
    public RfidIdentifierMock present(java.lang.Boolean newPresentValue,
            java.lang.String id) {
        proxy._publishPresent(newPresentValue,
            id);
        return this;
    }
    
    private java.util.HashMap<PresentIndices, java.lang.Boolean> __present = new java.util.HashMap<PresentIndices, java.lang.Boolean>();
    /**
     * Set the value (without publication) of source <code>present</code> from device <code>Identifier</code>.
    
    <pre>
    source present as Boolean indexed by id as String;
    </pre>
    @param newPresentValue the new value for the source <code>present</code>
    @param id the value of the index <code>id</code>
    @return this for fluent interface
     */
    public RfidIdentifierMock setPresent(java.lang.Boolean newPresentValue,
            java.lang.String id) {
        PresentIndices _indices_ = new PresentIndices(id);
        __present.put(_indices_, newPresentValue);
        return this;
    }
    // End of code for source present from device Identifier
}

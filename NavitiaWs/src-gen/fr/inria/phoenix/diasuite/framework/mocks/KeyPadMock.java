package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.keypad.AbstractKeyPad;

// @internal
public final class KeyPadMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractKeyPad {
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
        
        protected java.lang.Boolean getIsLocked() throws Exception {
            java.lang.Boolean result = __isLocked;
            if(result == null)
                return super.getIsLocked();
            return result;
        }
        
        public void _publishIsLocked(java.lang.Boolean newIsLockedValue) {
            publishIsLocked(newIsLockedValue);
        }
        
        protected void updateStatus(java.lang.Boolean isLocked) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("updateStatus");
                __action.add(isLocked);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    KeyPadMock(ServiceConfiguration serviceConfiguration,
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
    public KeyPadMock id(java.lang.String newIdValue) {
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
    public KeyPadMock location(java.lang.String newLocationValue) {
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
    public KeyPadMock user(java.lang.String newUserValue) {
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
    public KeyPadMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public KeyPadMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source isLocked from device KeyPad
    /**
     * Publish the value of source <code>isLocked</code> from device <code>KeyPad</code>.
    
    <pre>
    source isLocked as Boolean;
    </pre>
    @param newIsLockedValue the new value for the source <code>isLocked</code>
    @return this for fluent interface
     */
    public KeyPadMock isLocked(java.lang.Boolean newIsLockedValue) {
        proxy._publishIsLocked(newIsLockedValue);
        return this;
    }
    
    private java.lang.Boolean __isLocked = null;
    /**
     * Set the value (without publication) of source <code>isLocked</code> from device <code>KeyPad</code>.
    
    <pre>
    source isLocked as Boolean;
    </pre>
    @param newIsLockedValue the new value for the source <code>isLocked</code>
    @return this for fluent interface
     */
    public KeyPadMock setIsLocked(java.lang.Boolean newIsLockedValue) {
        __isLocked = newIsLockedValue;
        return this;
    }
    // End of code for source isLocked from device KeyPad
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>updateStatus</code> order from the <code>UpdateLockStatus</code> action
     * defined in device KeyPad was called.
     * 
    
    <pre>
    updateStatus(isLocked as Boolean);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectUpdateStatus() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("updateStatus".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>updateStatus</code> order from the <code>UpdateLockStatus</code> action
     * defined in device KeyPad was called.
     * 
    
    <pre>
    updateStatus(isLocked as Boolean);
    </pre>
     * @param isLocked parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectUpdateStatus(java.lang.Boolean isLocked) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("updateStatus".equals(__action.poll())))
                    return false;
                if(!isLocked.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

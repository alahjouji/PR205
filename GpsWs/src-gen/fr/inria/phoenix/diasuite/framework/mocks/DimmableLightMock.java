package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.dimmablelight.AbstractDimmableLight;

// @internal
public final class DimmableLightMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractDimmableLight {
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
        
        protected java.lang.Float getLevel() throws Exception {
            java.lang.Float result = __level;
            if(result == null)
                return super.getLevel();
            return result;
        }
        
        public void _publishLevel(java.lang.Float newLevelValue) {
            publishLevel(newLevelValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.state.State getStatus() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.state.State result = __status;
            if(result == null)
                return super.getStatus();
            return result;
        }
        
        public void _publishStatus(fr.inria.phoenix.diasuite.framework.datatype.state.State newStatusValue) {
            publishStatus(newStatusValue);
        }
        
        protected void decrease() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("decrease");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void increase() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("increase");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void off() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("off");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void on() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("on");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void setValue(java.lang.Float value) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setValue");
                __action.add(value);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    DimmableLightMock(ServiceConfiguration serviceConfiguration,
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
    public DimmableLightMock id(java.lang.String newIdValue) {
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
    public DimmableLightMock location(java.lang.String newLocationValue) {
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
    public DimmableLightMock user(java.lang.String newUserValue) {
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
    public DimmableLightMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public DimmableLightMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source level from device DimmableLight
    /**
     * Publish the value of source <code>level</code> from device <code>DimmableLight</code>.
    
    <pre>
    source level as Float;
    </pre>
    @param newLevelValue the new value for the source <code>level</code>
    @return this for fluent interface
     */
    public DimmableLightMock level(java.lang.Float newLevelValue) {
        proxy._publishLevel(newLevelValue);
        return this;
    }
    
    private java.lang.Float __level = null;
    /**
     * Set the value (without publication) of source <code>level</code> from device <code>DimmableLight</code>.
    
    <pre>
    source level as Float;
    </pre>
    @param newLevelValue the new value for the source <code>level</code>
    @return this for fluent interface
     */
    public DimmableLightMock setLevel(java.lang.Float newLevelValue) {
        __level = newLevelValue;
        return this;
    }
    // End of code for source level from device DimmableLight
    
    // Code for source status from device Light
    /**
     * Publish the value of source <code>status</code> from device <code>Light</code>.
    
    <pre>
    source status as State;
    </pre>
    @param newStatusValue the new value for the source <code>status</code>
    @return this for fluent interface
     */
    public DimmableLightMock status(fr.inria.phoenix.diasuite.framework.datatype.state.State newStatusValue) {
        proxy._publishStatus(newStatusValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.state.State __status = null;
    /**
     * Set the value (without publication) of source <code>status</code> from device <code>Light</code>.
    
    <pre>
    source status as State;
    </pre>
    @param newStatusValue the new value for the source <code>status</code>
    @return this for fluent interface
     */
    public DimmableLightMock setStatus(fr.inria.phoenix.diasuite.framework.datatype.state.State newStatusValue) {
        __status = newStatusValue;
        return this;
    }
    // End of code for source status from device Light
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>decrease</code> order from the <code>VariationControl</code> action
     * defined in device DimmableLight was called.
     * 
    
    <pre>
    decrease();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectDecrease() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("decrease".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>increase</code> order from the <code>VariationControl</code> action
     * defined in device DimmableLight was called.
     * 
    
    <pre>
    increase();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectIncrease() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("increase".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>off</code> order from the <code>Off</code> action
     * defined in device Appliance was called.
     * 
    
    <pre>
    off();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectOff() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("off".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>on</code> order from the <code>On</code> action
     * defined in device Appliance was called.
     * 
    
    <pre>
    on();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectOn() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("on".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>setValue</code> order from the <code>VariationControl</code> action
     * defined in device DimmableLight was called.
     * 
    
    <pre>
    setValue(value as Float);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetValue() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setValue".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setValue</code> order from the <code>VariationControl</code> action
     * defined in device DimmableLight was called.
     * 
    
    <pre>
    setValue(value as Float);
    </pre>
     * @param value parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetValue(java.lang.Float value) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setValue".equals(__action.poll())))
                    return false;
                if(!value.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

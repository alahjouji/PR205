package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.thermostat.AbstractThermostat;

// @internal
public final class ThermostatMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractThermostat {
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature getTargetTemperature() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature result = __targetTemperature;
            if(result == null)
                return super.getTargetTemperature();
            return result;
        }
        
        public void _publishTargetTemperature(fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature newTargetTemperatureValue) {
            publishTargetTemperature(newTargetTemperatureValue);
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
        
        protected void setTemperature(java.lang.Float value,
                fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setTemperature");
                __action.add(value);
                __action.add(unit);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    ThermostatMock(ServiceConfiguration serviceConfiguration,
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
    public ThermostatMock id(java.lang.String newIdValue) {
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
    public ThermostatMock location(java.lang.String newLocationValue) {
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
    public ThermostatMock user(java.lang.String newUserValue) {
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
    public ThermostatMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public ThermostatMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source targetTemperature from device Thermostat
    /**
     * Publish the value of source <code>targetTemperature</code> from device <code>Thermostat</code>.
    
    <pre>
    source targetTemperature as Temperature;
    </pre>
    @param newTargetTemperatureValue the new value for the source <code>targetTemperature</code>
    @return this for fluent interface
     */
    public ThermostatMock targetTemperature(fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature newTargetTemperatureValue) {
        proxy._publishTargetTemperature(newTargetTemperatureValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature __targetTemperature = null;
    /**
     * Set the value (without publication) of source <code>targetTemperature</code> from device <code>Thermostat</code>.
    
    <pre>
    source targetTemperature as Temperature;
    </pre>
    @param newTargetTemperatureValue the new value for the source <code>targetTemperature</code>
    @return this for fluent interface
     */
    public ThermostatMock setTargetTemperature(fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature newTargetTemperatureValue) {
        __targetTemperature = newTargetTemperatureValue;
        return this;
    }
    // End of code for source targetTemperature from device Thermostat
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
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
     * Check that the <code>setTemperature</code> order from the <code>SetTemperature</code> action
     * defined in device Thermostat was called.
     * 
    
    <pre>
    setTemperature(value as Float, unit as TemperatureUnit);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetTemperature() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setTemperature".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setTemperature</code> order from the <code>SetTemperature</code> action
     * defined in device Thermostat was called.
     * 
    
    <pre>
    setTemperature(value as Float, unit as TemperatureUnit);
    </pre>
     * @param value parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetTemperature(java.lang.Float value) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setTemperature".equals(__action.poll())))
                    return false;
                if(!value.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setTemperature</code> order from the <code>SetTemperature</code> action
     * defined in device Thermostat was called.
     * 
    
    <pre>
    setTemperature(value as Float, unit as TemperatureUnit);
    </pre>
     * @param value parameter 1 of the order.
     * @param unit parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetTemperature(java.lang.Float value,
            fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setTemperature".equals(__action.poll())))
                    return false;
                if(!value.equals(__action.poll()))
                    return false;
                if(!unit.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

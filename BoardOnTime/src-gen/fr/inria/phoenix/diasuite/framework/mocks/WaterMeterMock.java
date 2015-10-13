package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.watermeter.AbstractWaterMeter;

// @internal
public final class WaterMeterMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractWaterMeter {
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
        
        protected java.lang.Float getCurrentWaterConsumption() throws Exception {
            java.lang.Float result = __currentWaterConsumption;
            if(result == null)
                return super.getCurrentWaterConsumption();
            return result;
        }
        
        public void _publishCurrentWaterConsumption(java.lang.Float newCurrentWaterConsumptionValue) {
            publishCurrentWaterConsumption(newCurrentWaterConsumptionValue);
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
    
    WaterMeterMock(ServiceConfiguration serviceConfiguration,
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
    public WaterMeterMock id(java.lang.String newIdValue) {
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
    public WaterMeterMock location(java.lang.String newLocationValue) {
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
    public WaterMeterMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source currentWaterConsumption from device WaterMeter
    /**
     * Publish the value of source <code>currentWaterConsumption</code> from device <code>WaterMeter</code>.
    
    <pre>
    source currentWaterConsumption as Float;
    </pre>
    @param newCurrentWaterConsumptionValue the new value for the source <code>currentWaterConsumption</code>
    @return this for fluent interface
     */
    public WaterMeterMock currentWaterConsumption(java.lang.Float newCurrentWaterConsumptionValue) {
        proxy._publishCurrentWaterConsumption(newCurrentWaterConsumptionValue);
        return this;
    }
    
    private java.lang.Float __currentWaterConsumption = null;
    /**
     * Set the value (without publication) of source <code>currentWaterConsumption</code> from device <code>WaterMeter</code>.
    
    <pre>
    source currentWaterConsumption as Float;
    </pre>
    @param newCurrentWaterConsumptionValue the new value for the source <code>currentWaterConsumption</code>
    @return this for fluent interface
     */
    public WaterMeterMock setCurrentWaterConsumption(java.lang.Float newCurrentWaterConsumptionValue) {
        __currentWaterConsumption = newCurrentWaterConsumptionValue;
        return this;
    }
    // End of code for source currentWaterConsumption from device WaterMeter
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public WaterMeterMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public WaterMeterMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
}

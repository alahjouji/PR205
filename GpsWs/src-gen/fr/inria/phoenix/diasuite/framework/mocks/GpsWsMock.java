package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.gpsws.AbstractGpsWs;
import fr.inria.phoenix.diasuite.framework.device.gpsws.DestCoordinatesIndices;

// @internal
public final class GpsWsMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractGpsWs {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates getDestCoordinates(java.lang.String filter) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates result = __destCoordinates.get(new DestCoordinatesIndices(filter));
            if(result == null)
                return super.getDestCoordinates(filter);
            return result;
        }
        
        public void _publishDestCoordinates(fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates newDestCoordinatesValue,
                java.lang.String filter) {
            publishDestCoordinates(newDestCoordinatesValue,
                filter);
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
    
    GpsWsMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue);
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
    public GpsWsMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source destCoordinates from device GpsWs
    /**
     * Publish the value of source <code>destCoordinates</code> from device <code>GpsWs</code>.
    
    <pre>
    source destCoordinates as GpsCoordinates indexed by filter as String;
    </pre>
    @param newDestCoordinatesValue the new value for the source <code>destCoordinates</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public GpsWsMock destCoordinates(fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates newDestCoordinatesValue,
            java.lang.String filter) {
        proxy._publishDestCoordinates(newDestCoordinatesValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<DestCoordinatesIndices, fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates> __destCoordinates = new java.util.HashMap<DestCoordinatesIndices, fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates>();
    /**
     * Set the value (without publication) of source <code>destCoordinates</code> from device <code>GpsWs</code>.
    
    <pre>
    source destCoordinates as GpsCoordinates indexed by filter as String;
    </pre>
    @param newDestCoordinatesValue the new value for the source <code>destCoordinates</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public GpsWsMock setDestCoordinates(fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates newDestCoordinatesValue,
            java.lang.String filter) {
        DestCoordinatesIndices _indices_ = new DestCoordinatesIndices(filter);
        __destCoordinates.put(_indices_, newDestCoordinatesValue);
        return this;
    }
    // End of code for source destCoordinates from device GpsWs
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public GpsWsMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public GpsWsMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
}

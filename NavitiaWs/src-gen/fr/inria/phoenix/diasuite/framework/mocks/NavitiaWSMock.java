package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.navitiaws.AbstractNavitiaWS;
import fr.inria.phoenix.diasuite.framework.device.navitiaws.JourneysIndices;

// @internal
public final class NavitiaWSMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractNavitiaWS {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.sending.Sending getJourneys(java.lang.String filter) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.sending.Sending result = __journeys.get(new JourneysIndices(filter));
            if(result == null)
                return super.getJourneys(filter);
            return result;
        }
        
        public void _publishJourneys(fr.inria.phoenix.diasuite.framework.datatype.sending.Sending newJourneysValue,
                java.lang.String filter) {
            publishJourneys(newJourneysValue,
                filter);
        }
    }
    
    Proxy proxy;
    
    NavitiaWSMock(ServiceConfiguration serviceConfiguration,
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
    public NavitiaWSMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public NavitiaWSMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public NavitiaWSMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source journeys from device NavitiaWS
    /**
     * Publish the value of source <code>journeys</code> from device <code>NavitiaWS</code>.
    
    <pre>
    source journeys as Sending indexed by filter as String;
    </pre>
    @param newJourneysValue the new value for the source <code>journeys</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public NavitiaWSMock journeys(fr.inria.phoenix.diasuite.framework.datatype.sending.Sending newJourneysValue,
            java.lang.String filter) {
        proxy._publishJourneys(newJourneysValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<JourneysIndices, fr.inria.phoenix.diasuite.framework.datatype.sending.Sending> __journeys = new java.util.HashMap<JourneysIndices, fr.inria.phoenix.diasuite.framework.datatype.sending.Sending>();
    /**
     * Set the value (without publication) of source <code>journeys</code> from device <code>NavitiaWS</code>.
    
    <pre>
    source journeys as Sending indexed by filter as String;
    </pre>
    @param newJourneysValue the new value for the source <code>journeys</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public NavitiaWSMock setJourneys(fr.inria.phoenix.diasuite.framework.datatype.sending.Sending newJourneysValue,
            java.lang.String filter) {
        JourneysIndices _indices_ = new JourneysIndices(filter);
        __journeys.put(_indices_, newJourneysValue);
        return this;
    }
    // End of code for source journeys from device NavitiaWS
}

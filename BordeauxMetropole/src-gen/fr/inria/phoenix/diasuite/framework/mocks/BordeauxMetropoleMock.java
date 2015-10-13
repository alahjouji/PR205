package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.bordeauxmetropole.AbstractBordeauxMetropole;
import fr.inria.phoenix.diasuite.framework.device.bordeauxmetropole.BikesIndices;

// @internal
public final class BordeauxMetropoleMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractBordeauxMetropole {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes getBikes(fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv filter) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes result = __bikes.get(new BikesIndices(filter));
            if(result == null)
                return super.getBikes(filter);
            return result;
        }
        
        public void _publishBikes(fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes newBikesValue,
                fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv filter) {
            publishBikes(newBikesValue,
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.cross.Cross getReal_time_schedules() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.cross.Cross result = __real_time_schedules;
            if(result == null)
                return super.getReal_time_schedules();
            return result;
        }
        
        public void _publishReal_time_schedules(fr.inria.phoenix.diasuite.framework.datatype.cross.Cross newReal_time_schedulesValue) {
            publishReal_time_schedules(newReal_time_schedulesValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.cross.Cross getTheoretical_schedules() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.cross.Cross result = __theoretical_schedules;
            if(result == null)
                return super.getTheoretical_schedules();
            return result;
        }
        
        public void _publishTheoretical_schedules(fr.inria.phoenix.diasuite.framework.datatype.cross.Cross newTheoretical_schedulesValue) {
            publishTheoretical_schedules(newTheoretical_schedulesValue);
        }
    }
    
    Proxy proxy;
    
    BordeauxMetropoleMock(ServiceConfiguration serviceConfiguration,
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
    public BordeauxMetropoleMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source bikes from device BordeauxMetropole
    /**
     * Publish the value of source <code>bikes</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source bikes as Bikes indexed by filter as BikesAv;
    </pre>
    @param newBikesValue the new value for the source <code>bikes</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public BordeauxMetropoleMock bikes(fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes newBikesValue,
            fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv filter) {
        proxy._publishBikes(newBikesValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<BikesIndices, fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes> __bikes = new java.util.HashMap<BikesIndices, fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes>();
    /**
     * Set the value (without publication) of source <code>bikes</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source bikes as Bikes indexed by filter as BikesAv;
    </pre>
    @param newBikesValue the new value for the source <code>bikes</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public BordeauxMetropoleMock setBikes(fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes newBikesValue,
            fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv filter) {
        BikesIndices _indices_ = new BikesIndices(filter);
        __bikes.put(_indices_, newBikesValue);
        return this;
    }
    // End of code for source bikes from device BordeauxMetropole
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public BordeauxMetropoleMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public BordeauxMetropoleMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source real_time_schedules from device BordeauxMetropole
    /**
     * Publish the value of source <code>real_time_schedules</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source real_time_schedules as Cross;
    </pre>
    @param newReal_time_schedulesValue the new value for the source <code>real_time_schedules</code>
    @return this for fluent interface
     */
    public BordeauxMetropoleMock real_time_schedules(fr.inria.phoenix.diasuite.framework.datatype.cross.Cross newReal_time_schedulesValue) {
        proxy._publishReal_time_schedules(newReal_time_schedulesValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.cross.Cross __real_time_schedules = null;
    /**
     * Set the value (without publication) of source <code>real_time_schedules</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source real_time_schedules as Cross;
    </pre>
    @param newReal_time_schedulesValue the new value for the source <code>real_time_schedules</code>
    @return this for fluent interface
     */
    public BordeauxMetropoleMock setReal_time_schedules(fr.inria.phoenix.diasuite.framework.datatype.cross.Cross newReal_time_schedulesValue) {
        __real_time_schedules = newReal_time_schedulesValue;
        return this;
    }
    // End of code for source real_time_schedules from device BordeauxMetropole
    
    // Code for source theoretical_schedules from device BordeauxMetropole
    /**
     * Publish the value of source <code>theoretical_schedules</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source theoretical_schedules as Cross;
    </pre>
    @param newTheoretical_schedulesValue the new value for the source <code>theoretical_schedules</code>
    @return this for fluent interface
     */
    public BordeauxMetropoleMock theoretical_schedules(fr.inria.phoenix.diasuite.framework.datatype.cross.Cross newTheoretical_schedulesValue) {
        proxy._publishTheoretical_schedules(newTheoretical_schedulesValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.cross.Cross __theoretical_schedules = null;
    /**
     * Set the value (without publication) of source <code>theoretical_schedules</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source theoretical_schedules as Cross;
    </pre>
    @param newTheoretical_schedulesValue the new value for the source <code>theoretical_schedules</code>
    @return this for fluent interface
     */
    public BordeauxMetropoleMock setTheoretical_schedules(fr.inria.phoenix.diasuite.framework.datatype.cross.Cross newTheoretical_schedulesValue) {
        __theoretical_schedules = newTheoretical_schedulesValue;
        return this;
    }
    // End of code for source theoretical_schedules from device BordeauxMetropole
}

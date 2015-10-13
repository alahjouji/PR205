package fr.inria.phoenix.diasuite.framework.device.bordeauxmetropole;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device BordeauxMetropole extends Device {
 * 	source real_time_schedules as Cross;
 * 	source theoretical_schedules as Cross;
 * 	source bikes as Bikes indexed by filter as BikesAv;
 * }
</pre>
 */
public abstract class AbstractBordeauxMetropole extends Service {
    
    public AbstractBordeauxMetropole(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/BordeauxMetropole/", serviceConfiguration);
        updateId(idValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("bikes")) {
            return getBikes((fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("real_time_schedules")) {
            return getReal_time_schedules();
        }
        if (orderName.equals("theoretical_schedules")) {
            return getTheoretical_schedules();
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for source bikes from device BordeauxMetropole
    private java.util.HashMap<BikesIndices, fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes> _bikes = new java.util.HashMap<BikesIndices, fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes>();
    
    /**
     * Publish the value of source <code>bikes</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source bikes as Bikes indexed by filter as BikesAv;
    </pre>
    @param newBikesValue the new value for the source <code>bikes</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishBikes(fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes newBikesValue,
            fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv filter) {
        BikesIndices _indices_ = new BikesIndices(filter);
        _bikes.put(_indices_, newBikesValue);
        getProcessor().publishValue(getOutProperties(), "bikes", newBikesValue, filter); 
    }
    
    /**
     * Returns the value of source <code>bikes</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source bikes as Bikes indexed by filter as BikesAv;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>bikes</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.bikes.Bikes getBikes(fr.inria.phoenix.diasuite.framework.datatype.bikesav.BikesAv filter) throws Exception {
        return _bikes.get(new BikesIndices(filter));
    }
    // End of code for source bikes from device BordeauxMetropole
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source real_time_schedules from device BordeauxMetropole
    private fr.inria.phoenix.diasuite.framework.datatype.cross.Cross _real_time_schedules;
    
    /**
     * Publish the value of source <code>real_time_schedules</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source real_time_schedules as Cross;
    </pre>
    @param newReal_time_schedulesValue the new value for the source <code>real_time_schedules</code>
     */
    protected void publishReal_time_schedules(fr.inria.phoenix.diasuite.framework.datatype.cross.Cross newReal_time_schedulesValue) {
        _real_time_schedules = newReal_time_schedulesValue;
        getProcessor().publishValue(getOutProperties(), "real_time_schedules", newReal_time_schedulesValue); 
    }
    
    /**
     * Returns the value of source <code>real_time_schedules</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source real_time_schedules as Cross;
    </pre>
    @return the value of the source <code>real_time_schedules</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.cross.Cross getReal_time_schedules() throws Exception {
        return _real_time_schedules;
    }
    // End of code for source real_time_schedules from device BordeauxMetropole
    
    // Code for source theoretical_schedules from device BordeauxMetropole
    private fr.inria.phoenix.diasuite.framework.datatype.cross.Cross _theoretical_schedules;
    
    /**
     * Publish the value of source <code>theoretical_schedules</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source theoretical_schedules as Cross;
    </pre>
    @param newTheoretical_schedulesValue the new value for the source <code>theoretical_schedules</code>
     */
    protected void publishTheoretical_schedules(fr.inria.phoenix.diasuite.framework.datatype.cross.Cross newTheoretical_schedulesValue) {
        _theoretical_schedules = newTheoretical_schedulesValue;
        getProcessor().publishValue(getOutProperties(), "theoretical_schedules", newTheoretical_schedulesValue); 
    }
    
    /**
     * Returns the value of source <code>theoretical_schedules</code> from device <code>BordeauxMetropole</code>.
    
    <pre>
    source theoretical_schedules as Cross;
    </pre>
    @return the value of the source <code>theoretical_schedules</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.cross.Cross getTheoretical_schedules() throws Exception {
        return _theoretical_schedules;
    }
    // End of code for source theoretical_schedules from device BordeauxMetropole
}

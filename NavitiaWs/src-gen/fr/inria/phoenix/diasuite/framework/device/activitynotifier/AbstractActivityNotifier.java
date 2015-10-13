package fr.inria.phoenix.diasuite.framework.device.activitynotifier;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device ActivityNotifier extends Service {
 * 	source activity as DailyActivity;
 * 	action Update;
 * }
</pre>
 */
public abstract class AbstractActivityNotifier extends Service {
    
    public AbstractActivityNotifier(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/ActivityNotifier/", serviceConfiguration);
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
        if (orderName.equals("update")) {
            update((fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("activity")) {
            return getActivity();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
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
    
    // Code for source activity from device ActivityNotifier
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity _activity;
    
    /**
     * Publish the value of source <code>activity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source activity as DailyActivity;
    </pre>
    @param newActivityValue the new value for the source <code>activity</code>
     */
    protected void publishActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newActivityValue) {
        _activity = newActivityValue;
        getProcessor().publishValue(getOutProperties(), "activity", newActivityValue); 
    }
    
    /**
     * Returns the value of source <code>activity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source activity as DailyActivity;
    </pre>
    @return the value of the source <code>activity</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity getActivity() throws Exception {
        return _activity;
    }
    // End of code for source activity from device ActivityNotifier
    
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
    
    /**
     * Implement this method to define the <code>update</code> order from the <code>Update</code> action
     * defined in device ActivityNotifier.
     * 
    
    <pre>
    update(newActivity as DailyActivity);
    </pre>
     * @param newActivity parameter 1 of the order.
     */
    protected abstract void update(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newActivity) throws Exception;
}

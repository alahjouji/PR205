package fr.inria.phoenix.diasuite.framework.device.telephonygateway;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * Telephony

<pre>
device TelephonyGateway extends HomeService {
 * 	action TelephonyGatewayConfiguration;
 * 	source redirectionNumberOut as String;
 * 	source redirectionNumberIn as String;
 * 	source currentCall as Call;
 * 	source missedCalls as MissedCall[];
 * 	source lastMissedCall as MissedCall;
 * }
</pre>
 */
public abstract class AbstractTelephonyGateway extends Service {
    
    public AbstractTelephonyGateway(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/HomeService/TelephonyGateway/", serviceConfiguration);
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
        if (orderName.equals("setRedirectionNumberIn")) {
            setRedirectionNumberIn((java.lang.String) args[0]);
            return null;
        }
        if (orderName.equals("setRedirectionNumberOut")) {
            setRedirectionNumberOut((java.lang.String) args[0]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("currentCall")) {
            return getCurrentCall();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("lastMissedCall")) {
            return getLastMissedCall();
        }
        if (orderName.equals("missedCalls")) {
            return getMissedCalls();
        }
        if (orderName.equals("redirectionNumberIn")) {
            return getRedirectionNumberIn();
        }
        if (orderName.equals("redirectionNumberOut")) {
            return getRedirectionNumberOut();
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
    
    // Code for source currentCall from device TelephonyGateway
    private fr.inria.phoenix.diasuite.framework.datatype.call.Call _currentCall;
    
    /**
     * Publish the value of source <code>currentCall</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source currentCall as Call;
    </pre>
    @param newCurrentCallValue the new value for the source <code>currentCall</code>
     */
    protected void publishCurrentCall(fr.inria.phoenix.diasuite.framework.datatype.call.Call newCurrentCallValue) {
        _currentCall = newCurrentCallValue;
        getProcessor().publishValue(getOutProperties(), "currentCall", newCurrentCallValue); 
    }
    
    /**
     * Returns the value of source <code>currentCall</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source currentCall as Call;
    </pre>
    @return the value of the source <code>currentCall</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.call.Call getCurrentCall() throws Exception {
        return _currentCall;
    }
    // End of code for source currentCall from device TelephonyGateway
    
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
    
    // Code for source lastMissedCall from device TelephonyGateway
    private fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall _lastMissedCall;
    
    /**
     * Publish the value of source <code>lastMissedCall</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source lastMissedCall as MissedCall;
    </pre>
    @param newLastMissedCallValue the new value for the source <code>lastMissedCall</code>
     */
    protected void publishLastMissedCall(fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall newLastMissedCallValue) {
        _lastMissedCall = newLastMissedCallValue;
        getProcessor().publishValue(getOutProperties(), "lastMissedCall", newLastMissedCallValue); 
    }
    
    /**
     * Returns the value of source <code>lastMissedCall</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source lastMissedCall as MissedCall;
    </pre>
    @return the value of the source <code>lastMissedCall</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall getLastMissedCall() throws Exception {
        return _lastMissedCall;
    }
    // End of code for source lastMissedCall from device TelephonyGateway
    
    // Code for source missedCalls from device TelephonyGateway
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> _missedCalls;
    
    /**
     * Publish the value of source <code>missedCalls</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source missedCalls as MissedCall[];
    </pre>
    @param newMissedCallsValue the new value for the source <code>missedCalls</code>
     */
    protected void publishMissedCalls(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> newMissedCallsValue) {
        _missedCalls = newMissedCallsValue;
        getProcessor().publishValue(getOutProperties(), "missedCalls", newMissedCallsValue); 
    }
    
    /**
     * Returns the value of source <code>missedCalls</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source missedCalls as MissedCall[];
    </pre>
    @return the value of the source <code>missedCalls</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> getMissedCalls() throws Exception {
        return _missedCalls;
    }
    // End of code for source missedCalls from device TelephonyGateway
    
    // Code for source redirectionNumberIn from device TelephonyGateway
    private java.lang.String _redirectionNumberIn;
    
    /**
     * Publish the value of source <code>redirectionNumberIn</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source redirectionNumberIn as String;
    </pre>
    @param newRedirectionNumberInValue the new value for the source <code>redirectionNumberIn</code>
     */
    protected void publishRedirectionNumberIn(java.lang.String newRedirectionNumberInValue) {
        _redirectionNumberIn = newRedirectionNumberInValue;
        getProcessor().publishValue(getOutProperties(), "redirectionNumberIn", newRedirectionNumberInValue); 
    }
    
    /**
     * Returns the value of source <code>redirectionNumberIn</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source redirectionNumberIn as String;
    </pre>
    @return the value of the source <code>redirectionNumberIn</code>
     */
    protected java.lang.String getRedirectionNumberIn() throws Exception {
        return _redirectionNumberIn;
    }
    // End of code for source redirectionNumberIn from device TelephonyGateway
    
    // Code for source redirectionNumberOut from device TelephonyGateway
    private java.lang.String _redirectionNumberOut;
    
    /**
     * Publish the value of source <code>redirectionNumberOut</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source redirectionNumberOut as String;
    </pre>
    @param newRedirectionNumberOutValue the new value for the source <code>redirectionNumberOut</code>
     */
    protected void publishRedirectionNumberOut(java.lang.String newRedirectionNumberOutValue) {
        _redirectionNumberOut = newRedirectionNumberOutValue;
        getProcessor().publishValue(getOutProperties(), "redirectionNumberOut", newRedirectionNumberOutValue); 
    }
    
    /**
     * Returns the value of source <code>redirectionNumberOut</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source redirectionNumberOut as String;
    </pre>
    @return the value of the source <code>redirectionNumberOut</code>
     */
    protected java.lang.String getRedirectionNumberOut() throws Exception {
        return _redirectionNumberOut;
    }
    // End of code for source redirectionNumberOut from device TelephonyGateway
    
    /**
     * Implement this method to define the <code>setRedirectionNumberIn</code> order from the <code>TelephonyGatewayConfiguration</code> action
     * defined in device TelephonyGateway.
     * 
    
    <pre>
    setRedirectionNumberIn(number as String);
    </pre>
     * @param number parameter 1 of the order.
     */
    protected abstract void setRedirectionNumberIn(java.lang.String number) throws Exception;
    
    /**
     * Implement this method to define the <code>setRedirectionNumberOut</code> order from the <code>TelephonyGatewayConfiguration</code> action
     * defined in device TelephonyGateway.
     * 
    
    <pre>
    setRedirectionNumberOut(number as String);
    </pre>
     * @param number parameter 1 of the order.
     */
    protected abstract void setRedirectionNumberOut(java.lang.String number) throws Exception;
}

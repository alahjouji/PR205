package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.telephonygateway.AbstractTelephonyGateway;

// @internal
public final class TelephonyGatewayMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTelephonyGateway {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.call.Call getCurrentCall() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.call.Call result = __currentCall;
            if(result == null)
                return super.getCurrentCall();
            return result;
        }
        
        public void _publishCurrentCall(fr.inria.phoenix.diasuite.framework.datatype.call.Call newCurrentCallValue) {
            publishCurrentCall(newCurrentCallValue);
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall getLastMissedCall() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall result = __lastMissedCall;
            if(result == null)
                return super.getLastMissedCall();
            return result;
        }
        
        public void _publishLastMissedCall(fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall newLastMissedCallValue) {
            publishLastMissedCall(newLastMissedCallValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> getMissedCalls() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> result = __missedCalls;
            if(result == null)
                return super.getMissedCalls();
            return result;
        }
        
        public void _publishMissedCalls(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> newMissedCallsValue) {
            publishMissedCalls(newMissedCallsValue);
        }
        
        protected java.lang.String getRedirectionNumberIn() throws Exception {
            java.lang.String result = __redirectionNumberIn;
            if(result == null)
                return super.getRedirectionNumberIn();
            return result;
        }
        
        public void _publishRedirectionNumberIn(java.lang.String newRedirectionNumberInValue) {
            publishRedirectionNumberIn(newRedirectionNumberInValue);
        }
        
        protected java.lang.String getRedirectionNumberOut() throws Exception {
            java.lang.String result = __redirectionNumberOut;
            if(result == null)
                return super.getRedirectionNumberOut();
            return result;
        }
        
        public void _publishRedirectionNumberOut(java.lang.String newRedirectionNumberOutValue) {
            publishRedirectionNumberOut(newRedirectionNumberOutValue);
        }
        
        protected void setRedirectionNumberIn(java.lang.String number) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setRedirectionNumberIn");
                __action.add(number);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void setRedirectionNumberOut(java.lang.String number) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setRedirectionNumberOut");
                __action.add(number);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    TelephonyGatewayMock(ServiceConfiguration serviceConfiguration,
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
    public TelephonyGatewayMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source currentCall from device TelephonyGateway
    /**
     * Publish the value of source <code>currentCall</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source currentCall as Call;
    </pre>
    @param newCurrentCallValue the new value for the source <code>currentCall</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock currentCall(fr.inria.phoenix.diasuite.framework.datatype.call.Call newCurrentCallValue) {
        proxy._publishCurrentCall(newCurrentCallValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.call.Call __currentCall = null;
    /**
     * Set the value (without publication) of source <code>currentCall</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source currentCall as Call;
    </pre>
    @param newCurrentCallValue the new value for the source <code>currentCall</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock setCurrentCall(fr.inria.phoenix.diasuite.framework.datatype.call.Call newCurrentCallValue) {
        __currentCall = newCurrentCallValue;
        return this;
    }
    // End of code for source currentCall from device TelephonyGateway
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public TelephonyGatewayMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source lastMissedCall from device TelephonyGateway
    /**
     * Publish the value of source <code>lastMissedCall</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source lastMissedCall as MissedCall;
    </pre>
    @param newLastMissedCallValue the new value for the source <code>lastMissedCall</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock lastMissedCall(fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall newLastMissedCallValue) {
        proxy._publishLastMissedCall(newLastMissedCallValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall __lastMissedCall = null;
    /**
     * Set the value (without publication) of source <code>lastMissedCall</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source lastMissedCall as MissedCall;
    </pre>
    @param newLastMissedCallValue the new value for the source <code>lastMissedCall</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock setLastMissedCall(fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall newLastMissedCallValue) {
        __lastMissedCall = newLastMissedCallValue;
        return this;
    }
    // End of code for source lastMissedCall from device TelephonyGateway
    
    // Code for source missedCalls from device TelephonyGateway
    /**
     * Publish the value of source <code>missedCalls</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source missedCalls as MissedCall[];
    </pre>
    @param newMissedCallsValue the new value for the source <code>missedCalls</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock missedCalls(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> newMissedCallsValue) {
        proxy._publishMissedCalls(newMissedCallsValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> __missedCalls = null;
    /**
     * Set the value (without publication) of source <code>missedCalls</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source missedCalls as MissedCall[];
    </pre>
    @param newMissedCallsValue the new value for the source <code>missedCalls</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock setMissedCalls(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.missedcall.MissedCall> newMissedCallsValue) {
        __missedCalls = newMissedCallsValue;
        return this;
    }
    // End of code for source missedCalls from device TelephonyGateway
    
    // Code for source redirectionNumberIn from device TelephonyGateway
    /**
     * Publish the value of source <code>redirectionNumberIn</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source redirectionNumberIn as String;
    </pre>
    @param newRedirectionNumberInValue the new value for the source <code>redirectionNumberIn</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock redirectionNumberIn(java.lang.String newRedirectionNumberInValue) {
        proxy._publishRedirectionNumberIn(newRedirectionNumberInValue);
        return this;
    }
    
    private java.lang.String __redirectionNumberIn = null;
    /**
     * Set the value (without publication) of source <code>redirectionNumberIn</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source redirectionNumberIn as String;
    </pre>
    @param newRedirectionNumberInValue the new value for the source <code>redirectionNumberIn</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock setRedirectionNumberIn(java.lang.String newRedirectionNumberInValue) {
        __redirectionNumberIn = newRedirectionNumberInValue;
        return this;
    }
    // End of code for source redirectionNumberIn from device TelephonyGateway
    
    // Code for source redirectionNumberOut from device TelephonyGateway
    /**
     * Publish the value of source <code>redirectionNumberOut</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source redirectionNumberOut as String;
    </pre>
    @param newRedirectionNumberOutValue the new value for the source <code>redirectionNumberOut</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock redirectionNumberOut(java.lang.String newRedirectionNumberOutValue) {
        proxy._publishRedirectionNumberOut(newRedirectionNumberOutValue);
        return this;
    }
    
    private java.lang.String __redirectionNumberOut = null;
    /**
     * Set the value (without publication) of source <code>redirectionNumberOut</code> from device <code>TelephonyGateway</code>.
    
    <pre>
    source redirectionNumberOut as String;
    </pre>
    @param newRedirectionNumberOutValue the new value for the source <code>redirectionNumberOut</code>
    @return this for fluent interface
     */
    public TelephonyGatewayMock setRedirectionNumberOut(java.lang.String newRedirectionNumberOutValue) {
        __redirectionNumberOut = newRedirectionNumberOutValue;
        return this;
    }
    // End of code for source redirectionNumberOut from device TelephonyGateway
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>setRedirectionNumberIn</code> order from the <code>TelephonyGatewayConfiguration</code> action
     * defined in device TelephonyGateway was called.
     * 
    
    <pre>
    setRedirectionNumberIn(number as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetRedirectionNumberIn() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setRedirectionNumberIn".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setRedirectionNumberIn</code> order from the <code>TelephonyGatewayConfiguration</code> action
     * defined in device TelephonyGateway was called.
     * 
    
    <pre>
    setRedirectionNumberIn(number as String);
    </pre>
     * @param number parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetRedirectionNumberIn(java.lang.String number) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setRedirectionNumberIn".equals(__action.poll())))
                    return false;
                if(!number.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>setRedirectionNumberOut</code> order from the <code>TelephonyGatewayConfiguration</code> action
     * defined in device TelephonyGateway was called.
     * 
    
    <pre>
    setRedirectionNumberOut(number as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetRedirectionNumberOut() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setRedirectionNumberOut".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setRedirectionNumberOut</code> order from the <code>TelephonyGatewayConfiguration</code> action
     * defined in device TelephonyGateway was called.
     * 
    
    <pre>
    setRedirectionNumberOut(number as String);
    </pre>
     * @param number parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetRedirectionNumberOut(java.lang.String number) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setRedirectionNumberOut".equals(__action.poll())))
                    return false;
                if(!number.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

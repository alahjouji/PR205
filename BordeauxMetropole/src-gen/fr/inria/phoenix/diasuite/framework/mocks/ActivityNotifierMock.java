package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.activitynotifier.AbstractActivityNotifier;

// @internal
public final class ActivityNotifierMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractActivityNotifier {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity getActivity() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity result = __activity;
            if(result == null)
                return super.getActivity();
            return result;
        }
        
        public void _publishActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newActivityValue) {
            publishActivity(newActivityValue);
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
        
        protected void update(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newActivity) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("update");
                __action.add(newActivity);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    ActivityNotifierMock(ServiceConfiguration serviceConfiguration,
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
    public ActivityNotifierMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source activity from device ActivityNotifier
    /**
     * Publish the value of source <code>activity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source activity as DailyActivity;
    </pre>
    @param newActivityValue the new value for the source <code>activity</code>
    @return this for fluent interface
     */
    public ActivityNotifierMock activity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newActivityValue) {
        proxy._publishActivity(newActivityValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity __activity = null;
    /**
     * Set the value (without publication) of source <code>activity</code> from device <code>ActivityNotifier</code>.
    
    <pre>
    source activity as DailyActivity;
    </pre>
    @param newActivityValue the new value for the source <code>activity</code>
    @return this for fluent interface
     */
    public ActivityNotifierMock setActivity(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newActivityValue) {
        __activity = newActivityValue;
        return this;
    }
    // End of code for source activity from device ActivityNotifier
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public ActivityNotifierMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public ActivityNotifierMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>update</code> order from the <code>Update</code> action
     * defined in device ActivityNotifier was called.
     * 
    
    <pre>
    update(newActivity as DailyActivity);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectUpdate() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("update".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>update</code> order from the <code>Update</code> action
     * defined in device ActivityNotifier was called.
     * 
    
    <pre>
    update(newActivity as DailyActivity);
    </pre>
     * @param newActivity parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectUpdate(fr.inria.phoenix.diasuite.framework.datatype.dailyactivity.DailyActivity newActivity) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("update".equals(__action.poll())))
                    return false;
                if(!newActivity.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

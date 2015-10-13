package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.servicetablet.AbstractServiceTablet;
import fr.inria.phoenix.diasuite.framework.device.servicetablet.TabletActionIndices;

// @internal
public final class ServiceTabletMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractServiceTablet {
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode getTabletAction(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode result = __tabletAction.get(new TabletActionIndices(profile));
            if(result == null)
                return super.getTabletAction(profile);
            return result;
        }
        
        public void _publishTabletAction(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletActionValue,
                fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
            publishTabletAction(newTabletActionValue,
                profile);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode getTabletMode() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode result = __tabletMode;
            if(result == null)
                return super.getTabletMode();
            return result;
        }
        
        public void _publishTabletMode(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletModeValue) {
            publishTabletMode(newTabletModeValue);
        }
        
        protected void pushContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> profiles) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("pushContacts");
                __action.add(profiles);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    ServiceTabletMock(ServiceConfiguration serviceConfiguration,
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
    public ServiceTabletMock id(java.lang.String newIdValue) {
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
    public ServiceTabletMock location(java.lang.String newLocationValue) {
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
    public ServiceTabletMock user(java.lang.String newUserValue) {
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
    public ServiceTabletMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public ServiceTabletMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source tabletAction from device ServiceTablet
    /**
     * Publish the value of source <code>tabletAction</code> from device <code>ServiceTablet</code>.
    
    <pre>
    source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
    </pre>
    @param newTabletActionValue the new value for the source <code>tabletAction</code>
    @param profile the value of the index <code>profile</code>
    @return this for fluent interface
     */
    public ServiceTabletMock tabletAction(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletActionValue,
            fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
        proxy._publishTabletAction(newTabletActionValue,
            profile);
        return this;
    }
    
    private java.util.HashMap<TabletActionIndices, fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode> __tabletAction = new java.util.HashMap<TabletActionIndices, fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode>();
    /**
     * Set the value (without publication) of source <code>tabletAction</code> from device <code>ServiceTablet</code>.
    
    <pre>
    source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
    </pre>
    @param newTabletActionValue the new value for the source <code>tabletAction</code>
    @param profile the value of the index <code>profile</code>
    @return this for fluent interface
     */
    public ServiceTabletMock setTabletAction(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletActionValue,
            fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
        TabletActionIndices _indices_ = new TabletActionIndices(profile);
        __tabletAction.put(_indices_, newTabletActionValue);
        return this;
    }
    // End of code for source tabletAction from device ServiceTablet
    
    // Code for source tabletMode from device ServiceTablet
    /**
     * Publish the value of source <code>tabletMode</code> from device <code>ServiceTablet</code>.
    
    <pre>
    source tabletMode as ServiceTabletMode;
    </pre>
    @param newTabletModeValue the new value for the source <code>tabletMode</code>
    @return this for fluent interface
     */
    public ServiceTabletMock tabletMode(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletModeValue) {
        proxy._publishTabletMode(newTabletModeValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode __tabletMode = null;
    /**
     * Set the value (without publication) of source <code>tabletMode</code> from device <code>ServiceTablet</code>.
    
    <pre>
    source tabletMode as ServiceTabletMode;
    </pre>
    @param newTabletModeValue the new value for the source <code>tabletMode</code>
    @return this for fluent interface
     */
    public ServiceTabletMock setTabletMode(fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode newTabletModeValue) {
        __tabletMode = newTabletModeValue;
        return this;
    }
    // End of code for source tabletMode from device ServiceTablet
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>pushContacts</code> order from the <code>PushContacts</code> action
     * defined in device ServiceTablet was called.
     * 
    
    <pre>
    pushContacts(profiles as PersonalProfile[]);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectPushContacts() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("pushContacts".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>pushContacts</code> order from the <code>PushContacts</code> action
     * defined in device ServiceTablet was called.
     * 
    
    <pre>
    pushContacts(profiles as PersonalProfile[]);
    </pre>
     * @param profiles parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectPushContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> profiles) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("pushContacts".equals(__action.poll())))
                    return false;
                if(!profiles.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

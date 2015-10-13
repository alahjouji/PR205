package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.smarttv.AbstractSmartTv;

// @internal
public final class SmartTvMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractSmartTv {
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
        
        protected java.lang.String getCurrentChannel() throws Exception {
            java.lang.String result = __currentChannel;
            if(result == null)
                return super.getCurrentChannel();
            return result;
        }
        
        public void _publishCurrentChannel(java.lang.String newCurrentChannelValue) {
            publishCurrentChannel(newCurrentChannelValue);
        }
        
        protected java.lang.Float getCurrentVolume() throws Exception {
            java.lang.Float result = __currentVolume;
            if(result == null)
                return super.getCurrentVolume();
            return result;
        }
        
        public void _publishCurrentVolume(java.lang.Float newCurrentVolumeValue) {
            publishCurrentVolume(newCurrentVolumeValue);
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
        
        protected java.lang.Boolean getMute() throws Exception {
            java.lang.Boolean result = __mute;
            if(result == null)
                return super.getMute();
            return result;
        }
        
        public void _publishMute(java.lang.Boolean newMuteValue) {
            publishMute(newMuteValue);
        }
        
        protected java.lang.Boolean getTurnedOn() throws Exception {
            java.lang.Boolean result = __turnedOn;
            if(result == null)
                return super.getTurnedOn();
            return result;
        }
        
        public void _publishTurnedOn(java.lang.Boolean newTurnedOnValue) {
            publishTurnedOn(newTurnedOnValue);
        }
        
        protected void changeChannel(java.lang.String channel) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("changeChannel");
                __action.add(channel);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void mute(java.lang.Boolean mute) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("mute");
                __action.add(mute);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void nextChannel() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("nextChannel");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void pause() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("pause");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void play() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("play");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void previousChannel() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("previousChannel");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void setVolume(java.lang.Float level) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setVolume");
                __action.add(level);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void stop() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("stop");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void volumeDown() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("volumeDown");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void volumeUp() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("volumeUp");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    SmartTvMock(ServiceConfiguration serviceConfiguration,
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
    public SmartTvMock id(java.lang.String newIdValue) {
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
    public SmartTvMock location(java.lang.String newLocationValue) {
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
    public SmartTvMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source currentChannel from device Tv
    /**
     * Publish the value of source <code>currentChannel</code> from device <code>Tv</code>.
    
    <pre>
    source currentChannel as String;
    </pre>
    @param newCurrentChannelValue the new value for the source <code>currentChannel</code>
    @return this for fluent interface
     */
    public SmartTvMock currentChannel(java.lang.String newCurrentChannelValue) {
        proxy._publishCurrentChannel(newCurrentChannelValue);
        return this;
    }
    
    private java.lang.String __currentChannel = null;
    /**
     * Set the value (without publication) of source <code>currentChannel</code> from device <code>Tv</code>.
    
    <pre>
    source currentChannel as String;
    </pre>
    @param newCurrentChannelValue the new value for the source <code>currentChannel</code>
    @return this for fluent interface
     */
    public SmartTvMock setCurrentChannel(java.lang.String newCurrentChannelValue) {
        __currentChannel = newCurrentChannelValue;
        return this;
    }
    // End of code for source currentChannel from device Tv
    
    // Code for source currentVolume from device Tv
    /**
     * Publish the value of source <code>currentVolume</code> from device <code>Tv</code>.
    
    <pre>
    source currentVolume as Float;
    </pre>
    @param newCurrentVolumeValue the new value for the source <code>currentVolume</code>
    @return this for fluent interface
     */
    public SmartTvMock currentVolume(java.lang.Float newCurrentVolumeValue) {
        proxy._publishCurrentVolume(newCurrentVolumeValue);
        return this;
    }
    
    private java.lang.Float __currentVolume = null;
    /**
     * Set the value (without publication) of source <code>currentVolume</code> from device <code>Tv</code>.
    
    <pre>
    source currentVolume as Float;
    </pre>
    @param newCurrentVolumeValue the new value for the source <code>currentVolume</code>
    @return this for fluent interface
     */
    public SmartTvMock setCurrentVolume(java.lang.Float newCurrentVolumeValue) {
        __currentVolume = newCurrentVolumeValue;
        return this;
    }
    // End of code for source currentVolume from device Tv
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public SmartTvMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public SmartTvMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source mute from device Tv
    /**
     * Publish the value of source <code>mute</code> from device <code>Tv</code>.
    
    <pre>
    source mute as Boolean;
    </pre>
    @param newMuteValue the new value for the source <code>mute</code>
    @return this for fluent interface
     */
    public SmartTvMock mute(java.lang.Boolean newMuteValue) {
        proxy._publishMute(newMuteValue);
        return this;
    }
    
    private java.lang.Boolean __mute = null;
    /**
     * Set the value (without publication) of source <code>mute</code> from device <code>Tv</code>.
    
    <pre>
    source mute as Boolean;
    </pre>
    @param newMuteValue the new value for the source <code>mute</code>
    @return this for fluent interface
     */
    public SmartTvMock setMute(java.lang.Boolean newMuteValue) {
        __mute = newMuteValue;
        return this;
    }
    // End of code for source mute from device Tv
    
    // Code for source turnedOn from device Tv
    /**
     * Publish the value of source <code>turnedOn</code> from device <code>Tv</code>.
    
    <pre>
    source turnedOn as Boolean;
    </pre>
    @param newTurnedOnValue the new value for the source <code>turnedOn</code>
    @return this for fluent interface
     */
    public SmartTvMock turnedOn(java.lang.Boolean newTurnedOnValue) {
        proxy._publishTurnedOn(newTurnedOnValue);
        return this;
    }
    
    private java.lang.Boolean __turnedOn = null;
    /**
     * Set the value (without publication) of source <code>turnedOn</code> from device <code>Tv</code>.
    
    <pre>
    source turnedOn as Boolean;
    </pre>
    @param newTurnedOnValue the new value for the source <code>turnedOn</code>
    @return this for fluent interface
     */
    public SmartTvMock setTurnedOn(java.lang.Boolean newTurnedOnValue) {
        __turnedOn = newTurnedOnValue;
        return this;
    }
    // End of code for source turnedOn from device Tv
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>changeChannel</code> order from the <code>ChannelControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    changeChannel(channel as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectChangeChannel() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("changeChannel".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>changeChannel</code> order from the <code>ChannelControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    changeChannel(channel as String);
    </pre>
     * @param channel parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectChangeChannel(java.lang.String channel) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("changeChannel".equals(__action.poll())))
                    return false;
                if(!channel.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>mute</code> order from the <code>VolumeControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    mute(mute as Boolean);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectMute() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("mute".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>mute</code> order from the <code>VolumeControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    mute(mute as Boolean);
    </pre>
     * @param mute parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectMute(java.lang.Boolean mute) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("mute".equals(__action.poll())))
                    return false;
                if(!mute.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>nextChannel</code> order from the <code>ChannelControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    nextChannel();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectNextChannel() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("nextChannel".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>pause</code> order from the <code>TimeControl</code> action
     * defined in device SmartTv was called.
     * 
    
    <pre>
    pause();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectPause() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("pause".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>play</code> order from the <code>TimeControl</code> action
     * defined in device SmartTv was called.
     * 
    
    <pre>
    play();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectPlay() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("play".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>previousChannel</code> order from the <code>ChannelControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    previousChannel();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectPreviousChannel() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("previousChannel".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>setVolume</code> order from the <code>VolumeControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    setVolume(level as Float);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetVolume() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setVolume".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setVolume</code> order from the <code>VolumeControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    setVolume(level as Float);
    </pre>
     * @param level parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetVolume(java.lang.Float level) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setVolume".equals(__action.poll())))
                    return false;
                if(!level.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>stop</code> order from the <code>TimeControl</code> action
     * defined in device SmartTv was called.
     * 
    
    <pre>
    stop();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectStop() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("stop".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>volumeDown</code> order from the <code>VolumeControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    volumeDown();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectVolumeDown() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("volumeDown".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>volumeUp</code> order from the <code>VolumeControl</code> action
     * defined in device Tv was called.
     * 
    
    <pre>
    volumeUp();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectVolumeUp() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("volumeUp".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

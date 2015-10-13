package fr.inria.phoenix.diasuite.framework.device.smarttv;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device SmartTv extends Tv {
 * 	action TimeControl;
 * }
</pre>
 */
public abstract class AbstractSmartTv extends Service {
    
    public AbstractSmartTv(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        super("/Device/Device/PhysicalDevice/Tv/SmartTv/", serviceConfiguration);
        updateId(idValue);
        updateLocation(locationValue);
        updateUser(userValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        attributes.put("location", _location);
        attributes.put("user", _user);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("changeChannel")) {
            changeChannel((java.lang.String) args[0]);
            return null;
        }
        if (orderName.equals("mute")) {
            mute((java.lang.Boolean) args[0]);
            return null;
        }
        if (orderName.equals("nextChannel")) {
            nextChannel();
            return null;
        }
        if (orderName.equals("pause")) {
            pause();
            return null;
        }
        if (orderName.equals("play")) {
            play();
            return null;
        }
        if (orderName.equals("previousChannel")) {
            previousChannel();
            return null;
        }
        if (orderName.equals("setVolume")) {
            setVolume((java.lang.Float) args[0]);
            return null;
        }
        if (orderName.equals("stop")) {
            stop();
            return null;
        }
        if (orderName.equals("volumeDown")) {
            volumeDown();
            return null;
        }
        if (orderName.equals("volumeUp")) {
            volumeUp();
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("location")) {
            return _location;
        }
        if (orderName.equals("user")) {
            return _user;
        }
        if (orderName.equals("currentChannel")) {
            return getCurrentChannel();
        }
        if (orderName.equals("currentVolume")) {
            return getCurrentVolume();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("mute")) {
            return getMute();
        }
        if (orderName.equals("turnedOn")) {
            return getTurnedOn();
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
    
    // Code for the attribute location from device PhysicalDevice
    private java.lang.String _location;
    
    /**
     * Set the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @param newLocationValue the new value of <code>location</code>
     */
    protected void updateLocation(java.lang.String newLocationValue) {
        if (_location != newLocationValue) {
            _location = newLocationValue;
            updateAttribute("location", newLocationValue);
        }
    }
    
    /**
     * Returns the value of the <code>location</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute location as String;
    </pre>
    @return the value of <code>location</code>
     */
    public java.lang.String getLocation() {
        return _location;
    }
    // End of code for the attribute location from device PhysicalDevice
    
    // Code for the attribute user from device PhysicalDevice
    private java.lang.String _user;
    
    /**
     * Set the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @param newUserValue the new value of <code>user</code>
     */
    protected void updateUser(java.lang.String newUserValue) {
        if (_user != newUserValue) {
            _user = newUserValue;
            updateAttribute("user", newUserValue);
        }
    }
    
    /**
     * Returns the value of the <code>user</code> attribute from device <code>PhysicalDevice</code>.
    
    <pre>
    attribute user as String;
    </pre>
    @return the value of <code>user</code>
     */
    public java.lang.String getUser() {
        return _user;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source currentChannel from device Tv
    private java.lang.String _currentChannel;
    
    /**
     * Publish the value of source <code>currentChannel</code> from device <code>Tv</code>.
    
    <pre>
    source currentChannel as String;
    </pre>
    @param newCurrentChannelValue the new value for the source <code>currentChannel</code>
     */
    protected void publishCurrentChannel(java.lang.String newCurrentChannelValue) {
        _currentChannel = newCurrentChannelValue;
        getProcessor().publishValue(getOutProperties(), "currentChannel", newCurrentChannelValue); 
    }
    
    /**
     * Returns the value of source <code>currentChannel</code> from device <code>Tv</code>.
    
    <pre>
    source currentChannel as String;
    </pre>
    @return the value of the source <code>currentChannel</code>
     */
    protected java.lang.String getCurrentChannel() throws Exception {
        return _currentChannel;
    }
    // End of code for source currentChannel from device Tv
    
    // Code for source currentVolume from device Tv
    private java.lang.Float _currentVolume;
    
    /**
     * Publish the value of source <code>currentVolume</code> from device <code>Tv</code>.
    
    <pre>
    source currentVolume as Float;
    </pre>
    @param newCurrentVolumeValue the new value for the source <code>currentVolume</code>
     */
    protected void publishCurrentVolume(java.lang.Float newCurrentVolumeValue) {
        _currentVolume = newCurrentVolumeValue;
        getProcessor().publishValue(getOutProperties(), "currentVolume", newCurrentVolumeValue); 
    }
    
    /**
     * Returns the value of source <code>currentVolume</code> from device <code>Tv</code>.
    
    <pre>
    source currentVolume as Float;
    </pre>
    @return the value of the source <code>currentVolume</code>
     */
    protected java.lang.Float getCurrentVolume() throws Exception {
        return _currentVolume;
    }
    // End of code for source currentVolume from device Tv
    
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
    
    // Code for source mute from device Tv
    private java.lang.Boolean _mute;
    
    /**
     * Publish the value of source <code>mute</code> from device <code>Tv</code>.
    
    <pre>
    source mute as Boolean;
    </pre>
    @param newMuteValue the new value for the source <code>mute</code>
     */
    protected void publishMute(java.lang.Boolean newMuteValue) {
        _mute = newMuteValue;
        getProcessor().publishValue(getOutProperties(), "mute", newMuteValue); 
    }
    
    /**
     * Returns the value of source <code>mute</code> from device <code>Tv</code>.
    
    <pre>
    source mute as Boolean;
    </pre>
    @return the value of the source <code>mute</code>
     */
    protected java.lang.Boolean getMute() throws Exception {
        return _mute;
    }
    // End of code for source mute from device Tv
    
    // Code for source turnedOn from device Tv
    private java.lang.Boolean _turnedOn;
    
    /**
     * Publish the value of source <code>turnedOn</code> from device <code>Tv</code>.
    
    <pre>
    source turnedOn as Boolean;
    </pre>
    @param newTurnedOnValue the new value for the source <code>turnedOn</code>
     */
    protected void publishTurnedOn(java.lang.Boolean newTurnedOnValue) {
        _turnedOn = newTurnedOnValue;
        getProcessor().publishValue(getOutProperties(), "turnedOn", newTurnedOnValue); 
    }
    
    /**
     * Returns the value of source <code>turnedOn</code> from device <code>Tv</code>.
    
    <pre>
    source turnedOn as Boolean;
    </pre>
    @return the value of the source <code>turnedOn</code>
     */
    protected java.lang.Boolean getTurnedOn() throws Exception {
        return _turnedOn;
    }
    // End of code for source turnedOn from device Tv
    
    /**
     * Implement this method to define the <code>changeChannel</code> order from the <code>ChannelControl</code> action
     * defined in device Tv.
     * 
    
    <pre>
    changeChannel(channel as String);
    </pre>
     * @param channel parameter 1 of the order.
     */
    protected abstract void changeChannel(java.lang.String channel) throws Exception;
    
    /**
     * Implement this method to define the <code>mute</code> order from the <code>VolumeControl</code> action
     * defined in device Tv.
     * 
    
    <pre>
    mute(mute as Boolean);
    </pre>
     * @param mute parameter 1 of the order.
     */
    protected abstract void mute(java.lang.Boolean mute) throws Exception;
    
    /**
     * Implement this method to define the <code>nextChannel</code> order from the <code>ChannelControl</code> action
     * defined in device Tv.
     * 
    
    <pre>
    nextChannel();
    </pre>
     */
    protected abstract void nextChannel() throws Exception;
    
    /**
     * Implement this method to define the <code>pause</code> order from the <code>TimeControl</code> action
     * defined in device SmartTv.
     * 
    
    <pre>
    pause();
    </pre>
     */
    protected abstract void pause() throws Exception;
    
    /**
     * Implement this method to define the <code>play</code> order from the <code>TimeControl</code> action
     * defined in device SmartTv.
     * 
    
    <pre>
    play();
    </pre>
     */
    protected abstract void play() throws Exception;
    
    /**
     * Implement this method to define the <code>previousChannel</code> order from the <code>ChannelControl</code> action
     * defined in device Tv.
     * 
    
    <pre>
    previousChannel();
    </pre>
     */
    protected abstract void previousChannel() throws Exception;
    
    /**
     * Implement this method to define the <code>setVolume</code> order from the <code>VolumeControl</code> action
     * defined in device Tv.
     * 
    
    <pre>
    setVolume(level as Float);
    </pre>
     * @param level parameter 1 of the order.
     */
    protected abstract void setVolume(java.lang.Float level) throws Exception;
    
    /**
     * Implement this method to define the <code>stop</code> order from the <code>TimeControl</code> action
     * defined in device SmartTv.
     * 
    
    <pre>
    stop();
    </pre>
     */
    protected abstract void stop() throws Exception;
    
    /**
     * Implement this method to define the <code>volumeDown</code> order from the <code>VolumeControl</code> action
     * defined in device Tv.
     * 
    
    <pre>
    volumeDown();
    </pre>
     */
    protected abstract void volumeDown() throws Exception;
    
    /**
     * Implement this method to define the <code>volumeUp</code> order from the <code>VolumeControl</code> action
     * defined in device Tv.
     * 
    
    <pre>
    volumeUp();
    </pre>
     */
    protected abstract void volumeUp() throws Exception;
}

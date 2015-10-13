package fr.inria.phoenix.diasuite.framework.device.ptzvideocamera;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device PTZVideoCamera extends VideoCamera {
 * 	action PTZ;
 * 	source panAngle as Float;
 * 	source tiltAngle as Float;
 * 	source zoom as Float;
 * }
</pre>
 */
public abstract class AbstractPTZVideoCamera extends Service {
    
    public AbstractPTZVideoCamera(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue,
            java.lang.String locationValue,
            java.lang.String userValue) {
        super("/Device/Device/PhysicalDevice/Camera/VideoCamera/PTZVideoCamera/", serviceConfiguration);
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
        if (orderName.equals("goToPreset")) {
            goToPreset((java.lang.String) args[0]);
            return null;
        }
        if (orderName.equals("pan")) {
            pan((java.lang.Float) args[0]);
            return null;
        }
        if (orderName.equals("panLeft")) {
            panLeft();
            return null;
        }
        if (orderName.equals("panRight")) {
            panRight();
            return null;
        }
        if (orderName.equals("startRecording")) {
            startRecording();
            return null;
        }
        if (orderName.equals("stopRecording")) {
            stopRecording();
            return null;
        }
        if (orderName.equals("tilt")) {
            tilt((java.lang.Float) args[0]);
            return null;
        }
        if (orderName.equals("tiltDown")) {
            tiltDown();
            return null;
        }
        if (orderName.equals("tiltUp")) {
            tiltUp();
            return null;
        }
        if (orderName.equals("zoom")) {
            zoom((java.lang.Float) args[0]);
            return null;
        }
        if (orderName.equals("zoomIn")) {
            zoomIn();
            return null;
        }
        if (orderName.equals("zoomOut")) {
            zoomOut();
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
        if (orderName.equals("image")) {
            return getImage();
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("panAngle")) {
            return getPanAngle();
        }
        if (orderName.equals("tiltAngle")) {
            return getTiltAngle();
        }
        if (orderName.equals("video")) {
            return getVideo();
        }
        if (orderName.equals("zoom")) {
            return getZoom();
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
    
    // Code for source image from device Camera
    private fr.inria.phoenix.diasuite.framework.datatype.file.File _image;
    
    /**
     * Publish the value of source <code>image</code> from device <code>Camera</code>.
    
    <pre>
    source image as File;
    </pre>
    @param newImageValue the new value for the source <code>image</code>
     */
    protected void publishImage(fr.inria.phoenix.diasuite.framework.datatype.file.File newImageValue) {
        _image = newImageValue;
        getProcessor().publishValue(getOutProperties(), "image", newImageValue); 
    }
    
    /**
     * Returns the value of source <code>image</code> from device <code>Camera</code>.
    
    <pre>
    source image as File;
    </pre>
    @return the value of the source <code>image</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.file.File getImage() throws Exception {
        return _image;
    }
    // End of code for source image from device Camera
    
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
    
    // Code for source panAngle from device PTZVideoCamera
    private java.lang.Float _panAngle;
    
    /**
     * Publish the value of source <code>panAngle</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source panAngle as Float;
    </pre>
    @param newPanAngleValue the new value for the source <code>panAngle</code>
     */
    protected void publishPanAngle(java.lang.Float newPanAngleValue) {
        _panAngle = newPanAngleValue;
        getProcessor().publishValue(getOutProperties(), "panAngle", newPanAngleValue); 
    }
    
    /**
     * Returns the value of source <code>panAngle</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source panAngle as Float;
    </pre>
    @return the value of the source <code>panAngle</code>
     */
    protected java.lang.Float getPanAngle() throws Exception {
        return _panAngle;
    }
    // End of code for source panAngle from device PTZVideoCamera
    
    // Code for source tiltAngle from device PTZVideoCamera
    private java.lang.Float _tiltAngle;
    
    /**
     * Publish the value of source <code>tiltAngle</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source tiltAngle as Float;
    </pre>
    @param newTiltAngleValue the new value for the source <code>tiltAngle</code>
     */
    protected void publishTiltAngle(java.lang.Float newTiltAngleValue) {
        _tiltAngle = newTiltAngleValue;
        getProcessor().publishValue(getOutProperties(), "tiltAngle", newTiltAngleValue); 
    }
    
    /**
     * Returns the value of source <code>tiltAngle</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source tiltAngle as Float;
    </pre>
    @return the value of the source <code>tiltAngle</code>
     */
    protected java.lang.Float getTiltAngle() throws Exception {
        return _tiltAngle;
    }
    // End of code for source tiltAngle from device PTZVideoCamera
    
    // Code for source video from device VideoCamera
    private fr.inria.phoenix.diasuite.framework.datatype.file.File _video;
    
    /**
     * Publish the value of source <code>video</code> from device <code>VideoCamera</code>.
    
    <pre>
    source video as File;
    </pre>
    @param newVideoValue the new value for the source <code>video</code>
     */
    protected void publishVideo(fr.inria.phoenix.diasuite.framework.datatype.file.File newVideoValue) {
        _video = newVideoValue;
        getProcessor().publishValue(getOutProperties(), "video", newVideoValue); 
    }
    
    /**
     * Returns the value of source <code>video</code> from device <code>VideoCamera</code>.
    
    <pre>
    source video as File;
    </pre>
    @return the value of the source <code>video</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.file.File getVideo() throws Exception {
        return _video;
    }
    // End of code for source video from device VideoCamera
    
    // Code for source zoom from device PTZVideoCamera
    private java.lang.Float _zoom;
    
    /**
     * Publish the value of source <code>zoom</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source zoom as Float;
    </pre>
    @param newZoomValue the new value for the source <code>zoom</code>
     */
    protected void publishZoom(java.lang.Float newZoomValue) {
        _zoom = newZoomValue;
        getProcessor().publishValue(getOutProperties(), "zoom", newZoomValue); 
    }
    
    /**
     * Returns the value of source <code>zoom</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source zoom as Float;
    </pre>
    @return the value of the source <code>zoom</code>
     */
    protected java.lang.Float getZoom() throws Exception {
        return _zoom;
    }
    // End of code for source zoom from device PTZVideoCamera
    
    /**
     * Implement this method to define the <code>goToPreset</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    goToPreset(presetName as String);
    </pre>
     * @param presetName parameter 1 of the order.
     */
    protected abstract void goToPreset(java.lang.String presetName) throws Exception;
    
    /**
     * Implement this method to define the <code>pan</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    pan(angle as Float);
    </pre>
     * @param angle parameter 1 of the order.
     */
    protected abstract void pan(java.lang.Float angle) throws Exception;
    
    /**
     * Implement this method to define the <code>panLeft</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    panLeft();
    </pre>
     */
    protected abstract void panLeft() throws Exception;
    
    /**
     * Implement this method to define the <code>panRight</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    panRight();
    </pre>
     */
    protected abstract void panRight() throws Exception;
    
    /**
     * Implement this method to define the <code>startRecording</code> order from the <code>StartStopRecording</code> action
     * defined in device VideoCamera.
     * 
    
    <pre>
    startRecording();
    </pre>
     */
    protected abstract void startRecording() throws Exception;
    
    /**
     * Implement this method to define the <code>stopRecording</code> order from the <code>StartStopRecording</code> action
     * defined in device VideoCamera.
     * 
    
    <pre>
    stopRecording();
    </pre>
     */
    protected abstract void stopRecording() throws Exception;
    
    /**
     * Implement this method to define the <code>tilt</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    tilt(angle as Float);
    </pre>
     * @param angle parameter 1 of the order.
     */
    protected abstract void tilt(java.lang.Float angle) throws Exception;
    
    /**
     * Implement this method to define the <code>tiltDown</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    tiltDown();
    </pre>
     */
    protected abstract void tiltDown() throws Exception;
    
    /**
     * Implement this method to define the <code>tiltUp</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    tiltUp();
    </pre>
     */
    protected abstract void tiltUp() throws Exception;
    
    /**
     * Implement this method to define the <code>zoom</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    zoom(factor as Float);
    </pre>
     * @param factor parameter 1 of the order.
     */
    protected abstract void zoom(java.lang.Float factor) throws Exception;
    
    /**
     * Implement this method to define the <code>zoomIn</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    zoomIn();
    </pre>
     */
    protected abstract void zoomIn() throws Exception;
    
    /**
     * Implement this method to define the <code>zoomOut</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera.
     * 
    
    <pre>
    zoomOut();
    </pre>
     */
    protected abstract void zoomOut() throws Exception;
}

package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.videocamera.AbstractVideoCamera;

// @internal
public final class VideoCameraMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractVideoCamera {
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getImage() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.file.File result = __image;
            if(result == null)
                return super.getImage();
            return result;
        }
        
        public void _publishImage(fr.inria.phoenix.diasuite.framework.datatype.file.File newImageValue) {
            publishImage(newImageValue);
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getVideo() throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.file.File result = __video;
            if(result == null)
                return super.getVideo();
            return result;
        }
        
        public void _publishVideo(fr.inria.phoenix.diasuite.framework.datatype.file.File newVideoValue) {
            publishVideo(newVideoValue);
        }
        
        protected void startRecording() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("startRecording");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void stopRecording() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("stopRecording");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    VideoCameraMock(ServiceConfiguration serviceConfiguration,
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
    public VideoCameraMock id(java.lang.String newIdValue) {
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
    public VideoCameraMock location(java.lang.String newLocationValue) {
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
    public VideoCameraMock user(java.lang.String newUserValue) {
        proxy._updateUser(newUserValue);
        return this;
    }
    // End of code for the attribute user from device PhysicalDevice
    
    // Code for source image from device Camera
    /**
     * Publish the value of source <code>image</code> from device <code>Camera</code>.
    
    <pre>
    source image as File;
    </pre>
    @param newImageValue the new value for the source <code>image</code>
    @return this for fluent interface
     */
    public VideoCameraMock image(fr.inria.phoenix.diasuite.framework.datatype.file.File newImageValue) {
        proxy._publishImage(newImageValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.file.File __image = null;
    /**
     * Set the value (without publication) of source <code>image</code> from device <code>Camera</code>.
    
    <pre>
    source image as File;
    </pre>
    @param newImageValue the new value for the source <code>image</code>
    @return this for fluent interface
     */
    public VideoCameraMock setImage(fr.inria.phoenix.diasuite.framework.datatype.file.File newImageValue) {
        __image = newImageValue;
        return this;
    }
    // End of code for source image from device Camera
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public VideoCameraMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public VideoCameraMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source video from device VideoCamera
    /**
     * Publish the value of source <code>video</code> from device <code>VideoCamera</code>.
    
    <pre>
    source video as File;
    </pre>
    @param newVideoValue the new value for the source <code>video</code>
    @return this for fluent interface
     */
    public VideoCameraMock video(fr.inria.phoenix.diasuite.framework.datatype.file.File newVideoValue) {
        proxy._publishVideo(newVideoValue);
        return this;
    }
    
    private fr.inria.phoenix.diasuite.framework.datatype.file.File __video = null;
    /**
     * Set the value (without publication) of source <code>video</code> from device <code>VideoCamera</code>.
    
    <pre>
    source video as File;
    </pre>
    @param newVideoValue the new value for the source <code>video</code>
    @return this for fluent interface
     */
    public VideoCameraMock setVideo(fr.inria.phoenix.diasuite.framework.datatype.file.File newVideoValue) {
        __video = newVideoValue;
        return this;
    }
    // End of code for source video from device VideoCamera
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>startRecording</code> order from the <code>StartStopRecording</code> action
     * defined in device VideoCamera was called.
     * 
    
    <pre>
    startRecording();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectStartRecording() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("startRecording".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>stopRecording</code> order from the <code>StartStopRecording</code> action
     * defined in device VideoCamera was called.
     * 
    
    <pre>
    stopRecording();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectStopRecording() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("stopRecording".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

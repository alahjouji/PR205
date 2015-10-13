package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.ptzvideocamera.AbstractPTZVideoCamera;

// @internal
public final class PTZVideoCameraMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractPTZVideoCamera {
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
        
        protected java.lang.Float getPanAngle() throws Exception {
            java.lang.Float result = __panAngle;
            if(result == null)
                return super.getPanAngle();
            return result;
        }
        
        public void _publishPanAngle(java.lang.Float newPanAngleValue) {
            publishPanAngle(newPanAngleValue);
        }
        
        protected java.lang.Float getTiltAngle() throws Exception {
            java.lang.Float result = __tiltAngle;
            if(result == null)
                return super.getTiltAngle();
            return result;
        }
        
        public void _publishTiltAngle(java.lang.Float newTiltAngleValue) {
            publishTiltAngle(newTiltAngleValue);
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
        
        protected java.lang.Float getZoom() throws Exception {
            java.lang.Float result = __zoom;
            if(result == null)
                return super.getZoom();
            return result;
        }
        
        public void _publishZoom(java.lang.Float newZoomValue) {
            publishZoom(newZoomValue);
        }
        
        protected void goToPreset(java.lang.String presetName) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("goToPreset");
                __action.add(presetName);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void pan(java.lang.Float angle) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("pan");
                __action.add(angle);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void panLeft() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("panLeft");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void panRight() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("panRight");
                __actions.add(__action);
                __actions.notifyAll();
             }
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
        
        protected void tilt(java.lang.Float angle) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("tilt");
                __action.add(angle);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void tiltDown() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("tiltDown");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void tiltUp() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("tiltUp");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void zoom(java.lang.Float factor) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("zoom");
                __action.add(factor);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void zoomIn() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("zoomIn");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void zoomOut() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("zoomOut");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    PTZVideoCameraMock(ServiceConfiguration serviceConfiguration,
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
    public PTZVideoCameraMock id(java.lang.String newIdValue) {
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
    public PTZVideoCameraMock location(java.lang.String newLocationValue) {
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
    public PTZVideoCameraMock user(java.lang.String newUserValue) {
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
    public PTZVideoCameraMock image(fr.inria.phoenix.diasuite.framework.datatype.file.File newImageValue) {
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
    public PTZVideoCameraMock setImage(fr.inria.phoenix.diasuite.framework.datatype.file.File newImageValue) {
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
    public PTZVideoCameraMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public PTZVideoCameraMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source panAngle from device PTZVideoCamera
    /**
     * Publish the value of source <code>panAngle</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source panAngle as Float;
    </pre>
    @param newPanAngleValue the new value for the source <code>panAngle</code>
    @return this for fluent interface
     */
    public PTZVideoCameraMock panAngle(java.lang.Float newPanAngleValue) {
        proxy._publishPanAngle(newPanAngleValue);
        return this;
    }
    
    private java.lang.Float __panAngle = null;
    /**
     * Set the value (without publication) of source <code>panAngle</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source panAngle as Float;
    </pre>
    @param newPanAngleValue the new value for the source <code>panAngle</code>
    @return this for fluent interface
     */
    public PTZVideoCameraMock setPanAngle(java.lang.Float newPanAngleValue) {
        __panAngle = newPanAngleValue;
        return this;
    }
    // End of code for source panAngle from device PTZVideoCamera
    
    // Code for source tiltAngle from device PTZVideoCamera
    /**
     * Publish the value of source <code>tiltAngle</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source tiltAngle as Float;
    </pre>
    @param newTiltAngleValue the new value for the source <code>tiltAngle</code>
    @return this for fluent interface
     */
    public PTZVideoCameraMock tiltAngle(java.lang.Float newTiltAngleValue) {
        proxy._publishTiltAngle(newTiltAngleValue);
        return this;
    }
    
    private java.lang.Float __tiltAngle = null;
    /**
     * Set the value (without publication) of source <code>tiltAngle</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source tiltAngle as Float;
    </pre>
    @param newTiltAngleValue the new value for the source <code>tiltAngle</code>
    @return this for fluent interface
     */
    public PTZVideoCameraMock setTiltAngle(java.lang.Float newTiltAngleValue) {
        __tiltAngle = newTiltAngleValue;
        return this;
    }
    // End of code for source tiltAngle from device PTZVideoCamera
    
    // Code for source video from device VideoCamera
    /**
     * Publish the value of source <code>video</code> from device <code>VideoCamera</code>.
    
    <pre>
    source video as File;
    </pre>
    @param newVideoValue the new value for the source <code>video</code>
    @return this for fluent interface
     */
    public PTZVideoCameraMock video(fr.inria.phoenix.diasuite.framework.datatype.file.File newVideoValue) {
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
    public PTZVideoCameraMock setVideo(fr.inria.phoenix.diasuite.framework.datatype.file.File newVideoValue) {
        __video = newVideoValue;
        return this;
    }
    // End of code for source video from device VideoCamera
    
    // Code for source zoom from device PTZVideoCamera
    /**
     * Publish the value of source <code>zoom</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source zoom as Float;
    </pre>
    @param newZoomValue the new value for the source <code>zoom</code>
    @return this for fluent interface
     */
    public PTZVideoCameraMock zoom(java.lang.Float newZoomValue) {
        proxy._publishZoom(newZoomValue);
        return this;
    }
    
    private java.lang.Float __zoom = null;
    /**
     * Set the value (without publication) of source <code>zoom</code> from device <code>PTZVideoCamera</code>.
    
    <pre>
    source zoom as Float;
    </pre>
    @param newZoomValue the new value for the source <code>zoom</code>
    @return this for fluent interface
     */
    public PTZVideoCameraMock setZoom(java.lang.Float newZoomValue) {
        __zoom = newZoomValue;
        return this;
    }
    // End of code for source zoom from device PTZVideoCamera
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>goToPreset</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    goToPreset(presetName as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectGoToPreset() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("goToPreset".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>goToPreset</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    goToPreset(presetName as String);
    </pre>
     * @param presetName parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectGoToPreset(java.lang.String presetName) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("goToPreset".equals(__action.poll())))
                    return false;
                if(!presetName.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>pan</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    pan(angle as Float);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectPan() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("pan".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>pan</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    pan(angle as Float);
    </pre>
     * @param angle parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectPan(java.lang.Float angle) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("pan".equals(__action.poll())))
                    return false;
                if(!angle.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>panLeft</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    panLeft();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectPanLeft() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("panLeft".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>panRight</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    panRight();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectPanRight() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("panRight".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
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
    
    /**
     * Check that the <code>tilt</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    tilt(angle as Float);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectTilt() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("tilt".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>tilt</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    tilt(angle as Float);
    </pre>
     * @param angle parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectTilt(java.lang.Float angle) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("tilt".equals(__action.poll())))
                    return false;
                if(!angle.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>tiltDown</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    tiltDown();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectTiltDown() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("tiltDown".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>tiltUp</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    tiltUp();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectTiltUp() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("tiltUp".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>zoom</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    zoom(factor as Float);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectZoom() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("zoom".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>zoom</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    zoom(factor as Float);
    </pre>
     * @param factor parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectZoom(java.lang.Float factor) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("zoom".equals(__action.poll())))
                    return false;
                if(!factor.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>zoomIn</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    zoomIn();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectZoomIn() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("zoomIn".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>zoomOut</code> order from the <code>PTZ</code> action
     * defined in device PTZVideoCamera was called.
     * 
    
    <pre>
    zoomOut();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectZoomOut() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("zoomOut".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

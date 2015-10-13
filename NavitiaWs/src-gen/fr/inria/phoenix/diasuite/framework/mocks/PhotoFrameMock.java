package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.photoframe.AbstractPhotoFrame;

// @internal
public final class PhotoFrameMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractPhotoFrame {
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
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> getPhotos() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> result = __photos;
            if(result == null)
                return super.getPhotos();
            return result;
        }
        
        public void _publishPhotos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> newPhotosValue) {
            publishPhotos(newPhotosValue);
        }
        
        protected void addPhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addPhoto");
                __action.add(photo);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removeAllPhoto() throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removeAllPhoto");
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void removePhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("removePhoto");
                __action.add(photo);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void setCurrentPhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("setCurrentPhoto");
                __action.add(photo);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    PhotoFrameMock(ServiceConfiguration serviceConfiguration,
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
    public PhotoFrameMock id(java.lang.String newIdValue) {
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
    public PhotoFrameMock location(java.lang.String newLocationValue) {
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
    public PhotoFrameMock user(java.lang.String newUserValue) {
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
    public PhotoFrameMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public PhotoFrameMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source photos from device PhotoFrame
    /**
     * Publish the value of source <code>photos</code> from device <code>PhotoFrame</code>.
    
    <pre>
    source photos as File[];
    </pre>
    @param newPhotosValue the new value for the source <code>photos</code>
    @return this for fluent interface
     */
    public PhotoFrameMock photos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> newPhotosValue) {
        proxy._publishPhotos(newPhotosValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> __photos = null;
    /**
     * Set the value (without publication) of source <code>photos</code> from device <code>PhotoFrame</code>.
    
    <pre>
    source photos as File[];
    </pre>
    @param newPhotosValue the new value for the source <code>photos</code>
    @return this for fluent interface
     */
    public PhotoFrameMock setPhotos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> newPhotosValue) {
        __photos = newPhotosValue;
        return this;
    }
    // End of code for source photos from device PhotoFrame
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>addPhoto</code> order from the <code>PhotoFrameManagement</code> action
     * defined in device PhotoFrame was called.
     * 
    
    <pre>
    addPhoto(photo as File);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddPhoto() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPhoto".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addPhoto</code> order from the <code>PhotoFrameManagement</code> action
     * defined in device PhotoFrame was called.
     * 
    
    <pre>
    addPhoto(photo as File);
    </pre>
     * @param photo parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddPhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addPhoto".equals(__action.poll())))
                    return false;
                if(!photo.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removeAllPhoto</code> order from the <code>PhotoFrameManagement</code> action
     * defined in device PhotoFrame was called.
     * 
    
    <pre>
    removeAllPhoto();
    </pre>    @return true if the action happened with the given parameters
     */
    public boolean expectRemoveAllPhoto() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removeAllPhoto".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>removePhoto</code> order from the <code>PhotoFrameManagement</code> action
     * defined in device PhotoFrame was called.
     * 
    
    <pre>
    removePhoto(photo as File);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRemovePhoto() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhoto".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>removePhoto</code> order from the <code>PhotoFrameManagement</code> action
     * defined in device PhotoFrame was called.
     * 
    
    <pre>
    removePhoto(photo as File);
    </pre>
     * @param photo parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRemovePhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("removePhoto".equals(__action.poll())))
                    return false;
                if(!photo.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>setCurrentPhoto</code> order from the <code>PhotoFrameManagement</code> action
     * defined in device PhotoFrame was called.
     * 
    
    <pre>
    setCurrentPhoto(photo as File);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSetCurrentPhoto() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setCurrentPhoto".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>setCurrentPhoto</code> order from the <code>PhotoFrameManagement</code> action
     * defined in device PhotoFrame was called.
     * 
    
    <pre>
    setCurrentPhoto(photo as File);
    </pre>
     * @param photo parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSetCurrentPhoto(fr.inria.phoenix.diasuite.framework.datatype.file.File photo) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("setCurrentPhoto".equals(__action.poll())))
                    return false;
                if(!photo.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

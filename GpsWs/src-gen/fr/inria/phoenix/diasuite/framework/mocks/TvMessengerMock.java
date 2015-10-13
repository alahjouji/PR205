package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.tvmessenger.AbstractTvMessenger;

// @internal
public final class TvMessengerMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTvMessenger {
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
        
        protected void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendMessage");
                __action.add(to);
                __action.add(title);
                __action.add(content);
                __action.add(attachments);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void sendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
                java.lang.String title,
                java.lang.String content,
                java.lang.String image) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("sendMessageWithImage");
                __action.add(to);
                __action.add(title);
                __action.add(content);
                __action.add(image);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    TvMessengerMock(ServiceConfiguration serviceConfiguration,
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
    public TvMessengerMock id(java.lang.String newIdValue) {
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
    public TvMessengerMock location(java.lang.String newLocationValue) {
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
    public TvMessengerMock user(java.lang.String newUserValue) {
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
    public TvMessengerMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public TvMessengerMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessage(to as Contact, title as String, content as String, attachments as File[]);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     * @param attachments parameter 4 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!attachments.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessageWithImage() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectSendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>sendMessageWithImage</code> order from the <code>SendMessage</code> action
     * defined in device Messenger was called.
     * 
    
    <pre>
    sendMessageWithImage(to as Contact, title as String, content as String, image as String);
    </pre>
     * @param to parameter 1 of the order.
     * @param title parameter 2 of the order.
     * @param content parameter 3 of the order.
     * @param image parameter 4 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectSendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to,
            java.lang.String title,
            java.lang.String content,
            java.lang.String image) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("sendMessageWithImage".equals(__action.poll())))
                    return false;
                if(!to.equals(__action.poll()))
                    return false;
                if(!title.equals(__action.poll()))
                    return false;
                if(!content.equals(__action.poll()))
                    return false;
                if(!image.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

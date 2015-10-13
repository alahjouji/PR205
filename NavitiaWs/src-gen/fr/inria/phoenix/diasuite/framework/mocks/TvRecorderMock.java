package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.tvrecorder.AbstractTvRecorder;
import fr.inria.phoenix.diasuite.framework.device.tvrecorder.RecordedProgramIndices;

// @internal
public final class TvRecorderMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTvRecorder {
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.file.File getRecordedProgram(java.lang.String name) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.file.File result = __recordedProgram.get(new RecordedProgramIndices(name));
            if(result == null)
                return super.getRecordedProgram(name);
            return result;
        }
        
        public void _publishRecordedProgram(fr.inria.phoenix.diasuite.framework.datatype.file.File newRecordedProgramValue,
                java.lang.String name) {
            publishRecordedProgram(newRecordedProgramValue,
                name);
        }
        
        protected void record(java.lang.String name,
                java.lang.String channel,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
                fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("record");
                __action.add(name);
                __action.add(channel);
                __action.add(startDate);
                __action.add(endDate);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    TvRecorderMock(ServiceConfiguration serviceConfiguration,
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
    public TvRecorderMock id(java.lang.String newIdValue) {
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
    public TvRecorderMock location(java.lang.String newLocationValue) {
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
    public TvRecorderMock user(java.lang.String newUserValue) {
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
    public TvRecorderMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public TvRecorderMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source recordedProgram from device TvRecorder
    /**
     * Publish the value of source <code>recordedProgram</code> from device <code>TvRecorder</code>.
    
    <pre>
    source recordedProgram as File indexed by name as String;
    </pre>
    @param newRecordedProgramValue the new value for the source <code>recordedProgram</code>
    @param name the value of the index <code>name</code>
    @return this for fluent interface
     */
    public TvRecorderMock recordedProgram(fr.inria.phoenix.diasuite.framework.datatype.file.File newRecordedProgramValue,
            java.lang.String name) {
        proxy._publishRecordedProgram(newRecordedProgramValue,
            name);
        return this;
    }
    
    private java.util.HashMap<RecordedProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File> __recordedProgram = new java.util.HashMap<RecordedProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.file.File>();
    /**
     * Set the value (without publication) of source <code>recordedProgram</code> from device <code>TvRecorder</code>.
    
    <pre>
    source recordedProgram as File indexed by name as String;
    </pre>
    @param newRecordedProgramValue the new value for the source <code>recordedProgram</code>
    @param name the value of the index <code>name</code>
    @return this for fluent interface
     */
    public TvRecorderMock setRecordedProgram(fr.inria.phoenix.diasuite.framework.datatype.file.File newRecordedProgramValue,
            java.lang.String name) {
        RecordedProgramIndices _indices_ = new RecordedProgramIndices(name);
        __recordedProgram.put(_indices_, newRecordedProgramValue);
        return this;
    }
    // End of code for source recordedProgram from device TvRecorder
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>record</code> order from the <code>TvRecording</code> action
     * defined in device TvRecorder was called.
     * 
    
    <pre>
    record(name as String, channel as String, startDate as Date, endDate as Date);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRecord() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("record".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>record</code> order from the <code>TvRecording</code> action
     * defined in device TvRecorder was called.
     * 
    
    <pre>
    record(name as String, channel as String, startDate as Date, endDate as Date);
    </pre>
     * @param name parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRecord(java.lang.String name) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("record".equals(__action.poll())))
                    return false;
                if(!name.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>record</code> order from the <code>TvRecording</code> action
     * defined in device TvRecorder was called.
     * 
    
    <pre>
    record(name as String, channel as String, startDate as Date, endDate as Date);
    </pre>
     * @param name parameter 1 of the order.
     * @param channel parameter 2 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRecord(java.lang.String name,
            java.lang.String channel) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("record".equals(__action.poll())))
                    return false;
                if(!name.equals(__action.poll()))
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
     * Check that the <code>record</code> order from the <code>TvRecording</code> action
     * defined in device TvRecorder was called.
     * 
    
    <pre>
    record(name as String, channel as String, startDate as Date, endDate as Date);
    </pre>
     * @param name parameter 1 of the order.
     * @param channel parameter 2 of the order.
     * @param startDate parameter 3 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectRecord(java.lang.String name,
            java.lang.String channel,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("record".equals(__action.poll())))
                    return false;
                if(!name.equals(__action.poll()))
                    return false;
                if(!channel.equals(__action.poll()))
                    return false;
                if(!startDate.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>record</code> order from the <code>TvRecording</code> action
     * defined in device TvRecorder was called.
     * 
    
    <pre>
    record(name as String, channel as String, startDate as Date, endDate as Date);
    </pre>
     * @param name parameter 1 of the order.
     * @param channel parameter 2 of the order.
     * @param startDate parameter 3 of the order.
     * @param endDate parameter 4 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectRecord(java.lang.String name,
            java.lang.String channel,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date startDate,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date endDate) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("record".equals(__action.poll())))
                    return false;
                if(!name.equals(__action.poll()))
                    return false;
                if(!channel.equals(__action.poll()))
                    return false;
                if(!startDate.equals(__action.poll()))
                    return false;
                if(!endDate.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

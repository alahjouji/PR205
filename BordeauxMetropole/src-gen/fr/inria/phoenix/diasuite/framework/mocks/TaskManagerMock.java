package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.taskmanager.AbstractTaskManager;

// @internal
public final class TaskManagerMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTaskManager {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
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
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> getTasks() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> result = __tasks;
            if(result == null)
                return super.getTasks();
            return result;
        }
        
        public void _publishTasks(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> newTasksValue) {
            publishTasks(newTasksValue);
        }
        
        protected void addTask(fr.inria.phoenix.diasuite.framework.datatype.task.Task task) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("addTask");
                __action.add(task);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void deleteTask(fr.inria.phoenix.diasuite.framework.datatype.task.Task task) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("deleteTask");
                __action.add(task);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
        
        protected void update(java.lang.String taskId,
                fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state) throws Exception {
            synchronized(__actions) {
                java.util.Queue<Object> __action = new java.util.LinkedList<Object>();
                __action.add("update");
                __action.add(taskId);
                __action.add(state);
                __actions.add(__action);
                __actions.notifyAll();
             }
        }
    }
    
    Proxy proxy;
    
    TaskManagerMock(ServiceConfiguration serviceConfiguration,
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
    public TaskManagerMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public TaskManagerMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public TaskManagerMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source tasks from device TaskManager
    /**
     * Publish the value of source <code>tasks</code> from device <code>TaskManager</code>.
    
    <pre>
    source tasks as Task[];
    </pre>
    @param newTasksValue the new value for the source <code>tasks</code>
    @return this for fluent interface
     */
    public TaskManagerMock tasks(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> newTasksValue) {
        proxy._publishTasks(newTasksValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> __tasks = null;
    /**
     * Set the value (without publication) of source <code>tasks</code> from device <code>TaskManager</code>.
    
    <pre>
    source tasks as Task[];
    </pre>
    @param newTasksValue the new value for the source <code>tasks</code>
    @return this for fluent interface
     */
    public TaskManagerMock setTasks(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> newTasksValue) {
        __tasks = newTasksValue;
        return this;
    }
    // End of code for source tasks from device TaskManager
    
    private java.util.Queue<java.util.Queue<Object>> __actions = new java.util.LinkedList<java.util.Queue<Object>>();
    
    /**
     * Check that the <code>addTask</code> order from the <code>AddTask</code> action
     * defined in device TaskManager was called.
     * 
    
    <pre>
    addTask(task as Task);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectAddTask() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addTask".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>addTask</code> order from the <code>AddTask</code> action
     * defined in device TaskManager was called.
     * 
    
    <pre>
    addTask(task as Task);
    </pre>
     * @param task parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectAddTask(fr.inria.phoenix.diasuite.framework.datatype.task.Task task) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("addTask".equals(__action.poll())))
                    return false;
                if(!task.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>deleteTask</code> order from the <code>DeleteTask</code> action
     * defined in device TaskManager was called.
     * 
    
    <pre>
    deleteTask(task as Task);
    </pre>    @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectDeleteTask() {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("deleteTask".equals(__action.poll())))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>deleteTask</code> order from the <code>DeleteTask</code> action
     * defined in device TaskManager was called.
     * 
    
    <pre>
    deleteTask(task as Task);
    </pre>
     * @param task parameter 1 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectDeleteTask(fr.inria.phoenix.diasuite.framework.datatype.task.Task task) {
        try {
            synchronized(__actions) {
                java.util.Queue<Object> __action = __actions.poll();
                if(__action == null) {
                    __actions.wait(TIMEOUT);
                    __action = __actions.poll();
                }
                if(__action == null)
                    return false;
                if(!("deleteTask".equals(__action.poll())))
                    return false;
                if(!task.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    
    /**
     * Check that the <code>update</code> order from the <code>UpdateTaskState</code> action
     * defined in device TaskManager was called.
     * 
    
    <pre>
    update(taskId as String, state as TaskState);
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
     * Check that the <code>update</code> order from the <code>UpdateTaskState</code> action
     * defined in device TaskManager was called.
     * 
    
    <pre>
    update(taskId as String, state as TaskState);
    </pre>
     * @param taskId parameter 1 of the order.
     *     @return true if the action happened with the given parameters, remaining parameters are ignored
     */
    public boolean expectUpdate(java.lang.String taskId) {
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
                if(!taskId.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
    /**
     * Check that the <code>update</code> order from the <code>UpdateTaskState</code> action
     * defined in device TaskManager was called.
     * 
    
    <pre>
    update(taskId as String, state as TaskState);
    </pre>
     * @param taskId parameter 1 of the order.
     * @param state parameter 2 of the order.
     *     @return true if the action happened with the given parameters
     */
    public boolean expectUpdate(java.lang.String taskId,
            fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state) {
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
                if(!taskId.equals(__action.poll()))
                    return false;
                if(!state.equals(__action.poll()))
                    return false;
                return true;
            }
         } catch(InterruptedException e) {
             return false;
         }
    }
}

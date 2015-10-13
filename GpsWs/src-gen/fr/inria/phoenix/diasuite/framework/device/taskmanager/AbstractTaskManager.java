package fr.inria.phoenix.diasuite.framework.device.taskmanager;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device TaskManager extends HomeService {
 * 	source tasks as Task[];
 * 	action AddTask;
 * 	action DeleteTask;
 * 	action UpdateTaskState;
 * }
</pre>
 */
public abstract class AbstractTaskManager extends Service {
    
    public AbstractTaskManager(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/HomeService/TaskManager/", serviceConfiguration);
        updateId(idValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("addTask")) {
            addTask((fr.inria.phoenix.diasuite.framework.datatype.task.Task) args[0]);
            return null;
        }
        if (orderName.equals("deleteTask")) {
            deleteTask((fr.inria.phoenix.diasuite.framework.datatype.task.Task) args[0]);
            return null;
        }
        if (orderName.equals("update")) {
            update((java.lang.String) args[0],
                    (fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState) args[1]);
            return null;
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("tasks")) {
            return getTasks();
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
    
    // Code for source tasks from device TaskManager
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> _tasks;
    
    /**
     * Publish the value of source <code>tasks</code> from device <code>TaskManager</code>.
    
    <pre>
    source tasks as Task[];
    </pre>
    @param newTasksValue the new value for the source <code>tasks</code>
     */
    protected void publishTasks(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> newTasksValue) {
        _tasks = newTasksValue;
        getProcessor().publishValue(getOutProperties(), "tasks", newTasksValue); 
    }
    
    /**
     * Returns the value of source <code>tasks</code> from device <code>TaskManager</code>.
    
    <pre>
    source tasks as Task[];
    </pre>
    @return the value of the source <code>tasks</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> getTasks() throws Exception {
        return _tasks;
    }
    // End of code for source tasks from device TaskManager
    
    /**
     * Implement this method to define the <code>addTask</code> order from the <code>AddTask</code> action
     * defined in device TaskManager.
     * 
    
    <pre>
    addTask(task as Task);
    </pre>
     * @param task parameter 1 of the order.
     */
    protected abstract void addTask(fr.inria.phoenix.diasuite.framework.datatype.task.Task task) throws Exception;
    
    /**
     * Implement this method to define the <code>deleteTask</code> order from the <code>DeleteTask</code> action
     * defined in device TaskManager.
     * 
    
    <pre>
    deleteTask(task as Task);
    </pre>
     * @param task parameter 1 of the order.
     */
    protected abstract void deleteTask(fr.inria.phoenix.diasuite.framework.datatype.task.Task task) throws Exception;
    
    /**
     * Implement this method to define the <code>update</code> order from the <code>UpdateTaskState</code> action
     * defined in device TaskManager.
     * 
    
    <pre>
    update(taskId as String, state as TaskState);
    </pre>
     * @param taskId parameter 1 of the order.
     * @param state parameter 2 of the order.
     */
    protected abstract void update(java.lang.String taskId,
            fr.inria.phoenix.diasuite.framework.datatype.taskstate.TaskState state) throws Exception;
}

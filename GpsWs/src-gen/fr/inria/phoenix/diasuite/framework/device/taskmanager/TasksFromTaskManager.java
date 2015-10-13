package fr.inria.phoenix.diasuite.framework.device.taskmanager;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>tasks</code> of the device <code>TaskManager</code>.
 *
 * <pre>
 * device TaskManager extends HomeService {
 * 	source tasks as Task[];
 * 	action AddTask;
 * 	action DeleteTask;
 * 	action UpdateTaskState;
 * }
 * </pre>
 */
public final class TasksFromTaskManager implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> value;
    
    /**
     * Get the value of the source <code>tasks</code>
     * 
     * @return the value of the source <code>tasks</code>
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> value() {
        return value;
    }
    
    public TasksFromTaskManager(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.task.Task> value) {
        this.sender = new TaskManagerProxy(service, remoteServiceInfo);
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TasksFromTaskManager other = (TasksFromTaskManager) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private TaskManagerProxy sender;
    
    /**
     * Get the sender of the source <code>tasks</code>. I.e., the <code>TaskManager</code> device that published the source.
     * 
     * @return A proxy to the <code>TaskManager</code> that triggered the source
     */
    public TaskManagerProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>TaskManager</code> that discloses subscription/unsubscription methods.
     */
    public class TaskManagerProxy extends Proxy {
        private TaskManagerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>tasks</code> from this <code>TaskManager</code>.
         */
        public void subscribeTasks() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tasks");
        }
        
        /**
         * Unsubcribes from publication of source <code>tasks</code> from this <code>TaskManager</code>.
         */
        public void unsubscribeTasks() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tasks");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

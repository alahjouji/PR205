package fr.inria.phoenix.diasuite.framework.device.contactsensor;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>state</code> of the device <code>ContactSensor</code>.
 *
 * <pre>
 * device ContactSensor extends Sensor {
 * 	source state as State;
 * }
 * </pre>
 */
public final class StateFromContactSensor implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.state.State value;
    
    /**
     * Get the value of the source <code>state</code>
     * 
     * @return the value of the source <code>state</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.state.State value() {
        return value;
    }
    
    public StateFromContactSensor(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.state.State value) {
        this.sender = new ContactSensorProxy(service, remoteServiceInfo);
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
        StateFromContactSensor other = (StateFromContactSensor) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private ContactSensorProxy sender;
    
    /**
     * Get the sender of the source <code>state</code>. I.e., the <code>ContactSensor</code> device that published the source.
     * 
     * @return A proxy to the <code>ContactSensor</code> that triggered the source
     */
    public ContactSensorProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>ContactSensor</code> that discloses subscription/unsubscription methods.
     */
    public class ContactSensorProxy extends Proxy {
        private ContactSensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>state</code> from this <code>ContactSensor</code>.
         */
        public void subscribeState() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "state");
        }
        
        /**
         * Unsubcribes from publication of source <code>state</code> from this <code>ContactSensor</code>.
         */
        public void unsubscribeState() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "state");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
        
        /**
         * @return the value of the <code>location</code> attribute
         */
        public java.lang.String location() {
            return (java.lang.String) callGetValue("location");
        }
        
        /**
         * @return the value of the <code>user</code> attribute
         */
        public java.lang.String user() {
            return (java.lang.String) callGetValue("user");
        }
    }
}

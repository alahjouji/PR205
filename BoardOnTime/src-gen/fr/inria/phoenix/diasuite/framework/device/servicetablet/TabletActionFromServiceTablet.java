package fr.inria.phoenix.diasuite.framework.device.servicetablet;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>tabletAction</code> of the device <code>ServiceTablet</code>.
 *
 * <pre>
 * device ServiceTablet extends PhysicalDevice {
 * 	action PushContacts;
 * 	source tabletMode as ServiceTabletMode;
 * 	source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
 * }
 * </pre>
 */
public final class TabletActionFromServiceTablet implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode value;
    
    /**
     * Get the value of the source <code>tabletAction</code>
     * 
     * @return the value of the source <code>tabletAction</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode value() {
        return value;
    }
    
    private TabletActionIndices indices;
    
    /**
     * Get the value of the indices of the source <code>tabletAction</code>
     * 
     * @return the value of the indices
     */
    public TabletActionIndices indices() {
        return indices;
    }
    
    public TabletActionFromServiceTablet(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode value, TabletActionIndices indices) {
        this.sender = new ServiceTabletProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public TabletActionFromServiceTablet(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode value,
            fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
        this.sender = new ServiceTabletProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new TabletActionIndices(profile);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((indices == null) ? 0 : indices.hashCode());
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
        TabletActionFromServiceTablet other = (TabletActionFromServiceTablet) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (indices == null) {
            if (other.indices != null)
                return false;
        } else if (!indices.equals(other.indices))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private ServiceTabletProxy sender;
    
    /**
     * Get the sender of the source <code>tabletAction</code>. I.e., the <code>ServiceTablet</code> device that published the source.
     * 
     * @return A proxy to the <code>ServiceTablet</code> that triggered the source
     */
    public ServiceTabletProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>ServiceTablet</code> that discloses subscription/unsubscription methods.
     */
    public class ServiceTabletProxy extends Proxy {
        private ServiceTabletProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>tabletAction</code> from this <code>ServiceTablet</code>.
         */
        public void subscribeTabletAction() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tabletAction");
        }
        
        /**
         * Unsubcribes from publication of source <code>tabletAction</code> from this <code>ServiceTablet</code>.
         */
        public void unsubscribeTabletAction() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tabletAction");
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

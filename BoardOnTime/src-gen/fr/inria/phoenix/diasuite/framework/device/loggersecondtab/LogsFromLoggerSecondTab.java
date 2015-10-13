package fr.inria.phoenix.diasuite.framework.device.loggersecondtab;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>logs</code> of the device <code>LoggerSecondTab</code>.
 *
 * <pre>
 * device LoggerSecondTab extends PhysicalDevice{
 * 	source logs as String;
 * }
 * </pre>
 */
public final class LogsFromLoggerSecondTab implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the source <code>logs</code>
     * 
     * @return the value of the source <code>logs</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    public LogsFromLoggerSecondTab(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value) {
        this.sender = new LoggerSecondTabProxy(service, remoteServiceInfo);
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
        LogsFromLoggerSecondTab other = (LogsFromLoggerSecondTab) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private LoggerSecondTabProxy sender;
    
    /**
     * Get the sender of the source <code>logs</code>. I.e., the <code>LoggerSecondTab</code> device that published the source.
     * 
     * @return A proxy to the <code>LoggerSecondTab</code> that triggered the source
     */
    public LoggerSecondTabProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>LoggerSecondTab</code> that discloses subscription/unsubscription methods.
     */
    public class LoggerSecondTabProxy extends Proxy {
        private LoggerSecondTabProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>logs</code> from this <code>LoggerSecondTab</code>.
         */
        public void subscribeLogs() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "logs");
        }
        
        /**
         * Unsubcribes from publication of source <code>logs</code> from this <code>LoggerSecondTab</code>.
         */
        public void unsubscribeLogs() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "logs");
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

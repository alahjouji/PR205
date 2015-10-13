package fr.inria.phoenix.diasuite.framework.device.tvrecorder;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>recordedProgram</code> of the device <code>TvRecorder</code>.
 *
 * <pre>
 * device TvRecorder extends PhysicalDevice {
 * 	action TvRecording;
 * 	source recordedProgram as File indexed by name as String;
 * }
 * </pre>
 */
public final class RecordedProgramFromTvRecorder implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.file.File value;
    
    /**
     * Get the value of the source <code>recordedProgram</code>
     * 
     * @return the value of the source <code>recordedProgram</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File value() {
        return value;
    }
    
    private RecordedProgramIndices indices;
    
    /**
     * Get the value of the indices of the source <code>recordedProgram</code>
     * 
     * @return the value of the indices
     */
    public RecordedProgramIndices indices() {
        return indices;
    }
    
    public RecordedProgramFromTvRecorder(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value, RecordedProgramIndices indices) {
        this.sender = new TvRecorderProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public RecordedProgramFromTvRecorder(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value,
            java.lang.String name) {
        this.sender = new TvRecorderProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new RecordedProgramIndices(name);
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
        RecordedProgramFromTvRecorder other = (RecordedProgramFromTvRecorder) obj;
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
    private TvRecorderProxy sender;
    
    /**
     * Get the sender of the source <code>recordedProgram</code>. I.e., the <code>TvRecorder</code> device that published the source.
     * 
     * @return A proxy to the <code>TvRecorder</code> that triggered the source
     */
    public TvRecorderProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>TvRecorder</code> that discloses subscription/unsubscription methods.
     */
    public class TvRecorderProxy extends Proxy {
        private TvRecorderProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>recordedProgram</code> from this <code>TvRecorder</code>.
         */
        public void subscribeRecordedProgram() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "recordedProgram");
        }
        
        /**
         * Unsubcribes from publication of source <code>recordedProgram</code> from this <code>TvRecorder</code>.
         */
        public void unsubscribeRecordedProgram() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "recordedProgram");
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

package fr.inria.phoenix.diasuite.framework.device.tvguide;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device TvGuide extends HomeService {
 * 	source availableChannels as Channel[];
 * 	source currentProgram as TvSchedule indexed by channelId as String;
 * 	source nextProgram as TvSchedule indexed by channelId as String;
 * 	source programs as TvSchedule[] indexed by filter as TvSchedule;
 * }
</pre>
 */
public abstract class AbstractTvGuide extends Service {
    
    public AbstractTvGuide(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/HomeService/TvGuide/", serviceConfiguration);
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
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("availableChannels")) {
            return getAvailableChannels();
        }
        if (orderName.equals("currentProgram")) {
            return getCurrentProgram((java.lang.String) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("nextProgram")) {
            return getNextProgram((java.lang.String) args[0]);
        }
        if (orderName.equals("programs")) {
            return getPrograms((fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule) args[0]);
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
    
    // Code for source availableChannels from device TvGuide
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> _availableChannels;
    
    /**
     * Publish the value of source <code>availableChannels</code> from device <code>TvGuide</code>.
    
    <pre>
    source availableChannels as Channel[];
    </pre>
    @param newAvailableChannelsValue the new value for the source <code>availableChannels</code>
     */
    protected void publishAvailableChannels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> newAvailableChannelsValue) {
        _availableChannels = newAvailableChannelsValue;
        getProcessor().publishValue(getOutProperties(), "availableChannels", newAvailableChannelsValue); 
    }
    
    /**
     * Returns the value of source <code>availableChannels</code> from device <code>TvGuide</code>.
    
    <pre>
    source availableChannels as Channel[];
    </pre>
    @return the value of the source <code>availableChannels</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> getAvailableChannels() throws Exception {
        return _availableChannels;
    }
    // End of code for source availableChannels from device TvGuide
    
    // Code for source currentProgram from device TvGuide
    private java.util.HashMap<CurrentProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> _currentProgram = new java.util.HashMap<CurrentProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>();
    
    /**
     * Publish the value of source <code>currentProgram</code> from device <code>TvGuide</code>.
    
    <pre>
    source currentProgram as TvSchedule indexed by channelId as String;
    </pre>
    @param newCurrentProgramValue the new value for the source <code>currentProgram</code>
    @param channelId the value of the index <code>channelId</code>
     */
    protected void publishCurrentProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newCurrentProgramValue,
            java.lang.String channelId) {
        CurrentProgramIndices _indices_ = new CurrentProgramIndices(channelId);
        _currentProgram.put(_indices_, newCurrentProgramValue);
        getProcessor().publishValue(getOutProperties(), "currentProgram", newCurrentProgramValue, channelId); 
    }
    
    /**
     * Returns the value of source <code>currentProgram</code> from device <code>TvGuide</code>.
    
    <pre>
    source currentProgram as TvSchedule indexed by channelId as String;
    </pre>
    @param channelId the value of the index <code>channelId</code>
    @return the value of the source <code>currentProgram</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule getCurrentProgram(java.lang.String channelId) throws Exception {
        return _currentProgram.get(new CurrentProgramIndices(channelId));
    }
    // End of code for source currentProgram from device TvGuide
    
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
    
    // Code for source nextProgram from device TvGuide
    private java.util.HashMap<NextProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> _nextProgram = new java.util.HashMap<NextProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>();
    
    /**
     * Publish the value of source <code>nextProgram</code> from device <code>TvGuide</code>.
    
    <pre>
    source nextProgram as TvSchedule indexed by channelId as String;
    </pre>
    @param newNextProgramValue the new value for the source <code>nextProgram</code>
    @param channelId the value of the index <code>channelId</code>
     */
    protected void publishNextProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newNextProgramValue,
            java.lang.String channelId) {
        NextProgramIndices _indices_ = new NextProgramIndices(channelId);
        _nextProgram.put(_indices_, newNextProgramValue);
        getProcessor().publishValue(getOutProperties(), "nextProgram", newNextProgramValue, channelId); 
    }
    
    /**
     * Returns the value of source <code>nextProgram</code> from device <code>TvGuide</code>.
    
    <pre>
    source nextProgram as TvSchedule indexed by channelId as String;
    </pre>
    @param channelId the value of the index <code>channelId</code>
    @return the value of the source <code>nextProgram</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule getNextProgram(java.lang.String channelId) throws Exception {
        return _nextProgram.get(new NextProgramIndices(channelId));
    }
    // End of code for source nextProgram from device TvGuide
    
    // Code for source programs from device TvGuide
    private java.util.HashMap<ProgramsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>> _programs = new java.util.HashMap<ProgramsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>>();
    
    /**
     * Publish the value of source <code>programs</code> from device <code>TvGuide</code>.
    
    <pre>
    source programs as TvSchedule[] indexed by filter as TvSchedule;
    </pre>
    @param newProgramsValue the new value for the source <code>programs</code>
    @param filter the value of the index <code>filter</code>
     */
    protected void publishPrograms(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> newProgramsValue,
            fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) {
        ProgramsIndices _indices_ = new ProgramsIndices(filter);
        _programs.put(_indices_, newProgramsValue);
        getProcessor().publishValue(getOutProperties(), "programs", newProgramsValue, filter); 
    }
    
    /**
     * Returns the value of source <code>programs</code> from device <code>TvGuide</code>.
    
    <pre>
    source programs as TvSchedule[] indexed by filter as TvSchedule;
    </pre>
    @param filter the value of the index <code>filter</code>
    @return the value of the source <code>programs</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> getPrograms(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) throws Exception {
        return _programs.get(new ProgramsIndices(filter));
    }
    // End of code for source programs from device TvGuide
}

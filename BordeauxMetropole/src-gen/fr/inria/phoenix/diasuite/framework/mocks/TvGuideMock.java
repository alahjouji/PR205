package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.tvguide.AbstractTvGuide;
import fr.inria.phoenix.diasuite.framework.device.tvguide.ProgramsIndices;
import fr.inria.phoenix.diasuite.framework.device.tvguide.CurrentProgramIndices;
import fr.inria.phoenix.diasuite.framework.device.tvguide.NextProgramIndices;

// @internal
public final class TvGuideMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractTvGuide {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> getAvailableChannels() throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> result = __availableChannels;
            if(result == null)
                return super.getAvailableChannels();
            return result;
        }
        
        public void _publishAvailableChannels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> newAvailableChannelsValue) {
            publishAvailableChannels(newAvailableChannelsValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule getCurrentProgram(java.lang.String channelId) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule result = __currentProgram.get(new CurrentProgramIndices(channelId));
            if(result == null)
                return super.getCurrentProgram(channelId);
            return result;
        }
        
        public void _publishCurrentProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newCurrentProgramValue,
                java.lang.String channelId) {
            publishCurrentProgram(newCurrentProgramValue,
                channelId);
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
        
        protected fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule getNextProgram(java.lang.String channelId) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule result = __nextProgram.get(new NextProgramIndices(channelId));
            if(result == null)
                return super.getNextProgram(channelId);
            return result;
        }
        
        public void _publishNextProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newNextProgramValue,
                java.lang.String channelId) {
            publishNextProgram(newNextProgramValue,
                channelId);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> getPrograms(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> result = __programs.get(new ProgramsIndices(filter));
            if(result == null)
                return super.getPrograms(filter);
            return result;
        }
        
        public void _publishPrograms(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> newProgramsValue,
                fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) {
            publishPrograms(newProgramsValue,
                filter);
        }
    }
    
    Proxy proxy;
    
    TvGuideMock(ServiceConfiguration serviceConfiguration,
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
    public TvGuideMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source availableChannels from device TvGuide
    /**
     * Publish the value of source <code>availableChannels</code> from device <code>TvGuide</code>.
    
    <pre>
    source availableChannels as Channel[];
    </pre>
    @param newAvailableChannelsValue the new value for the source <code>availableChannels</code>
    @return this for fluent interface
     */
    public TvGuideMock availableChannels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> newAvailableChannelsValue) {
        proxy._publishAvailableChannels(newAvailableChannelsValue);
        return this;
    }
    
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> __availableChannels = null;
    /**
     * Set the value (without publication) of source <code>availableChannels</code> from device <code>TvGuide</code>.
    
    <pre>
    source availableChannels as Channel[];
    </pre>
    @param newAvailableChannelsValue the new value for the source <code>availableChannels</code>
    @return this for fluent interface
     */
    public TvGuideMock setAvailableChannels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> newAvailableChannelsValue) {
        __availableChannels = newAvailableChannelsValue;
        return this;
    }
    // End of code for source availableChannels from device TvGuide
    
    // Code for source currentProgram from device TvGuide
    /**
     * Publish the value of source <code>currentProgram</code> from device <code>TvGuide</code>.
    
    <pre>
    source currentProgram as TvSchedule indexed by channelId as String;
    </pre>
    @param newCurrentProgramValue the new value for the source <code>currentProgram</code>
    @param channelId the value of the index <code>channelId</code>
    @return this for fluent interface
     */
    public TvGuideMock currentProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newCurrentProgramValue,
            java.lang.String channelId) {
        proxy._publishCurrentProgram(newCurrentProgramValue,
            channelId);
        return this;
    }
    
    private java.util.HashMap<CurrentProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> __currentProgram = new java.util.HashMap<CurrentProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>();
    /**
     * Set the value (without publication) of source <code>currentProgram</code> from device <code>TvGuide</code>.
    
    <pre>
    source currentProgram as TvSchedule indexed by channelId as String;
    </pre>
    @param newCurrentProgramValue the new value for the source <code>currentProgram</code>
    @param channelId the value of the index <code>channelId</code>
    @return this for fluent interface
     */
    public TvGuideMock setCurrentProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newCurrentProgramValue,
            java.lang.String channelId) {
        CurrentProgramIndices _indices_ = new CurrentProgramIndices(channelId);
        __currentProgram.put(_indices_, newCurrentProgramValue);
        return this;
    }
    // End of code for source currentProgram from device TvGuide
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public TvGuideMock isAlive(java.lang.Boolean newIsAliveValue) {
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
    public TvGuideMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source nextProgram from device TvGuide
    /**
     * Publish the value of source <code>nextProgram</code> from device <code>TvGuide</code>.
    
    <pre>
    source nextProgram as TvSchedule indexed by channelId as String;
    </pre>
    @param newNextProgramValue the new value for the source <code>nextProgram</code>
    @param channelId the value of the index <code>channelId</code>
    @return this for fluent interface
     */
    public TvGuideMock nextProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newNextProgramValue,
            java.lang.String channelId) {
        proxy._publishNextProgram(newNextProgramValue,
            channelId);
        return this;
    }
    
    private java.util.HashMap<NextProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> __nextProgram = new java.util.HashMap<NextProgramIndices, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>();
    /**
     * Set the value (without publication) of source <code>nextProgram</code> from device <code>TvGuide</code>.
    
    <pre>
    source nextProgram as TvSchedule indexed by channelId as String;
    </pre>
    @param newNextProgramValue the new value for the source <code>nextProgram</code>
    @param channelId the value of the index <code>channelId</code>
    @return this for fluent interface
     */
    public TvGuideMock setNextProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newNextProgramValue,
            java.lang.String channelId) {
        NextProgramIndices _indices_ = new NextProgramIndices(channelId);
        __nextProgram.put(_indices_, newNextProgramValue);
        return this;
    }
    // End of code for source nextProgram from device TvGuide
    
    // Code for source programs from device TvGuide
    /**
     * Publish the value of source <code>programs</code> from device <code>TvGuide</code>.
    
    <pre>
    source programs as TvSchedule[] indexed by filter as TvSchedule;
    </pre>
    @param newProgramsValue the new value for the source <code>programs</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public TvGuideMock programs(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> newProgramsValue,
            fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) {
        proxy._publishPrograms(newProgramsValue,
            filter);
        return this;
    }
    
    private java.util.HashMap<ProgramsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>> __programs = new java.util.HashMap<ProgramsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>>();
    /**
     * Set the value (without publication) of source <code>programs</code> from device <code>TvGuide</code>.
    
    <pre>
    source programs as TvSchedule[] indexed by filter as TvSchedule;
    </pre>
    @param newProgramsValue the new value for the source <code>programs</code>
    @param filter the value of the index <code>filter</code>
    @return this for fluent interface
     */
    public TvGuideMock setPrograms(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> newProgramsValue,
            fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) {
        ProgramsIndices _indices_ = new ProgramsIndices(filter);
        __programs.put(_indices_, newProgramsValue);
        return this;
    }
    // End of code for source programs from device TvGuide
}

package fr.inria.phoenix.diasuite.framework.device.tvguide;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>nextProgram</code> from device <code>TvGuide</code>.

<pre>
source nextProgram as TvSchedule indexed by channelId as String;
</pre>
 */
public final class NextProgramIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public NextProgramIndices(java.lang.String channelId) {
        this._channelId = channelId;
    }
    
    // Code for index channelId
    private java.lang.String _channelId;
    
    /**
     * Get the <code>channelId</code> index
     * 
     * @return the value of the <code>channelId</code> index
     */
    public java.lang.String channelId() {
        return _channelId;
    }
    
    /**
     * Set the <code>channelId</code> index
     * 
     * @param newChannelId the new value for the <code>channelId</code> index
     */
    public void setChannelId(java.lang.String newChannelId) {
        this._channelId = newChannelId;
    }
    // End of code for index channelId
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_channelId == null) ? 0 : _channelId.hashCode());
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
        NextProgramIndices other = (NextProgramIndices) obj;
        if (_channelId == null) {
            if (other._channelId != null)
                return false;
        } else if (!_channelId.equals(other._channelId))
            return false;
        return true;
    }
}

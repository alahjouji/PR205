package fr.inria.phoenix.diasuite.framework.device.tvguide;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>programs</code> from device <code>TvGuide</code>.

<pre>
source programs as TvSchedule[] indexed by filter as TvSchedule;
</pre>
 */
public final class ProgramsIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public ProgramsIndices(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) {
        this._filter = filter;
    }
    
    // Code for index filter
    private fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule _filter;
    
    /**
     * Get the <code>filter</code> index
     * 
     * @return the value of the <code>filter</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter() {
        return _filter;
    }
    
    /**
     * Set the <code>filter</code> index
     * 
     * @param newFilter the new value for the <code>filter</code> index
     */
    public void setFilter(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newFilter) {
        this._filter = newFilter;
    }
    // End of code for index filter
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_filter == null) ? 0 : _filter.hashCode());
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
        ProgramsIndices other = (ProgramsIndices) obj;
        if (_filter == null) {
            if (other._filter != null)
                return false;
        } else if (!_filter.equals(other._filter))
            return false;
        return true;
    }
}

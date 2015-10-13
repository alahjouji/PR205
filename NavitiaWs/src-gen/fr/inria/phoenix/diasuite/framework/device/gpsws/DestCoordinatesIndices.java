package fr.inria.phoenix.diasuite.framework.device.gpsws;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>destCoordinates</code> from device <code>GpsWs</code>.

<pre>
source destCoordinates as GpsCoordinates indexed by filter as String;
</pre>
 */
public final class DestCoordinatesIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public DestCoordinatesIndices(java.lang.String filter) {
        this._filter = filter;
    }
    
    // Code for index filter
    private java.lang.String _filter;
    
    /**
     * Get the <code>filter</code> index
     * 
     * @return the value of the <code>filter</code> index
     */
    public java.lang.String filter() {
        return _filter;
    }
    
    /**
     * Set the <code>filter</code> index
     * 
     * @param newFilter the new value for the <code>filter</code> index
     */
    public void setFilter(java.lang.String newFilter) {
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
        DestCoordinatesIndices other = (DestCoordinatesIndices) obj;
        if (_filter == null) {
            if (other._filter != null)
                return false;
        } else if (!_filter.equals(other._filter))
            return false;
        return true;
    }
}

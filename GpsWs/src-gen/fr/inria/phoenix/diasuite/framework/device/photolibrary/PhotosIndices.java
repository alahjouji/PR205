package fr.inria.phoenix.diasuite.framework.device.photolibrary;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>photos</code> from device <code>PhotoLibrary</code>.

<pre>
source photos as Photo [] indexed by filter as PhotoFilter;
</pre>
 */
public final class PhotosIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public PhotosIndices(fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter) {
        this._filter = filter;
    }
    
    // Code for index filter
    private fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter _filter;
    
    /**
     * Get the <code>filter</code> index
     * 
     * @return the value of the <code>filter</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter filter() {
        return _filter;
    }
    
    /**
     * Set the <code>filter</code> index
     * 
     * @param newFilter the new value for the <code>filter</code> index
     */
    public void setFilter(fr.inria.phoenix.diasuite.framework.datatype.photofilter.PhotoFilter newFilter) {
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
        PhotosIndices other = (PhotosIndices) obj;
        if (_filter == null) {
            if (other._filter != null)
                return false;
        } else if (!_filter.equals(other._filter))
            return false;
        return true;
    }
}

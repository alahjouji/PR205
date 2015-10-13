package fr.inria.phoenix.diasuite.framework.device.networkstorage;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>fileBrowsing</code> from device <code>NetworkStorage</code>.

<pre>
source fileBrowsing as FileInfo[] indexed by directory as FileInfo, filter as FileType;
</pre>
 */
public final class FileBrowsingIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public FileBrowsingIndices(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory,
            fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
        this._directory = directory;
        this._filter = filter;
    }
    
    // Code for index directory
    private fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo _directory;
    
    /**
     * Get the <code>directory</code> index
     * 
     * @return the value of the <code>directory</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory() {
        return _directory;
    }
    
    /**
     * Set the <code>directory</code> index
     * 
     * @param newDirectory the new value for the <code>directory</code> index
     */
    public void setDirectory(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo newDirectory) {
        this._directory = newDirectory;
    }
    // End of code for index directory
    
    // Code for index filter
    private fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType _filter;
    
    /**
     * Get the <code>filter</code> index
     * 
     * @return the value of the <code>filter</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter() {
        return _filter;
    }
    
    /**
     * Set the <code>filter</code> index
     * 
     * @param newFilter the new value for the <code>filter</code> index
     */
    public void setFilter(fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType newFilter) {
        this._filter = newFilter;
    }
    // End of code for index filter
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_directory == null) ? 0 : _directory.hashCode());
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
        FileBrowsingIndices other = (FileBrowsingIndices) obj;
        if (_directory == null) {
            if (other._directory != null)
                return false;
        } else if (!_directory.equals(other._directory))
            return false;
        if (_filter == null) {
            if (other._filter != null)
                return false;
        } else if (!_filter.equals(other._filter))
            return false;
        return true;
    }
}

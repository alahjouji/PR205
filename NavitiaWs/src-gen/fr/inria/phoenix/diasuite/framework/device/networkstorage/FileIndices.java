package fr.inria.phoenix.diasuite.framework.device.networkstorage;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>file</code> from device <code>NetworkStorage</code>.

<pre>
source file as File indexed by info as FileInfo;
</pre>
 */
public final class FileIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public FileIndices(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info) {
        this._info = info;
    }
    
    // Code for index info
    private fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo _info;
    
    /**
     * Get the <code>info</code> index
     * 
     * @return the value of the <code>info</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo info() {
        return _info;
    }
    
    /**
     * Set the <code>info</code> index
     * 
     * @param newInfo the new value for the <code>info</code> index
     */
    public void setInfo(fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo newInfo) {
        this._info = newInfo;
    }
    // End of code for index info
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_info == null) ? 0 : _info.hashCode());
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
        FileIndices other = (FileIndices) obj;
        if (_info == null) {
            if (other._info != null)
                return false;
        } else if (!_info.equals(other._info))
            return false;
        return true;
    }
}

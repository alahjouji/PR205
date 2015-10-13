package fr.inria.phoenix.diasuite.framework.device.socialnetworkphotolibrary;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>tags</code> from device <code>SocialNetworkPhotoLibrary</code>.

<pre>
source tags as Tag [] indexed by photoID as String;
</pre>
 */
public final class TagsIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public TagsIndices(java.lang.String photoID) {
        this._photoID = photoID;
    }
    
    // Code for index photoID
    private java.lang.String _photoID;
    
    /**
     * Get the <code>photoID</code> index
     * 
     * @return the value of the <code>photoID</code> index
     */
    public java.lang.String photoID() {
        return _photoID;
    }
    
    /**
     * Set the <code>photoID</code> index
     * 
     * @param newPhotoID the new value for the <code>photoID</code> index
     */
    public void setPhotoID(java.lang.String newPhotoID) {
        this._photoID = newPhotoID;
    }
    // End of code for index photoID
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_photoID == null) ? 0 : _photoID.hashCode());
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
        TagsIndices other = (TagsIndices) obj;
        if (_photoID == null) {
            if (other._photoID != null)
                return false;
        } else if (!_photoID.equals(other._photoID))
            return false;
        return true;
    }
}

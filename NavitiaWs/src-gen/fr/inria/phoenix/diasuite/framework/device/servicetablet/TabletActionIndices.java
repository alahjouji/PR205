package fr.inria.phoenix.diasuite.framework.device.servicetablet;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>tabletAction</code> from device <code>ServiceTablet</code>.

<pre>
source tabletAction as ServiceTabletMode indexed by profile as PersonalProfile;
</pre>
 */
public final class TabletActionIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public TabletActionIndices(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile) {
        this._profile = profile;
    }
    
    // Code for index profile
    private fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile _profile;
    
    /**
     * Get the <code>profile</code> index
     * 
     * @return the value of the <code>profile</code> index
     */
    public fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile profile() {
        return _profile;
    }
    
    /**
     * Set the <code>profile</code> index
     * 
     * @param newProfile the new value for the <code>profile</code> index
     */
    public void setProfile(fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile newProfile) {
        this._profile = newProfile;
    }
    // End of code for index profile
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_profile == null) ? 0 : _profile.hashCode());
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
        TabletActionIndices other = (TabletActionIndices) obj;
        if (_profile == null) {
            if (other._profile != null)
                return false;
        } else if (!_profile.equals(other._profile))
            return false;
        return true;
    }
}

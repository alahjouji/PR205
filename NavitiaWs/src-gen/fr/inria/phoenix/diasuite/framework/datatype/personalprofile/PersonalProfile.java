package fr.inria.phoenix.diasuite.framework.datatype.personalprofile;

import java.io.Serializable;

/**
 * <pre>
structure PersonalProfile {
 * 	info as Contact;
 * 	picture as File;
 * 	relationship as Relationship;
 * }
</pre>
 */
public class PersonalProfile implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field info
    private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact info;
    
    /**
     * Returns the value of the info field.
    
    <pre>
    info as Contact
    </pre>
    @return the value of info
     */
    public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact getInfo() {
        return info;
    }
    
    /**
     * Set the value of the info field.
    
    <pre>
    info as Contact
    </pre>
    @param info the new value of info
     */
    public void setInfo(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact info) {
        this.info = info;
    }
    // End of code for field info

    // Code for field picture
    private fr.inria.phoenix.diasuite.framework.datatype.file.File picture;
    
    /**
     * Returns the value of the picture field.
    
    <pre>
    picture as File
    </pre>
    @return the value of picture
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File getPicture() {
        return picture;
    }
    
    /**
     * Set the value of the picture field.
    
    <pre>
    picture as File
    </pre>
    @param picture the new value of picture
     */
    public void setPicture(fr.inria.phoenix.diasuite.framework.datatype.file.File picture) {
        this.picture = picture;
    }
    // End of code for field picture

    // Code for field relationship
    private fr.inria.phoenix.diasuite.framework.datatype.relationship.Relationship relationship;
    
    /**
     * Returns the value of the relationship field.
    
    <pre>
    relationship as Relationship
    </pre>
    @return the value of relationship
     */
    public fr.inria.phoenix.diasuite.framework.datatype.relationship.Relationship getRelationship() {
        return relationship;
    }
    
    /**
     * Set the value of the relationship field.
    
    <pre>
    relationship as Relationship
    </pre>
    @param relationship the new value of relationship
     */
    public void setRelationship(fr.inria.phoenix.diasuite.framework.datatype.relationship.Relationship relationship) {
        this.relationship = relationship;
    }
    // End of code for field relationship

    public PersonalProfile() {
    }

    public PersonalProfile(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact info,
            fr.inria.phoenix.diasuite.framework.datatype.file.File picture,
            fr.inria.phoenix.diasuite.framework.datatype.relationship.Relationship relationship) {
        this.info = info;
        this.picture = picture;
        this.relationship = relationship;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        result = prime * result + ((picture == null) ? 0 : picture.hashCode());
        result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());
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
        PersonalProfile other = (PersonalProfile) obj;
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
            return false;
        if (picture == null) {
            if (other.picture != null)
                return false;
        } else if (!picture.equals(other.picture))
            return false;
        if (relationship == null) {
            if (other.relationship != null)
                return false;
        } else if (!relationship.equals(other.relationship))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PersonalProfile [" + 
            "info=" + info +", " + 
            "picture=" + picture +", " + 
            "relationship=" + relationship +
        "]";
    }
}

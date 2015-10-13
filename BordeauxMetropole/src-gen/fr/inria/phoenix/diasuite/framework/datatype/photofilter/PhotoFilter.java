package fr.inria.phoenix.diasuite.framework.datatype.photofilter;

import java.io.Serializable;

/**
 * <pre>
structure PhotoFilter {
 * 	date as Date;
 * 	albumID as String;
 * 	titleString as String;
 * 	contact as Contact;
 * }
</pre>
 */
public class PhotoFilter implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field date
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date date;
    
    /**
     * Returns the value of the date field.
    
    <pre>
    date as Date
    </pre>
    @return the value of date
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getDate() {
        return date;
    }
    
    /**
     * Set the value of the date field.
    
    <pre>
    date as Date
    </pre>
    @param date the new value of date
     */
    public void setDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
        this.date = date;
    }
    // End of code for field date

    // Code for field albumID
    private java.lang.String albumID;
    
    /**
     * Returns the value of the albumID field.
    
    <pre>
    albumID as String
    </pre>
    @return the value of albumID
     */
    public java.lang.String getAlbumID() {
        return albumID;
    }
    
    /**
     * Set the value of the albumID field.
    
    <pre>
    albumID as String
    </pre>
    @param albumID the new value of albumID
     */
    public void setAlbumID(java.lang.String albumID) {
        this.albumID = albumID;
    }
    // End of code for field albumID

    // Code for field titleString
    private java.lang.String titleString;
    
    /**
     * Returns the value of the titleString field.
    
    <pre>
    titleString as String
    </pre>
    @return the value of titleString
     */
    public java.lang.String getTitleString() {
        return titleString;
    }
    
    /**
     * Set the value of the titleString field.
    
    <pre>
    titleString as String
    </pre>
    @param titleString the new value of titleString
     */
    public void setTitleString(java.lang.String titleString) {
        this.titleString = titleString;
    }
    // End of code for field titleString

    // Code for field contact
    private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact;
    
    /**
     * Returns the value of the contact field.
    
    <pre>
    contact as Contact
    </pre>
    @return the value of contact
     */
    public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact getContact() {
        return contact;
    }
    
    /**
     * Set the value of the contact field.
    
    <pre>
    contact as Contact
    </pre>
    @param contact the new value of contact
     */
    public void setContact(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) {
        this.contact = contact;
    }
    // End of code for field contact

    public PhotoFilter() {
    }

    public PhotoFilter(fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            java.lang.String albumID,
            java.lang.String titleString,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact contact) {
        this.date = date;
        this.albumID = albumID;
        this.titleString = titleString;
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((albumID == null) ? 0 : albumID.hashCode());
        result = prime * result + ((titleString == null) ? 0 : titleString.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
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
        PhotoFilter other = (PhotoFilter) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (albumID == null) {
            if (other.albumID != null)
                return false;
        } else if (!albumID.equals(other.albumID))
            return false;
        if (titleString == null) {
            if (other.titleString != null)
                return false;
        } else if (!titleString.equals(other.titleString))
            return false;
        if (contact == null) {
            if (other.contact != null)
                return false;
        } else if (!contact.equals(other.contact))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhotoFilter [" + 
            "date=" + date +", " + 
            "albumID=" + albumID +", " + 
            "titleString=" + titleString +", " + 
            "contact=" + contact +
        "]";
    }
}

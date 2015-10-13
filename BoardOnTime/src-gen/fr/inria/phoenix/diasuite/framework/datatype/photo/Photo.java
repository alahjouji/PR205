package fr.inria.phoenix.diasuite.framework.datatype.photo;

import java.io.Serializable;

/**
 * <pre>
structure Photo {
 * 	albumID as String;
 * 	uploadedBy as Contact;
 * 	title as String;
 * 	content as Binary;
 * 	description as String;
 * 	date as Date;
 * 	reference as String;
 * }
</pre>
 */
public class Photo implements Serializable {
    private static final long serialVersionUID = 0;

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

    // Code for field uploadedBy
    private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact uploadedBy;
    
    /**
     * Returns the value of the uploadedBy field.
    
    <pre>
    uploadedBy as Contact
    </pre>
    @return the value of uploadedBy
     */
    public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact getUploadedBy() {
        return uploadedBy;
    }
    
    /**
     * Set the value of the uploadedBy field.
    
    <pre>
    uploadedBy as Contact
    </pre>
    @param uploadedBy the new value of uploadedBy
     */
    public void setUploadedBy(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
    // End of code for field uploadedBy

    // Code for field title
    private java.lang.String title;
    
    /**
     * Returns the value of the title field.
    
    <pre>
    title as String
    </pre>
    @return the value of title
     */
    public java.lang.String getTitle() {
        return title;
    }
    
    /**
     * Set the value of the title field.
    
    <pre>
    title as String
    </pre>
    @param title the new value of title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    // End of code for field title

    // Code for field content
    private byte[] content;
    
    /**
     * Returns the value of the content field.
    
    <pre>
    content as Binary
    </pre>
    @return the value of content
     */
    public byte[] getContent() {
        return content;
    }
    
    /**
     * Set the value of the content field.
    
    <pre>
    content as Binary
    </pre>
    @param content the new value of content
     */
    public void setContent(byte[] content) {
        this.content = content;
    }
    // End of code for field content

    // Code for field description
    private java.lang.String description;
    
    /**
     * Returns the value of the description field.
    
    <pre>
    description as String
    </pre>
    @return the value of description
     */
    public java.lang.String getDescription() {
        return description;
    }
    
    /**
     * Set the value of the description field.
    
    <pre>
    description as String
    </pre>
    @param description the new value of description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    // End of code for field description

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

    // Code for field reference
    private java.lang.String reference;
    
    /**
     * Returns the value of the reference field.
    
    <pre>
    reference as String
    </pre>
    @return the value of reference
     */
    public java.lang.String getReference() {
        return reference;
    }
    
    /**
     * Set the value of the reference field.
    
    <pre>
    reference as String
    </pre>
    @param reference the new value of reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }
    // End of code for field reference

    public Photo() {
    }

    public Photo(java.lang.String albumID,
            fr.inria.phoenix.diasuite.framework.datatype.contact.Contact uploadedBy,
            java.lang.String title,
            byte[] content,
            java.lang.String description,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            java.lang.String reference) {
        this.albumID = albumID;
        this.uploadedBy = uploadedBy;
        this.title = title;
        this.content = content;
        this.description = description;
        this.date = date;
        this.reference = reference;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((albumID == null) ? 0 : albumID.hashCode());
        result = prime * result + ((uploadedBy == null) ? 0 : uploadedBy.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
        Photo other = (Photo) obj;
        if (albumID == null) {
            if (other.albumID != null)
                return false;
        } else if (!albumID.equals(other.albumID))
            return false;
        if (uploadedBy == null) {
            if (other.uploadedBy != null)
                return false;
        } else if (!uploadedBy.equals(other.uploadedBy))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (reference == null) {
            if (other.reference != null)
                return false;
        } else if (!reference.equals(other.reference))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Photo [" + 
            "albumID=" + albumID +", " + 
            "uploadedBy=" + uploadedBy +", " + 
            "title=" + title +", " + 
            "content.length=" + content.length +", " + 
            "description=" + description +", " + 
            "date=" + date +", " + 
            "reference=" + reference +
        "]";
    }
}

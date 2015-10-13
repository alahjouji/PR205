package fr.inria.phoenix.diasuite.framework.datatype.photoalbum;

import java.io.Serializable;

/**
 * <pre>
structure PhotoAlbum {
 * 	id as String;
 * 	name as String;
 * 	description as String;
 * 	date as Date;
 * 	photos as Photo [];
 * }
</pre>
 */
public class PhotoAlbum implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field id
    private java.lang.String id;
    
    /**
     * Returns the value of the id field.
    
    <pre>
    id as String
    </pre>
    @return the value of id
     */
    public java.lang.String getId() {
        return id;
    }
    
    /**
     * Set the value of the id field.
    
    <pre>
    id as String
    </pre>
    @param id the new value of id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }
    // End of code for field id

    // Code for field name
    private java.lang.String name;
    
    /**
     * Returns the value of the name field.
    
    <pre>
    name as String
    </pre>
    @return the value of name
     */
    public java.lang.String getName() {
        return name;
    }
    
    /**
     * Set the value of the name field.
    
    <pre>
    name as String
    </pre>
    @param name the new value of name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    // End of code for field name

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

    // Code for field photos
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> photos;
    
    /**
     * Returns the value of the photos field.
    
    <pre>
    photos as Photo []
    </pre>
    @return the value of photos
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> getPhotos() {
        return photos;
    }
    
    /**
     * Set the value of the photos field.
    
    <pre>
    photos as Photo []
    </pre>
    @param photos the new value of photos
     */
    public void setPhotos(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> photos) {
        this.photos = photos;
    }
    // End of code for field photos

    public PhotoAlbum() {
    }

    public PhotoAlbum(java.lang.String id,
            java.lang.String name,
            java.lang.String description,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.photo.Photo> photos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.photos = photos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((photos == null) ? 0 : photos.hashCode());
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
        PhotoAlbum other = (PhotoAlbum) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
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
        if (photos == null) {
            if (other.photos != null)
                return false;
        } else if (!photos.equals(other.photos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhotoAlbum [" + 
            "id=" + id +", " + 
            "name=" + name +", " + 
            "description=" + description +", " + 
            "date=" + date +", " + 
            "photos=" + photos +
        "]";
    }
}

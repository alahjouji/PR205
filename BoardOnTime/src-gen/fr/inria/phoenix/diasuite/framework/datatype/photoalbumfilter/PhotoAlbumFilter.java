package fr.inria.phoenix.diasuite.framework.datatype.photoalbumfilter;

import java.io.Serializable;

/**
 * <pre>
structure PhotoAlbumFilter {
 * 	date as Date;
 * 	titleString as String;
 * }
</pre>
 */
public class PhotoAlbumFilter implements Serializable {
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

    public PhotoAlbumFilter() {
    }

    public PhotoAlbumFilter(fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            java.lang.String titleString) {
        this.date = date;
        this.titleString = titleString;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((titleString == null) ? 0 : titleString.hashCode());
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
        PhotoAlbumFilter other = (PhotoAlbumFilter) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (titleString == null) {
            if (other.titleString != null)
                return false;
        } else if (!titleString.equals(other.titleString))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhotoAlbumFilter [" + 
            "date=" + date +", " + 
            "titleString=" + titleString +
        "]";
    }
}

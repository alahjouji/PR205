package fr.inria.phoenix.diasuite.framework.datatype.comment;

import java.io.Serializable;

/**
 * <pre>
structure Comment {
 * 	author as String;
 * 	text as String;
 * 	date as Date;
 * }
</pre>
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field author
    private java.lang.String author;
    
    /**
     * Returns the value of the author field.
    
    <pre>
    author as String
    </pre>
    @return the value of author
     */
    public java.lang.String getAuthor() {
        return author;
    }
    
    /**
     * Set the value of the author field.
    
    <pre>
    author as String
    </pre>
    @param author the new value of author
     */
    public void setAuthor(java.lang.String author) {
        this.author = author;
    }
    // End of code for field author

    // Code for field text
    private java.lang.String text;
    
    /**
     * Returns the value of the text field.
    
    <pre>
    text as String
    </pre>
    @return the value of text
     */
    public java.lang.String getText() {
        return text;
    }
    
    /**
     * Set the value of the text field.
    
    <pre>
    text as String
    </pre>
    @param text the new value of text
     */
    public void setText(java.lang.String text) {
        this.text = text;
    }
    // End of code for field text

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

    public Comment() {
    }

    public Comment(java.lang.String author,
            java.lang.String text,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
        this.author = author;
        this.text = text;
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        Comment other = (Comment) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Comment [" + 
            "author=" + author +", " + 
            "text=" + text +", " + 
            "date=" + date +
        "]";
    }
}

package fr.inria.phoenix.diasuite.framework.datatype.email;

import java.io.Serializable;

/**
 * <pre>
structure Email {
 * 	title as String;
 * 	text as String;
 * 	date as String;
 * }
</pre>
 */
public class Email implements Serializable {
    private static final long serialVersionUID = 0;

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
    private java.lang.String date;
    
    /**
     * Returns the value of the date field.
    
    <pre>
    date as String
    </pre>
    @return the value of date
     */
    public java.lang.String getDate() {
        return date;
    }
    
    /**
     * Set the value of the date field.
    
    <pre>
    date as String
    </pre>
    @param date the new value of date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }
    // End of code for field date

    public Email() {
    }

    public Email(java.lang.String title,
            java.lang.String text,
            java.lang.String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        Email other = (Email) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
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
        return "Email [" + 
            "title=" + title +", " + 
            "text=" + text +", " + 
            "date=" + date +
        "]";
    }
}

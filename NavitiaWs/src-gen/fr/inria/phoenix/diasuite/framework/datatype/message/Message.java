package fr.inria.phoenix.diasuite.framework.datatype.message;

import java.io.Serializable;

/**
 * <pre>
structure Message {
 * 	sender as Contact;
 * 	title as String;
 * 	text as String;
 * 	attachments as File[];
 * }
</pre>
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field sender
    private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact sender;
    
    /**
     * Returns the value of the sender field.
    
    <pre>
    sender as Contact
    </pre>
    @return the value of sender
     */
    public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact getSender() {
        return sender;
    }
    
    /**
     * Set the value of the sender field.
    
    <pre>
    sender as Contact
    </pre>
    @param sender the new value of sender
     */
    public void setSender(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact sender) {
        this.sender = sender;
    }
    // End of code for field sender

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

    // Code for field attachments
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments;
    
    /**
     * Returns the value of the attachments field.
    
    <pre>
    attachments as File[]
    </pre>
    @return the value of attachments
     */
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> getAttachments() {
        return attachments;
    }
    
    /**
     * Set the value of the attachments field.
    
    <pre>
    attachments as File[]
    </pre>
    @param attachments the new value of attachments
     */
    public void setAttachments(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) {
        this.attachments = attachments;
    }
    // End of code for field attachments

    public Message() {
    }

    public Message(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact sender,
            java.lang.String title,
            java.lang.String text,
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) {
        this.sender = sender;
        this.title = title;
        this.text = text;
        this.attachments = attachments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sender == null) ? 0 : sender.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((attachments == null) ? 0 : attachments.hashCode());
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
        Message other = (Message) obj;
        if (sender == null) {
            if (other.sender != null)
                return false;
        } else if (!sender.equals(other.sender))
            return false;
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
        if (attachments == null) {
            if (other.attachments != null)
                return false;
        } else if (!attachments.equals(other.attachments))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Message [" + 
            "sender=" + sender +", " + 
            "title=" + title +", " + 
            "text=" + text +", " + 
            "attachments=" + attachments +
        "]";
    }
}

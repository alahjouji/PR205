package fr.inria.phoenix.diasuite.framework.datatype.channel;

import java.io.Serializable;

/**
 * <pre>
structure Channel {
 * 	name as String;
 * 	icon as File;
 * }
</pre>
 */
public class Channel implements Serializable {
    private static final long serialVersionUID = 0;

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

    // Code for field icon
    private fr.inria.phoenix.diasuite.framework.datatype.file.File icon;
    
    /**
     * Returns the value of the icon field.
    
    <pre>
    icon as File
    </pre>
    @return the value of icon
     */
    public fr.inria.phoenix.diasuite.framework.datatype.file.File getIcon() {
        return icon;
    }
    
    /**
     * Set the value of the icon field.
    
    <pre>
    icon as File
    </pre>
    @param icon the new value of icon
     */
    public void setIcon(fr.inria.phoenix.diasuite.framework.datatype.file.File icon) {
        this.icon = icon;
    }
    // End of code for field icon

    public Channel() {
    }

    public Channel(java.lang.String name,
            fr.inria.phoenix.diasuite.framework.datatype.file.File icon) {
        this.name = name;
        this.icon = icon;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((icon == null) ? 0 : icon.hashCode());
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
        Channel other = (Channel) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (icon == null) {
            if (other.icon != null)
                return false;
        } else if (!icon.equals(other.icon))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Channel [" + 
            "name=" + name +", " + 
            "icon=" + icon +
        "]";
    }
}

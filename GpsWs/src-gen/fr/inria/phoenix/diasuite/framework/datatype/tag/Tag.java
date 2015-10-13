package fr.inria.phoenix.diasuite.framework.datatype.tag;

import java.io.Serializable;

/**
 * ------------------
Photo Management
------------------------------------
** STRUCTURES **

<pre>
structure Tag {
 * 	name as String;
 * }
</pre>
 */
public class Tag implements Serializable {
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

    public Tag() {
    }

    public Tag(java.lang.String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Tag other = (Tag) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tag [" + 
            "name=" + name +
        "]";
    }
}

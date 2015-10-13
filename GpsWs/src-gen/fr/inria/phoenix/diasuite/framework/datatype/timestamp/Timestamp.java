package fr.inria.phoenix.diasuite.framework.datatype.timestamp;

import java.io.Serializable;

/**
 * <pre>
structure Timestamp{
 * 	timestampstr as String;
 * }
</pre>
 */
public class Timestamp implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field timestampstr
    private java.lang.String timestampstr;
    
    /**
     * Returns the value of the timestampstr field.
    
    <pre>
    timestampstr as String
    </pre>
    @return the value of timestampstr
     */
    public java.lang.String getTimestampstr() {
        return timestampstr;
    }
    
    /**
     * Set the value of the timestampstr field.
    
    <pre>
    timestampstr as String
    </pre>
    @param timestampstr the new value of timestampstr
     */
    public void setTimestampstr(java.lang.String timestampstr) {
        this.timestampstr = timestampstr;
    }
    // End of code for field timestampstr

    public Timestamp() {
    }

    public Timestamp(java.lang.String timestampstr) {
        this.timestampstr = timestampstr;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((timestampstr == null) ? 0 : timestampstr.hashCode());
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
        Timestamp other = (Timestamp) obj;
        if (timestampstr == null) {
            if (other.timestampstr != null)
                return false;
        } else if (!timestampstr.equals(other.timestampstr))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Timestamp [" + 
            "timestampstr=" + timestampstr +
        "]";
    }
}

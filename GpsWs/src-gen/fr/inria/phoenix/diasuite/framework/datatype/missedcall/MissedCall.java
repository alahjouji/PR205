package fr.inria.phoenix.diasuite.framework.datatype.missedcall;

import java.io.Serializable;

/**
 * <pre>
structure MissedCall {
 * 	caller as String;
 * 	date as String;
 * }
</pre>
 */
public class MissedCall implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field caller
    private java.lang.String caller;
    
    /**
     * Returns the value of the caller field.
    
    <pre>
    caller as String
    </pre>
    @return the value of caller
     */
    public java.lang.String getCaller() {
        return caller;
    }
    
    /**
     * Set the value of the caller field.
    
    <pre>
    caller as String
    </pre>
    @param caller the new value of caller
     */
    public void setCaller(java.lang.String caller) {
        this.caller = caller;
    }
    // End of code for field caller

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

    public MissedCall() {
    }

    public MissedCall(java.lang.String caller,
            java.lang.String date) {
        this.caller = caller;
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((caller == null) ? 0 : caller.hashCode());
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
        MissedCall other = (MissedCall) obj;
        if (caller == null) {
            if (other.caller != null)
                return false;
        } else if (!caller.equals(other.caller))
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
        return "MissedCall [" + 
            "caller=" + caller +", " + 
            "date=" + date +
        "]";
    }
}

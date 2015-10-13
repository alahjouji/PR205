package fr.inria.phoenix.diasuite.framework.datatype.onoff;

import java.io.Serializable;

/**
 * ------------------
Appliances
------------------------------------

<pre>
structure OnOff{
 * 	status as String;
 * 	eventTime as String;
 * }
</pre>
 */
public class OnOff implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field status
    private java.lang.String status;
    
    /**
     * Returns the value of the status field.
    
    <pre>
    status as String
    </pre>
    @return the value of status
     */
    public java.lang.String getStatus() {
        return status;
    }
    
    /**
     * Set the value of the status field.
    
    <pre>
    status as String
    </pre>
    @param status the new value of status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    // End of code for field status

    // Code for field eventTime
    private java.lang.String eventTime;
    
    /**
     * Returns the value of the eventTime field.
    
    <pre>
    eventTime as String
    </pre>
    @return the value of eventTime
     */
    public java.lang.String getEventTime() {
        return eventTime;
    }
    
    /**
     * Set the value of the eventTime field.
    
    <pre>
    eventTime as String
    </pre>
    @param eventTime the new value of eventTime
     */
    public void setEventTime(java.lang.String eventTime) {
        this.eventTime = eventTime;
    }
    // End of code for field eventTime

    public OnOff() {
    }

    public OnOff(java.lang.String status,
            java.lang.String eventTime) {
        this.status = status;
        this.eventTime = eventTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((eventTime == null) ? 0 : eventTime.hashCode());
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
        OnOff other = (OnOff) obj;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (eventTime == null) {
            if (other.eventTime != null)
                return false;
        } else if (!eventTime.equals(other.eventTime))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OnOff [" + 
            "status=" + status +", " + 
            "eventTime=" + eventTime +
        "]";
    }
}

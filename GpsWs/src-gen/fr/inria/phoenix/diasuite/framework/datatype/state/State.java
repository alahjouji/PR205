package fr.inria.phoenix.diasuite.framework.datatype.state;

import java.io.Serializable;

/**
 * <pre>
structure State{
 * 	state as String;
 * 	timestamp as String;
 * 	batteryLevel as String;
 * }
</pre>
 */
public class State implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field state
    private java.lang.String state;
    
    /**
     * Returns the value of the state field.
    
    <pre>
    state as String
    </pre>
    @return the value of state
     */
    public java.lang.String getState() {
        return state;
    }
    
    /**
     * Set the value of the state field.
    
    <pre>
    state as String
    </pre>
    @param state the new value of state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }
    // End of code for field state

    // Code for field timestamp
    private java.lang.String timestamp;
    
    /**
     * Returns the value of the timestamp field.
    
    <pre>
    timestamp as String
    </pre>
    @return the value of timestamp
     */
    public java.lang.String getTimestamp() {
        return timestamp;
    }
    
    /**
     * Set the value of the timestamp field.
    
    <pre>
    timestamp as String
    </pre>
    @param timestamp the new value of timestamp
     */
    public void setTimestamp(java.lang.String timestamp) {
        this.timestamp = timestamp;
    }
    // End of code for field timestamp

    // Code for field batteryLevel
    private java.lang.String batteryLevel;
    
    /**
     * Returns the value of the batteryLevel field.
    
    <pre>
    batteryLevel as String
    </pre>
    @return the value of batteryLevel
     */
    public java.lang.String getBatteryLevel() {
        return batteryLevel;
    }
    
    /**
     * Set the value of the batteryLevel field.
    
    <pre>
    batteryLevel as String
    </pre>
    @param batteryLevel the new value of batteryLevel
     */
    public void setBatteryLevel(java.lang.String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    // End of code for field batteryLevel

    public State() {
    }

    public State(java.lang.String state,
            java.lang.String timestamp,
            java.lang.String batteryLevel) {
        this.state = state;
        this.timestamp = timestamp;
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
        result = prime * result + ((batteryLevel == null) ? 0 : batteryLevel.hashCode());
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
        State other = (State) obj;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (timestamp == null) {
            if (other.timestamp != null)
                return false;
        } else if (!timestamp.equals(other.timestamp))
            return false;
        if (batteryLevel == null) {
            if (other.batteryLevel != null)
                return false;
        } else if (!batteryLevel.equals(other.batteryLevel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "State [" + 
            "state=" + state +", " + 
            "timestamp=" + timestamp +", " + 
            "batteryLevel=" + batteryLevel +
        "]";
    }
}

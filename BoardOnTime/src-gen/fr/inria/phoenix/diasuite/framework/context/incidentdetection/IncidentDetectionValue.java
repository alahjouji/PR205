package fr.inria.phoenix.diasuite.framework.context.incidentdetection;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>IncidentDetection</code>.
 * <p>
 * context 3
 *
 * <pre>
 * context IncidentDetection as Boolean {
 *     when provided timerTriggered from Timer 
 *     get JourneySelection, real_time_schedules from BordeauxMetropole, theoretical_schedules from BordeauxMetropole
 *     maybe publish;
 * }
 * </pre>
 */
public final class IncidentDetectionValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.Boolean value;
    
    /**
     * Get the value of the context <code>IncidentDetection</code>
     * 
     * <p>
     * context 3
     * 
     * @return the value of the context <code>IncidentDetection</code>
     */
    public java.lang.Boolean value() {
        return value;
    }
    
    public IncidentDetectionValue(java.lang.Boolean value) {
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        IncidentDetectionValue other = (IncidentDetectionValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}

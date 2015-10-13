package fr.inria.phoenix.diasuite.framework.context.journeycomputer;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>JourneyComputer</code>.
 * <p>
 * context 1
 *
 * <pre>
 * context JourneyComputer as Sending {
 *     when provided answer from Prompter
 *     get GpsConversion, journeys from NavitiaWS
 *     always publish;
 * }
 * </pre>
 */
public final class JourneyComputerValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.sending.Sending value;
    
    /**
     * Get the value of the context <code>JourneyComputer</code>
     * 
     * <p>
     * context 1
     * 
     * @return the value of the context <code>JourneyComputer</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.sending.Sending value() {
        return value;
    }
    
    public JourneyComputerValue(fr.inria.phoenix.diasuite.framework.datatype.sending.Sending value) {
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
        JourneyComputerValue other = (JourneyComputerValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}

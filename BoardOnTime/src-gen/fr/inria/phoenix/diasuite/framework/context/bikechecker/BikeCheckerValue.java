package fr.inria.phoenix.diasuite.framework.context.bikechecker;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>BikeChecker</code>.
 * <p>
 * context 2bis
 *
 * <pre>
 * context BikeChecker as String {
 * 	when provided JourneySelection
 * 	maybe publish;
 * }
 * </pre>
 */
public final class BikeCheckerValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the context <code>BikeChecker</code>
     * 
     * <p>
     * context 2bis
     * 
     * @return the value of the context <code>BikeChecker</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    public BikeCheckerValue(java.lang.String value) {
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
        BikeCheckerValue other = (BikeCheckerValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}

package fr.inria.phoenix.diasuite.framework.context.bike_availability;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>Bike_availability</code>.
 * <p>
 * context 4
 *
 * <pre>
 * context Bike_availability as String{
 *     when provided BikeChecker
 *     get bikes from BordeauxMetropole
 *     maybe publish;
 * }
 * </pre>
 */
public final class Bike_availabilityValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private java.lang.String value;
    
    /**
     * Get the value of the context <code>Bike_availability</code>
     * 
     * <p>
     * context 4
     * 
     * @return the value of the context <code>Bike_availability</code>
     */
    public java.lang.String value() {
        return value;
    }
    
    public Bike_availabilityValue(java.lang.String value) {
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
        Bike_availabilityValue other = (Bike_availabilityValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}

package fr.inria.phoenix.diasuite.framework.context.gpsconversion;

import java.io.Serializable;

/**
 * An object to store a value published by the context <code>GpsConversion</code>.
 * <p>
 * context 0
 *
 * <pre>
 * context GpsConversion as GpsCoordinates {
 *     when provided answer from Prompter
 *     get destCoordinates from GpsWs
 *     no publish; 
 *    when required;   
 * }
 * </pre>
 */
public final class GpsConversionValue implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates value;
    
    /**
     * Get the value of the context <code>GpsConversion</code>
     * 
     * <p>
     * context 0
     * 
     * @return the value of the context <code>GpsConversion</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates value() {
        return value;
    }
    
    public GpsConversionValue(fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates value) {
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
        GpsConversionValue other = (GpsConversionValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}

package fr.inria.phoenix.diasuite.framework.datatype.temperature;

import java.io.Serializable;

/**
 * <pre>
structure Temperature {
 * 	value as Float;
 * 	unit as TemperatureUnit;
 * }
</pre>
 */
public class Temperature implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field value
    private java.lang.Float value;
    
    /**
     * Returns the value of the value field.
    
    <pre>
    value as Float
    </pre>
    @return the value of value
     */
    public java.lang.Float getValue() {
        return value;
    }
    
    /**
     * Set the value of the value field.
    
    <pre>
    value as Float
    </pre>
    @param value the new value of value
     */
    public void setValue(java.lang.Float value) {
        this.value = value;
    }
    // End of code for field value

    // Code for field unit
    private fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit;
    
    /**
     * Returns the value of the unit field.
    
    <pre>
    unit as TemperatureUnit
    </pre>
    @return the value of unit
     */
    public fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit getUnit() {
        return unit;
    }
    
    /**
     * Set the value of the unit field.
    
    <pre>
    unit as TemperatureUnit
    </pre>
    @param unit the new value of unit
     */
    public void setUnit(fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
        this.unit = unit;
    }
    // End of code for field unit

    public Temperature() {
    }

    public Temperature(java.lang.Float value,
            fr.inria.phoenix.diasuite.framework.datatype.temperatureunit.TemperatureUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
        Temperature other = (Temperature) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (unit == null) {
            if (other.unit != null)
                return false;
        } else if (!unit.equals(other.unit))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Temperature [" + 
            "value=" + value +", " + 
            "unit=" + unit +
        "]";
    }
}

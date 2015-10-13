package fr.inria.phoenix.diasuite.framework.datatype.windinfo;

import java.io.Serializable;

/**
 * <pre>
structure WindInfo {
 * 	speed as Float;
 * 	direction as String;
 * }
</pre>
 */
public class WindInfo implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field speed
    private java.lang.Float speed;
    
    /**
     * Returns the value of the speed field.
    
    <pre>
    speed as Float
    </pre>
    @return the value of speed
     */
    public java.lang.Float getSpeed() {
        return speed;
    }
    
    /**
     * Set the value of the speed field.
    
    <pre>
    speed as Float
    </pre>
    @param speed the new value of speed
     */
    public void setSpeed(java.lang.Float speed) {
        this.speed = speed;
    }
    // End of code for field speed

    // Code for field direction
    private java.lang.String direction;
    
    /**
     * Returns the value of the direction field.
    
    <pre>
    direction as String
    </pre>
    @return the value of direction
     */
    public java.lang.String getDirection() {
        return direction;
    }
    
    /**
     * Set the value of the direction field.
    
    <pre>
    direction as String
    </pre>
    @param direction the new value of direction
     */
    public void setDirection(java.lang.String direction) {
        this.direction = direction;
    }
    // End of code for field direction

    public WindInfo() {
    }

    public WindInfo(java.lang.Float speed,
            java.lang.String direction) {
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((speed == null) ? 0 : speed.hashCode());
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
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
        WindInfo other = (WindInfo) obj;
        if (speed == null) {
            if (other.speed != null)
                return false;
        } else if (!speed.equals(other.speed))
            return false;
        if (direction == null) {
            if (other.direction != null)
                return false;
        } else if (!direction.equals(other.direction))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WindInfo [" + 
            "speed=" + speed +", " + 
            "direction=" + direction +
        "]";
    }
}

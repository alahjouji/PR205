package fr.inria.phoenix.diasuite.framework.datatype.bikes;

import java.io.Serializable;

/**
 * <pre>
structure Bikes {
 * 	stationsBi as Integer[];
 * 	stationsPl as Integer[];
 * }
</pre>
 */
public class Bikes implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field stationsBi
    private java.util.List<java.lang.Integer> stationsBi;
    
    /**
     * Returns the value of the stationsBi field.
    
    <pre>
    stationsBi as Integer[]
    </pre>
    @return the value of stationsBi
     */
    public java.util.List<java.lang.Integer> getStationsBi() {
        return stationsBi;
    }
    
    /**
     * Set the value of the stationsBi field.
    
    <pre>
    stationsBi as Integer[]
    </pre>
    @param stationsBi the new value of stationsBi
     */
    public void setStationsBi(java.util.List<java.lang.Integer> stationsBi) {
        this.stationsBi = stationsBi;
    }
    // End of code for field stationsBi

    // Code for field stationsPl
    private java.util.List<java.lang.Integer> stationsPl;
    
    /**
     * Returns the value of the stationsPl field.
    
    <pre>
    stationsPl as Integer[]
    </pre>
    @return the value of stationsPl
     */
    public java.util.List<java.lang.Integer> getStationsPl() {
        return stationsPl;
    }
    
    /**
     * Set the value of the stationsPl field.
    
    <pre>
    stationsPl as Integer[]
    </pre>
    @param stationsPl the new value of stationsPl
     */
    public void setStationsPl(java.util.List<java.lang.Integer> stationsPl) {
        this.stationsPl = stationsPl;
    }
    // End of code for field stationsPl

    public Bikes() {
    }

    public Bikes(java.util.List<java.lang.Integer> stationsBi,
            java.util.List<java.lang.Integer> stationsPl) {
        this.stationsBi = stationsBi;
        this.stationsPl = stationsPl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((stationsBi == null) ? 0 : stationsBi.hashCode());
        result = prime * result + ((stationsPl == null) ? 0 : stationsPl.hashCode());
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
        Bikes other = (Bikes) obj;
        if (stationsBi == null) {
            if (other.stationsBi != null)
                return false;
        } else if (!stationsBi.equals(other.stationsBi))
            return false;
        if (stationsPl == null) {
            if (other.stationsPl != null)
                return false;
        } else if (!stationsPl.equals(other.stationsPl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bikes [" + 
            "stationsBi=" + stationsBi +", " + 
            "stationsPl=" + stationsPl +
        "]";
    }
}

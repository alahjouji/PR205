package fr.inria.phoenix.diasuite.framework.datatype.cross;

import java.io.Serializable;

/**
 * <pre>
structure Cross {
 *  	date as Date;
 *  	station as String;
 * }
</pre>
 */
public class Cross implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field date
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date date;
    
    /**
     * Returns the value of the date field.
    
    <pre>
    date as Date
    </pre>
    @return the value of date
     */
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getDate() {
        return date;
    }
    
    /**
     * Set the value of the date field.
    
    <pre>
    date as Date
    </pre>
    @param date the new value of date
     */
    public void setDate(fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
        this.date = date;
    }
    // End of code for field date

    // Code for field station
    private java.lang.String station;
    
    /**
     * Returns the value of the station field.
    
    <pre>
    station as String
    </pre>
    @return the value of station
     */
    public java.lang.String getStation() {
        return station;
    }
    
    /**
     * Set the value of the station field.
    
    <pre>
    station as String
    </pre>
    @param station the new value of station
     */
    public void setStation(java.lang.String station) {
        this.station = station;
    }
    // End of code for field station

    public Cross() {
    }

    public Cross(fr.inria.phoenix.diasuite.framework.datatype.date.Date date,
            java.lang.String station) {
        this.date = date;
        this.station = station;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((station == null) ? 0 : station.hashCode());
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
        Cross other = (Cross) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (station == null) {
            if (other.station != null)
                return false;
        } else if (!station.equals(other.station))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cross [" + 
            "date=" + date +", " + 
            "station=" + station +
        "]";
    }
}

package fr.inria.phoenix.diasuite.framework.datatype.navitia;

import java.io.Serializable;

/**
 * <pre>
structure Navitia {
 * 	location as GpsCoordinates;
 * 	arrival as GpsCoordinates;
 * 	date as String;
 * }
</pre>
 */
public class Navitia implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field location
    private fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates location;
    
    /**
     * Returns the value of the location field.
    
    <pre>
    location as GpsCoordinates
    </pre>
    @return the value of location
     */
    public fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates getLocation() {
        return location;
    }
    
    /**
     * Set the value of the location field.
    
    <pre>
    location as GpsCoordinates
    </pre>
    @param location the new value of location
     */
    public void setLocation(fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates location) {
        this.location = location;
    }
    // End of code for field location

    // Code for field arrival
    private fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates arrival;
    
    /**
     * Returns the value of the arrival field.
    
    <pre>
    arrival as GpsCoordinates
    </pre>
    @return the value of arrival
     */
    public fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates getArrival() {
        return arrival;
    }
    
    /**
     * Set the value of the arrival field.
    
    <pre>
    arrival as GpsCoordinates
    </pre>
    @param arrival the new value of arrival
     */
    public void setArrival(fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates arrival) {
        this.arrival = arrival;
    }
    // End of code for field arrival

    // Code for field date
    private java.lang.String date;
    
    /**
     * Returns the value of the date field.
    
    <pre>
    date as String
    </pre>
    @return the value of date
     */
    public java.lang.String getDate() {
        return date;
    }
    
    /**
     * Set the value of the date field.
    
    <pre>
    date as String
    </pre>
    @param date the new value of date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }
    // End of code for field date

    public Navitia() {
    }

    public Navitia(fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates location,
            fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates.GpsCoordinates arrival,
            java.lang.String date) {
        this.location = location;
        this.arrival = arrival;
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        Navitia other = (Navitia) obj;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (arrival == null) {
            if (other.arrival != null)
                return false;
        } else if (!arrival.equals(other.arrival))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Navitia [" + 
            "location=" + location +", " + 
            "arrival=" + arrival +", " + 
            "date=" + date +
        "]";
    }
}

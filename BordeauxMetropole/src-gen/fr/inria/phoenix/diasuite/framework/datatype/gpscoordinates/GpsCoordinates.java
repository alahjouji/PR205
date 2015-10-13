package fr.inria.phoenix.diasuite.framework.datatype.gpscoordinates;

import java.io.Serializable;

/**
 * BOT

<pre>
structure GpsCoordinates {
 *     longitude as String;
 *     latitude as String;
 * }
</pre>
 */
public class GpsCoordinates implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field longitude
    private java.lang.String longitude;
    
    /**
     * Returns the value of the longitude field.
    
    <pre>
    longitude as String
    </pre>
    @return the value of longitude
     */
    public java.lang.String getLongitude() {
        return longitude;
    }
    
    /**
     * Set the value of the longitude field.
    
    <pre>
    longitude as String
    </pre>
    @param longitude the new value of longitude
     */
    public void setLongitude(java.lang.String longitude) {
        this.longitude = longitude;
    }
    // End of code for field longitude

    // Code for field latitude
    private java.lang.String latitude;
    
    /**
     * Returns the value of the latitude field.
    
    <pre>
    latitude as String
    </pre>
    @return the value of latitude
     */
    public java.lang.String getLatitude() {
        return latitude;
    }
    
    /**
     * Set the value of the latitude field.
    
    <pre>
    latitude as String
    </pre>
    @param latitude the new value of latitude
     */
    public void setLatitude(java.lang.String latitude) {
        this.latitude = latitude;
    }
    // End of code for field latitude

    public GpsCoordinates() {
    }

    public GpsCoordinates(java.lang.String longitude,
            java.lang.String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
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
        GpsCoordinates other = (GpsCoordinates) obj;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GpsCoordinates [" + 
            "longitude=" + longitude +", " + 
            "latitude=" + latitude +
        "]";
    }
}

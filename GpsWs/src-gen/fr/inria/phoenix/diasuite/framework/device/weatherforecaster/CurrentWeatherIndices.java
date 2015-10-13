package fr.inria.phoenix.diasuite.framework.device.weatherforecaster;

import java.io.Serializable;

/**
 * Container for the indices of the source <code>currentWeather</code> from device <code>WeatherForecaster</code>.

<pre>
source currentWeather as Weather indexed by region as String;
</pre>
 */
public final class CurrentWeatherIndices implements Serializable {
    private static final long serialVersionUID = 0;
    
    public CurrentWeatherIndices(java.lang.String region) {
        this._region = region;
    }
    
    // Code for index region
    private java.lang.String _region;
    
    /**
     * Get the <code>region</code> index
     * 
     * @return the value of the <code>region</code> index
     */
    public java.lang.String region() {
        return _region;
    }
    
    /**
     * Set the <code>region</code> index
     * 
     * @param newRegion the new value for the <code>region</code> index
     */
    public void setRegion(java.lang.String newRegion) {
        this._region = newRegion;
    }
    // End of code for index region
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_region == null) ? 0 : _region.hashCode());
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
        CurrentWeatherIndices other = (CurrentWeatherIndices) obj;
        if (_region == null) {
            if (other._region != null)
                return false;
        } else if (!_region.equals(other._region))
            return false;
        return true;
    }
}

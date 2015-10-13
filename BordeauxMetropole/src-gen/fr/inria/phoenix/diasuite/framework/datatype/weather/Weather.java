package fr.inria.phoenix.diasuite.framework.datatype.weather;

import java.io.Serializable;

/**
 * <pre>
structure Weather {
 * 	type as WeatherType;
 * 	temperature as Temperature;
 * 	wind as WindInfo;
 * }
</pre>
 */
public class Weather implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field type
    private fr.inria.phoenix.diasuite.framework.datatype.weathertype.WeatherType type;
    
    /**
     * Returns the value of the type field.
    
    <pre>
    type as WeatherType
    </pre>
    @return the value of type
     */
    public fr.inria.phoenix.diasuite.framework.datatype.weathertype.WeatherType getType() {
        return type;
    }
    
    /**
     * Set the value of the type field.
    
    <pre>
    type as WeatherType
    </pre>
    @param type the new value of type
     */
    public void setType(fr.inria.phoenix.diasuite.framework.datatype.weathertype.WeatherType type) {
        this.type = type;
    }
    // End of code for field type

    // Code for field temperature
    private fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature temperature;
    
    /**
     * Returns the value of the temperature field.
    
    <pre>
    temperature as Temperature
    </pre>
    @return the value of temperature
     */
    public fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature getTemperature() {
        return temperature;
    }
    
    /**
     * Set the value of the temperature field.
    
    <pre>
    temperature as Temperature
    </pre>
    @param temperature the new value of temperature
     */
    public void setTemperature(fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature temperature) {
        this.temperature = temperature;
    }
    // End of code for field temperature

    // Code for field wind
    private fr.inria.phoenix.diasuite.framework.datatype.windinfo.WindInfo wind;
    
    /**
     * Returns the value of the wind field.
    
    <pre>
    wind as WindInfo
    </pre>
    @return the value of wind
     */
    public fr.inria.phoenix.diasuite.framework.datatype.windinfo.WindInfo getWind() {
        return wind;
    }
    
    /**
     * Set the value of the wind field.
    
    <pre>
    wind as WindInfo
    </pre>
    @param wind the new value of wind
     */
    public void setWind(fr.inria.phoenix.diasuite.framework.datatype.windinfo.WindInfo wind) {
        this.wind = wind;
    }
    // End of code for field wind

    public Weather() {
    }

    public Weather(fr.inria.phoenix.diasuite.framework.datatype.weathertype.WeatherType type,
            fr.inria.phoenix.diasuite.framework.datatype.temperature.Temperature temperature,
            fr.inria.phoenix.diasuite.framework.datatype.windinfo.WindInfo wind) {
        this.type = type;
        this.temperature = temperature;
        this.wind = wind;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
        result = prime * result + ((wind == null) ? 0 : wind.hashCode());
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
        Weather other = (Weather) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (temperature == null) {
            if (other.temperature != null)
                return false;
        } else if (!temperature.equals(other.temperature))
            return false;
        if (wind == null) {
            if (other.wind != null)
                return false;
        } else if (!wind.equals(other.wind))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Weather [" + 
            "type=" + type +", " + 
            "temperature=" + temperature +", " + 
            "wind=" + wind +
        "]";
    }
}

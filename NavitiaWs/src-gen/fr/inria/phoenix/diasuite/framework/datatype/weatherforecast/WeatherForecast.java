package fr.inria.phoenix.diasuite.framework.datatype.weatherforecast;

import java.io.Serializable;

/**
 * <pre>
structure WeatherForecast {
 * 	weather as Weather;
 * 	date as Date;
 * }
</pre>
 */
public class WeatherForecast implements Serializable {
    private static final long serialVersionUID = 0;

    // Code for field weather
    private fr.inria.phoenix.diasuite.framework.datatype.weather.Weather weather;
    
    /**
     * Returns the value of the weather field.
    
    <pre>
    weather as Weather
    </pre>
    @return the value of weather
     */
    public fr.inria.phoenix.diasuite.framework.datatype.weather.Weather getWeather() {
        return weather;
    }
    
    /**
     * Set the value of the weather field.
    
    <pre>
    weather as Weather
    </pre>
    @param weather the new value of weather
     */
    public void setWeather(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather weather) {
        this.weather = weather;
    }
    // End of code for field weather

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

    public WeatherForecast() {
    }

    public WeatherForecast(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather weather,
            fr.inria.phoenix.diasuite.framework.datatype.date.Date date) {
        this.weather = weather;
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((weather == null) ? 0 : weather.hashCode());
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
        WeatherForecast other = (WeatherForecast) obj;
        if (weather == null) {
            if (other.weather != null)
                return false;
        } else if (!weather.equals(other.weather))
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
        return "WeatherForecast [" + 
            "weather=" + weather +", " + 
            "date=" + date +
        "]";
    }
}

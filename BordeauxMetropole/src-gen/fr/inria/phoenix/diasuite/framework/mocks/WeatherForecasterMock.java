package fr.inria.phoenix.diasuite.framework.mocks;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.device.weatherforecaster.AbstractWeatherForecaster;
import fr.inria.phoenix.diasuite.framework.device.weatherforecaster.WeatherForecastsIndices;
import fr.inria.phoenix.diasuite.framework.device.weatherforecaster.CurrentWeatherIndices;

// @internal
public final class WeatherForecasterMock {
    
    /**
     * The timeout in milliseconds to wait action. Set it if your application computations are long.
     */
    public long TIMEOUT = Mock.TIMEOUT;
    
    class Proxy extends AbstractWeatherForecaster {
        private Proxy(ServiceConfiguration serviceConfiguration,
                java.lang.String idValue) {
            super(serviceConfiguration, idValue);
        }
        
        public void _updateId(java.lang.String newIdValue) {
            updateId(newIdValue);
        }
        
        protected fr.inria.phoenix.diasuite.framework.datatype.weather.Weather getCurrentWeather(java.lang.String region) throws Exception {
            fr.inria.phoenix.diasuite.framework.datatype.weather.Weather result = __currentWeather.get(new CurrentWeatherIndices(region));
            if(result == null)
                return super.getCurrentWeather(region);
            return result;
        }
        
        public void _publishCurrentWeather(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather newCurrentWeatherValue,
                java.lang.String region) {
            publishCurrentWeather(newCurrentWeatherValue,
                region);
        }
        
        protected java.lang.Boolean getIsAlive() throws Exception {
            java.lang.Boolean result = __isAlive;
            if(result == null)
                return super.getIsAlive();
            return result;
        }
        
        public void _publishIsAlive(java.lang.Boolean newIsAliveValue) {
            publishIsAlive(newIsAliveValue);
        }
        
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> getWeatherForecasts(java.lang.String region) throws Exception {
            java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> result = __weatherForecasts.get(new WeatherForecastsIndices(region));
            if(result == null)
                return super.getWeatherForecasts(region);
            return result;
        }
        
        public void _publishWeatherForecasts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> newWeatherForecastsValue,
                java.lang.String region) {
            publishWeatherForecasts(newWeatherForecastsValue,
                region);
        }
    }
    
    Proxy proxy;
    
    WeatherForecasterMock(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        this.proxy = new Proxy(serviceConfiguration, idValue);
    }
    
    
    // Code for the attribute id from device Device
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
    @return this for fluent interface
     */
    public WeatherForecasterMock id(java.lang.String newIdValue) {
        proxy._updateId(newIdValue);
        return this;
    }
    // End of code for the attribute id from device Device
    
    // Code for source currentWeather from device WeatherForecaster
    /**
     * Publish the value of source <code>currentWeather</code> from device <code>WeatherForecaster</code>.
    
    <pre>
    source currentWeather as Weather indexed by region as String;
    </pre>
    @param newCurrentWeatherValue the new value for the source <code>currentWeather</code>
    @param region the value of the index <code>region</code>
    @return this for fluent interface
     */
    public WeatherForecasterMock currentWeather(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather newCurrentWeatherValue,
            java.lang.String region) {
        proxy._publishCurrentWeather(newCurrentWeatherValue,
            region);
        return this;
    }
    
    private java.util.HashMap<CurrentWeatherIndices, fr.inria.phoenix.diasuite.framework.datatype.weather.Weather> __currentWeather = new java.util.HashMap<CurrentWeatherIndices, fr.inria.phoenix.diasuite.framework.datatype.weather.Weather>();
    /**
     * Set the value (without publication) of source <code>currentWeather</code> from device <code>WeatherForecaster</code>.
    
    <pre>
    source currentWeather as Weather indexed by region as String;
    </pre>
    @param newCurrentWeatherValue the new value for the source <code>currentWeather</code>
    @param region the value of the index <code>region</code>
    @return this for fluent interface
     */
    public WeatherForecasterMock setCurrentWeather(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather newCurrentWeatherValue,
            java.lang.String region) {
        CurrentWeatherIndices _indices_ = new CurrentWeatherIndices(region);
        __currentWeather.put(_indices_, newCurrentWeatherValue);
        return this;
    }
    // End of code for source currentWeather from device WeatherForecaster
    
    // Code for source isAlive from device Device
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public WeatherForecasterMock isAlive(java.lang.Boolean newIsAliveValue) {
        proxy._publishIsAlive(newIsAliveValue);
        return this;
    }
    
    private java.lang.Boolean __isAlive = null;
    /**
     * Set the value (without publication) of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
    @return this for fluent interface
     */
    public WeatherForecasterMock setIsAlive(java.lang.Boolean newIsAliveValue) {
        __isAlive = newIsAliveValue;
        return this;
    }
    // End of code for source isAlive from device Device
    
    // Code for source weatherForecasts from device WeatherForecaster
    /**
     * Publish the value of source <code>weatherForecasts</code> from device <code>WeatherForecaster</code>.
    
    <pre>
    source weatherForecasts as WeatherForecast[] indexed by region as String;
    </pre>
    @param newWeatherForecastsValue the new value for the source <code>weatherForecasts</code>
    @param region the value of the index <code>region</code>
    @return this for fluent interface
     */
    public WeatherForecasterMock weatherForecasts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> newWeatherForecastsValue,
            java.lang.String region) {
        proxy._publishWeatherForecasts(newWeatherForecastsValue,
            region);
        return this;
    }
    
    private java.util.HashMap<WeatherForecastsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast>> __weatherForecasts = new java.util.HashMap<WeatherForecastsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast>>();
    /**
     * Set the value (without publication) of source <code>weatherForecasts</code> from device <code>WeatherForecaster</code>.
    
    <pre>
    source weatherForecasts as WeatherForecast[] indexed by region as String;
    </pre>
    @param newWeatherForecastsValue the new value for the source <code>weatherForecasts</code>
    @param region the value of the index <code>region</code>
    @return this for fluent interface
     */
    public WeatherForecasterMock setWeatherForecasts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> newWeatherForecastsValue,
            java.lang.String region) {
        WeatherForecastsIndices _indices_ = new WeatherForecastsIndices(region);
        __weatherForecasts.put(_indices_, newWeatherForecastsValue);
        return this;
    }
    // End of code for source weatherForecasts from device WeatherForecaster
}

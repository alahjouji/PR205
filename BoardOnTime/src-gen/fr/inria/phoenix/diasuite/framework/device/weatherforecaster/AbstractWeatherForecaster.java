package fr.inria.phoenix.diasuite.framework.device.weatherforecaster;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

/**
 * <pre>
device WeatherForecaster extends HomeService {
 * 	source currentWeather as Weather indexed by region as String;
 * 	source weatherForecasts as WeatherForecast[] indexed by region as String;
 * }
</pre>
 */
public abstract class AbstractWeatherForecaster extends Service {
    
    public AbstractWeatherForecaster(ServiceConfiguration serviceConfiguration,
            java.lang.String idValue) {
        super("/Device/Device/Service/HomeService/WeatherForecaster/", serviceConfiguration);
        updateId(idValue);
    }
    
    // Methods from the Service class
    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id", _id);
        return attributes;
    }
    
    @Override
    protected final void internalPostInitialize() {
        postInitialize();
    }
    
    @SuppressWarnings("all")
    @Override
    public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        throw new InvocationException("Undefined method name " + orderName);
    }
    
    @Override
    public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("id")) {
            return _id;
        }
        if (orderName.equals("currentWeather")) {
            return getCurrentWeather((java.lang.String) args[0]);
        }
        if (orderName.equals("isAlive")) {
            return getIsAlive();
        }
        if (orderName.equals("weatherForecasts")) {
            return getWeatherForecasts((java.lang.String) args[0]);
        }
        throw new InvocationException("Undefined method name " + orderName);
    }
    // End of methods from the Service class
    
    // Code for the attribute id from device Device
    private java.lang.String _id;
    
    /**
     * Set the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @param newIdValue the new value of <code>id</code>
     */
    protected void updateId(java.lang.String newIdValue) {
        if (_id != newIdValue) {
            _id = newIdValue;
            updateAttribute("id", newIdValue);
        }
    }
    
    /**
     * Returns the value of the <code>id</code> attribute from device <code>Device</code>.
    
    <pre>
    attribute id as String;
    </pre>
    @return the value of <code>id</code>
     */
    public java.lang.String getId() {
        return _id;
    }
    // End of code for the attribute id from device Device
    
    // Code for source currentWeather from device WeatherForecaster
    private java.util.HashMap<CurrentWeatherIndices, fr.inria.phoenix.diasuite.framework.datatype.weather.Weather> _currentWeather = new java.util.HashMap<CurrentWeatherIndices, fr.inria.phoenix.diasuite.framework.datatype.weather.Weather>();
    
    /**
     * Publish the value of source <code>currentWeather</code> from device <code>WeatherForecaster</code>.
    
    <pre>
    source currentWeather as Weather indexed by region as String;
    </pre>
    @param newCurrentWeatherValue the new value for the source <code>currentWeather</code>
    @param region the value of the index <code>region</code>
     */
    protected void publishCurrentWeather(fr.inria.phoenix.diasuite.framework.datatype.weather.Weather newCurrentWeatherValue,
            java.lang.String region) {
        CurrentWeatherIndices _indices_ = new CurrentWeatherIndices(region);
        _currentWeather.put(_indices_, newCurrentWeatherValue);
        getProcessor().publishValue(getOutProperties(), "currentWeather", newCurrentWeatherValue, region); 
    }
    
    /**
     * Returns the value of source <code>currentWeather</code> from device <code>WeatherForecaster</code>.
    
    <pre>
    source currentWeather as Weather indexed by region as String;
    </pre>
    @param region the value of the index <code>region</code>
    @return the value of the source <code>currentWeather</code>
     */
    protected fr.inria.phoenix.diasuite.framework.datatype.weather.Weather getCurrentWeather(java.lang.String region) throws Exception {
        return _currentWeather.get(new CurrentWeatherIndices(region));
    }
    // End of code for source currentWeather from device WeatherForecaster
    
    // Code for source isAlive from device Device
    private java.lang.Boolean _isAlive;
    
    /**
     * Publish the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @param newIsAliveValue the new value for the source <code>isAlive</code>
     */
    protected void publishIsAlive(java.lang.Boolean newIsAliveValue) {
        _isAlive = newIsAliveValue;
        getProcessor().publishValue(getOutProperties(), "isAlive", newIsAliveValue); 
    }
    
    /**
     * Returns the value of source <code>isAlive</code> from device <code>Device</code>.
    
    <pre>
    source isAlive as Boolean;
    </pre>
    @return the value of the source <code>isAlive</code>
     */
    protected java.lang.Boolean getIsAlive() throws Exception {
        return _isAlive;
    }
    // End of code for source isAlive from device Device
    
    // Code for source weatherForecasts from device WeatherForecaster
    private java.util.HashMap<WeatherForecastsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast>> _weatherForecasts = new java.util.HashMap<WeatherForecastsIndices, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast>>();
    
    /**
     * Publish the value of source <code>weatherForecasts</code> from device <code>WeatherForecaster</code>.
    
    <pre>
    source weatherForecasts as WeatherForecast[] indexed by region as String;
    </pre>
    @param newWeatherForecastsValue the new value for the source <code>weatherForecasts</code>
    @param region the value of the index <code>region</code>
     */
    protected void publishWeatherForecasts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> newWeatherForecastsValue,
            java.lang.String region) {
        WeatherForecastsIndices _indices_ = new WeatherForecastsIndices(region);
        _weatherForecasts.put(_indices_, newWeatherForecastsValue);
        getProcessor().publishValue(getOutProperties(), "weatherForecasts", newWeatherForecastsValue, region); 
    }
    
    /**
     * Returns the value of source <code>weatherForecasts</code> from device <code>WeatherForecaster</code>.
    
    <pre>
    source weatherForecasts as WeatherForecast[] indexed by region as String;
    </pre>
    @param region the value of the index <code>region</code>
    @return the value of the source <code>weatherForecasts</code>
     */
    protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.weatherforecast.WeatherForecast> getWeatherForecasts(java.lang.String region) throws Exception {
        return _weatherForecasts.get(new WeatherForecastsIndices(region));
    }
    // End of code for source weatherForecasts from device WeatherForecaster
}

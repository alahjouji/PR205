package fr.inria.phoenix.diasuite.framework.device.weatherforecaster;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

/**
 * An object to store a value published on the source <code>currentWeather</code> of the device <code>WeatherForecaster</code>.
 *
 * <pre>
 * device WeatherForecaster extends HomeService {
 * 	source currentWeather as Weather indexed by region as String;
 * 	source weatherForecasts as WeatherForecast[] indexed by region as String;
 * }
 * </pre>
 */
public final class CurrentWeatherFromWeatherForecaster implements Serializable {
    private static final long serialVersionUID = 0;
    
    private fr.inria.phoenix.diasuite.framework.datatype.weather.Weather value;
    
    /**
     * Get the value of the source <code>currentWeather</code>
     * 
     * @return the value of the source <code>currentWeather</code>
     */
    public fr.inria.phoenix.diasuite.framework.datatype.weather.Weather value() {
        return value;
    }
    
    private CurrentWeatherIndices indices;
    
    /**
     * Get the value of the indices of the source <code>currentWeather</code>
     * 
     * @return the value of the indices
     */
    public CurrentWeatherIndices indices() {
        return indices;
    }
    
    public CurrentWeatherFromWeatherForecaster(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.weather.Weather value, CurrentWeatherIndices indices) {
        this.sender = new WeatherForecasterProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = indices;
    }
    
    public CurrentWeatherFromWeatherForecaster(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.weather.Weather value,
            java.lang.String region) {
        this.sender = new WeatherForecasterProxy(service, remoteServiceInfo);
        this.value = value;
        this.indices = new CurrentWeatherIndices(region);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((indices == null) ? 0 : indices.hashCode());
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
        CurrentWeatherFromWeatherForecaster other = (CurrentWeatherFromWeatherForecaster) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (indices == null) {
            if (other.indices != null)
                return false;
        } else if (!indices.equals(other.indices))
            return false;
        return true;
    }
    
    // Proxy to the sender, i.e., the device that published the source
    private WeatherForecasterProxy sender;
    
    /**
     * Get the sender of the source <code>currentWeather</code>. I.e., the <code>WeatherForecaster</code> device that published the source.
     * 
     * @return A proxy to the <code>WeatherForecaster</code> that triggered the source
     */
    public WeatherForecasterProxy sender() {
        return sender;
    }
    
    /**
     * A proxy to a <code>WeatherForecaster</code> that discloses subscription/unsubscription methods.
     */
    public class WeatherForecasterProxy extends Proxy {
        private WeatherForecasterProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
            super(service, remoteServiceInfo);
        }
        
        /**
         * Subcribes to publication of source <code>currentWeather</code> from this <code>WeatherForecaster</code>.
         */
        public void subscribeCurrentWeather() {
            getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentWeather");
        }
        
        /**
         * Unsubcribes from publication of source <code>currentWeather</code> from this <code>WeatherForecaster</code>.
         */
        public void unsubscribeCurrentWeather() {
            getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "currentWeather");
        }
        
        /**
         * @return the value of the <code>id</code> attribute
         */
        public java.lang.String id() {
            return (java.lang.String) callGetValue("id");
        }
    }
}

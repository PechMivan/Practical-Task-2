package com.weather.weather;

public interface WeatherDataService {
    WeatherData saveWeatherData(WeatherData weatherData);
    WeatherData getWeatherDataById(Long id);
    WeatherData getWeatherDataFromApi(String cityName);

}

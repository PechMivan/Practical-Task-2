package com.weather.weather;

import java.util.List;

public interface WeatherDataService {
    WeatherData saveWeatherData(WeatherData weatherData);
    WeatherData getWeatherDataById(Long id);
    WeatherData getWeatherDataFromApi(String cityName);

    List<WeatherData> getAllWeatherData();

}

package com.weather.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final WeatherDataRepository weatherDataRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherDataServiceImpl(WeatherDataRepository weatherDataRepository, RestTemplate restTemplate) {
        this.weatherDataRepository = weatherDataRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherData saveWeatherData(WeatherData weatherData) {
        return weatherDataRepository.save(weatherData);
    }

    @Override
    public List<WeatherData> getAllWeatherData() {
        return (List<WeatherData>) weatherDataRepository.findAll();
    }

    @Override
    public WeatherData getWeatherDataById(Long id) {
        return weatherDataRepository.findById(id).orElse(null);
    }

    @Override
    public WeatherData getWeatherDataFromApi(String cityName) {
        String apiKey = "67c0f96eb870453981b43557243001";
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + cityName;
        return restTemplate.getForObject(apiUrl, WeatherData.class);
    }

}
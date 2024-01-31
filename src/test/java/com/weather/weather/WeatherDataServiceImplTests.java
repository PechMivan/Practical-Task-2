package com.weather.weather;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class WeatherDataServiceImplTests {

    @Mock
    private WeatherDataRepository weatherDataRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherDataServiceImpl weatherDataService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveWeatherData() {
        // Mock repository behavior
        WeatherData.Location location1 = new WeatherData.Location("merida", "mexico");
        WeatherData.CurrentWeather cw1 = new WeatherData.CurrentWeather(23.4, 43.6, 38.5, 60);
        WeatherData mockWeatherData = new WeatherData(1L, location1, cw1);
        when(weatherDataRepository.save(any(WeatherData.class))).thenReturn(mockWeatherData);

        // Call the service method
        WeatherData savedWeatherData = weatherDataService.saveWeatherData(new WeatherData());

        // Verify the result
        assertEquals(mockWeatherData, savedWeatherData);
    }

    @Test
    public void testGetAllWeatherData() {
        // Mock repository behavior
        WeatherData.Location location1 = new WeatherData.Location("merida", "mexico");
        WeatherData.Location location2 = new WeatherData.Location("mexico city", "mexico");
        WeatherData.CurrentWeather cw1 = new WeatherData.CurrentWeather(23.4, 43.6, 38.5, 60);
        WeatherData.CurrentWeather cw2 = new WeatherData.CurrentWeather(10.0, 15.6, 30.0, 25);
        List<WeatherData> mockWeatherDataList = Arrays.asList(new WeatherData(1L, location1, cw1), new WeatherData(2L, location2, cw2));
        when(weatherDataRepository.findAll()).thenReturn(mockWeatherDataList);

        // Call the service method
        List<WeatherData> result = weatherDataService.getAllWeatherData();

        // Verify the result
        assertEquals(mockWeatherDataList, result);
    }

    @Test
    public void testGetWeatherDataById() {
        WeatherData.Location location1 = new WeatherData.Location("merida", "mexico");
        WeatherData.CurrentWeather cw1 = new WeatherData.CurrentWeather(23.4, 43.6, 38.5, 60);
        WeatherData mockWeatherData = new WeatherData(1L, location1, cw1);
        when(weatherDataRepository.findById(1L)).thenReturn(Optional.of(mockWeatherData));

        // Call the service method
        WeatherData result = weatherDataService.getWeatherDataById(1L);

        // Verify the result
        assertEquals(mockWeatherData, result);
    }

    @Test
    public void testGetWeatherDataFromApi() {
        // Mock restTemplate behavior
        String cityName = "TestCity";
        WeatherData.Location location1 = new WeatherData.Location("merida", "mexico");
        WeatherData.CurrentWeather cw1 = new WeatherData.CurrentWeather(23.4, 43.6, 38.5, 60);
        WeatherData mockWeatherData = new WeatherData(1L, location1, cw1);
        when(restTemplate.getForObject(anyString(), eq(WeatherData.class))).thenReturn(mockWeatherData);

        // Call the service method
        WeatherData result = weatherDataService.getWeatherDataFromApi(cityName);

        // Verify the result
        assertEquals(mockWeatherData, result);
    }
}


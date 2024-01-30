package com.weather.weather;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class WeatherDataControllerTests {

    @Mock
    private WeatherDataService weatherDataService;

    @InjectMocks
    private WeatherDataController weatherDataController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(weatherDataController).build();
    }

    @Test
    public void testShowWeatherDataList() throws Exception {
        // Mock service behavior
        List<WeatherData> mockWeatherDataList = Arrays.asList(new WeatherData(), new WeatherData());
        when(weatherDataService.getAllWeatherData()).thenReturn(mockWeatherDataList);

        // Perform the request
        mockMvc.perform(get("/api/weather"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("weatherDataList"));

        // Verify service method invocation
        verify(weatherDataService, times(1)).getAllWeatherData();
    }

    @Test
    public void testShowWeatherForm() throws Exception {
        // Perform the request
        mockMvc.perform(get("/api/weather/weatherForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("createWeatherData"))
                .andExpect(model().attributeExists("weatherForm"));
    }

    @Test
    public void testSubmitWeatherForm() throws Exception {
        // Mock service behavior
        WeatherData mockWeatherData = new WeatherData();
        when(weatherDataService.getWeatherDataFromApi(anyString())).thenReturn(mockWeatherData);

        // Perform the request
        mockMvc.perform(post("/api/weather/weatherData")
                        .param("location", "TestLocation"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        // Verify service method invocation
        verify(weatherDataService, times(1)).getWeatherDataFromApi(eq("TestLocation"));
        verify(weatherDataService, times(1)).saveWeatherData(eq(mockWeatherData));
    }

    // Add other tests as needed for additional handler methods
}


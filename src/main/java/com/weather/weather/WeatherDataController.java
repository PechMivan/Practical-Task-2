package com.weather.weather;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/api/weather")
public class WeatherDataController {

    private final WeatherDataService weatherDataService;
    private static final Logger log = LoggerFactory.getLogger(WeatherDataController.class);

    @Autowired
    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    // Handler method to display saved weather data
    @GetMapping
    public String showWeatherDataList(Model model) {
        List<WeatherData> weatherDataList = weatherDataService.getAllWeatherData();
        model.addAttribute("weatherDataList", weatherDataList);
        return "index";
    }

    // Handler method to display the form
    @GetMapping("/weatherForm")
    public String showWeatherForm(Model model) {
        model.addAttribute("weatherForm", new WeatherDataForm());
        return "createWeatherData";
    }

    // Handler method to process the form submission
    @PostMapping("/weatherData")
    public String submitWeatherForm(@ModelAttribute WeatherDataForm weatherForm) {

        String location = weatherForm.getLocation();
        WeatherData weatherData = weatherDataService.getWeatherDataFromApi(location);

        // Save the weather data to the database
        WeatherData savedWeatherData = weatherDataService.saveWeatherData(weatherData);

        return "redirect:/";  // Create a Thymeleaf template for displaying weather details
    }

    // Other handler methods

}

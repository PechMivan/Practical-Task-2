package com.weather.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "weather_data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @JsonProperty("location")
    private Location location;

    @Embedded
    @JsonProperty("current")
    private CurrentWeather current;

    // Getters and setters

    // Additional methods or constructors as needed

    // Inner classes for nested structures

    @Embeddable
    public static class Location {
        private String name;
        private String country;

        // Getters and setters for 'name' and 'country'
        // ...

        // Additional fields if needed
    }

    @Embeddable
    public static class CurrentWeather {
        @JsonProperty("temp_c")
        private Double temperatureC;

        @JsonProperty("wind_kph")
        private Double windKph;

        @JsonProperty("precip_mm")
        private Double precipitationMm;

        private Integer humidity;

        // Getters and setters for 'temperatureC', 'windKph', 'precipitationMm', and 'humidity'
        // ...

        // Additional fields if needed
    }
}
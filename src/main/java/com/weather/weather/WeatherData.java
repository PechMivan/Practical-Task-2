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
    public Location location;

    @Embedded
    @JsonProperty("current")
    public CurrentWeather current;

    public WeatherData() {
    }

    public WeatherData(Long id, Location location, CurrentWeather current) {
        this.id = id;
        this.location = location;
        this.current = current;
    }

    @Embeddable
    public static class Location {
        @JsonProperty("name")
        private String name;
        @JsonProperty("country")
        private String country;

        public Location() {
        }

        public Location(String name, String country) {
            this.name = name;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    @Embeddable
    public static class CurrentWeather {
        @JsonProperty("temp_c")
        private Double temperatureC;

        @JsonProperty("wind_kph")
        private Double windKph;

        @JsonProperty("precip_mm")
        private Double precipitationMm;

        @JsonProperty("humidity")
        private Integer humidity;

        public CurrentWeather() {
        }

        public CurrentWeather(Double temperatureC, Double windKph, Double precipitationMm, Integer humidity) {
            this.temperatureC = temperatureC;
            this.windKph = windKph;
            this.precipitationMm = precipitationMm;
            this.humidity = humidity;
        }

        public Double getTemperatureC() {
            return temperatureC;
        }

        public void setTemperatureC(Double temperatureC) {
            this.temperatureC = temperatureC;
        }

        public Double getWindKph() {
            return windKph;
        }

        public void setWindKph(Double windKph) {
            this.windKph = windKph;
        }

        public Double getPrecipitationMm() {
            return precipitationMm;
        }

        public void setPrecipitationMm(Double precipitationMm) {
            this.precipitationMm = precipitationMm;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }
    }
}
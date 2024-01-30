package com.weather.weather;

import org.springframework.data.repository.CrudRepository;

public interface WeatherDataRepository extends CrudRepository<WeatherData, Long> {

}

package service;

import dto.WeatherDto;

import java.time.LocalDate;

public interface WeatherService {

    WeatherDto getWeatherByDate(LocalDate localDate);

}

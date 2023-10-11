package service;

import dto.WeatherDaysDto;
import dto.WeatherTodayDto;

import java.time.LocalDate;

public interface WeatherService {

    WeatherTodayDto getWeatherByDate(LocalDate localDate);
    WeatherDaysDto getWeatherForDays(int days);

}

package dao;

import dto.WeatherDto;

import java.time.LocalDate;

public interface WeatherDao {

    WeatherDto getWeatherByDate(LocalDate date);

    WeatherDto getWeatherForDays(int days);
}

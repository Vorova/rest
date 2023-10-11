package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.WeatherDaysDto;
import dto.WeatherTodayDto;

import java.time.LocalDate;

public interface WeatherDao {

    WeatherTodayDto getWeatherByDate(LocalDate date);

    WeatherDaysDto getWeatherForDays(int days);
}

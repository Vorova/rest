package service.impl;

import dao.WeatherDao;
import dao.impl.WeatherDaoImpl;
import dto.WeatherDaysDto;
import dto.WeatherTodayDto;
import service.WeatherService;

import java.time.LocalDate;

public class WeatherServiceImpl implements WeatherService {

    WeatherDao weatherDao = new WeatherDaoImpl();

    @Override
    public WeatherTodayDto getWeatherByDate(LocalDate date) {
        // TODO кэширование
        return weatherDao.getWeatherByDate(date);
    }

    @Override
    public WeatherDaysDto getWeatherForDays(int days) {
        return weatherDao.getWeatherForDays(days);
    }

}

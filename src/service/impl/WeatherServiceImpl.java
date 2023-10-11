package service.impl;

import dao.WeatherDao;
import dao.impl.WeatherDaoImpl;
import dto.WeatherDto;
import service.WeatherService;

import java.time.LocalDate;

public class WeatherServiceImpl implements WeatherService {

    WeatherDao weatherDao = new WeatherDaoImpl();

    @Override
    public WeatherDto getWeatherByDate(LocalDate date) {
        // TODO кэширование
        return weatherDao.getWeatherByDate(date);
    }

    @Override
    public WeatherDto getWeatherForDays(int days) {
        return weatherDao.getWeatherForDays(days);
    }

}

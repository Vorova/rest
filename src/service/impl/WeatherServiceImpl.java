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
        WeatherDto weatherDay = weatherDao.getWeatherByDate(date);
        // TODO mapping
        // TODO кэширование
        return weatherDay;
    }

}

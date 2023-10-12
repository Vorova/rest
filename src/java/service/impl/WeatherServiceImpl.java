package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.WeatherDao;
import dao.impl.WeatherApi;
import dto.WeatherDto;
import service.WeatherService;

import java.time.LocalDate;

/**
 * Сервисный слой погоды.
 * Логика данного сервиса заключается в получении данных от {code java.dao},
 * обработка полученной информации и возвращению
 *
 * @author vorova
 */
public class WeatherServiceImpl implements WeatherService {

    private WeatherDao weatherDao;

    /**
     * Маппер. <br>
     * Данный маппер преобразует строковые значения в объекты.
     */
    private ObjectMapper mapper;

    /**
     * Конструктор. <br>
     * Инициализация java.dao слоя погоды. <br>
     * Инициализация и конфигурация маппера, который будет преобразовывать строковые отображения
     * в объекты отображения.
     */
    public WeatherServiceImpl() {
        weatherDao = new WeatherApi();

        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.findAndRegisterModules();
    }

    /**
     * Отправляет запрос в слой java.dao и преобразует полученную строку в DTO объект <br>
     * Полученный объект возвращается.
     * @param date день, на который получаем прогноз
     * @return Общее отображение погоды и локации
     * @throws JsonProcessingException ошибка десериализации объекта
     */
    @Override
    public WeatherDto getWeatherByDate(LocalDate date) throws JsonProcessingException {
        if(date == null) throw new NullPointerException("Date cannot be null");
        String result = weatherDao.getWeatherByDate(date);
        return mapper.readValue(result, WeatherDto.class);
    }

    /**
     * Получает прогноз погоды сразу на несколько дней вперед в строковом виде. <br>
     * Материализованный из строки объект возвращается.<br>
     * @param days кол-во дней, на которые нужен прогноз. Значение от одного до 14.
     * @return {code WeatherDto Class} Отображение погоды и локации
     * @throws JsonProcessingException ошибка десериализации объекта
     */
    @Override
    public WeatherDto getWeatherForDays(int days) throws JsonProcessingException {
        String result = weatherDao.getWeatherForDays(days);
        return mapper.readValue(result, WeatherDto.class);
    }

}

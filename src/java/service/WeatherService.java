package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.WeatherDto;

import java.time.LocalDate;

/**
 * Бизнес логика, осуществляемая над сущностью WeatherDto <br>
 */
public interface WeatherService {

    /**
     * Получает прогноз погоды на один день
     * @param date дата, на которую нужно получить прогноз
     * @return WeatherDto
     * @throws JsonProcessingException ошибка десериализации объектов
     */
    WeatherDto getWeatherByDate(LocalDate date) throws JsonProcessingException;

    /**
     * Получает прогноз погоды на несколько дней <br>
     * @param days кол-во дней, на которые нужен прогноз.
     * @return WeatherDto
     * @throws JsonProcessingException ошибка десериализации объектов
     */
    WeatherDto getWeatherForDays(int days) throws JsonProcessingException;

}

package dao;

import java.time.LocalDate;

/**
 * Dao layout.
 * Выполнение запросов к стороннему сервису
 */
public interface WeatherDao {

    /**
     * Получение информации на один конкретный день
     * @param date день, на который нужно получить прогноз
     * @return WeatherDto
     */
    String getWeatherByDate(LocalDate date);

    /**
     * Получение информации на несколько дней.
     * @param days кол-во дней. Принимается значение от 1 до 14.
     * @return WeatherDto
     */
    String getWeatherForDays(int days);
}

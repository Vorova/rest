package dao.impl;

import dao.WeatherDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

/**
 * Реализация WeatherDao. <br>
 * Данная реализация получает данные от сервиса api.weatherapi.com
 */
public class WeatherApi implements WeatherDao {

    /**
     * Начало запроса для прогноза на один день
     */
    private final static String URL_FUTURE = "https://api.weatherapi.com/v1/future.json";

    /**
     * Начало запроса для прогноза на несколько дней
     */
    private final static String URL_FORECAST = "https://api.weatherapi.com/v1/forecast.json";

    /**
     * Приватный ключ, который необходимо получить на сервисе api.weatherapi.com
     */
    private final static String KEY = "a28beba7424d4262b50162831231010";

    /**
     * Локация, в отношении которой формируются запросы
     */
    private final static String LOCATION = "Moscow";

    /**
     * Получает прогноз сформировав запрос вида api.weatherapi.com/v1/future <br>
     * В ответ приходит результат в json формате в виде строки.
     * @param date день, на который нужно получить прогноз
     * @return String
     */
    @Override
    public String getWeatherByDate(LocalDate date) {
        return getResultByUrl(getFullUrlForFuture(date));
    }

    /**
     * Получает прогноз сформировав запрос вида api.weatherapi.com/v1/forecast <br>
     * В результате приходит json формат в виде строки
     * @param days кол-во дней. Принимается значение от 1 до 14.
     * @return String
     */
    @Override
    public String getWeatherForDays(int days) {
        return getResultByUrl(getFullUrlForForecast(days));
    }

    private String getResultByUrl(String fullUrl) {
        StringBuilder content = new StringBuilder();
        try {
            String inputLine;
            URL url = new URL(fullUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((inputLine = buffer.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException();
        }
    }

    private String getFullUrlForFuture(LocalDate date) {
        return new StringBuilder(URL_FUTURE)
                .append("?")
                .append("key=").append(KEY)
                .append("&")
                .append("q=").append(LOCATION)
                .append("&")
                .append("dt=").append(date.getYear())
                .append("-").append(date.getDayOfMonth())
                .append("-").append(date.getMonthValue())
                .toString();
    }

    private String getFullUrlForForecast(int days) {
        return new StringBuilder(URL_FORECAST)
                .append("?")
                .append("key=").append(KEY)
                .append("&")
                .append("q=").append(LOCATION)
                .append("&")
                .append("days=").append(days)
                .toString();
    }

}

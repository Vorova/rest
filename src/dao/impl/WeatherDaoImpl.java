package dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.WeatherDao;
import dto.WeatherDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class WeatherDaoImpl implements WeatherDao {

    private final String URL_FUTURE = "https://api.weatherapi.com/v1/future.json";
    private final String URL_FORECAST = "https://api.weatherapi.com/v1/forecast.json";
    private final String KEY = "a28beba7424d4262b50162831231010";
    private final String Q = "Moscow";

    private final ObjectMapper mapper;

    public WeatherDaoImpl() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.findAndRegisterModules();
    }

    @Override
    public WeatherDto getWeatherByDate(LocalDate date) {
        try {
            return mapper.readValue(getResultByUrl(getFullUrlForFuture(date)), WeatherDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public WeatherDto getWeatherForDays(int days) {
        try {
            return mapper.readValue(getResultByUrl(getFullUrlForForecast(days)), WeatherDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
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
        StringBuilder url = new StringBuilder(URL_FUTURE)
                .append("?")
                .append("key=").append(KEY)
                .append("&")
                .append("q=").append(Q)
                .append("&")
                .append("dt=").append(date.getYear() + "-" + date.getDayOfMonth() + "-" + date.getMonthValue());
        return url.toString();
    }

    private String getFullUrlForForecast(int days) {
        StringBuilder url = new StringBuilder(URL_FORECAST)
                .append("?")
                .append("key=").append(KEY)
                .append("&")
                .append("q=").append(Q)
                .append("&")
                .append("days=").append(days);
        return url.toString();
    }

}

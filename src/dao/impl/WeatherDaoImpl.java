package dao.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.WeatherDao;
import dto.WeatherDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class WeatherDaoImpl implements WeatherDao {

    private final String URL_ADDRESS = "https://api.weatherapi.com/v1/future.json";
    private final String KEY = "a28beba7424d4262b50162831231010";
    private final String Q = "London";

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public WeatherDto getWeatherByDate(LocalDate date) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.findAndRegisterModules();
        StringBuilder content = new StringBuilder();
        try {
            String inputLine;
            URL url = new URL(getFullUrl(date));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((inputLine = buffer.readLine()) != null) {
                content.append(inputLine);
            }

            return mapper.readValue(content.toString(), WeatherDto.class);
        } catch (Exception e) {
            // TODO Обработка исключчения!
            System.out.println("EX");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private String getFullUrl(LocalDate date) {
        StringBuilder url = new StringBuilder(URL_ADDRESS)
                .append("?")
                .append("key=").append(KEY)
                .append("&")
                .append("q=").append(Q)
                .append("&")
                .append("dt=").append(date.getYear() + "-" + date.getDayOfMonth() + "-" + date.getMonthValue());
        return url.toString();
    }

}

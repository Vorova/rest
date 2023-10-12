package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * Отображение погоды.
 */
@Data
public class WeatherDto {

    /**
     * Локация и локальное время.
     */
    @JsonSetter("location")
    private LocationDto location;

    /**
     * Прогноз
     */
    @JsonSetter("forecast")
    private ForecastDto forecastDto;

}

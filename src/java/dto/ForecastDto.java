package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;

/**
 * Отображение прогноза погоды.
 */
@Data
public class ForecastDto {

    /**
     * Коллекцию прогнозов по дням
     */
    @JsonSetter("forecastday")
    private List<ForecastDayDto> forecastDayDto;
}

package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;

@Data
public class ForecastDto {

    @JsonSetter("forecastday")
    private List<ForecastDayDto> forecastDayDto;
}

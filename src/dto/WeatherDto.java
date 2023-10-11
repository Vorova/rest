package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class WeatherDto {

    @JsonSetter("location")
    private LocationDto location;

    @JsonSetter("forecast")
    private ForecastDto forecastDto;

}

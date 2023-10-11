package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WeatherTodayDto {

    @JsonSetter("location")
    private LocationDto locationDto;

    @JsonSetter("forecast")
    private ForecastDto forecastDto;

}

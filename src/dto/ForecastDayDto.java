package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
public class ForecastDayDto {

    @JsonSetter("date")
    private LocalDate date;

    @JsonSetter("day")
    private DayDto dayDto;

    @JsonSetter("hour")
    private List<HourDto> hours;

}

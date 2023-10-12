package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


/**
 * Отображение прогноза погоды на конкретный день.
 */
@Data
public class ForecastDayDto {

    /**
     * Локальное время
     */
    @JsonSetter("date")
    private LocalDate date;

    /**
     * Информация о средних величинах за день
     */
    @JsonSetter("day")
    private DayDto dayDto;

    /**
     * Коллекция по каждому часу
     */
    @JsonSetter("hour")
    private List<HourDto> hours;

}

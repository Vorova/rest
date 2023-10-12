package dto;

import lombok.Data;

/**
 * Отображение прогноза на 1 час
 */
@Data
public class HourDto {

    /**
     * Выбранный час
     */
    private String time;

    /**
     * Температура
     */
    private String temp_c;

}

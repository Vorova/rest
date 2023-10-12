package dto;

import lombok.Data;

/**
 * Отображение прогноза о конкретном дне
 */
@Data
public class DayDto {

    /**
     * Максимальная температура за день
     */
    private String maxtemp_c;

    /**
     * Минимальная температура за день
     */
    private String mintemp_c;

    /**
     * Средняя температура за день
     */
    private String avgtemp_c;

}

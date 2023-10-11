package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class HourDto {

//    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
//    private LocalDateTime startDate;
//
//    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
//    private LocalDateTime time;
    private String temp_c;

}

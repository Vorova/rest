package dto;

import lombok.Data;

@Data
public class LocationDto {

    private String name;
    private String region;
    private String country;
    private String localtime;
    private String tz_id;

}

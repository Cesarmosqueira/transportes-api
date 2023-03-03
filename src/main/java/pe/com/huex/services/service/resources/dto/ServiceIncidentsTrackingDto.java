package pe.com.huex.services.service.resources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ServiceIncidentsTrackingDto {

    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date dateService;
    private TrackingServiceTruckFleetDto truckFleet;
    private TrackingServiceRateDto rate;

}

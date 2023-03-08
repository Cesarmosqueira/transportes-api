package pe.com.huex.vehicles.service.resources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import pe.com.huex.services.service.resources.dto.TrackingServiceEmployeeDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceRateDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceTruckFleetDto;

import java.util.Date;

@Data
public class FuelControlTrackingDto {

    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date dateService;
    private TrackingServiceTruckFleetDto truckFleet;
    private TrackingServiceRateDto rate;
    private TrackingServiceEmployeeDto driver;
    private TrackingServiceEmployeeDto copilot;
    private String preloadStatus;

}

package pe.com.huex.services.service.resources.dto;

import lombok.*;
import pe.com.huex.services.domain.entities.TrackingService;

@Data
public class ServiceIncidentsDto {

    private Long id;
    private TrackingService trackingService;
    private String grt;
    private String grr;
    private String order;
    private String quantityUnits;
    private String observation;

}

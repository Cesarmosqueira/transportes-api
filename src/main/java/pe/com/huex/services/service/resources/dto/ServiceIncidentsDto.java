package pe.com.huex.services.service.resources.dto;

import lombok.*;

@Data
public class ServiceIncidentsDto {

    private Long id;
    private Long trackingServiceId;
    private String grt;
    private String grr;
    private String order;
    private String quantityUnits;
    private String observation;

}

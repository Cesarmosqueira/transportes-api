package pe.com.huex.services.service.resources.dto;

import lombok.*;
import pe.com.huex.services.domain.model.entity.TrackingService;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ServiceIncidentsDto {

    private Long id;
    private Long trackingServiceId;
    private String grt;
    private String grr;
    private String order;
    private String quantityUnits;
    private String observation;

}

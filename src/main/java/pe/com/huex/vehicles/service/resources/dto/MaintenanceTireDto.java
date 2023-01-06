package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.Date;

@Getter
@Setter
public class MaintenanceTireDto {
    private Long id;
    private TruckFleet truckFleet;
    private Date dateReview;
    private Date dateRenewal;
    private String statusTire;
}
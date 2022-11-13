package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceTireDto {
    private Long id;
    private Long idTruckFleet;
    private Date dateReview;
    private Date dateRenewal;
    private String statusTire;
}
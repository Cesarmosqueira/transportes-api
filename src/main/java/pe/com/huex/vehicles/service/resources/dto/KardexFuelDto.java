package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;
import pe.com.huex.vehicles.domain.model.entity.TruckFleet;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class KardexFuelDto {
    private Long id;
    private Long idTruckFleet;
    private Date date;
    private Integer amountFuel;
    private Integer mileage;
    private String dutyManager;
}
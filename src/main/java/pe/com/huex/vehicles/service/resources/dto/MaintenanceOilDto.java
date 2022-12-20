package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;
import pe.com.huex.vehicles.domain.model.entity.TruckFleet;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceOilDto {
    private Long id;
    private Long idTruckFleet;
    private String changeType;
    private String place;
    private Date dateChange;
    private Integer kmLast;
    private Integer kmCurrent;
    private Integer kmNext;
    private Integer status;
    private Date dateCurrent;
    private Integer differences;
}
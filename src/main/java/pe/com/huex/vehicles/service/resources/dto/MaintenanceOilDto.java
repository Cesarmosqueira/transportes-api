package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.Date;

@Getter
@Setter
public class MaintenanceOilDto {
    private Long id;
    private TruckFleet truckFleet;
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
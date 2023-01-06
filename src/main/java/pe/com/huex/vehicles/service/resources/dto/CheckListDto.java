package pe.com.huex.vehicles.service.resources.dto;

import lombok.Getter;
import lombok.Setter;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.Date;

@Getter
@Setter
public class CheckListDto {
    private Long id;
    private TruckFleet truckFleet;
    private Date date;
    private String namePhoto;
    private byte[] photo;
}
package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TruckFleetDto {

    private Long id;
    private Long idProvider;
    private String tractPlate;
    private String vanPlate;
    private String brand;
    private Double volume;
    private Date fabricationDate;
    private Double tonNumber;
    private Integer axes;
    private String model;
    private String highWideLong;
    private String fleetType;
}

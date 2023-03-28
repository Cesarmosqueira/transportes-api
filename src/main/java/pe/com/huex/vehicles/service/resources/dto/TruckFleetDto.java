package pe.com.huex.vehicles.service.resources.dto;

import lombok.Getter;
import lombok.Setter;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

import java.util.Date;

@Getter
@Setter
public class TruckFleetDto {

    private Long id;
    private ProviderDto provider;
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

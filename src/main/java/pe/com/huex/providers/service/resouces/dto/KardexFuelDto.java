package pe.com.huex.providers.service.resouces.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pe.com.huex.providers.domain.model.entity.FuelSupply;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.Date;

@Getter
@Setter
public class KardexFuelDto {
    private Long id;
    private TruckFleet truckFleet;
    private Date date;
    private Integer amountFuel;
    private Integer mileage;
    private String dutyManager;
    private FuelSupply fuelSupply;
}
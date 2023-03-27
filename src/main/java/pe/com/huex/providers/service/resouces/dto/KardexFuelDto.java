package pe.com.huex.providers.service.resouces.dto;

import lombok.Getter;
import lombok.Setter;
import pe.com.huex.providers.domain.model.entity.FuelSupply;

import java.util.Date;

@Getter
@Setter
public class KardexFuelDto {
    private Long id;
    private String tractPlate;
    private Date date;
    private Integer amountFuel;
    private Integer mileage;
    private String dutyManager;
    private FuelSupply fuelSupply;
    private String operation;
    private Double unitPrice;
    private Double balances;
}
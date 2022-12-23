package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;

import java.util.Date;

@Data
public class KardexFuelDto {
    private Long id;
    private Long idTruckFleet;
    private Date date;
    private Integer amountFuel;
    private Integer mileage;
    private String dutyManager;
}
package pe.com.huex.providers.service.resouces.dto;

import lombok.*;

import java.util.Date;

@Data
public class FuelSupplyDto {

    private Long id;

    private Long providerId;

    private Date dateFuel;

    private Integer fuelQuantity;

    private Double gallonPrice;

    private Double totalPrice;

    private String observation;


}

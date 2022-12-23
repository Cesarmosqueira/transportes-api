package pe.com.huex.providers.service.resouces.dto;

import lombok.*;

import java.util.Date;

@Data
public class TireReplacementDto {

    private Long id;
    private Long providerId;
    private Date replacementDate;
    private Integer tireQuantity;
    private Double unitPrice;
    private  Double totalPrice;
    private String brand;
    private String model;
    private String observation;

}

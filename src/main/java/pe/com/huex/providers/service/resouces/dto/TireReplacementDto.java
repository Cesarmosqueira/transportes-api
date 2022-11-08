package pe.com.huex.providers.service.resouces.dto;

import lombok.*;
import pe.com.huex.providers.domain.model.entity.Provider;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TireReplacementDto {

    private Long id;
    private Provider provider;
    private Date replacementDate;
    private Integer tireQuantity;
    private Double unitPrice;
    private  Double totalPrice;
    private String brand;
    private String model;
    private String observation;

}

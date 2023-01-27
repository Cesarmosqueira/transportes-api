package pe.com.huex.providers.service.resouces.dto;

import lombok.*;
import pe.com.huex.providers.domain.model.entity.Provider;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class FuelSupplyDto {

    private Long id;

    private Provider provider;

    private Date dateFuel;

    private Integer fuelQuantity;

    private Double gallonPrice;



    private String observation;


}

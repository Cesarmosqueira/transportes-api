package pe.com.huex.providers.service.resouces.dto;

import lombok.*;
import pe.com.huex.customer.domain.entities.Route;
import pe.com.huex.providers.domain.model.entity.Provider;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEstivatorDto {

    private Long id;
    private Route route;
    private Provider provider;
    private double costM3;
    private String observation;

}

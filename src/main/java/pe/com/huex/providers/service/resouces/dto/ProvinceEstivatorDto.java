package pe.com.huex.providers.service.resouces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
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
    private double CostM3;
    private String Observation;

}

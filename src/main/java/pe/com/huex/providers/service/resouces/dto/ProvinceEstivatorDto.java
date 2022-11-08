package pe.com.huex.providers.service.resouces.dto;

import lombok.*;
import pe.com.huex.customers.domain.model.entity.Rute;
import pe.com.huex.providers.domain.model.entity.Provider;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEstivatorDto {

    private Long id;
    private Rute rute;
    private Provider provider;
    private double CostM3;
    private String Observation;


}

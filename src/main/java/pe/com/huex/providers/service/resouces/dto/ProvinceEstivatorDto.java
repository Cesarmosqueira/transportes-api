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
    private Long routeId;
    private Long providerId;
    private double costM3;
    private String observation;

}

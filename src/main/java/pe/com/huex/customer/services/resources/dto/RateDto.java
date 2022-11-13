package pe.com.huex.customer.services.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.domain.entities.Route;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {

    private Long id;
    private Customer customer;
    private Route route;
    private String leadTime;
    private int volume;
    private double cost;
    private String observationRate;

}

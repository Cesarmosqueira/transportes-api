package pe.com.huex.customer.services.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {

    private Long id;
    private CustomerDto customer;
    private RouteDto route;
    private String routeDetail;
    private String leadTime;
    private String tonNumber;
    private int volume;
    private double cost;
    private String observationRate;

}

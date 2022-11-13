package pe.com.huex.customer.services.resources.dto;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private Long id;
    private String routeStart;
    private String routeEnd;
    private String zone;
    private double distanceKM;
    private double gallons;

}

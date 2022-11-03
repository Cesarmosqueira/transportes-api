package pe.com.huex.customers.service.resources.dto;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RuteDto {

    private Long id;
    private String routeStart;
    private String routeEnd;
    private String zone;
    private double distanceKM;
    private double gallons;


}

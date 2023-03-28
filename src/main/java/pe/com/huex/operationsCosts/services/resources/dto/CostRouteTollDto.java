package pe.com.huex.operationsCosts.services.resources.dto;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CostRouteTollDto {


    private BigInteger numberToll;
    private String configuration;
    private String routeEnd;
    private Double cost;


}

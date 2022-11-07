package pe.com.huex.customers.service.resources.dto;

import lombok.*;
import pe.com.huex.customers.domain.model.entity.Client;
import pe.com.huex.customers.domain.model.entity.Rute;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {

    private Long id;
    private Client client;
    private Rute rute;
    private String leadTime;
    private int volume;
    private double cost;
    private String observationRate;

}

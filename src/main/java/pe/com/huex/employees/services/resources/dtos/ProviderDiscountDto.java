package pe.com.huex.employees.services.resources.dtos;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDiscountDto {
    private Long id;
    private ProviderDto provider;
    private Date date;
    private String observations;
    private String status;
    private double charge;
}

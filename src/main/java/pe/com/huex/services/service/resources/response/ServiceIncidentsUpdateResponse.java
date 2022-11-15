package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ServiceIncidentsUpdateResponse {

    private ServiceIncidentsDto serviceIncidentsDto = null;

    public ServiceIncidentsUpdateResponse serviceIncidentsUpdateResponse(ServiceIncidentsDto serviceIncidentsDto) {
        this.serviceIncidentsDto = serviceIncidentsDto;
        return this;
    }
}

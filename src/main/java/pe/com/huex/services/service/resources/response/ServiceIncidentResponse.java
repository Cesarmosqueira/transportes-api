package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;

@Data
@NoArgsConstructor
public class ServiceIncidentResponse {

    private ServiceIncidentsDto serviceIncident = null;

    public ServiceIncidentResponse serviceIncident(ServiceIncidentsDto serviceIncidentsDto) {
        this.serviceIncident = serviceIncidentsDto;
        return this;
    }
}

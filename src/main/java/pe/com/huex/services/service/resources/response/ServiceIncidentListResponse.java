package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;

import java.util.List;
@Data
@NoArgsConstructor
public class ServiceIncidentListResponse {

    private List<ServiceIncidentsDto> serviceIncidents = null;

    public ServiceIncidentListResponse serviceIncidentsList(List<ServiceIncidentsDto> serviceIncidentsDtos) {
        this.serviceIncidents = serviceIncidentsDtos;
        return this;
    }
}

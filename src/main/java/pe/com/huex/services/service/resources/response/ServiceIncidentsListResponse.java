package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;

import java.util.List;
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ServiceIncidentsListResponse {

    private List<ServiceIncidentsDto> serviceIncidentsDtos = null;

    public ServiceIncidentsListResponse serviceIncidentsList(List<ServiceIncidentsDto> serviceIncidentsDtos) {
        this.serviceIncidentsDtos = serviceIncidentsDtos;
        return this;
    }
}

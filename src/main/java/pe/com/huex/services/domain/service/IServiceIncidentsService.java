package pe.com.huex.services.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;
import pe.com.huex.services.service.resources.response.*;

public interface IServiceIncidentsService {

    ResponseDto<ServiceIncidentListResponse> listServiceIncidents();

    ResponseDto<ServiceIncidentResponse> retrieveServiceIncidents(Long id);

    ResponseDto<ServiceIncidentResponse> registerServiceIncidents(ServiceIncidentsDto serviceIncidentsDto);

    ResponseDto<ServiceIncidentResponse> updateServiceIncidents(ServiceIncidentsDto serviceIncidentsDto);
}

package pe.com.huex.services.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;
import pe.com.huex.services.service.resources.response.*;

public interface IServiceIncidentsService {

    ResponseDto<ServiceIncidentsListResponse> listServiceIncidents();

    ResponseDto<ServiceIncidentsRetrieveResponse> retrieveServiceIncidents(Long id);

    ResponseDto<ServiceIncidentsRegisterResponse> registerServiceIncidents(ServiceIncidentsDto serviceIncidentsDto);

    ResponseDto<ServiceIncidentsUpdateResponse> updateServiceIncidents(ServiceIncidentsDto serviceIncidentsDto);
}

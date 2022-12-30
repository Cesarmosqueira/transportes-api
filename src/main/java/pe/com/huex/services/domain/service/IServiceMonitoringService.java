package pe.com.huex.services.domain.service;

import pe.com.huex.services.service.resources.dto.ServiceMonitoringDto;
import pe.com.huex.services.service.resources.response.ServiceMonitoringListResponse;
import pe.com.huex.services.service.resources.response.ServiceMonitoringResponse;
import pe.com.huex.util.ResponseDto;

public interface IServiceMonitoringService {

    ResponseDto<ServiceMonitoringListResponse> listServiceMonitoring();

    ResponseDto<ServiceMonitoringResponse> retrieveServiceMonitoring(Long id);

    ResponseDto<ServiceMonitoringResponse> registerServiceMonitoring(ServiceMonitoringDto serviceMonitoringDto);

    ResponseDto<ServiceMonitoringResponse> updateServiceMonitoring(ServiceMonitoringDto serviceMonitoringDto);

    ResponseDto deleteServiceMonitoring(Long id);
}

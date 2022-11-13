package pe.com.huex.services.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;
import pe.com.huex.services.service.resources.response.TrackingServiceListResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceRegisterResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceRetrieveResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceUpdateResponse;

public interface ITrackingServiceService {

    ResponseDto<TrackingServiceListResponse> listTrackingServices();

    ResponseDto<TrackingServiceRetrieveResponse> retrieveTrackingService(Long id);

    ResponseDto<TrackingServiceRegisterResponse> registerTrackingService(TrackingServiceDto trackingServiceDto);

    ResponseDto<TrackingServiceUpdateResponse> updateTrackingService(TrackingServiceDto trackingServiceDto);
}

package pe.com.huex.services.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;
import pe.com.huex.services.service.resources.response.TrackingServiceListResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceResponse;

public interface ITrackingServiceService {

    ResponseDto<TrackingServiceListResponse> listTrackingServices();

    ResponseDto<TrackingServiceResponse> retrieveTrackingService(Long id);

    ResponseDto<TrackingServiceResponse> registerTrackingService(TrackingServiceDto trackingServiceDto);

    ResponseDto<TrackingServiceResponse> updateTrackingService(TrackingServiceDto trackingServiceDto);

    ResponseDto deleteTrackingService(Long id);
}

package pe.com.huex.services.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.services.domain.service.ITrackingServiceService;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;
import pe.com.huex.services.service.resources.response.TrackingServiceListResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceRegisterResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceRetrieveResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceUpdateResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "service/trackingService", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrackingServiceController {

    @Autowired
    ITrackingServiceService trackingService;

    @GetMapping
    public ResponseDto<TrackingServiceListResponse> listTrackingServices() {
        return trackingService.listTrackingServices();
    }

    @GetMapping("{id}")
    public ResponseDto<TrackingServiceRetrieveResponse> retrieveTrackingService(@PathVariable Long id) {
        return trackingService.retrieveTrackingService(id);
    }

    @PostMapping
    public ResponseDto<TrackingServiceRegisterResponse> registerTrackingService(@RequestBody TrackingServiceDto truckFleetDto) {
        return trackingService.registerTrackingService(truckFleetDto);
    }

    @PutMapping
    public ResponseDto<TrackingServiceUpdateResponse> updateTrackingService(@RequestBody TrackingServiceDto truckFleetDto) {
        return trackingService.updateTrackingService(truckFleetDto);
    }
}
package pe.com.huex.services.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.services.service.resources.response.TrackingServiceListLightResponse;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.domain.service.ITrackingServiceService;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;
import pe.com.huex.services.service.resources.response.TrackingServiceListResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceResponse;

import java.util.Date;

@RestController
@RequestMapping(value = "service/tracking", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrackingServiceController {

    @Autowired
    ITrackingServiceService trackingService;


    @GetMapping("/findByRangeDate")
    public ResponseDto<TrackingServiceListResponse> listTrackingServicesFindByRangeDate(
            @RequestParam(name = "dateStart") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateStart,
    @RequestParam(name = "dateEnd") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateEnd ) {
        ResponseDto<TrackingServiceListResponse> trackingServiceListResponse = trackingService.listTrackingServicesFindByRangeDate(dateStart,dateEnd);
        return trackingServiceListResponse;
    }

    @GetMapping
    public ResponseDto<TrackingServiceListLightResponse> listTrackingServices() {
        return trackingService.listTrackingServices();
    }


    @GetMapping("{id}")
    public ResponseDto<TrackingServiceResponse> retrieveTrackingService(@PathVariable Long id) {
        return trackingService.retrieveTrackingService(id);
    }

    @PostMapping
    public ResponseDto<TrackingServiceResponse> registerTrackingService(@RequestBody TrackingServiceDto truckFleetDto) {
        return trackingService.registerTrackingService(truckFleetDto);
    }

    @PutMapping
    public ResponseDto<TrackingServiceResponse> updateTrackingService(@RequestBody TrackingServiceDto truckFleetDto) {
        return trackingService.updateTrackingService(truckFleetDto);
    }
    @DeleteMapping("{id}")
    public ResponseDto deleteTrackingService(@PathVariable Long id){
        return  trackingService.deleteTrackingService(id);
    }
}

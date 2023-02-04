package pe.com.huex.services.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.services.domain.service.IServiceMonitoringService;
import pe.com.huex.services.service.resources.dto.ServiceMonitoringDto;
import pe.com.huex.services.service.resources.response.ServiceMonitoringListResponse;
import pe.com.huex.services.service.resources.response.ServiceMonitoringResponse;
import pe.com.huex.util.ResponseDto;


@RestController
@RequestMapping(value = "serviceMonitoring", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceMonitoringController {

    private final IServiceMonitoringService serviceMonitoringService;

    public ServiceMonitoringController(IServiceMonitoringService serviceMonitoringService) {
        this.serviceMonitoringService = serviceMonitoringService;
    }


    @GetMapping
    public ResponseDto<ServiceMonitoringListResponse> listServiceMonitoring() {
        return serviceMonitoringService.listServiceMonitoring();
    }

    @GetMapping("{id}")
    public ResponseDto<ServiceMonitoringResponse> retrieveServiceMonitoring(@PathVariable Long id) {
        return serviceMonitoringService.retrieveServiceMonitoring(id);
    }

    @PostMapping
    public ResponseDto<ServiceMonitoringResponse> registerServiceMonitoring(@RequestBody ServiceMonitoringDto serviceMonitoringDto) {
        return serviceMonitoringService.registerServiceMonitoring(serviceMonitoringDto);
    }

    @PutMapping
    public ResponseDto<ServiceMonitoringResponse> updateServiceMonitoring(@RequestBody ServiceMonitoringDto serviceMonitoringDto) {
        return serviceMonitoringService.updateServiceMonitoring(serviceMonitoringDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteServiceMonitoring(@PathVariable Long id) {
        return serviceMonitoringService.deleteServiceMonitoring(id);
    }

    @GetMapping("tracking/{id}")
    public ResponseDto<ServiceMonitoringListResponse> listServiceMonitoringByIdTracking(@PathVariable Long id) {
        return serviceMonitoringService.listServiceMonitoringByIdTracking(id);
    }

}

package pe.com.huex.services.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.domain.service.IServiceIncidentsService;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;
import pe.com.huex.services.service.resources.response.*;

@RestController
@RequestMapping(value = "service_incident", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceIncidentsController {

    private final IServiceIncidentsService serviceIncidentsService;


    public ServiceIncidentsController(IServiceIncidentsService serviceIncidentsService) {
        this.serviceIncidentsService = serviceIncidentsService;
    }

    @GetMapping
    public ResponseDto<ServiceIncidentListResponse> listServiceIncident() throws Exception {
        return serviceIncidentsService.listServiceIncidents();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<ServiceIncidentResponse> retrieveServiceIncident(@PathVariable Long id) throws Exception {
        return serviceIncidentsService.retrieveServiceIncidents(id);
    }

    @PostMapping
    public ResponseDto<ServiceIncidentResponse> registerServiceIncident(@RequestBody ServiceIncidentsDto serviceIncidentsDto)
            throws Exception {
        return serviceIncidentsService.registerServiceIncidents(serviceIncidentsDto);
    }

    @PutMapping
    public ResponseDto<ServiceIncidentResponse> updateServiceIncident(@RequestBody ServiceIncidentsDto serviceIncidentsDto)
            throws Exception {
        return serviceIncidentsService.updateServiceIncidents(serviceIncidentsDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteServiceIncidents(@PathVariable Long id) {
        return serviceIncidentsService.deleteServiceIncidents(id);
    }

    @GetMapping("tracking/{id}")
    public ResponseDto<ServiceIncidentListResponse> listServiceIncidentByIdTracking(@PathVariable Long id) throws Exception {
        return serviceIncidentsService.listServiceIncidentByIdTracking(id);
    }
}

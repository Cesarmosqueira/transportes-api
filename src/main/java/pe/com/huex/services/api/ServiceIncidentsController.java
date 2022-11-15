package pe.com.huex.services.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.services.domain.service.IServiceIncidentsService;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;
import pe.com.huex.services.service.resources.response.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "service_incident", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceIncidentsController {

    private final IServiceIncidentsService serviceIncidentsService;


    public ServiceIncidentsController(IServiceIncidentsService serviceIncidentsService) {
        this.serviceIncidentsService = serviceIncidentsService;
    }

    @GetMapping
    public ResponseDto<ServiceIncidentsListResponse> listServiceIncident() throws Exception {
        return serviceIncidentsService.listServiceIncidents();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<ServiceIncidentsRetrieveResponse> retrieveServiceIncident(@PathVariable Long id) throws Exception {
        return serviceIncidentsService.retrieveServiceIncidents(id);
    }

    @PostMapping
    public ResponseDto<ServiceIncidentsRegisterResponse> registerServiceIncident(@RequestBody ServiceIncidentsDto serviceIncidentsDto)
            throws Exception {
        return serviceIncidentsService.registerServiceIncidents(serviceIncidentsDto);
    }

    @PutMapping
    public ResponseDto<ServiceIncidentsUpdateResponse> updateServiceIncident(@RequestBody ServiceIncidentsDto serviceIncidentsDto)
            throws Exception {
        return serviceIncidentsService.updateServiceIncidents(serviceIncidentsDto);
    }
}

package pe.com.huex.services.api;

import org.springframework.web.bind.annotation.*;
import pe.com.huex.services.domain.service.IAdditionalServicesService;
import pe.com.huex.services.service.resources.dto.AdditionalServicesDto;
import pe.com.huex.services.service.resources.response.AdditionalServicesListResponse;
import pe.com.huex.services.service.resources.response.AdditionalServicesResponse;
import pe.com.huex.util.ResponseDto;

@RestController
@RequestMapping("additional_services")
public class AdditionalServicesController {

    private final IAdditionalServicesService additionalServicesService;

    public AdditionalServicesController(IAdditionalServicesService additionalServicesService) {
        this.additionalServicesService = additionalServicesService;
    }


    @GetMapping
    public ResponseDto<AdditionalServicesListResponse> listAdditionalServices() throws Exception {
        return additionalServicesService.listAdditionalServices();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<AdditionalServicesResponse> retrieveAdditionalServices(@PathVariable Long id) throws Exception {
        return additionalServicesService.retrieveAdditionalServices(id);
    }

    @PostMapping
    public ResponseDto<AdditionalServicesResponse> registerAdditionalServices(@RequestBody AdditionalServicesDto additionalServicesDto)
            throws Exception {
        return additionalServicesService.registerAdditionalServices(additionalServicesDto);
    }

    @PutMapping
    public ResponseDto<AdditionalServicesResponse> updateAdditionalService(@RequestBody AdditionalServicesDto additionalServicesDto)
            throws Exception {
        return additionalServicesService.updateAdditionalServices(additionalServicesDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteAdditionalService(@PathVariable Long id) {
        return additionalServicesService.deleteAdditionalServices(id);
    }
}

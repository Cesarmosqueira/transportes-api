package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.domain.service.IMaintenanceTireService;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireListResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireUpdateResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "vehicle/maintenanceTire", produces = MediaType.APPLICATION_JSON_VALUE)
public class MaintenanceTireController {
    @Autowired
    IMaintenanceTireService maintenanceTireService;

    @GetMapping()
    public ResponseDto<MaintenanceTireListResponse> listMaintenanceTires() throws Exception {
        return maintenanceTireService.listMaintenanceTires();
    }

    @GetMapping(path ="{id}")
    public ResponseDto<MaintenanceTireRetrieveResponse> retrieveMaintenanceTire(@PathVariable Long id) throws Exception {
        return maintenanceTireService.retrieveMaintenanceTire(id);
    }

    @PostMapping
    public ResponseDto<MaintenanceTireRegisterResponse> registerMaintenanceTire(@RequestBody MaintenanceTireDto maintenanceTireDto) throws Exception {
        return maintenanceTireService.registerMaintenanceTire(maintenanceTireDto);
    }

    @PutMapping
    public ResponseDto<MaintenanceTireUpdateResponse> updateMaintenanceTire(@RequestBody MaintenanceTireDto maintenanceTireDto) throws Exception {
        return maintenanceTireService.updateMaintenanceTire(maintenanceTireDto);
    }
}

package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.domain.service.IMaintenanceOilService;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilListResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilUpdateResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "maintenanceOil", produces = MediaType.APPLICATION_JSON_VALUE)
public class MaintenanceOilController {
    @Autowired
    IMaintenanceOilService maintenanceOilService;

    @GetMapping()
    public ResponseDto<MaintenanceOilListResponse> listMaintenanceOils() throws Exception {
        return maintenanceOilService.listMaintenanceOils();
    }

    @GetMapping(path ="{id}")
    public ResponseDto<MaintenanceOilRetrieveResponse> retrieveMaintenanceOil(@PathVariable Long id) throws Exception {
        return maintenanceOilService.retrieveMaintenanceOil(id);
    }

    @PostMapping
    public ResponseDto<MaintenanceOilRegisterResponse> registerMaintenanceOil(@RequestBody MaintenanceOilDto maintenanceOilDto) throws Exception {
        return maintenanceOilService.registerMaintenanceOil(maintenanceOilDto);
    }

    @PutMapping
    public ResponseDto<MaintenanceOilUpdateResponse> updateMaintenanceOil(@RequestBody MaintenanceOilDto maintenanceOilDto) throws Exception {
        return maintenanceOilService.updateMaintenanceOil(maintenanceOilDto);
    }
}

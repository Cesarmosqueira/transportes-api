package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.domain.service.IMaintenanceOilService;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;
import pe.com.huex.vehicles.service.resources.response.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "vehicle/maintenanceOil", produces = MediaType.APPLICATION_JSON_VALUE)
public class MaintenanceOilController {
    @Autowired
    IMaintenanceOilService maintenanceOilService;

    @GetMapping()
    public ResponseDto<MaintenanceOilListResponse> listMaintenanceOils() {
        return maintenanceOilService.listMaintenanceOils();
    }

    @GetMapping(path ="{id}")
    public ResponseDto<MaintenanceOilRetrieveResponse> retrieveMaintenanceOil(@PathVariable Long id) {
        return maintenanceOilService.retrieveMaintenanceOil(id);
    }

    @PostMapping
    public ResponseDto<MaintenanceOilRegisterResponse> registerMaintenanceOil(@RequestBody MaintenanceOilDto maintenanceOilDto) {
        return maintenanceOilService.registerMaintenanceOil(maintenanceOilDto);
    }

    @PutMapping
    public ResponseDto<MaintenanceOilUpdateResponse> updateMaintenanceOil(@RequestBody MaintenanceOilDto maintenanceOilDto) {
        return maintenanceOilService.updateMaintenanceOil(maintenanceOilDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto<CheckListUpdateResponse> deleteMaintenanceOil(@PathVariable Long id) {
        return maintenanceOilService.deleteMaintenanceOil(id);
    }

    @GetMapping("truckFleet/{id}")
    public ResponseDto<MaintenanceOilListResponse> listMaintenanceOilsByIdTruckFleet(@PathVariable Long id) {
        return maintenanceOilService.listMaintenanceOilsByIdTruckFleet(id);
    }
}

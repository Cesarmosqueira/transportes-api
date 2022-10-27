package pe.com.huex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.MaintenanceOil;
import pe.com.huex.services.MaintenanceOilService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("maintenanceOil")
public class MaintenanceOilController {
    @Autowired
    MaintenanceOilService maintenanceOilService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<MaintenanceOilListDto> listMaintenanceOils() throws Exception {
        return maintenanceOilService.listMaintenanceOils();
    }

    @GetMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<MaintenanceOilRetrieveDto> retrieveMaintenanceOil(@PathVariable Long id) throws Exception {
        return maintenanceOilService.retrieveMaintenanceOil(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<MaintenanceOilRegisterDto> registerMaintenanceOil(@RequestBody MaintenanceOil maintenanceOil) throws Exception {
        return maintenanceOilService.registerMaintenanceOil(maintenanceOil);
    }

    @PutMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<MaintenanceOilUpdateDto> updateMaintenanceOil(@PathVariable Long id, @RequestBody MaintenanceOil maintenanceOil) throws Exception {
        return maintenanceOilService.updateMaintenanceOil(id, maintenanceOil);
    }
}

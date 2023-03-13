package pe.com.huex.vehicles.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.domain.service.IFuelControlService;
import pe.com.huex.vehicles.service.resources.dto.FuelControlDto;
import pe.com.huex.vehicles.service.resources.response.FuelControlListResponse;
import pe.com.huex.vehicles.service.resources.response.FuelControlResponse;


@RestController
@RequestMapping(value = "fuel_control", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuelControlController {

    private final IFuelControlService fuelControlService;


    public FuelControlController(IFuelControlService fuelControlService) {
        this.fuelControlService = fuelControlService;
    }


    @GetMapping
    public ResponseDto<FuelControlListResponse> listFuelControl() {
        return fuelControlService.listFuelControl();
    }

    @GetMapping("{id}")
    public ResponseDto<FuelControlResponse> retrieveFuelControl(@PathVariable Long id) {
        return fuelControlService.retrieveFuelControl(id);
    }

    @PostMapping
    public ResponseDto<FuelControlResponse> registerFuelControl(@RequestBody FuelControlDto fuelControlDto) {
        return fuelControlService.registerFuelControl(fuelControlDto);
    }

    @PutMapping
    public ResponseDto<FuelControlResponse> updateFuelControl(@RequestBody FuelControlDto fuelControlDto) {
        return fuelControlService.updateFuelControl(fuelControlDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteFuelControl(@PathVariable Long id) {
        return fuelControlService.deleteFuelControl(id);
    }

}

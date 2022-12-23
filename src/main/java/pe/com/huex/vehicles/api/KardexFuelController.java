package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.domain.service.IKardexFuelService;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;
import pe.com.huex.vehicles.service.resources.response.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "vehicle/kardexFuel", produces = MediaType.APPLICATION_JSON_VALUE)
public class KardexFuelController {

    @Autowired
    IKardexFuelService kardexFuelService;

    @GetMapping
    public ResponseDto<KardexFuelListResponse> listKardexFuels() {
        return kardexFuelService.listKardexFuels();
    }

    @GetMapping("{id}")
    public ResponseDto<KardexFuelResponse> retrieveKardexFuel(@PathVariable Long id) {
        return kardexFuelService.retrieveKardexFuel(id);
    }

    @PostMapping
    public ResponseDto<KardexFuelResponse> registerKardexFuel(@RequestBody KardexFuelDto kardexFuelDto) {
        return kardexFuelService.registerKardexFuel(kardexFuelDto);
    }

    @PutMapping
    public ResponseDto<KardexFuelResponse> updateKardexFuel(@RequestBody KardexFuelDto kardexFuelDto) {
        return kardexFuelService.updateKardexFuel(kardexFuelDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto<CheckListResponse> deleteKardexFuel(@PathVariable Long id) {
        return kardexFuelService.deleteKardexFuel(id);
    }

    @GetMapping("truckFleet/{id}")
    public ResponseDto listKardexFuelsByIdTruckFleet(@PathVariable Long id) {
        return kardexFuelService.listKardexFuelsByIdTruckFleet(id);
    }
}

package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.domain.service.ITruckFleetService;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;
import pe.com.huex.vehicles.service.resources.response.TruckFleetListResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetResponse;

@RestController
@RequestMapping(value = "vehicle/truckFleet", produces = MediaType.APPLICATION_JSON_VALUE)
public class TruckFleetController {

    @Autowired
    ITruckFleetService truckFleetService;

    @GetMapping
    public ResponseDto<TruckFleetListResponse> listTruckFleets() {

        return truckFleetService.listTruckFleets();
    }

    @GetMapping("{id}")
    public ResponseDto<TruckFleetResponse> retrieveTruckFleet(@PathVariable Long id) {
        return truckFleetService.retrieveTruckFleet(id);
    }

    @PostMapping
    public ResponseDto<TruckFleetResponse> registerTruckFleet(@RequestBody TruckFleetDto truckFleetDto) {
        return truckFleetService.registerTruckFleet(truckFleetDto);
    }

    @PutMapping
    public ResponseDto<TruckFleetResponse> updateTruckFleet(@RequestBody TruckFleetDto truckFleetDto) {
        return truckFleetService.updateTruckFleet(truckFleetDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteTruckFleet(@PathVariable Long id) {
        return truckFleetService.deleteTruckFleet(id);
    }
}

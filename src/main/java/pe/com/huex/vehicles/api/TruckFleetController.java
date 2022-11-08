package pe.com.huex.vehicles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.domain.service.ITruckFleetService;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;
import pe.com.huex.vehicles.service.resources.response.TruckFleetListResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetUpdateResponse;

@CrossOrigin(origins = "*")
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
    public ResponseDto<TruckFleetRetrieveResponse> retrieveTruckFleet(@PathVariable Long id) {
        return truckFleetService.retrieveTruckFleet(id);
    }

    @PostMapping
    public ResponseDto<TruckFleetRegisterResponse> registerTruckFleet(@RequestBody TruckFleetDto truckFleetDto) {
        return truckFleetService.registerTruckFleet(truckFleetDto);
    }

    @PutMapping
    public ResponseDto<TruckFleetUpdateResponse> updateTruckFleet(@RequestBody TruckFleetDto truckFleetDto) {
        return truckFleetService.updateTruckFleet(truckFleetDto);
    }
}

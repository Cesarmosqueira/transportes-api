package pe.com.huex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.TruckFleet;
import pe.com.huex.services.TruckFleetService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("truckFleet")
public class TruckFleetController {

    @Autowired
    TruckFleetService truckFleetService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<TruckFleetListDto> listTruckFleets() throws Exception {
        return truckFleetService.listTruckFleets();
    }

    @GetMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<TruckFleetRetrieveDto> retrieveTruckFleet(@PathVariable Long id) throws Exception {
        return truckFleetService.retrieveTruckFleet(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<TruckFleetRegisterDto> registerTruckFleet(@RequestBody TruckFleet truckFleet) throws Exception {
        return truckFleetService.registerTruckFleet(truckFleet);
    }

    @PutMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<TruckFleetUpdateDto> updateTruckFleet(@PathVariable Long id, @RequestBody TruckFleet truckFleet) throws Exception {
        return truckFleetService.updateTruckFleet(id, truckFleet);
    }
}

package pe.com.huex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.KardexFuel;
import pe.com.huex.services.KardexFuelService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("kardexFuel")
public class KardexFuelController {

    @Autowired
    KardexFuelService kardexFuelService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<KardexFuelListDto> listKardexFuels() throws Exception {
        return kardexFuelService.listKardexFuels();
    }

    @GetMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<KardexFuelRetrieveDto> retrieveKardexFuel(@PathVariable Long id) throws Exception {
        return kardexFuelService.retrieveKardexFuel(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<KardexFuelRegisterDto> registerKardexFuel(@RequestBody KardexFuel kardexFuel) throws Exception {
        return kardexFuelService.registerKardexFuel(kardexFuel);
    }

    @PutMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<KardexFuelUpdateDto> updateKardexFuel(@PathVariable Long id, @RequestBody KardexFuel kardexFuel) throws Exception {
        return kardexFuelService.updateKardexFuel(id, kardexFuel);
    }
}

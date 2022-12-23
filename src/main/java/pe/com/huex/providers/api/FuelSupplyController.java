package pe.com.huex.providers.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.domain.service.IFuelSupplyService;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;
import pe.com.huex.providers.service.resouces.response.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "fuelSupply",produces = MediaType.APPLICATION_JSON_VALUE)
public class FuelSupplyController {

    private final IFuelSupplyService fuelSupplyService;

    public FuelSupplyController(IFuelSupplyService fuelSupplyService) {
        this.fuelSupplyService = fuelSupplyService;
    }

    @GetMapping
    public ResponseDto<FuelSupplyListResponse> listFuelSupply() throws Exception {
        return fuelSupplyService.listFuelSupply();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<FuelSupplyResponse> retrieveFuelSupply(@PathVariable Long id) throws Exception {
        return fuelSupplyService.retrieveFuelSupply(id);
    }

    @PostMapping
    public ResponseDto<FuelSupplyResponse> registerFuelSupply(@RequestBody FuelSupplyDto fuelSupplyDto) throws Exception {
        return fuelSupplyService.registerFuelSupply(fuelSupplyDto);
    }

    @PutMapping
    public ResponseDto<FuelSupplyResponse> updateFuelSupply(@RequestBody FuelSupplyDto fuelSupplyDto)
            throws Exception {
        return fuelSupplyService.updateFuelSupply(fuelSupplyDto);
    }
    
}

package pe.com.huex.providers.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.domain.service.ITireReplacementService;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;
import pe.com.huex.providers.service.resouces.response.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "tireReplacement",produces = MediaType.APPLICATION_JSON_VALUE)
public class TireReplacementController {

    private final ITireReplacementService tiredReplacementService;

    public TireReplacementController(ITireReplacementService tiredReplacementService) {
        this.tiredReplacementService = tiredReplacementService;
    }

    @GetMapping
    public ResponseDto<TireReplacementListResponse> listTireReplacement() throws Exception {
        return tiredReplacementService.listTireReplacement();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<TireReplacementRetrieveResponse> retrieveTireReplacement(@PathVariable Long id) throws Exception {
        return tiredReplacementService.retrieveTireReplacement(id);
    }
    @PostMapping
    public ResponseDto<TireReplacementRegisterResponse> registerTireReplacement(@RequestBody TireReplacementDto tireReplacementDto) throws Exception {
        return tiredReplacementService.registerTireReplacement(tireReplacementDto);
    }

    @PutMapping
    public ResponseDto<TireReplacementUpdateResponse> updateTireReplacement(@RequestBody TireReplacementDto tireReplacementDto)
            throws Exception {
        return tiredReplacementService.updateTireReplacementDto(tireReplacementDto);
    }


}

package pe.com.huex.providers.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.domain.service.ITireReplacementService;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;
import pe.com.huex.providers.service.resouces.response.TireReplacementListResponse;
import pe.com.huex.providers.service.resouces.response.TireReplacementRegisterResponse;
import pe.com.huex.providers.service.resouces.response.TireReplacementRetrieveResponse;
import pe.com.huex.providers.service.resouces.response.TireReplacementUpdateResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "tireReplacement", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseDto<TireReplacementRetrieveResponse> retrieveTireReplacement(@PathVariable Long id)
            throws Exception {
        return tiredReplacementService.retrieveTireReplacement(id);
    }

    @PostMapping
    public ResponseDto<TireReplacementRegisterResponse> registerTireReplacement(
            @RequestBody TireReplacementDto tireReplacementDto) throws Exception {
        return tiredReplacementService.registerTireReplacement(tireReplacementDto);
    }

    @PutMapping
    public ResponseDto<TireReplacementUpdateResponse> updateTireReplacement(
            @RequestBody TireReplacementDto tireReplacementDto)
            throws Exception {
        return tiredReplacementService.updateTireReplacement(tireReplacementDto);
    }

}

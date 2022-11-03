package pe.com.huex.customers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.customers.domain.service.IRuteService;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.customers.service.resources.response.*;
import pe.com.huex.dto.Response.ResponseDto;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rutes", produces = MediaType.APPLICATION_JSON_VALUE)
public class RuteController {

    @Autowired
    IRuteService ruteService;

    @GetMapping
    public ResponseDto<RuteListResponse> listRute() throws Exception {
        return ruteService.listRute();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<RuteRetrieveResponse> retrieveRute(@PathVariable Long id) throws Exception {
        return ruteService.retrieveRute(id);
    }

    @PostMapping
    public ResponseDto<RuteRegisterResponse> registerRute(@RequestBody RuteDto ruteDto) throws Exception {
        return ruteService.registerRute(ruteDto);
    }
    @PutMapping
    public ResponseDto<RuteUpdateResponse> updateRute(@RequestBody RuteDto ruteDto)
            throws Exception {
        return ruteService.updateRute(ruteDto);
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<RuteDeleteResponse> deleteRute(@PathVariable Long id)
            throws Exception {
        return ruteService.deleteRute(id);
    }

}

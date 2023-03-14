package pe.com.huex.operationsCosts.api;

import org.springframework.web.bind.annotation.*;

import pe.com.huex.operationsCosts.domain.service.ITollService;
import pe.com.huex.operationsCosts.services.resources.dto.TollDto;
import pe.com.huex.operationsCosts.services.resources.response.TollListReponse;
import pe.com.huex.operationsCosts.services.resources.response.TollResponse;
import pe.com.huex.util.ResponseDto;

@RestController
@RequestMapping("tolls")
public class TollController {

    private final ITollService tollService;


    public TollController(ITollService tollService) {
        this.tollService = tollService;
    }

    @GetMapping
    public ResponseDto<TollListReponse> listToll() throws Exception {
        return tollService.tollList();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<TollResponse> retrieveToll(@PathVariable Long id) throws Exception {
        return tollService.retrieveToll(id);
    }

    @PostMapping
    public ResponseDto<TollResponse> registerToll(@RequestBody TollDto tollDto) throws Exception {
        return tollService.registerToll(tollDto);
    }

    @PutMapping
    public ResponseDto<TollResponse> updateToll(@RequestBody TollDto tollDto)
            throws Exception {
        return tollService.updateToll(tollDto);
    }

    @DeleteMapping(path = "{id}")
    public ResponseDto<TollResponse> deleteToll(@PathVariable Long id)
            throws Exception {
        return tollService.deleteToll(id);
    }

}

package pe.com.huex.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.com.huex.customer.domain.service.IRateService;
import pe.com.huex.customer.services.resources.dto.RateDto;
import pe.com.huex.customer.services.resources.response.RateListResponse;
import pe.com.huex.customer.services.resources.response.RateResponse;
import pe.com.huex.util.ResponseDto;

@RestController
@RequestMapping("rates")
public class RateController {

    @Autowired
    IRateService rateService;

    @GetMapping
    public ResponseDto<RateListResponse> listRate() throws Exception {
        return rateService.listRate();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<RateResponse> retrieveRate(@PathVariable Long id) throws Exception {
        return rateService.retrieveRate(id);
    }

    @PostMapping
    public ResponseDto<RateResponse> registerRate(@RequestBody RateDto rateDto) throws Exception {
        return rateService.registerRate(rateDto);
    }

    @PutMapping
    public ResponseDto<RateResponse> updateRate(@RequestBody RateDto rateDto)
            throws Exception {
        return rateService.updateRate(rateDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteRate(@PathVariable Long id) {
        return rateService.deleteRate(id);
    }

}

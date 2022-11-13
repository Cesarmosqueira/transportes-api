package pe.com.huex.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.customer.domain.service.IRateService;
import pe.com.huex.customer.services.resources.dto.RateDto;
import pe.com.huex.customer.services.resources.response.RateListResponse;
import pe.com.huex.customer.services.resources.response.RateRegisterResponse;
import pe.com.huex.customer.services.resources.response.RateRetrieveResponse;
import pe.com.huex.customer.services.resources.response.RateUpdateResponse;
import pe.com.huex.dto.Response.ResponseDto;

@CrossOrigin(origins = "*")
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
    public ResponseDto<RateRetrieveResponse> retrieveRate(@PathVariable Long id) throws Exception {
        return rateService.retrieveRate(id);
    }

    @PostMapping
    public ResponseDto<RateRegisterResponse> registerRate(@RequestBody RateDto rateDto) throws Exception {
        return rateService.registerRate(rateDto);
    }

    @PutMapping
    public ResponseDto<RateUpdateResponse> updateRate(@RequestBody RateDto rateDto)
            throws Exception {
        return rateService.updateRate(rateDto);
    }

}

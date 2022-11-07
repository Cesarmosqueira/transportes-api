package pe.com.huex.customers.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.customers.domain.model.entity.Rate;
import pe.com.huex.customers.domain.service.IRateService;
import pe.com.huex.customers.service.RateServiceImpl;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.customers.service.resources.response.*;
import pe.com.huex.dto.Response.ResponseDto;

import java.util.List;

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

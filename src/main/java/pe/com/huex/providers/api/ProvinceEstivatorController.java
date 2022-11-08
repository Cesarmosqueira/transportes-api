package pe.com.huex.providers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.domain.model.entity.ProvinceEstivators;
import pe.com.huex.providers.domain.service.IProvinceEstivatorService;
import pe.com.huex.providers.service.ProvinceEstivatorService;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;
import pe.com.huex.providers.service.resouces.response.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("provinceEstivators")
public class ProvinceEstivatorController {

    @Autowired
    IProvinceEstivatorService provinceEstivatorService;

    @GetMapping
    public ResponseDto<ProvinceEstivatorListResponse> listProvinceEstivator() throws Exception {
        return provinceEstivatorService.listProvinceEstivator();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<ProvinceEstivatorRetrieveResponse> retrieveProvinceEstivator(@PathVariable Long id) throws Exception {
        return provinceEstivatorService.retrieveProvinceEstivator(id);
    }

    @PostMapping
    public ResponseDto<ProvinceEstivatorRegisterResponse> registerProvinceEstivator(@RequestBody ProvinceEstivatorDto provinceEstivatorDto) throws Exception {
        return provinceEstivatorService.registerProvinceEstivator(provinceEstivatorDto);
    }

    @PutMapping
    public ResponseDto<ProvinceEstivatorUpdateResponse> updateProvinceEstivator(@RequestBody ProvinceEstivatorDto provinceEstivatorDto)
            throws Exception {
        return provinceEstivatorService.updateProvinceEstivator(provinceEstivatorDto);
    }


}

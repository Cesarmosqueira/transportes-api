package pe.com.huex.providers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.domain.service.IProvinceEstivatorService;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;
import pe.com.huex.providers.service.resouces.response.ProvinceEstivatorListResponse;
import pe.com.huex.providers.service.resouces.response.ProvinceEstivatorResponse;

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
    public ResponseDto<ProvinceEstivatorResponse> retrieveProvinceEstivator(@PathVariable Long id)
            throws Exception {
        return provinceEstivatorService.retrieveProvinceEstivator(id);
    }

    @PostMapping
    public ResponseDto<ProvinceEstivatorResponse> registerProvinceEstivator(
            @RequestBody ProvinceEstivatorDto provinceEstivatorDto) throws Exception {
        return provinceEstivatorService.registerProvinceEstivator(provinceEstivatorDto);
    }

    @PutMapping
    public ResponseDto<ProvinceEstivatorResponse> updateProvinceEstivator(
            @RequestBody ProvinceEstivatorDto provinceEstivatorDto)
            throws Exception {
        return provinceEstivatorService.updateProvinceEstivator(provinceEstivatorDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteProvinceEstivator(@PathVariable Long id) {
        return provinceEstivatorService.deleteProvinceEstivator(id);
    }

}

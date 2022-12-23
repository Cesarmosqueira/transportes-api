package pe.com.huex.providers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.domain.service.IProvinceEstivatorService;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;
import pe.com.huex.providers.service.resouces.response.ProvinceEstivatorListResponse;
import pe.com.huex.providers.service.resouces.response.ProvinceEstivatorResponse;

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

}

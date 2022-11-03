package pe.com.huex.providers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.providers.domain.model.entity.ProvinceEstivators;
import pe.com.huex.providers.service.ProvinceEstivatorService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("provinceEstivators")
public class ProvinceEstivatorController {

    @Autowired
    ProvinceEstivatorService provinceEstivatorService;

    @PostMapping
    public ResponseEntity<ProvinceEstivators> registerProvinceEstivators(
            @Validated @RequestBody ProvinceEstivators provinceEstivators)
            throws Exception {
        provinceEstivators = provinceEstivatorService.createProvinceEstivators(provinceEstivators);
        return new ResponseEntity<>(provinceEstivators, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProvinceEstivators> retrieveProvinceEstivators(@PathVariable Long id) throws Exception {
        ProvinceEstivators provinceEstivators = provinceEstivatorService.getProvinceEstivators(id);
        return new ResponseEntity<>(provinceEstivators, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProvinceEstivators>> listProvinceEstivators() throws Exception {
        List<ProvinceEstivators> provinceEstivators = provinceEstivatorService.listProvinceEstivators();
        return new ResponseEntity<>(provinceEstivators, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProvinceEstivators> updateProvinceEstivators(
            @PathVariable Long id, @Validated @RequestBody ProvinceEstivators provinceEstivators)
            throws Exception {
        ProvinceEstivators updated = provinceEstivatorService.updateProvinceEstivators(id, provinceEstivators);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}

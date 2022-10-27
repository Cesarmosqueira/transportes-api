package pe.com.huex.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.entities.Rate;
import pe.com.huex.entities.Rute;
import pe.com.huex.services.RateService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("rates")
public class RateController {

    @Autowired
    RateService rateService;

    @PostMapping
    public ResponseEntity<Rate> registerRate(@Validated @RequestBody Rate rate)
            throws Exception {
        rate = rateService.createRate(rate);
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Rate> retrieveRate(@PathVariable Long id) throws Exception {
        Rate rate = rateService.getRate(id);
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Rate>> listRates() throws Exception {
        List<Rate> rates = rateService.listRate();
        return new ResponseEntity<>(rates, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Rate> updateRute(@PathVariable Long id, @Validated @RequestBody Rate rate)
            throws Exception {
        Rate updated = rateService.updateRate(id, rate);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}

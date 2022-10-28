package pe.com.huex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.entities.Employee;
import pe.com.huex.entities.Rute;
import pe.com.huex.services.RuteService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("rutes")
public class RuteController {

    @Autowired
    RuteService ruteService;

    @PostMapping
    public ResponseEntity<Rute> registerRute(@Validated @RequestBody Rute rute)
            throws Exception {
        rute = ruteService.createRute(rute);
        return new ResponseEntity<>(rute, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Rute> retrieveRute(@PathVariable Long id) throws Exception {
        Rute rute = ruteService.getRute(id);
        return new ResponseEntity<>(rute, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Rute>> listRutes() throws Exception {
        List<Rute> rutes = ruteService.listRute();
        return new ResponseEntity<>(rutes, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Rute> updateRute(@PathVariable Long id, @Validated @RequestBody Rute rute)
            throws Exception {
        Rute updated = ruteService.updateRute(id, rute);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}

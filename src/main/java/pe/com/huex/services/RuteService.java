package pe.com.huex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import pe.com.huex.entities.Employee;
import pe.com.huex.entities.Rute;
import pe.com.huex.repositories.RuteRepository;

import java.util.List;

@Service
public class RuteService {

    @Autowired
    RuteRepository ruteRepository;

    public Rute createRute(Rute rute) throws Exception {
        return ruteRepository.save(rute);
    }

    public Rute getRute(Long id) throws Exception {
        return ruteRepository.findById(id)
                .orElseThrow(() -> new Exception("ruta '" + id + "' no existe en la base de datos"));
    }
    public List<Rute> listRute() {

        return ruteRepository.findAll();
    }

    public Rute updateRute(Long id, Rute rute) throws Exception {
        ruteRepository.findById(id)
                .orElseThrow(() -> new Exception("ruta '" + id + "' no existe en la base de datos"));

        rute.setId(id);
        return ruteRepository.save(rute);
    }

}
package pe.com.huex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.entities.ProvinceEstivators;
import pe.com.huex.entities.Rute;
import pe.com.huex.repositories.ProvinceEstivatorRepository;

import java.util.List;

@Service
public class ProvinceEstivatorService {

    @Autowired
    ProvinceEstivatorRepository provinceEstivatorRepository;

    public ProvinceEstivators createProvinceEstivators(ProvinceEstivators provinceEstivators) throws Exception {
        return provinceEstivatorRepository.save(provinceEstivators);
    }

    public ProvinceEstivators getProvinceEstivators(Long id) throws Exception {
        return provinceEstivatorRepository.findById(id)
                .orElseThrow(() -> new Exception("Estivador '" + id + "' no existe en la base de datos"));
    }
    public List<ProvinceEstivators> listProvinceEstivators() {

        return provinceEstivatorRepository.findAll();
    }

    public ProvinceEstivators updateProvinceEstivators(Long id, ProvinceEstivators provinceEstivators) throws Exception {
        provinceEstivatorRepository.findById(id)
                .orElseThrow(() -> new Exception("estivadores '" + id + "' no existe en la base de datos"));

        provinceEstivators.setId(id);
        return provinceEstivatorRepository.save(provinceEstivators);
    }
}

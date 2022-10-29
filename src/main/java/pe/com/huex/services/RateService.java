package pe.com.huex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.entities.Rate;
import pe.com.huex.entities.Rute;
import pe.com.huex.repositories.RateRepository;

import java.util.List;

@Service
public class RateService {

    @Autowired
    RateRepository rateRepository;

    public Rate createRate(Rate rate) throws Exception {
        return rateRepository.save(rate);
    }

    public Rate getRate(Long id) throws Exception {
        return rateRepository.findById(id)
                .orElseThrow(() -> new Exception("tarifa '" + id + "' no existe en la base de datos"));
    }

    public List<Rate> listRate() {

        return rateRepository.findAll();
    }

    public Rate updateRate(Long id, Rate rate) throws Exception {
        rateRepository.findById(id)
                .orElseThrow(() -> new Exception("tarifa '" + id + "' no existe en la base de datos"));

        rate.setId(id);
        return rateRepository.save(rate);
    }
}
package pe.com.huex.customer.services;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.customer.domain.persistence.RateRepository;
import pe.com.huex.customer.domain.service.IRateService;
import pe.com.huex.customer.mapping.RateMapping;
import pe.com.huex.customer.services.resources.dto.RateDto;
import pe.com.huex.customer.services.resources.response.RateListResponse;
import pe.com.huex.customer.services.resources.response.RateResponse;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class RateServiceImpl implements IRateService {

    private static final String MESSAGE_INQUIRY_RATE_SUCCESS = "La consulta de tarifas fue exitoso";
    private static final String MESSAGE_INQUIRY_RATE_WARN = "No se encontró ningúna tarifa registrado";

    private static final String MESSAGE_REGISTER_RATE_SUCCESS = "El registro de tarifa fue exitoso";
    private static final String MESSAGE_REGISTER_RATE_WARN = "Ocurrió un error al registrar la tarifa";

    private static final String MESSAGE_UPDATE_RATE_SUCCESS = "La actualización de datos de la tarifa fue exitoso";
    private static final String MESSAGE_UPDATE_RATE_WARN = "Ocurrió un error al actualizar los datos de la tarifa";

    private static final String MESSAGE_RETRIEVE_RATE_SUCCESS = "La consulta de tarifa fue exitoso";
    private static final String MESSAGE_RETRIEVE_RATE_WARN = "No se encontró los datos de la tarifa";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    RateRepository rateRepository;

    @Autowired
    RateMapping rateMapping;

    @Override
    public ResponseDto<RateListResponse> listRate() {
        ResponseDto<RateListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<Rate> rateList = rateRepository.findAll();

            if (rateList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_RATE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_RATE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(rateList.size()));
            response.setDatos(new RateListResponse().rates(rateMapping.modelList(rateList)));

        } catch (Exception ex) {
            log.error("error al consultar tarifas" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RateResponse> retrieveRate(Long id) {
        ResponseDto<RateResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Rate> rateList = rateRepository.findById(id);

            if (rateList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_RATE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_RATE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new RateResponse().rate(rateMapping.modelDto(rateList.get())));

        } catch (Exception ex) {
            log.error("error al consultar tarifa" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RateResponse> registerRate(RateDto rateDto) {
        ResponseDto<RateResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            Rate rateResponse = rateRepository.save(rateMapping.model(rateDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_RATE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RateResponse().rate(rateMapping.modelDto(rateResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_RATE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RateResponse> updateRate(RateDto rateDto) {
        ResponseDto<RateResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Rate> rateResponse = rateRepository.findById(rateDto.getId());

            if (rateResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_RATE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            rateRepository.save(rateMapping.model(rateDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_RATE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RateResponse().rate(rateDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_RATE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteRate(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            rateRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_RATE_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_RATE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

}

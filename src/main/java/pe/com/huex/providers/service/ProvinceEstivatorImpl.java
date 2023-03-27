package pe.com.huex.providers.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.domain.model.entity.ProvinceEstivators;
import pe.com.huex.providers.domain.persistence.IProvinceEstivatorRepository;
import pe.com.huex.providers.domain.service.IProvinceEstivatorService;
import pe.com.huex.providers.mapping.ProvinceEstivatorMapping;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;
import pe.com.huex.providers.service.resouces.response.*;
import pe.com.huex.util.MetaDatosUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class ProvinceEstivatorImpl implements IProvinceEstivatorService {

    private static final String MESSAGE_INQUIRY_PROVINCE_ESTIVATOR_SUCCESS = "La consulta de estivador provincia fue exitoso";
    private static final String MESSAGE_INQUIRY_PROVINCE_ESTIVATOR_WARN = "No se encontró ningún estivador provincia registrado";

    private static final String MESSAGE_REGISTER_PROVINCE_ESTIVATOR_SUCCESS = "El registro del estivador provincia fue exitoso";
    private static final String MESSAGE_REGISTER_PROVINCE_ESTIVATOR_WARN = "Ocurrió un error al registrar al estivador provincia";

    private static final String MESSAGE_UPDATE_PROVINCE_ESTIVATOR_SUCCESS = "La actualización de datos del estivador provincia fue exitoso";
    private static final String MESSAGE_UPDATE_PROVINCE_ESTIVATOR_WARN = "Ocurrió un error al actualizar los datos del estivador provincia";

    private static final String MESSAGE_RETRIEVE_PROVINCE_ESTIVATOR_SUCCESS = "La consulta del estivador provincia fue exitoso";
    private static final String MESSAGE_RETRIEVE_PROVINCE_ESTIVATOR_WARN = "No se encontró los datos del estivador provincia";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    IProvinceEstivatorRepository IProvinceEstivatorRepository;

    @Autowired
    ProvinceEstivatorMapping provinceEstivatorMapping;

    @Override
    public ResponseDto<ProvinceEstivatorListResponse> listProvinceEstivator() {
        ResponseDto<ProvinceEstivatorListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<ProvinceEstivators> provinceEstivatorsList = IProvinceEstivatorRepository.findAll();

            if (provinceEstivatorsList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_PROVINCE_ESTIVATOR_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_PROVINCE_ESTIVATOR_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(provinceEstivatorsList.size()));
            response.setDatos(new ProvinceEstivatorListResponse()
                    .provinceEstivatorListResponse(provinceEstivatorMapping.modelList(provinceEstivatorsList)));

        } catch (Exception ex) {
            log.error("error al consultar estivador provincia" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ProvinceEstivatorResponse> retrieveProvinceEstivator(Long id) {
        ResponseDto<ProvinceEstivatorResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ProvinceEstivators> provinceEstivatorsList = IProvinceEstivatorRepository.findById(id);

            if (provinceEstivatorsList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_PROVINCE_ESTIVATOR_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_PROVINCE_ESTIVATOR_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new ProvinceEstivatorResponse().provinceEstivator(
                    provinceEstivatorMapping.modelDto(provinceEstivatorsList.get())));

        } catch (Exception ex) {
            log.error("error al consultar estivador provincia" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ProvinceEstivatorResponse> registerProvinceEstivator(ProvinceEstivatorDto provinceEstivatorDto) {

        ResponseDto<ProvinceEstivatorResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            ProvinceEstivators provinceEstivatorsResponse = IProvinceEstivatorRepository.save(provinceEstivatorMapping.model(provinceEstivatorDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_PROVINCE_ESTIVATOR_SUCCESS, INFO, idTransaccion));
            response.setDatos(new ProvinceEstivatorResponse().provinceEstivator(provinceEstivatorMapping.modelDto(provinceEstivatorsResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_PROVINCE_ESTIVATOR_WARN + ": " + ex);
            throw ex;
        }
        return response;
    }

    @Override
    public ResponseDto<ProvinceEstivatorResponse> updateProvinceEstivator(
            ProvinceEstivatorDto provinceEstivatorDto) {
        ResponseDto<ProvinceEstivatorResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ProvinceEstivators> provinceEstivatorsResponse = IProvinceEstivatorRepository
                    .findById(provinceEstivatorDto.getId());

            if (provinceEstivatorsResponse.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_PROVINCE_ESTIVATOR_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            IProvinceEstivatorRepository.save(provinceEstivatorMapping.model(provinceEstivatorDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_PROVINCE_ESTIVATOR_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(
                    new ProvinceEstivatorResponse().provinceEstivator(provinceEstivatorDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_PROVINCE_ESTIVATOR_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteProvinceEstivator(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            IProvinceEstivatorRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_PROVINCE_ESTIVATOR_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_PROVINCE_ESTIVATOR_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

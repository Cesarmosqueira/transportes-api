package pe.com.huex.providers.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.domain.model.entity.TireReplacement;
import pe.com.huex.providers.domain.persistence.TireReplacementRepository;
import pe.com.huex.providers.domain.service.ITireReplacementService;
import pe.com.huex.providers.mapping.TireReplacementMapping;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;
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
public class TireReplacementImpl implements ITireReplacementService {

    private static final String MESSAGE_INQUIRY_TIRE_REPLACEMENT_SUCCESS = "La consulta de reposicion llanta fue exitoso";
    private static final String MESSAGE_INQUIRY_TIRE_REPLACEMENT_WARN = "No se encontró ningún reposicion llanta registrado";

    private static final String MESSAGE_REGISTER_TIRE_REPLACEMENT_SUCCESS = "El registro de reposicion llanta fue exitoso";
    private static final String MESSAGE_REGISTER_TIRE_REPLACEMENT_WARN = "Ocurrió un error al registrar al reposicion llanta";

    private static final String MESSAGE_UPDATE_TIRE_REPLACEMENT_SUCCESS = "La actualización de datos del reposicion llanta fue exitoso";
    private static final String MESSAGE_UPDATE_TIRE_REPLACEMENT_WARN = "Ocurrió un error al actualizar los datos del reposicion llanta";

    private static final String MESSAGE_RETRIEVE_TIRE_REPLACEMENT_SUCCESS = "La consulta del reposicion llanta fue exitoso";
    private static final String MESSAGE_RETRIEVE_TIRE_REPLACEMENT_WARN = "No se encontró los datos del reposicion llanta";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final TireReplacementMapping tireReplacementMapping;

    private final TireReplacementRepository tireReplacementRepository;

    public TireReplacementImpl(TireReplacementMapping tireReplacementMapping,
            TireReplacementRepository tireReplacementRepository) {
        this.tireReplacementMapping = tireReplacementMapping;
        this.tireReplacementRepository = tireReplacementRepository;
    }

    @Override
    public ResponseDto<TireReplacementListResponse> listTireReplacement() {
        ResponseDto<TireReplacementListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<TireReplacement> tireReplacementList = tireReplacementRepository.findAll();

            if (tireReplacementList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_TIRE_REPLACEMENT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_TIRE_REPLACEMENT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(tireReplacementList.size()));
            response.setDatos(new TireReplacementListResponse()
                    .tireReplacementListResponse(tireReplacementMapping.modelList(tireReplacementList)));

        } catch (Exception ex) {
            log.error("error al consultar reposicion llanta " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TireReplacementResponse> retrieveTireReplacement(Long id) {
        ResponseDto<TireReplacementResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<TireReplacement> tireReplacementList = tireReplacementRepository.findById(id);

            if (tireReplacementList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TIRE_REPLACEMENT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_TIRE_REPLACEMENT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new TireReplacementResponse()
                    .tireReplacement(tireReplacementMapping.modelDto(tireReplacementList.get())));

        } catch (Exception ex) {
            log.error("error al consultar reposicion llanta provincia" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TireReplacementResponse> registerTireReplacement(TireReplacementDto tireReplacementDto) {
        ResponseDto<TireReplacementResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            TireReplacement tireReplacementResponse = tireReplacementRepository
                    .save(tireReplacementMapping.model(tireReplacementDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_TIRE_REPLACEMENT_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new TireReplacementResponse()
                    .tireReplacement(tireReplacementMapping.modelDto(tireReplacementResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_TIRE_REPLACEMENT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TireReplacementResponse> updateTireReplacement(TireReplacementDto tireReplacementDto) {
        ResponseDto<TireReplacementResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<TireReplacement> tireReplacementResponse = tireReplacementRepository
                    .findById(tireReplacementDto.getId());

            if (tireReplacementResponse.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TIRE_REPLACEMENT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            tireReplacementRepository.save(tireReplacementMapping.model(tireReplacementDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_TIRE_REPLACEMENT_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new TireReplacementResponse().tireReplacement(tireReplacementDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_TIRE_REPLACEMENT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteTireReplacement(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            tireReplacementRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_TIRE_REPLACEMENT_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_TIRE_REPLACEMENT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

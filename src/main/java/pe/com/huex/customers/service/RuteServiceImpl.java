package pe.com.huex.customers.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.customers.domain.model.entity.Rute;
import pe.com.huex.customers.domain.persistence.RuteRepository;
import pe.com.huex.customers.domain.service.IRuteService;
import pe.com.huex.customers.mapping.RuteMapping;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.customers.service.resources.response.*;
import pe.com.huex.dto.Response.ResponseDto;

import pe.com.huex.util.MetaDatosUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class RuteServiceImpl implements IRuteService {



    private static final String MESSAGE_INQUIRY_RUTE_SUCCESS = "La consulta de rutas fue exitoso";
    private static final String MESSAGE_INQUIRY_RUTE_WARN = "No se encontró ningúna ruta registrado";

    private static final String MESSAGE_REGISTER_RUTE_SUCCESS = "El registro de ruta fue exitoso";
    private static final String MESSAGE_REGISTER_RUTE_WARN = "Ocurrió un error al registrar la ruta";

    private static final String MESSAGE_UPDATE_RUTE_SUCCESS = "La actualización de datos de la ruta fue exitoso";
    private static final String MESSAGE_UPDATE_RUTE_WARN = "Ocurrió un error al actualizar los datos de la ruta";

    private static final String MESSAGE_RETRIEVE_RUTE_SUCCESS = "La consulta de ruta fue exitoso";
    private static final String MESSAGE_RETRIEVE_RUTE_WARN = "No se encontró los datos de la ruta";

    private static final String MESSAGE_DELETE_RUTE_SUCCESS = "La eliminación de la ruta fue exitosa";
    private static final String MESSAGE_DELETE_RUTE_WARN = "Ocurrió un error al eliminar la ruta";


    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    RuteRepository ruteRepository;
    @Autowired
    RuteMapping ruteMapping;


    @Override
    public ResponseDto<RuteListResponse> listRute() {
        ResponseDto<RuteListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<Rute> ruteList = ruteRepository.findAll();

            if (ruteList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_RUTE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_RUTE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(ruteList.size()));
            response.setDatos(new RuteListResponse().ruteListResponse(ruteMapping.modelList(ruteList)));

        } catch (Exception ex) {
            log.error("error al consultar rutas" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RuteRetrieveResponse> retrieveRute(Long id) {
        ResponseDto<RuteRetrieveResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Rute> ruteList = ruteRepository.findById(id);

            if (ruteList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_RUTE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_RUTE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new RuteRetrieveResponse().ruteRetrieveResponse(ruteMapping.modelDto(ruteList.get())));

        } catch (Exception ex) {
            log.error("error al consultar ruta" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RuteRegisterResponse> registerRute(RuteDto ruteDto) {

        ResponseDto<RuteRegisterResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            Rute ruteResponse = ruteRepository.save(ruteMapping.model(ruteDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_RUTE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RuteRegisterResponse().ruteRegisterResponse(ruteMapping.modelDto(ruteResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_RUTE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RuteUpdateResponse> updateRute(RuteDto ruteDto) {

        ResponseDto<RuteUpdateResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Rute> ruteResponse = ruteRepository.findById(ruteDto.getId());

            if (ruteResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_RUTE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            ruteRepository.save(ruteMapping.model(ruteDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_RUTE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RuteUpdateResponse().ruteUpdateResponse(ruteDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_RUTE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RuteDeleteResponse> deleteRute(Long id) {
        ResponseDto<RuteDeleteResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Rute> ruteResponse = ruteRepository.findById(id);

            if (ruteResponse.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_DELETE_RUTE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            ruteRepository.deleteById(id);
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_RUTE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RuteDeleteResponse().ruteDeleteResponse(id));

        } catch (Exception ex) {
            log.error("error al actualizar ruta: " + ex);
            throw ex;
        }

        return response;
    }
}

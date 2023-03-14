package pe.com.huex.operationsCosts.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.services.resources.response.CustomerListResponse;
import pe.com.huex.customer.services.resources.response.CustomerResponse;
import pe.com.huex.operationsCosts.domain.entities.Toll;
import pe.com.huex.operationsCosts.domain.persistence.TollRepository;
import pe.com.huex.operationsCosts.domain.service.ITollService;
import pe.com.huex.operationsCosts.mapping.TollMapping;
import pe.com.huex.operationsCosts.services.resources.dto.TollDto;
import pe.com.huex.operationsCosts.services.resources.response.TollListReponse;
import pe.com.huex.operationsCosts.services.resources.response.TollResponse;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class ITollServiceImpl implements ITollService {


    private static final String MESSAGE_INQUIRY_TOLL_SUCCESS = "La consulta de peajes fue exitoso";
    private static final String MESSAGE_INQUIRY_TOLL_WARN = "No se encontró ningún peaje registrado";

    private static final String MESSAGE_REGISTER_TOLL_SUCCESS = "El registro de peaje fue exitoso";
    private static final String MESSAGE_REGISTER_TOLL_WARN = "Ocurrió un error al registrar el peaje";

    private static final String MESSAGE_UPDATE_TOLL_SUCCESS = "La actualización de datos de peaje fue exitoso";
    private static final String MESSAGE_UPDATE_TOLL_WARN = "Ocurrió un error al actualizar los datos de el peaje";

    private static final String MESSAGE_RETRIEVE_TOLL_SUCCESS = "La consulta de peaje fue exitoso";
    private static final String MESSAGE_RETRIEVE_TOLL_WARN = "No se encontró los datos de el peaje";

    private static final String MESSAGE_DELETE_TOLL_SUCCESS = "La eliminación de el peaje fue exitosa";
    private static final String MESSAGE_DELETE_TOLL_WARN = "Ocurrió un error al eliminar el peaje";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final TollRepository tollRepository;

    private final TollMapping tollMapping;

    public ITollServiceImpl(TollRepository tollRepository, TollMapping tollMapping) {
        this.tollRepository = tollRepository;
        this.tollMapping = tollMapping;
    }


    @Override
    public ResponseDto<TollListReponse> tollList() {
        ResponseDto<TollListReponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<Toll> tollList = tollRepository.findAll();

            if (tollList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_TOLL_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_TOLL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(tollList.size()));
            response.setDatos(new TollListReponse().toll(tollMapping.modelList(tollList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_TOLL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TollResponse> retrieveToll(Long id) {

        ResponseDto<TollResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Toll> tollList = tollRepository.findById(id);

            if (tollList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TOLL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_TOLL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new TollResponse().toll(tollMapping.modelDto(tollList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_TOLL_WARN+": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TollResponse> registerToll(TollDto tollDto) {
        ResponseDto<TollResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            Toll tollResponse = tollRepository.save(tollMapping.model(tollDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_TOLL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new TollResponse().toll(tollMapping.modelDto(tollResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_TOLL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TollResponse> updateToll(TollDto tollDto) {
        ResponseDto<TollResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Toll> tollResponse = tollRepository.findById(tollDto.getId());

            if (tollResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TOLL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            tollRepository.save(tollMapping.model(tollDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_TOLL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new TollResponse().toll(tollDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_TOLL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteToll(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            tollRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_TOLL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TOLL_WARN + ": " + ex);
            throw ex;
        }
        return response;
    }
}

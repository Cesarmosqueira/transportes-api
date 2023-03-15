package pe.com.huex.operationsCosts.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.operationsCosts.domain.entities.RouteToll;
import pe.com.huex.operationsCosts.domain.entities.Toll;
import pe.com.huex.operationsCosts.domain.persistence.RouteTollRepository;
import pe.com.huex.operationsCosts.domain.service.IRouteTollService;
import pe.com.huex.operationsCosts.mapping.RouteTollMapping;
import pe.com.huex.operationsCosts.services.resources.dto.RouteTollDto;
import pe.com.huex.operationsCosts.services.resources.response.RouteTollListResponse;
import pe.com.huex.operationsCosts.services.resources.response.RouteTollResponse;
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
public class IRouteTollServiceImpl implements IRouteTollService {

    private static final String MESSAGE_INQUIRY_ROUTE_TOLL_SUCCESS = "La consulta de ruta peajes fue exitoso";
    private static final String MESSAGE_INQUIRY_ROUTE_TOLL_WARN = "No se encontró ningúna ruta peaje registrado";

    private static final String MESSAGE_REGISTER_ROUTE_TOLL_SUCCESS = "El registro de ruta peaje fue exitoso";
    private static final String MESSAGE_REGISTER_ROUTE_TOLL_WARN = "Ocurrió un error al registrar el ruta peaje";

    private static final String MESSAGE_UPDATE_ROUTE_TOLL_SUCCESS = "La actualización de datos de ruta peaje fue exitoso";
    private static final String MESSAGE_UPDATE_ROUTE_TOLL_WARN = "Ocurrió un error al actualizar los datos de  ruta peaje";

    private static final String MESSAGE_RETRIEVE_ROUTE_TOLL_SUCCESS = "La consulta de ruta peaje fue exitoso";
    private static final String MESSAGE_RETRIEVE_ROUTE_TOLL_WARN = "No se encontró los datos de ruta peaje";

    private static final String MESSAGE_DELETE_ROUTE_TOLL_SUCCESS = "La eliminación de  ruta peaje fue exitosa";
    private static final String MESSAGE_DELETE_ROUTE_TOLL_WARN = "Ocurrió un error al eliminar  ruta peaje";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final RouteTollRepository routeTollRepository;
    private final RouteTollMapping routeTollMapping;

    public IRouteTollServiceImpl(RouteTollRepository routeTollRepository, RouteTollMapping routeTollMapping) {
        this.routeTollRepository = routeTollRepository;
        this.routeTollMapping = routeTollMapping;
    }


    @Override
    public ResponseDto<RouteTollListResponse> RouteTollList() {
        ResponseDto<RouteTollListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<RouteToll> routeTollList = routeTollRepository.findAll();

            if (routeTollList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_ROUTE_TOLL_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_ROUTE_TOLL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(routeTollList.size()));
            response.setDatos(new RouteTollListResponse().routeToll(routeTollMapping.modelList(routeTollList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_ROUTE_TOLL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RouteTollResponse> retrieveRouteToll(Long id) {

        ResponseDto<RouteTollResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<RouteToll> routeTollList = routeTollRepository.findById(id);

            if (routeTollList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_ROUTE_TOLL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_ROUTE_TOLL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new RouteTollResponse().routeToll(routeTollMapping.modelDto(routeTollList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_ROUTE_TOLL_WARN+": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RouteTollResponse> registerRouteToll(RouteTollDto routeTollDto) {

        ResponseDto<RouteTollResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            RouteToll routeTollResponse = routeTollRepository.save(routeTollMapping.model(routeTollDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_ROUTE_TOLL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RouteTollResponse().routeToll(routeTollMapping.modelDto(routeTollResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_ROUTE_TOLL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RouteTollResponse> updateRouteToll(RouteTollDto routeTollDto) {
        ResponseDto<RouteTollResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<RouteToll> routeTollResponse = routeTollRepository.findById(routeTollDto.getId());

            if (routeTollResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_ROUTE_TOLL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            routeTollRepository.save(routeTollMapping.model(routeTollDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_ROUTE_TOLL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RouteTollResponse().routeToll(routeTollDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_ROUTE_TOLL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteRouteToll(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            routeTollRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_ROUTE_TOLL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_ROUTE_TOLL_WARN + ": " + ex);
            throw ex;
        }
        return response;
    }
}

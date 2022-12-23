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
import pe.com.huex.customer.domain.entities.Route;
import pe.com.huex.customer.domain.persistence.RouteRepository;
import pe.com.huex.customer.domain.service.IRouteService;
import pe.com.huex.customer.mapping.RouteMapping;
import pe.com.huex.customer.services.resources.dto.RouteDto;
import pe.com.huex.customer.services.resources.response.RouteDeleteResponse;
import pe.com.huex.customer.services.resources.response.RouteListResponse;
import pe.com.huex.customer.services.resources.response.RouteResponse;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class RouteServiceImpl implements IRouteService {

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
    RouteRepository routeRepository;
    @Autowired
    RouteMapping routeMapping;

    @Override
    public ResponseDto<RouteListResponse> listRoute() {
        ResponseDto<RouteListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<Route> routeList = routeRepository.findAll();

            if (routeList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_RUTE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_RUTE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(routeList.size()));
            response.setDatos(new RouteListResponse().routes(routeMapping.modelList(routeList)));

        } catch (Exception ex) {
            log.error("error al consultar rutas" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RouteResponse> retrieveRoute(Long id) {
        ResponseDto<RouteResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Route> routeList = routeRepository.findById(id);

            if (routeList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_RUTE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_RUTE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(
                    new RouteResponse().route(routeMapping.modelDto(routeList.get())));

        } catch (Exception ex) {
            log.error("error al consultar ruta" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RouteResponse> registerRoute(RouteDto routeDto) {

        ResponseDto<RouteResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            Route routeResponse = routeRepository.save(routeMapping.model(routeDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_RUTE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RouteResponse().route(routeMapping.modelDto(routeResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_RUTE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RouteResponse> updateRoute(RouteDto routeDto) {

        ResponseDto<RouteResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Route> routeResponse = routeRepository.findById(routeDto.getId());

            if (routeResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_RUTE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            routeRepository.save(routeMapping.model(routeDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_RUTE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RouteResponse().route(routeDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_RUTE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<RouteDeleteResponse> deleteRoute(Long id) {
        ResponseDto<RouteDeleteResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Route> routeResponse = routeRepository.findById(id);

            if (routeResponse.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_DELETE_RUTE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            routeRepository.deleteById(id);
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_RUTE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new RouteDeleteResponse().routeDeleteResponse(id));

        } catch (Exception ex) {
            log.error("error al actualizar ruta: " + ex);
            throw ex;
        }

        return response;
    }
}

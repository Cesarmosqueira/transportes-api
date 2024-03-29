package pe.com.huex.services.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.mapping.ServiceIncidentsMapping;
import pe.com.huex.services.domain.entities.ServiceIncidents;
import pe.com.huex.services.domain.persistence.ServiceIncidentsRepository;
import pe.com.huex.services.domain.service.IServiceIncidentsService;
import pe.com.huex.services.service.resources.dto.ServiceIncidentsDto;
import pe.com.huex.services.service.resources.response.*;
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
public class ServiceIncidentsServiceImpl implements IServiceIncidentsService {


    private static final String MESSAGE_INQUIRY_SERVICE_INCIDENTS_SUCCESS = "La consulta de incidente servicio fue exitoso";
    private static final String MESSAGE_INQUIRY_SERVICE_INCIDENTS_WARN = "No se encontró ningún incidente servicio registrado";

    private static final String MESSAGE_REGISTER_SERVICE_INCIDENTS_SUCCESS = "El registro del incidente servicio fue exitoso";
    private static final String MESSAGE_REGISTER_SERVICE_INCIDENTS_WARN = "Ocurrió un error al registrar el incidente servicio";

    private static final String MESSAGE_UPDATE_SERVICE_INCIDENTS_SUCCESS = "La actualización de datos del incidente servicio fue exitoso";
    private static final String MESSAGE_UPDATE_SERVICE_INCIDENTS_WARN = "Ocurrió un error al actualizar los datos del incidente servicio";

    private static final String MESSAGE_RETRIEVE_SERVICE_INCIDENTS_SUCCESS = "La consulta del incidente servicio fue exitoso";
    private static final String MESSAGE_RETRIEVE_SERVICE_INCIDENTS_WARN = "No se encontró los datos del incidente servicio";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final ServiceIncidentsRepository serviceIncidentsRepository;

    private final ServiceIncidentsMapping serviceIncidentsMapping;

    public ServiceIncidentsServiceImpl(ServiceIncidentsRepository serviceIncidentsRepository, ServiceIncidentsMapping serviceIncidentsMapping) {
        this.serviceIncidentsRepository = serviceIncidentsRepository;
        this.serviceIncidentsMapping = serviceIncidentsMapping;
    }


    @Override
    public ResponseDto<ServiceIncidentListResponse> listServiceIncidents() {
        ResponseDto<ServiceIncidentListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<ServiceIncidents> serviceIncidentsList = serviceIncidentsRepository.listIncidentService();

            if (serviceIncidentsList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_SERVICE_INCIDENTS_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_SERVICE_INCIDENTS_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(serviceIncidentsList.size()));
            response.setDatos(new ServiceIncidentListResponse()
                    .serviceIncidentsList(serviceIncidentsMapping.modelList(serviceIncidentsList)));

        } catch (Exception ex) {
            log.error("error al consultar incidente servicio" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ServiceIncidentResponse> retrieveServiceIncidents(Long id) {
        ResponseDto<ServiceIncidentResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ServiceIncidents> serviceIncidentsList = serviceIncidentsRepository.findById(id);

            if (serviceIncidentsList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_SERVICE_INCIDENTS_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_SERVICE_INCIDENTS_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new ServiceIncidentResponse()
                    .serviceIncident(serviceIncidentsMapping.modelDto(serviceIncidentsList.get())));

        } catch (Exception ex) {
            log.error("error al consultar incidente servicio" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ServiceIncidentResponse> registerServiceIncidents(ServiceIncidentsDto serviceIncidentsDto) {
        ResponseDto<ServiceIncidentResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            ServiceIncidents serviceIncidentsResponse = serviceIncidentsRepository.save(serviceIncidentsMapping.model(serviceIncidentsDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_SERVICE_INCIDENTS_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new ServiceIncidentResponse()
                    .serviceIncident(serviceIncidentsMapping.modelDto(serviceIncidentsResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_SERVICE_INCIDENTS_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ServiceIncidentResponse> updateServiceIncidents(ServiceIncidentsDto serviceIncidentsDto) {
        ResponseDto<ServiceIncidentResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ServiceIncidents> serviceIncidentsResponse = serviceIncidentsRepository.findById(serviceIncidentsDto.getId());

            if (serviceIncidentsResponse.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_SERVICE_INCIDENTS_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            serviceIncidentsRepository.save(serviceIncidentsMapping.model(serviceIncidentsDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_SERVICE_INCIDENTS_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new ServiceIncidentResponse().serviceIncident(serviceIncidentsDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_SERVICE_INCIDENTS_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteServiceIncidents(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            serviceIncidentsRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_SERVICE_INCIDENTS_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_SERVICE_INCIDENTS_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ServiceIncidentListResponse> listServiceIncidentByIdTracking(Long id) {
        ResponseDto<ServiceIncidentListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<ServiceIncidents> serviceIncidentsList = serviceIncidentsRepository.findByIdTracking(id);

            if (serviceIncidentsList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_SERVICE_INCIDENTS_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_SERVICE_INCIDENTS_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(serviceIncidentsList.size()));
            response.setDatos(new ServiceIncidentListResponse()
                    .serviceIncidentsList(serviceIncidentsMapping.modelList(serviceIncidentsList)));

        } catch (Exception ex) {
            log.error("error al consultar incidente servicio" + ex);
            throw ex;
        }

        return response;
    }
}

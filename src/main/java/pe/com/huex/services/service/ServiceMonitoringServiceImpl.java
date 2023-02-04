package pe.com.huex.services.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.services.domain.entities.ServiceMonitoring;
import pe.com.huex.services.domain.persistence.IServiceMonitoringRepository;
import pe.com.huex.services.domain.service.IServiceMonitoringService;
import pe.com.huex.services.mapping.ServiceMonitoringMapping;
import pe.com.huex.services.service.resources.dto.ServiceMonitoringDto;
import pe.com.huex.services.service.resources.response.ServiceMonitoringListResponse;
import pe.com.huex.services.service.resources.response.ServiceMonitoringResponse;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.domain.entities.TruckFleet;
import pe.com.huex.vehicles.service.resources.response.TruckFleetListResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class ServiceMonitoringServiceImpl implements IServiceMonitoringService {

    private static final String MESSAGE_INQUIRY_SERVICESMONITORING_SUCCESS = "La consulta de camiones fue exitoso";
    private static final String MESSAGE_INQUIRY_SERVICESMONITORING_WARN = "No se encontró ningún camión registrado";

    private static final String MESSAGE_REGISTER_SERVICESMONITORING_SUCCESS = "El registro del camión fue exitoso";
    private static final String MESSAGE_REGISTER_SERVICESMONITORING_WARN = "Ocurrió un error al registrar el camión";

    private static final String MESSAGE_UPDATE_SERVICESMONITORING_SUCCESS = "La actualización de datos del camión fue exitoso";
    private static final String MESSAGE_UPDATE_SERVICESMONITORING_WARN = "Ocurrió un error al actualizar los datos del camión";

    private static final String MESSAGE_RETRIEVE_SERVICESMONITORING_SUCCESS = "La consulta del camión fue exitoso";
    private static final String MESSAGE_RETRIEVE_TSERVICESMONITORING_WARN = "No se encontró los datos del camión";


    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final IServiceMonitoringRepository serviceMonitoringRepository;

    private final ServiceMonitoringMapping serviceMonitoringMapping;

    public ServiceMonitoringServiceImpl(IServiceMonitoringRepository serviceMonitoringRepository, ServiceMonitoringMapping serviceMonitoringMapping) {
        this.serviceMonitoringRepository = serviceMonitoringRepository;
        this.serviceMonitoringMapping = serviceMonitoringMapping;
    }


    @Override
    public ResponseDto<ServiceMonitoringListResponse> listServiceMonitoring() {
        ResponseDto<ServiceMonitoringListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<ServiceMonitoring> serviceMonitoringList = serviceMonitoringRepository.findAll();

            if (serviceMonitoringList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_SERVICESMONITORING_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_SERVICESMONITORING_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(serviceMonitoringList.size()));
            response.setDatos(new ServiceMonitoringListResponse().serviceMonitoringList(serviceMonitoringMapping.modelList(serviceMonitoringList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_SERVICESMONITORING_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ServiceMonitoringResponse> retrieveServiceMonitoring(Long id) {
        ResponseDto<ServiceMonitoringResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ServiceMonitoring> serviceMonitoringList = serviceMonitoringRepository.findById(id);

            if (serviceMonitoringList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TSERVICESMONITORING_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_SERVICESMONITORING_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));
            response.setDatos(
                    new ServiceMonitoringResponse().serviceMonitoring(serviceMonitoringMapping.modelDto(serviceMonitoringList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TSERVICESMONITORING_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ServiceMonitoringResponse> registerServiceMonitoring(ServiceMonitoringDto serviceMonitoringDto) {
        ResponseDto<ServiceMonitoringResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            ServiceMonitoring serviceMonitoring = serviceMonitoringRepository.save(serviceMonitoringMapping.model(serviceMonitoringDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_SERVICESMONITORING_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new ServiceMonitoringResponse().serviceMonitoring(serviceMonitoringMapping.modelDto(serviceMonitoring)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_SERVICESMONITORING_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ServiceMonitoringResponse> updateServiceMonitoring(ServiceMonitoringDto serviceMonitoringDto) {
        ResponseDto<ServiceMonitoringResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ServiceMonitoring> serviceMonitoringList = serviceMonitoringRepository.findById(serviceMonitoringDto.getId());

            if (serviceMonitoringList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TSERVICESMONITORING_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            ServiceMonitoring serviceMonitoring = serviceMonitoringRepository.save(serviceMonitoringMapping.model(serviceMonitoringDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_SERVICESMONITORING_SUCCESS, INFO, idTransaccion));
            response.setDatos(new ServiceMonitoringResponse().serviceMonitoring(serviceMonitoringMapping.modelDto(serviceMonitoring)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_SERVICESMONITORING_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteServiceMonitoring(Long id) {

        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            serviceMonitoringRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_SERVICESMONITORING_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TSERVICESMONITORING_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ServiceMonitoringListResponse> listServiceMonitoringByIdTracking(Long id) {
        ResponseDto<ServiceMonitoringListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<ServiceMonitoring> serviceMonitoringList = serviceMonitoringRepository.findByIdTracking(id);

            if (serviceMonitoringList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_SERVICESMONITORING_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_SERVICESMONITORING_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(serviceMonitoringList.size()));
            response.setDatos(new ServiceMonitoringListResponse().serviceMonitoringList(serviceMonitoringMapping.modelList(serviceMonitoringList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_SERVICESMONITORING_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

}

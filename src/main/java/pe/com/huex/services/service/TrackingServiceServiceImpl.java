package pe.com.huex.services.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.mapping.ProviderMapping;
import pe.com.huex.services.domain.model.entity.TrackingService;
import pe.com.huex.services.domain.persistence.ITrackingServiceRepository;
import pe.com.huex.services.domain.service.ITrackingServiceService;
import pe.com.huex.services.mapping.TrackingServiceMapping;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;
import pe.com.huex.services.service.resources.response.TrackingServiceListResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceRegisterResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceRetrieveResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceUpdateResponse;
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
public class TrackingServiceServiceImpl implements ITrackingServiceService {

    private static final String MESSAGE_INQUIRY_TRACKINGSERVICE_SUCCESS = "La consulta de seguimiento de servicios fue exitoso";
    private static final String MESSAGE_INQUIRY_TRACKINGSERVICE_WARN = "No se encontró ningún seguimiento de servicios registrado";

    private static final String MESSAGE_REGISTER_TRACKINGSERVICE_SUCCESS = "El registro del seguimiento de servicios fue exitoso";
    private static final String MESSAGE_REGISTER_TRACKINGSERVICE_WARN = "Ocurrió un error al registrar el seguimiento de servicios";

    private static final String MESSAGE_UPDATE_TRACKINGSERVICE_SUCCESS = "La actualización de datos del seguimiento de servicios fue exitoso";
    private static final String MESSAGE_UPDATE_TRACKINGSERVICE_WARN = "Ocurrió un error al actualizar los datos del seguimiento de servicios";

    private static final String MESSAGE_RETRIEVE_TRACKINGSERVICE_SUCCESS = "La consulta del seguimiento de servicios fue exitoso";
    private static final String MESSAGE_RETRIEVE_TRACKINGSERVICE_WARN = "No se encontró los datos del seguimiento de servicios";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    ITrackingServiceRepository trackingServiceRepository;
    @Autowired
    TrackingServiceMapping trackingServiceMapping;

    @Autowired
    ProviderMapping providerMapping;

    @Override
    public ResponseDto<TrackingServiceListResponse> listTrackingServices() {
        ResponseDto<TrackingServiceListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<TrackingService> trackingServiceList = trackingServiceRepository.findAll();

            if (trackingServiceList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_TRACKINGSERVICE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_TRACKINGSERVICE_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(trackingServiceList.size()));
            response.setDatos(new TrackingServiceListResponse().trackingServiceList(trackingServiceMapping.modelList(trackingServiceList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_TRACKINGSERVICE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TrackingServiceRetrieveResponse> retrieveTrackingService(Long id) {
        ResponseDto<TrackingServiceRetrieveResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<TrackingService> trackingServiceList = trackingServiceRepository.findById(id);

            if (trackingServiceList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TRACKINGSERVICE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_TRACKINGSERVICE_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));
            response.setDatos(
                    new TrackingServiceRetrieveResponse().trackingService(trackingServiceMapping.modelDto(trackingServiceList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TRACKINGSERVICE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TrackingServiceRegisterResponse> registerTrackingService(TrackingServiceDto trackingServiceDto) {
        ResponseDto<TrackingServiceRegisterResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            TrackingService trackingService = trackingServiceRepository.save(trackingServiceMapping.model(trackingServiceDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_TRACKINGSERVICE_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new TrackingServiceRegisterResponse().trackingService(trackingServiceMapping.modelDto(trackingService)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_TRACKINGSERVICE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TrackingServiceUpdateResponse> updateTrackingService(TrackingServiceDto trackingServiceDto) {
        ResponseDto<TrackingServiceUpdateResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<TrackingService> trackingServiceList = trackingServiceRepository.findById(trackingServiceDto.getId());

            if (trackingServiceList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TRACKINGSERVICE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            TrackingService trackingService = trackingServiceRepository.save(trackingServiceMapping.model(trackingServiceDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_TRACKINGSERVICE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new TrackingServiceUpdateResponse().trackingService(trackingServiceMapping.modelDto(trackingService)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_TRACKINGSERVICE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}
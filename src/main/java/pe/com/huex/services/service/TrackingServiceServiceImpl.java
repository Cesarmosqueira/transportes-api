package pe.com.huex.services.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.mapping.ProviderMapping;
import pe.com.huex.services.domain.entities.TrackingService;
import pe.com.huex.services.domain.persistence.ITrackingServiceRepository;
import pe.com.huex.services.domain.service.ITrackingServiceService;
import pe.com.huex.services.mapping.TrackingServiceMapping;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;
import pe.com.huex.services.service.resources.response.TrackingServiceListResponse;
import pe.com.huex.services.service.resources.response.TrackingServiceResponse;
import pe.com.huex.util.MetaDatosUtil;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

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

    @Override
    public ResponseDto<TrackingServiceListResponse> listTrackingServices() {
        ResponseDto<TrackingServiceListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<TrackingService> trackingServiceList = trackingServiceRepository.listTrackingServiceById();

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
    public ResponseDto<TrackingServiceListResponse> listTrackingServicesFindByRangeDate(Date dateStart, Date dateEnd) {
        ResponseDto<TrackingServiceListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<TrackingService> trackingServiceList = trackingServiceRepository.listTrackingServiceFindByRangeDate(dateStart,dateEnd);

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
    public ResponseDto<TrackingServiceResponse> retrieveTrackingService(Long id) {
        ResponseDto<TrackingServiceResponse> response = new ResponseDto<>();
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
                    new TrackingServiceResponse().trackingService(trackingServiceMapping.modelDto(trackingServiceList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TRACKINGSERVICE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TrackingServiceResponse> registerTrackingService(TrackingServiceDto trackingServiceDto) {
        ResponseDto<TrackingServiceResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            TrackingService trackingService = trackingServiceRepository.save(trackingServiceMapping.model(trackingServiceDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_TRACKINGSERVICE_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new TrackingServiceResponse().trackingService(trackingServiceMapping.modelDto(trackingService)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_TRACKINGSERVICE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TrackingServiceResponse> updateTrackingService(TrackingServiceDto trackingServiceDto) {
        ResponseDto<TrackingServiceResponse> response = new ResponseDto<>();

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
            response.setDatos(new TrackingServiceResponse().trackingService(trackingServiceMapping.modelDto(trackingService)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_TRACKINGSERVICE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteTrackingService(Long id) {

        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            trackingServiceRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_TRACKINGSERVICE_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TRACKINGSERVICE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}
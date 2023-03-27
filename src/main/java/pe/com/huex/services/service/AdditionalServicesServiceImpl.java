package pe.com.huex.services.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import pe.com.huex.services.domain.entities.AdditionalServices;
import pe.com.huex.services.domain.persistence.IAdditionalServicesRepository;
import pe.com.huex.services.domain.service.IAdditionalServicesService;
import pe.com.huex.services.mapping.AdditionalServicesMapping;
import pe.com.huex.services.service.resources.dto.AdditionalServicesDto;
import pe.com.huex.services.service.resources.response.AdditionalServicesListResponse;
import pe.com.huex.services.service.resources.response.AdditionalServicesResponse;
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
public class AdditionalServicesServiceImpl  implements IAdditionalServicesService {


    private static final String MESSAGE_INQUIRY_ADDITIONAL_SERVICES_SUCCESS = "La consulta de servicio adicional fue exitoso";
    private static final String MESSAGE_INQUIRY_ADDITIONAL_SERVICES_WARN = "No se encontró ningúna servicio adicional registrado";

    private static final String MESSAGE_REGISTER_ADDITIONAL_SERVICES_SUCCESS = "El registro de servicio adicional fue exitoso";
    private static final String MESSAGE_REGISTER_ADDITIONAL_SERVICES_WARN = "Ocurrió un error al registrar  servicio adicional";

    private static final String MESSAGE_UPDATE_ADDITIONAL_SERVICES_SUCCESS = "La actualización de datos de  servicio adicional fue exitoso";
    private static final String MESSAGE_UPDATE_ADDITIONAL_SERVICES_WARN = "Ocurrió un error al actualizar los datos de servicio adicional";

    private static final String MESSAGE_RETRIEVE_ADDITIONAL_SERVICES_SUCCESS = "La consulta de servicio adicional fue exitoso";
    private static final String MESSAGE_RETRIEVE_ADDITIONAL_SERVICES_WARN = "No se encontró los datos de servicio adicional";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final IAdditionalServicesRepository additionalServicesRepository;
    private final AdditionalServicesMapping additionalServicesMapping;

    public AdditionalServicesServiceImpl(IAdditionalServicesRepository additionalServicesRepository, AdditionalServicesMapping additionalServicesMapping) {
        this.additionalServicesRepository = additionalServicesRepository;
        this.additionalServicesMapping = additionalServicesMapping;
    }


    @Override
    public ResponseDto<AdditionalServicesListResponse> listAdditionalServices() {

        ResponseDto<AdditionalServicesListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<AdditionalServices> additionalServicesList = additionalServicesRepository.listAdditionalServiceDesc();

            if (additionalServicesList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_ADDITIONAL_SERVICES_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_ADDITIONAL_SERVICES_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(additionalServicesList.size()));
            response.setDatos(new AdditionalServicesListResponse().additionalServices(additionalServicesMapping.modelList(additionalServicesList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_ADDITIONAL_SERVICES_WARN+": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<AdditionalServicesResponse> retrieveAdditionalServices(Long id) {
        ResponseDto<AdditionalServicesResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<AdditionalServices> additionalServicesList = additionalServicesRepository.findById(id);

            if (additionalServicesList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_ADDITIONAL_SERVICES_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_ADDITIONAL_SERVICES_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new AdditionalServicesResponse().additionalServices(additionalServicesMapping.modelDto(additionalServicesList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_ADDITIONAL_SERVICES_WARN + ":" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<AdditionalServicesResponse> registerAdditionalServices(AdditionalServicesDto additionalServicesDto) {
        ResponseDto<AdditionalServicesResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            AdditionalServices additionalServicesResponse = additionalServicesRepository.save(additionalServicesMapping.model(additionalServicesDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_ADDITIONAL_SERVICES_SUCCESS, INFO, idTransaccion));
            response.setDatos(new AdditionalServicesResponse().additionalServices(additionalServicesMapping.modelDto(additionalServicesResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_ADDITIONAL_SERVICES_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<AdditionalServicesResponse> updateAdditionalServices(AdditionalServicesDto additionalServicesDto) {
        ResponseDto<AdditionalServicesResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<AdditionalServices> additionalServicesResponse = additionalServicesRepository.findById(additionalServicesDto.getId());

            if (additionalServicesResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_ADDITIONAL_SERVICES_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            additionalServicesRepository.save(additionalServicesMapping.model(additionalServicesDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_ADDITIONAL_SERVICES_SUCCESS, INFO, idTransaccion));
            response.setDatos(new AdditionalServicesResponse().additionalServices(additionalServicesDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_ADDITIONAL_SERVICES_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteAdditionalServices(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            additionalServicesRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_ADDITIONAL_SERVICES_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_ADDITIONAL_SERVICES_WARN + ": " + ex);
            throw ex;
        }
        return response;
    }
}

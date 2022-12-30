package pe.com.huex.providers.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.domain.model.entity.Provider;
import pe.com.huex.providers.domain.persistence.ProviderRepository;
import pe.com.huex.providers.domain.service.IProviderService;
import pe.com.huex.providers.mapping.ProviderMapping;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.response.ProviderListResponse;
import pe.com.huex.providers.service.resouces.response.ProviderResponse;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.vehicles.mapping.TruckFleetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class ProviderServiceImpl implements IProviderService {

    private static final String MESSAGE_INQUIRY_PROVIDERS_SUCCESS = "La consulta de proveedores fue exitoso";
    private static final String MESSAGE_INQUIRY_PROVIDERS_WARN = "No se encontró ningún proveedor registrado";

    private static final String MESSAGE_REGISTER_PROVIDERS_SUCCESS = "El registro del proeveedor fue exitoso";
    private static final String MESSAGE_REGISTER_PROVIDERS_WARN = "Ocurrió un error al registrar al proveedor";

    private static final String MESSAGE_UPDATE_PROVIDERS_SUCCESS = "La actualización de datos del proveedor fue exitoso";
    private static final String MESSAGE_UPDATE_PROVIDERS_WARN = "Ocurrió un error al actualizar los datos del proveedor";

    private static final String MESSAGE_RETRIEVE_PROVIDERS_SUCCESS = "La consulta del proveedor fue exitoso";
    private static final String MESSAGE_RETRIEVE_PROVIDERS_WARN = "No se encontró los datos del proveedor";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    ProviderMapping providerMapping;

    @Autowired
    TruckFleetMapping truckFleetMapping;

    @Override
    public ResponseDto<ProviderListResponse> listProviders() {
        ResponseDto<ProviderListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<Provider> providerList = providerRepository.findAll();

            if (providerList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_PROVIDERS_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_PROVIDERS_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(providerList.size()));
            response.setDatos(new ProviderListResponse().providerList(providerMapping.modelList(providerList)));

        } catch (Exception ex) {
            log.error("error al consultar proveedores" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ProviderResponse> retrieveProvider(Long id) {
        ResponseDto<ProviderResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Provider> providerList = providerRepository.findById(id);

            if (providerList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_PROVIDERS_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_PROVIDERS_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new ProviderResponse().provider(providerMapping.modelDto(providerList.get())));

        } catch (Exception ex) {
            log.error("error al consultar proveedor" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ProviderResponse> registerProvider(ProviderDto providerDto) {
        ResponseDto<ProviderResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            Provider providerResponse = providerRepository.save(providerMapping.model(providerDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_PROVIDERS_SUCCESS, INFO, idTransaccion));
            response.setDatos(new ProviderResponse().provider(providerMapping.modelDto(providerResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_PROVIDERS_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ProviderResponse> updateProvider(ProviderDto providerDto) {
        ResponseDto<ProviderResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<Provider> providerResponse = providerRepository.findById(providerDto.getId());

            if (providerResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_PROVIDERS_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            providerRepository.save(providerMapping.model(providerDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_PROVIDERS_SUCCESS, INFO, idTransaccion));
            response.setDatos(new ProviderResponse().provider(providerDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_PROVIDERS_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteProvider(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            providerRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_PROVIDERS_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_PROVIDERS_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

}
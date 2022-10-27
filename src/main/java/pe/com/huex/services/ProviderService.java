package pe.com.huex.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.dto.Response.*;

import pe.com.huex.entities.Provider;
import pe.com.huex.repositories.ProviderRepository;
import pe.com.huex.util.MetaDatosUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class ProviderService {
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

    public ResponseDto<ProviderListDto> listProviders() {
        ResponseDto<ProviderListDto> response = new ResponseDto<>();
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
            response.setDatos(new ProviderListDto().providerList(providerList));

        } catch (Exception ex) {
            log.error("error al consultar proveedores" + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<ProviderRetrieveDto> retrieveProviders(Long id) {
        ResponseDto<ProviderRetrieveDto> response = new ResponseDto<>();
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
            response.setDatos(new ProviderRetrieveDto().provider(providerList.get()));

        } catch (Exception ex) {
            log.error("error al consultar proveedor" + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<ProviderRegisterDto> registerProviders(Provider provider) {
        ResponseDto<ProviderRegisterDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            Provider providerResponse = providerRepository.save(provider);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_PROVIDERS_SUCCESS, INFO, idTransaccion));
            response.setDatos(new ProviderRegisterDto().provider(providerResponse));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_PROVIDERS_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<ProviderUpdateDto> updateProviders(Long id, Provider provider) {
        ResponseDto<ProviderUpdateDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Provider providerResponse = providerRepository.findById(id).get();

            if (Objects.isNull(providerResponse)) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_PROVIDERS_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            provider.setId(id);
            providerRepository.save(provider);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_PROVIDERS_SUCCESS, INFO, idTransaccion));
            response.setDatos(new ProviderUpdateDto().provider(provider));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_PROVIDERS_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

}
package pe.com.huex.employees.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.domain.entities.ProviderDiscount;
import pe.com.huex.employees.domain.persistence.IProviderDiscountRepository;
import pe.com.huex.employees.domain.service.IProviderDiscountService;
import pe.com.huex.employees.mapping.ProviderDiscountMapping;
import pe.com.huex.employees.services.resources.dtos.ProviderDiscountDto;
import pe.com.huex.employees.services.resources.response.DiscountListResponse;
import pe.com.huex.employees.services.resources.response.DiscountResponse;
import pe.com.huex.employees.services.resources.response.ProviderDiscountListResponse;
import pe.com.huex.employees.services.resources.response.ProviderDiscountResponse;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class ProviderDiscountService implements IProviderDiscountService {

    private static final String MESSAGE_INQUIRY_DISCOUNT_SUCCESS = "La consulta de los descuentos fue exitoso";
    private static final String MESSAGE_INQUIRY_DISCOUNT_WARN = "No se encontró ningúna descuento registrado";

    private static final String MESSAGE_REGISTER_DISCOUNT_SUCCESS = "El registro del descuento fue exitoso";
    private static final String MESSAGE_REGISTER_DISCOUNT_WARN = "Ocurrió un error al registrar el descuento";

    private static final String MESSAGE_UPDATE_DISCOUNT_SUCCESS = "La actualización de datos del descuento fue exitoso";
    private static final String MESSAGE_UPDATE_DISCOUNT_WARN = "Ocurrió un error al actualizar los datos del descuento";

    private static final String MESSAGE_RETRIEVE_DISCOUNT_SUCCESS = "La consulta del descuento fue exitoso";
    private static final String MESSAGE_RETRIEVE_DISCOUNT_WARN = "No se encontró los datos del descuento";

    private static final String MESSAGE_DELETE_DISCOUNT_SUCCESS = "Se eliminó correctamente el descuento";

    private static final String MESSAGE_DELETE_DISCOUNT_WARN = "Ocurrió un error al eliminar el descuento";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";


    @Autowired
    IProviderDiscountRepository providerDiscountRepository;
    @Autowired
    ProviderDiscountMapping providerDiscountMapping;




    @Override
    public ResponseDto<ProviderDiscountListResponse> listProviderDiscounts() {
        ResponseDto<ProviderDiscountListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<ProviderDiscount> providerDiscountList = providerDiscountRepository.listProviderDiscountDesc();

            if (providerDiscountList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_DISCOUNT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_DISCOUNT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(providerDiscountList.size()));
            response.setDatos(new ProviderDiscountListResponse().providerDiscount(providerDiscountMapping.modelList(providerDiscountList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_DISCOUNT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ProviderDiscountResponse> retrieveProviderDiscount(Long id) {
        ResponseDto<ProviderDiscountResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ProviderDiscount> providerDiscountList = providerDiscountRepository.findById(id);

            if (providerDiscountList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_DISCOUNT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_DISCOUNT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new ProviderDiscountResponse().providerDiscount(providerDiscountMapping.modelDto(providerDiscountList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_DISCOUNT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ProviderDiscountResponse> registerProviderDiscount(ProviderDiscountDto providerDiscountDto) throws IOException {
        ResponseDto<ProviderDiscountResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            ProviderDiscount providerDiscountResponse = providerDiscountRepository.save(providerDiscountMapping.model(providerDiscountDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_DISCOUNT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new ProviderDiscountResponse().providerDiscount(providerDiscountMapping.modelDto(providerDiscountResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_DISCOUNT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ProviderDiscountResponse> updateProviderDiscount(ProviderDiscountDto providerDiscountDto) throws IOException {
        ResponseDto<ProviderDiscountResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ProviderDiscount> providerDiscountList = providerDiscountRepository.findById(providerDiscountDto.getId());

            if (providerDiscountList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_DISCOUNT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            ProviderDiscount providerDiscountResponse = providerDiscountRepository.save(providerDiscountMapping.model(providerDiscountDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_DISCOUNT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new ProviderDiscountResponse().providerDiscount(providerDiscountMapping.modelDto(providerDiscountResponse)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_DISCOUNT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteProviderDiscount(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            providerDiscountRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_DISCOUNT_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_DELETE_DISCOUNT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

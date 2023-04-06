package pe.com.huex.warehouse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;

import pe.com.huex.warehouse.domain.model.entity.InvoicedProduct;
import pe.com.huex.warehouse.domain.persistence.IInvoicedProductRepository;
import pe.com.huex.warehouse.domain.service.IInvoicedProductService;
import pe.com.huex.warehouse.mapping.InvoicedProductMapping;
import pe.com.huex.warehouse.service.resources.dto.InvoicedProductDto;
import pe.com.huex.warehouse.service.resources.response.InvoicedProductListResponse;
import pe.com.huex.warehouse.service.resources.response.InvoicedProductResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class InvoicedProductServiceImpl implements IInvoicedProductService {

    private static final String MESSAGE_INQUIRY_INVOICED_PRODUCT_SUCCESS = "La consulta de producto facturado fue exitoso";
    private static final String MESSAGE_INQUIRY_INVOICED_PRODUCT_WARN = "No se encontró ningún producto facturado registrado";

    private static final String MESSAGE_REGISTER_INVOICED_PRODUCT_SUCCESS = "El registro del producto facturado fue exitoso";
    private static final String MESSAGE_REGISTER_INVOICED_PRODUCT_WARN = "Ocurrió un error al registrar el producto facturado";

    private static final String MESSAGE_UPDATE_INVOICED_PRODUCT_SUCCESS = "La actualización de datos del producto facturado fue exitoso";
    private static final String MESSAGE_UPDATE_INVOICED_PRODUCT_WARN = "Ocurrió un error al actualizar los datos del producto facturado";

    private static final String MESSAGE_RETRIEVE_INVOICED_PRODUCT_SUCCESS = "La consulta del producto facturado fue exitoso";
    private static final String MESSAGE_RETRIEVE_INVOICED_PRODUCT_WARN = "No se encontró los datos del producto facturado";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final IInvoicedProductRepository invoicedProductRepository;

    private final InvoicedProductMapping invoicedProductMapping;

    public InvoicedProductServiceImpl(IInvoicedProductRepository invoicedProductRepository, InvoicedProductMapping invoicedProductMapping) {
        this.invoicedProductRepository = invoicedProductRepository;
        this.invoicedProductMapping = invoicedProductMapping;
    }


    @Override
    public ResponseDto<InvoicedProductListResponse> listInvoicedProduct() {
        ResponseDto<InvoicedProductListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<InvoicedProduct> invoicedProductList = invoicedProductRepository.findAll();

            if (invoicedProductList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_INVOICED_PRODUCT_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_INVOICED_PRODUCT_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(invoicedProductList.size()));
            response.setDatos(new InvoicedProductListResponse().invoicedProduct(invoicedProductMapping.modelList(invoicedProductList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_INVOICED_PRODUCT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<InvoicedProductResponse> retrieveInvoicedProduct(Long id) {
        ResponseDto<InvoicedProductResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<InvoicedProduct> invoicedProductList = invoicedProductRepository.findById(id);

            if (invoicedProductList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_INVOICED_PRODUCT_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_INVOICED_PRODUCT_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));
            response.setDatos(
                    new InvoicedProductResponse().invoicedProduct(invoicedProductMapping.modelDto(invoicedProductList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_INVOICED_PRODUCT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<InvoicedProductResponse> registerInvoicedProduct(InvoicedProductDto invoicedProductDto) {
        ResponseDto<InvoicedProductResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            InvoicedProduct invoicedProduct = invoicedProductRepository.save(invoicedProductMapping.model(invoicedProductDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_INVOICED_PRODUCT_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new InvoicedProductResponse().invoicedProduct(invoicedProductMapping.modelDto(invoicedProduct)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_INVOICED_PRODUCT_WARN + ": " + ex);
            throw ex;
        }
        return response;
    }

    @Override
    public ResponseDto<InvoicedProductResponse> updateInvoicedProduct(InvoicedProductDto invoicedProductDto) {
        ResponseDto<InvoicedProductResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<InvoicedProduct> invoicedProductList = invoicedProductRepository.findById(invoicedProductDto.getId());

            if (invoicedProductList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_INVOICED_PRODUCT_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            InvoicedProduct invoicedProduct = invoicedProductRepository.save(invoicedProductMapping.model(invoicedProductDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_INVOICED_PRODUCT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new InvoicedProductResponse().invoicedProduct(invoicedProductMapping.modelDto(invoicedProduct)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_INVOICED_PRODUCT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteInvoicedProduct(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            invoicedProductRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_INVOICED_PRODUCT_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_INVOICED_PRODUCT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

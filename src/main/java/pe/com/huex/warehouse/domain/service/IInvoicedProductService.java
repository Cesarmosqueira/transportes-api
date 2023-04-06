package pe.com.huex.warehouse.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.warehouse.service.resources.dto.InvoicedProductDto;
import pe.com.huex.warehouse.service.resources.response.InvoicedProductListResponse;
import pe.com.huex.warehouse.service.resources.response.InvoicedProductResponse;

public interface IInvoicedProductService {

    ResponseDto<InvoicedProductListResponse> listInvoicedProduct();

    ResponseDto<InvoicedProductResponse> retrieveInvoicedProduct(Long id);

    ResponseDto<InvoicedProductResponse> registerInvoicedProduct(InvoicedProductDto invoicedProductDto);

    ResponseDto<InvoicedProductResponse> updateInvoicedProduct(InvoicedProductDto invoicedProductDto);

    ResponseDto deleteInvoicedProduct(Long id);


}

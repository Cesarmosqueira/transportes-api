package pe.com.huex.warehouse.service.resources.response;

import lombok.Data;
import pe.com.huex.warehouse.service.resources.dto.InvoicedProductDto;

import java.util.List;
@Data
public class InvoicedProductListResponse {

    private List<InvoicedProductDto> invoicedProduct = null;

    public InvoicedProductListResponse invoicedProduct(List<InvoicedProductDto> invoicedProduct) {
        this.invoicedProduct = invoicedProduct;
        return this;
    }
}

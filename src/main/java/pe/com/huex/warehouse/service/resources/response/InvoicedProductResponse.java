package pe.com.huex.warehouse.service.resources.response;


import lombok.Data;
import pe.com.huex.warehouse.service.resources.dto.InvoicedProductDto;
@Data
public class InvoicedProductResponse {

    private InvoicedProductDto invoicedProduct = null;

    public InvoicedProductResponse invoicedProduct(InvoicedProductDto invoicedProduct) {
        this.invoicedProduct = invoicedProduct;
        return this;
    }
}

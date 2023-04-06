package pe.com.huex.warehouse.api;

import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.warehouse.domain.service.IInvoicedProductService;
import pe.com.huex.warehouse.service.resources.dto.InvoicedProductDto;
import pe.com.huex.warehouse.service.resources.response.InvoicedProductListResponse;
import pe.com.huex.warehouse.service.resources.response.InvoicedProductResponse;

@RestController
@RequestMapping("invoiced_product")
public class InvoicedProductController {

    private final IInvoicedProductService invoicedProductService;

    public InvoicedProductController(IInvoicedProductService invoicedProductService) {
        this.invoicedProductService = invoicedProductService;
    }
    @GetMapping
    public ResponseDto<InvoicedProductListResponse>listInvoicedProduct(){
        return invoicedProductService.listInvoicedProduct();
    }
    @GetMapping("{id}")
    public ResponseDto<InvoicedProductResponse> retrieveInvoicedProduct(@PathVariable Long id) {
        return invoicedProductService.retrieveInvoicedProduct(id);
    }

    @PostMapping
    public ResponseDto<InvoicedProductResponse>registerInvoicedProduct(@RequestBody InvoicedProductDto invoicedProductDto){
        return invoicedProductService.registerInvoicedProduct(invoicedProductDto);
    }
    @PutMapping
    public ResponseDto<InvoicedProductResponse>updateInvoicedProduct(@RequestBody InvoicedProductDto invoicedProductDto){
        return invoicedProductService.updateInvoicedProduct(invoicedProductDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteInvoicedProduct(@PathVariable Long id){
        return invoicedProductService.deleteInvoicedProduct(id);
    }

}

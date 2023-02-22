package pe.com.huex.employees.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.employees.domain.service.IProviderDiscountService;
import pe.com.huex.employees.services.resources.dtos.ProviderDiscountDto;
import pe.com.huex.employees.services.resources.response.ProviderDiscountListResponse;
import pe.com.huex.employees.services.resources.response.ProviderDiscountResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;

@RestController
@RequestMapping("provider_discounts")
public class ProviderDiscountController {

    private final IProviderDiscountService providerDiscountService;

    public ProviderDiscountController(IProviderDiscountService providerDiscountService) {
        this.providerDiscountService = providerDiscountService;
    }

    @GetMapping
    public ResponseDto<ProviderDiscountListResponse> listDiscount() {
        return providerDiscountService.listProviderDiscounts();
    }

    @GetMapping("{id}")
    public ResponseDto<ProviderDiscountResponse> retrieveDiscount(@PathVariable Long id) {
        return providerDiscountService.retrieveProviderDiscount(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<ProviderDiscountResponse> registerDiscount(
            @RequestBody ProviderDiscountDto discount)
            throws Exception {
        return providerDiscountService.registerProviderDiscount(discount);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<ProviderDiscountResponse> updateDiscount(

            @RequestBody ProviderDiscountDto discountDto) throws IOException {
        return providerDiscountService.updateProviderDiscount(discountDto);
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseDto deleteDiscount(@PathVariable Long id) {
        return providerDiscountService.deleteProviderDiscount(id);
    }

}

package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import pe.com.huex.employees.services.resources.dtos.ProviderDiscountDto;

@Data
public class ProviderDiscountResponse {

    private ProviderDiscountDto providerDiscount = null;
    public ProviderDiscountResponse providerDiscount(ProviderDiscountDto providerDiscount) {
        this.providerDiscount = providerDiscount;
        return this;
    }
}

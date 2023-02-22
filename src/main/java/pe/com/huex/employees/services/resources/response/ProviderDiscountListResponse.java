package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.services.resources.dtos.ProviderDiscountDto;

import java.util.List;

@Data
@NoArgsConstructor
public class ProviderDiscountListResponse {

    private List<ProviderDiscountDto> providerDiscount = null;

    public ProviderDiscountListResponse providerDiscount(List<ProviderDiscountDto> providerDiscountList) {
        this.providerDiscount = providerDiscountList;
        return this;
    }
}

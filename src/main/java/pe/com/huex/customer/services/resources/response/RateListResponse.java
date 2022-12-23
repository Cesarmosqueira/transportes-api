package pe.com.huex.customer.services.resources.response;

import java.util.List;

import lombok.*;
import pe.com.huex.customer.services.resources.dto.RateDto;

@Data
@NoArgsConstructor
public class RateListResponse {

    private List<RateDto> rates = null;

    public RateListResponse rates(List<RateDto> rateDtoList) {
        this.rates = rateDtoList;
        return this;
    }
}

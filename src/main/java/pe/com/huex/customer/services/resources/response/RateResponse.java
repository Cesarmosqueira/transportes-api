package pe.com.huex.customer.services.resources.response;

import lombok.*;
import pe.com.huex.customer.services.resources.dto.RateDto;

@Data
@NoArgsConstructor
public class RateResponse {

    private RateDto rate = null;

    public RateResponse rate(RateDto rateDto) {
        this.rate = rateDto;
        return this;
    }
}

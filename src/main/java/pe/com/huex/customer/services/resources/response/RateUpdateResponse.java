package pe.com.huex.customer.services.resources.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import pe.com.huex.customer.services.resources.dto.RateDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RateUpdateResponse {

    private RateDto rateDto = null;

    public RateUpdateResponse rateUpdateResponse(RateDto rateDto) {
        this.rateDto = rateDto;
        return this;
    }
}

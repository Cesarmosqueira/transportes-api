package pe.com.huex.customers.service.resources.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.dto.RuteDto;


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

package pe.com.huex.customers.service.resources.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.dto.RuteDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RateRegisterResponse {

    private RateDto rateDto = null;

    public RateRegisterResponse rateRegisterResponse(RateDto rateDto) {
        this.rateDto = rateDto;
        return this;
    }
}

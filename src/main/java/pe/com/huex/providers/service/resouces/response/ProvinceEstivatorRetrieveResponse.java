package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.response.RateRetrieveResponse;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEstivatorRetrieveResponse {

    private ProvinceEstivatorDto provinceEstivatorDto = null;

    public ProvinceEstivatorRetrieveResponse provinceEstivatorRetrieveResponse(ProvinceEstivatorDto provinceEstivatorDto) {
        this.provinceEstivatorDto = provinceEstivatorDto;
        return this;
    }
}

package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.response.RateUpdateResponse;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEstivatorUpdateResponse {

    private ProvinceEstivatorDto provinceEstivatorDto = null;

    public ProvinceEstivatorUpdateResponse provinceEstivatorUpdateResponse(ProvinceEstivatorDto provinceEstivatorDto) {
        this.provinceEstivatorDto = provinceEstivatorDto;
        return this;
    }
}

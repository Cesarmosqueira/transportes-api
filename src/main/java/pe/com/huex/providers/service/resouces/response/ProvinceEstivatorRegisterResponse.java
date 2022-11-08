package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEstivatorRegisterResponse {

    private ProvinceEstivatorDto provinceEstivatorDto = null;

    public ProvinceEstivatorRegisterResponse provinceEstivatorRegisterResponse(ProvinceEstivatorDto provinceEstivatorDto) {
        this.provinceEstivatorDto = provinceEstivatorDto;
        return this;
    }
}

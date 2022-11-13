package pe.com.huex.providers.service.resouces.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEstivatorRetrieveResponse {

    private ProvinceEstivatorDto provinceEstivatorDto = null;

    public ProvinceEstivatorRetrieveResponse provinceEstivatorRetrieveResponse(
            ProvinceEstivatorDto provinceEstivatorDto) {
        this.provinceEstivatorDto = provinceEstivatorDto;
        return this;
    }
}

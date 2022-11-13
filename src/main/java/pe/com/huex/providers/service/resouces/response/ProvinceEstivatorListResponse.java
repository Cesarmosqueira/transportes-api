package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEstivatorListResponse {

    private List<ProvinceEstivatorDto> provinceEstivatorDtoList = null;

    public ProvinceEstivatorListResponse provinceEstivatorListResponse(
            List<ProvinceEstivatorDto> provinceEstivatorDtos) {
        this.provinceEstivatorDtoList = provinceEstivatorDtoList;
        return this;
    }
}

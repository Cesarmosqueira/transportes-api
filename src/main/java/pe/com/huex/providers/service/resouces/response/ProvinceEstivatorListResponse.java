package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;

import java.util.List;

@Data
@NoArgsConstructor
public class ProvinceEstivatorListResponse {

    private List<ProvinceEstivatorDto> provinceEstivators = null;

    public ProvinceEstivatorListResponse provinceEstivatorListResponse(
            List<ProvinceEstivatorDto> provinceEstivatorDtos) {
        this.provinceEstivators = provinceEstivatorDtos;
        return this;
    }
}

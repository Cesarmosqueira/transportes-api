package pe.com.huex.providers.service.resouces.response;

import lombok.*;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;

@Data
@NoArgsConstructor
public class ProvinceEstivatorResponse {

    private ProvinceEstivatorDto provinceEstivator = null;

    public ProvinceEstivatorResponse provinceEstivator(ProvinceEstivatorDto provinceEstivatorDto) {
        this.provinceEstivator = provinceEstivatorDto;
        return this;
    }
}

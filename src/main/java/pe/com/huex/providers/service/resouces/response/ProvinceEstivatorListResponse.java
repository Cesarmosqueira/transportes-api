package pe.com.huex.providers.service.resouces.response;

import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;

import java.util.List;

public class ProvinceEstivatorListResponse {

    private List<ProvinceEstivatorDto> provinceEstivatorDtoList = null;

    public ProvinceEstivatorListResponse provinceEstivatorListResponse(List<ProvinceEstivatorDto> provinceEstivatorDtos) {
        this.provinceEstivatorDtoList = provinceEstivatorDtoList;
        return this;
    }
}

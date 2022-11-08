package pe.com.huex.providers.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;
import pe.com.huex.providers.service.resouces.response.*;

public interface IProvinceEstivatorService {

    ResponseDto<ProvinceEstivatorListResponse> listProvinceEstivator();

    ResponseDto<ProvinceEstivatorRetrieveResponse> retrieveProvinceEstivator(Long id);

    ResponseDto<ProvinceEstivatorRegisterResponse> registerProvinceEstivator(ProvinceEstivatorDto provinceEstivatorDto);

    ResponseDto<ProvinceEstivatorUpdateResponse> updateProvinceEstivator(ProvinceEstivatorDto provinceEstivatorDto);
}

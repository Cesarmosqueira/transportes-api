package pe.com.huex.providers.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;
import pe.com.huex.providers.service.resouces.response.*;

public interface IProvinceEstivatorService {

    ResponseDto<ProvinceEstivatorListResponse> listProvinceEstivator();

    ResponseDto<ProvinceEstivatorResponse> retrieveProvinceEstivator(Long id);

    ResponseDto<ProvinceEstivatorResponse> registerProvinceEstivator(ProvinceEstivatorDto provinceEstivatorDto);

    ResponseDto<ProvinceEstivatorResponse> updateProvinceEstivator(ProvinceEstivatorDto provinceEstivatorDto);

    ResponseDto deleteProvinceEstivator(Long id);

}

package pe.com.huex.customer.domain.service;

import pe.com.huex.customer.services.resources.dto.RateDto;
import pe.com.huex.customer.services.resources.response.RateListResponse;
import pe.com.huex.customer.services.resources.response.RateResponse;
import pe.com.huex.util.ResponseDto;

public interface IRateService {

    ResponseDto<RateListResponse> listRate();

    ResponseDto<RateResponse> retrieveRate(Long id);

    ResponseDto<RateResponse> registerRate(RateDto rateDto);

    ResponseDto<RateResponse> updateRate(RateDto rateDto);

    ResponseDto deleteRate(Long id);

}

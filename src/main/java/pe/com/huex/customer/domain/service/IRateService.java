package pe.com.huex.customer.domain.service;

import pe.com.huex.customer.services.resources.dto.RateDto;
import pe.com.huex.customer.services.resources.response.RateListResponse;
import pe.com.huex.customer.services.resources.response.RateRegisterResponse;
import pe.com.huex.customer.services.resources.response.RateRetrieveResponse;
import pe.com.huex.customer.services.resources.response.RateUpdateResponse;
import pe.com.huex.dto.Response.ResponseDto;

public interface IRateService {

    ResponseDto<RateListResponse> listRate();

    ResponseDto<RateRetrieveResponse> retrieveRate(Long id);

    ResponseDto<RateRegisterResponse> registerRate(RateDto rateDto);

    ResponseDto<RateUpdateResponse> updateRate(RateDto rateDto);
}

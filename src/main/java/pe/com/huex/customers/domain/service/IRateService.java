package pe.com.huex.customers.domain.service;

import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.customers.service.resources.response.*;
import pe.com.huex.dto.Response.ResponseDto;

public interface IRateService {

    ResponseDto<RateListResponse> listRate();

    ResponseDto<RateRetrieveResponse> retrieveRate(Long id);

    ResponseDto<RateRegisterResponse> registerRate(RateDto rateDto);

    ResponseDto<RateUpdateResponse> updateRate(RateDto rateDto);
}

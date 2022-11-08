package pe.com.huex.providers.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;
import pe.com.huex.providers.service.resouces.response.*;

public interface ITireReplacementService {

    ResponseDto<TireReplacementListResponse> listTireReplacement();

    ResponseDto<TireReplacementRetrieveResponse> retrieveTireReplacement(Long id);

    ResponseDto<TireReplacementRegisterResponse> registerTireReplacement(TireReplacementDto tireReplacementDto);

    ResponseDto<TireReplacementUpdateResponse> updateTireReplacementDto(TireReplacementDto tireReplacementDto);

}

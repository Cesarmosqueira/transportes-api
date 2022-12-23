package pe.com.huex.providers.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;
import pe.com.huex.providers.service.resouces.response.*;

public interface ITireReplacementService {

    ResponseDto<TireReplacementListResponse> listTireReplacement();

    ResponseDto<TireReplacementResponse> retrieveTireReplacement(Long id);

    ResponseDto<TireReplacementResponse> registerTireReplacement(TireReplacementDto tireReplacementDto);

    ResponseDto<TireReplacementResponse> updateTireReplacement(TireReplacementDto tireReplacementDto);

}

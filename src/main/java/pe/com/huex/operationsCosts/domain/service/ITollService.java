package pe.com.huex.operationsCosts.domain.service;

import pe.com.huex.operationsCosts.services.resources.dto.TollDto;
import pe.com.huex.operationsCosts.services.resources.response.TollListReponse;
import pe.com.huex.operationsCosts.services.resources.response.TollResponse;
import pe.com.huex.util.ResponseDto;

public interface ITollService {

    ResponseDto<TollListReponse> tollList();

    ResponseDto<TollResponse> retrieveToll(Long id);

    ResponseDto<TollResponse> registerToll(TollDto tollDto);
    ResponseDto<TollResponse> updateToll(TollDto tollDto);
    ResponseDto deleteToll(Long id);

}

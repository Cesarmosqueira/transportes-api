package pe.com.huex.customers.domain.service;



import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.customers.service.resources.response.*;
import pe.com.huex.dto.Response.ResponseDto;


import java.util.List;

public interface IRuteService {

    ResponseDto<RuteListResponse> listRute();

    ResponseDto<RuteRetrieveResponse> retrieveRute(Long id);

    ResponseDto<RuteRegisterResponse> registerRute(RuteDto ruteDto);

    ResponseDto<RuteUpdateResponse> updateRute(RuteDto ruteDto);

    ResponseDto<RuteDeleteResponse> deleteRute(Long id);


}

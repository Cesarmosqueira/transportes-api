package pe.com.huex.vehicles.domain.service;

import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;
import pe.com.huex.vehicles.service.resources.response.*;

import java.io.IOException;

public interface ICheckListService {

    ResponseDto<CheckListListResponse> listCheckLists();

    ResponseDto<CheckListRetrieveResponse> retrieveCheckList(Long id);

    ResponseDto<CheckListRegisterResponse> registerCheckList(CheckListDto checkListDto) throws IOException;

    ResponseDto<CheckListUpdateResponse> updateCheckList(CheckListDto checkListDto) throws IOException;

    ResponseDto deleteCheckList(Long id);

    ResponseDto<CheckListListResponse> listCheckListsByIdTruckFleet(Long id);
}

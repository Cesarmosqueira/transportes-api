package pe.com.huex.vehicles.domain.service;

import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.response.CheckListListResponse;
import pe.com.huex.vehicles.service.resources.response.CheckListRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.CheckListRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.CheckListUpdateResponse;

import java.io.IOException;

public interface ICheckListService {

    ResponseDto<CheckListListResponse> listCheckLists();

    ResponseDto<CheckListRetrieveResponse> retrieveCheckList(Long id);

    ResponseDto<CheckListRegisterResponse> registerCheckList(MultipartFile file, String checkListDto) throws IOException;

    ResponseDto<CheckListUpdateResponse> updateCheckList(MultipartFile file, String checkListDto) throws IOException;
}

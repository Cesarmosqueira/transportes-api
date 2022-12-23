package pe.com.huex.vehicles.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;
import pe.com.huex.vehicles.service.resources.response.CheckListListResponse;
import pe.com.huex.vehicles.service.resources.response.CheckListResponse;

import java.io.IOException;

public interface ICheckListService {

    ResponseDto<CheckListListResponse> listCheckLists();

    ResponseDto<CheckListResponse> retrieveCheckList(Long id);

    ResponseDto<CheckListResponse> registerCheckList(CheckListDto checkListDto) throws IOException;

    ResponseDto<CheckListResponse> updateCheckList(CheckListDto checkListDto) throws IOException;

    ResponseDto deleteCheckList(Long id);

    ResponseDto<CheckListListResponse> listCheckListsByIdTruckFleet(Long id);
}

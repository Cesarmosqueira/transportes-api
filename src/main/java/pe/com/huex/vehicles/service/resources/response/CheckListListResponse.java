package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;

import java.util.List;

@Data
public class CheckListListResponse {
    private List<CheckListDto> checkLists = null;

    public CheckListListResponse checkList(List<CheckListDto> checkListDtoList) {
        this.checkLists = checkListDtoList;
        return this;
    }
}

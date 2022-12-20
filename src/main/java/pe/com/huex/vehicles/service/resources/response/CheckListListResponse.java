package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CheckListListResponse {
    private List<CheckListDto> checkListDtoList = null;

    public CheckListListResponse checkList(List<CheckListDto> checkListDtoList) {
        this.checkListDtoList = checkListDtoList;
        return this;
    }
}

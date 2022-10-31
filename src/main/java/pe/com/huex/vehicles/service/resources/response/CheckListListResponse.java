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
    private List<CheckListDto> checkListDtos = null;

    public CheckListListResponse checkList(List<CheckListDto> checkListDtos) {
        this.checkListDtos = checkListDtos;
        return this;
    }
}

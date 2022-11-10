package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CheckListRetrieveResponse {
    private CheckListDto checkListDto = null;

    public CheckListRetrieveResponse checkList(CheckListDto checkListDto) {
        this.checkListDto = checkListDto;
        return this;
    }
}
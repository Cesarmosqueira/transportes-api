package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CheckListRegisterResponse {

    private CheckListDto checkListDto = null;

    public CheckListRegisterResponse checkList(CheckListDto checkListDto) {
        this.checkListDto = checkListDto;
        return this;
    }
}

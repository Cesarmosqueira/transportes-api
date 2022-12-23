package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;

@Data
public class CheckListResponse {

    private CheckListDto checkListDto = null;

    public CheckListResponse checkList(CheckListDto checkListDto) {
        this.checkListDto = checkListDto;
        return this;
    }
}
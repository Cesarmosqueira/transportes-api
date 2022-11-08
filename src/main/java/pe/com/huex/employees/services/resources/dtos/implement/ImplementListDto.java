package pe.com.huex.employees.services.resources.dtos.implement;

import java.util.ArrayList;
import java.util.List;

import pe.com.huex.employees.domain.entities.Implement;
import pe.com.huex.employees.services.resources.response.ImplementResponseDto;

public class ImplementListDto {

    public ImplementListDto() {
    }

    private List<ImplementResponseDto> relationList = null;

    public ImplementListDto relationList(List<Implement> relationList) {
        this.relationList = new ArrayList<ImplementResponseDto>();
        for (Implement emp : relationList) {
            this.relationList.add(new ImplementResponseDto(emp));
        }
        return this;
    }

    public void setImplementResponseDtoList(List<ImplementResponseDto> relationList) {
        this.relationList = relationList;
    }

    public List<ImplementResponseDto> getImplementResponseDtoList() {
        return relationList;
    }

}

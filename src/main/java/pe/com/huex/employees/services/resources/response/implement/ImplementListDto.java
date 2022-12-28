package pe.com.huex.employees.services.resources.response.implement;

import java.util.ArrayList;
import java.util.List;

import pe.com.huex.employees.domain.entities.Implement;
import pe.com.huex.employees.services.resources.dtos.ImplementResponseDto;

public class ImplementListDto {

    public ImplementListDto() {
    }

    private List<ImplementResponseDto> implementList = null;

    public ImplementListDto relationList(List<Implement> relationList) {
        this.implementList = new ArrayList<ImplementResponseDto>();
        for (Implement emp : relationList) {
            this.implementList.add(new ImplementResponseDto(emp));
        }
        return this;
    }

    public void setImplementResponseDtoList(List<ImplementResponseDto> relationList) {
        this.implementList = relationList;
    }

    public List<ImplementResponseDto> getImplementResponseDtoList() {
        return implementList;
    }

}

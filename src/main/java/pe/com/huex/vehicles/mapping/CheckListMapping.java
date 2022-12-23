package pe.com.huex.vehicles.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.vehicles.domain.entities.CheckList;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CheckListMapping extends ModelMapper implements Serializable {

    public CheckListMapping() {
        super();
    }

    public List<CheckListDto> modelList(List<CheckList> modelList) {
        return modelList.stream().map(item -> this.map(item, CheckListDto.class))
                .collect(Collectors.toList());
    }

    public CheckList model(CheckListDto checkListDto) {
        return this.map(checkListDto, CheckList.class);
    }

    public CheckListDto modelDto(CheckList checkList) {
        return this.map(checkList, CheckListDto.class);
    }
}

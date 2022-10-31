package pe.com.huex.vehicles.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.vehicles.domain.model.entity.DocumentUnit;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentUnitMapping extends ModelMapper implements Serializable {

    public DocumentUnitMapping() { super(); }

    public List<DocumentUnitDto> modelList(List<DocumentUnit> modelList) {
        return modelList.stream().map(item -> this.map(item, DocumentUnitDto.class))
                .collect(Collectors.toList());
    }

    public DocumentUnit model(DocumentUnitDto modelDto) {
        return this.map(modelDto, DocumentUnit.class);
    }

    public DocumentUnitDto modelDto(DocumentUnit model) {
        return this.map(model, DocumentUnitDto.class);
    }
}

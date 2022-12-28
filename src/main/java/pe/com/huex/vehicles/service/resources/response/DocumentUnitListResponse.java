package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;

import java.util.List;

@Data
public class DocumentUnitListResponse {
    private List<DocumentUnitDto> documentsUnit = null;

    public DocumentUnitListResponse documentUnitList(List<DocumentUnitDto> documentUnitDtoList) {
        this.documentsUnit = documentUnitDtoList;
        return this;
    }
}

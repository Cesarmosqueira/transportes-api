package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUnitListResponse {
    private List<DocumentUnitDto> documentUnitDtoList = null;

    public DocumentUnitListResponse documentUnitList(List<DocumentUnitDto> documentUnitDtoList) {
        this.documentUnitDtoList = documentUnitDtoList;
        return this;
    }
}

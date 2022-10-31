package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUnitUpdateResponse {
    private DocumentUnitDto documentUnitDto = null;

    public DocumentUnitUpdateResponse documentUnit(DocumentUnitDto documentUnitDto) {
        this.documentUnitDto = documentUnitDto;
        return this;
    }
}

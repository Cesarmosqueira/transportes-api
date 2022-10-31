package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUnitRetrieveResponse {
    private DocumentUnitDto documentUnitDto = null;

    public DocumentUnitRetrieveResponse documentUnit(DocumentUnitDto documentUnitDto) {
        this.documentUnitDto = documentUnitDto;
        return this;
    }
}

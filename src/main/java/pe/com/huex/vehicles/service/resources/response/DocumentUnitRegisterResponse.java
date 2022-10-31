package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUnitRegisterResponse {
    private DocumentUnitDto documentUnitDto = null;

    public DocumentUnitRegisterResponse documentUnit(DocumentUnitDto documentUnitDto) {
        this.documentUnitDto = documentUnitDto;
        return this;
    }
}

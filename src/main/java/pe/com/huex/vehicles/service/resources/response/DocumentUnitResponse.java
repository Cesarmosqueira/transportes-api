package pe.com.huex.vehicles.service.resources.response;

import lombok.*;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;

@Data
public class DocumentUnitResponse {
    private DocumentUnitDto documentUnit = null;

    public DocumentUnitResponse documentUnit(DocumentUnitDto documentUnitDto) {
        this.documentUnit = documentUnitDto;
        return this;
    }
}

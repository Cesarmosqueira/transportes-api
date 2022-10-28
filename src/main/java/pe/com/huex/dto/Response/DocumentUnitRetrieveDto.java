package pe.com.huex.dto.Response;

import pe.com.huex.entities.DocumentUnit;

public class DocumentUnitRetrieveDto {
    
    public DocumentUnitRetrieveDto() {
    }

    private DocumentUnit documentUnit = null;

    public DocumentUnitRetrieveDto documentUnit(DocumentUnit documentUnit) {
        this.documentUnit = documentUnit;
        return this;
    }

    public void setDocumentUnit(DocumentUnit documentUnit) {
        this.documentUnit = documentUnit;
    }

    public DocumentUnit getDocumentUnit() {
        return documentUnit;
    }
}

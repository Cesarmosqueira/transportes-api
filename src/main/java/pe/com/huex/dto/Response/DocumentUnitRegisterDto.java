package pe.com.huex.dto.Response;

import pe.com.huex.entities.DocumentUnit;

public class DocumentUnitRegisterDto {

    public DocumentUnitRegisterDto() {
    }

    private DocumentUnit documentUnit = null;

    public DocumentUnitRegisterDto documentUnit(DocumentUnit documentUnit) {
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

package pe.com.huex.dto.Response;

import pe.com.huex.entities.DocumentUnit;

import java.util.List;

public class DocumentUnitListDto {
    
    public DocumentUnitListDto() {
    }

    private List<DocumentUnit> documentUnitList = null;

    public DocumentUnitListDto documentUnitList(List<DocumentUnit> documentUnitList) {
        this.documentUnitList = documentUnitList;
        return this;
    }

    public void setDocumentUnitList(List<DocumentUnit> DocumentUnitList) {
        this.documentUnitList = DocumentUnitList;
    }

    public List<DocumentUnit> getDocumentUnitList() {
        return documentUnitList;
    }
}

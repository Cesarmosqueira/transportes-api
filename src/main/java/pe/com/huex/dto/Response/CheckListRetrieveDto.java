package pe.com.huex.dto.Response;

import pe.com.huex.entities.CheckList;

public class CheckListRetrieveDto {
    
    public CheckListRetrieveDto() {
    }

    private CheckList checkList = null;

    public CheckListRetrieveDto checkList(CheckList checkList) {
        this.checkList = checkList;
        return this;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }

    public CheckList getCheckList() {
        return checkList;
    }
}

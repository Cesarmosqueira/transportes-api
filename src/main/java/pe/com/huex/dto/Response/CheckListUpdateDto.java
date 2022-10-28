package pe.com.huex.dto.Response;

import pe.com.huex.entities.CheckList;

public class CheckListUpdateDto {

    public CheckListUpdateDto() {
    }

    private CheckList checkList = null;

    public CheckListUpdateDto checkList(CheckList checkList) {
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

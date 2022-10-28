package pe.com.huex.dto.Response;

import pe.com.huex.entities.CheckList;

import java.util.List;

public class CheckListListDto {
    
    public CheckListListDto() {
    }

    private List<CheckList> checkList = null;

    public CheckListListDto checkList(List<CheckList> checkList) {
        this.checkList = checkList;
        return this;
    }

    public void setCheckList(List<CheckList> checkList) {
        this.checkList = checkList;
    }

    public List<CheckList> getCheckList() {
        return checkList;
    }
}

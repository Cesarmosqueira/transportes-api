package pe.com.huex.dto.Implement;

import java.util.List;

import pe.com.huex.entities.Implement;

public class ImplementListDto {

    public ImplementListDto() {
    }

    private List<Implement> implementList = null;

    public ImplementListDto implementList(List<Implement> implementList) {
        this.implementList = implementList;
        return this;
    }

    public void setImplementList(List<Implement> implementList) {
        this.implementList = implementList;
    }

    public List<Implement> getImplementList() {
        return implementList;
    }

}

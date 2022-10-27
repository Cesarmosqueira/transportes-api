package pe.com.huex.dto.Implement;

import pe.com.huex.entities.Implement;

public class ImplementRetrieveDto {

    public ImplementRetrieveDto() {
    }

    private Implement implement = null;

    public ImplementRetrieveDto implement(Implement implement) {
        this.implement = implement;
        return this;
    }

    public void setImplement(Implement implement) {
        this.implement = implement;
    }

    public Implement getImplement() {
        return implement;
    }

}

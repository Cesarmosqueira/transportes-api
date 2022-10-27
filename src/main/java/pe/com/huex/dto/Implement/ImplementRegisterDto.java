package pe.com.huex.dto.Implement;

import pe.com.huex.entities.Implement;

public class ImplementRegisterDto {
    private Implement implement = null;

    public ImplementRegisterDto() {
    }

    public ImplementRegisterDto implement(Implement implement) {
        this.implement = implement;
        return this;
    }

    public Implement getImplement() {
        return implement;
    }

    public void setImplement(Implement implement) {
        this.implement = implement;
    }

}

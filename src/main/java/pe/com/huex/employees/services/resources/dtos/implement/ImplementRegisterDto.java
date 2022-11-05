package pe.com.huex.employees.services.resources.dtos.implement;

import pe.com.huex.employees.domain.entities.Implement;

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

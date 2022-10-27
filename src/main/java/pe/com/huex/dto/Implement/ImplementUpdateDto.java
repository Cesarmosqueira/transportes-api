package pe.com.huex.dto.Implement;

import pe.com.huex.entities.Implement;

public class ImplementUpdateDto {
    private Implement implement = null;

    public ImplementUpdateDto() {
    }

    public ImplementUpdateDto implement(Implement implement) {
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

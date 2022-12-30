package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import pe.com.huex.employees.services.resources.dtos.ImplementDto;

import java.util.List;

@Data
public class ImplementListResponse {

    private List<ImplementDto> implementss = null;

    public ImplementListResponse implementss(List<ImplementDto> implementss) {
        this.implementss = implementss;
        return this;
    }
}

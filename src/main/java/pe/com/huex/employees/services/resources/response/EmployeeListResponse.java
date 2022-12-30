package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.services.resources.dtos.EmployeeDto;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeListResponse {
    private List<EmployeeDto> employees = null;

    public EmployeeListResponse employees(List<EmployeeDto> employeeDtoList) {
        this.employees = employeeDtoList;
        return this;
    }
}

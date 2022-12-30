package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import pe.com.huex.employees.services.resources.dtos.EmployeeDto;

@Data
public class EmployeeResponse {
    private EmployeeDto employee = null;

    public EmployeeResponse employee(EmployeeDto employeeDto) {
        this.employee = employeeDto;
        return this;
    }
}

package pe.com.huex.employees.services.resources.response.employees;

import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.services.resources.dtos.EmployeeResponseDto;

public class EmployeeUpdateDto {
    private EmployeeResponseDto employee = null;

    public EmployeeUpdateDto() {
    }

    public EmployeeUpdateDto employee(Employee employee) {
        this.employee = new EmployeeResponseDto(employee);
        return this;
    }

    public EmployeeResponseDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeResponseDto employee) {
        this.employee = employee;
    }

}

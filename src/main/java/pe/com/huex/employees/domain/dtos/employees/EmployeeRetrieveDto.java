package pe.com.huex.employees.domain.dtos.employees;

import pe.com.huex.employees.domain.entities.Employee;

public class EmployeeRetrieveDto {

    public EmployeeRetrieveDto() {
    }

    private EmployeeResponseDto employee = null;

    public EmployeeRetrieveDto employee(Employee employee) {
        EmployeeResponseDto employeeDto = new EmployeeResponseDto(employee);
        this.employee = employeeDto;
        return this;
    }

    public void setEmployee(EmployeeResponseDto employee) {
        this.employee = employee;
    }

    public EmployeeResponseDto getEmployee() {
        return employee;
    }
}

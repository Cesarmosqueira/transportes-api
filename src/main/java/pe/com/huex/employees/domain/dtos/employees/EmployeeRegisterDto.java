package pe.com.huex.employees.domain.dtos.employees;

import pe.com.huex.employees.domain.entities.Employee;

public class EmployeeRegisterDto {
    private EmployeeResponseDto employee = null;

    public EmployeeRegisterDto() {
    }

    public EmployeeRegisterDto employee(Employee employee) {
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

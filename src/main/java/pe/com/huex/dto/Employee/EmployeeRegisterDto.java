package pe.com.huex.dto.Employee;

import pe.com.huex.entities.Employee;

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

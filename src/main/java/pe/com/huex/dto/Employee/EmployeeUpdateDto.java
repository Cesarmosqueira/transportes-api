package pe.com.huex.dto.Employee;

import pe.com.huex.entities.Employee;

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

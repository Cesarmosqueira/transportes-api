package pe.com.huex.dto.Employee;

import pe.com.huex.entities.Employee;

public class EmployeeUpdateDto {
    private Employee employee = null;

    public EmployeeUpdateDto() {
    }

    public EmployeeUpdateDto employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}

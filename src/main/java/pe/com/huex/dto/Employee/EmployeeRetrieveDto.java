package pe.com.huex.dto.Employee;

import pe.com.huex.entities.Employee;

public class EmployeeRetrieveDto {

    public EmployeeRetrieveDto() {
    }

    private Employee employee = null;

    public EmployeeRetrieveDto employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

}

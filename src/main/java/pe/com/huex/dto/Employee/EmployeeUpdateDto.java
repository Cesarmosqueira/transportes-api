package pe.com.huex.dto.Employee;

import pe.com.huex.entities.Employee;

public class EmployeeUpdateDto {
    private Employee provider = null;

    public EmployeeUpdateDto() {
    }

    public EmployeeUpdateDto provider(Employee provider) {
        this.provider = provider;
        return this;
    }

    public Employee getEmployee() {
        return provider;
    }

    public void setEmployee(Employee provider) {
        this.provider = provider;
    }

}

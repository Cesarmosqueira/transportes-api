package pe.com.huex.dto.Employee;

import pe.com.huex.entities.Employee;

public class EmployeeRegisterDto {
    private Employee provider = null;

    public EmployeeRegisterDto() {
    }

    public EmployeeRegisterDto provider(Employee provider) {
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

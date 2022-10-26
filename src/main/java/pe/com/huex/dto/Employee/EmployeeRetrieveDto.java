package pe.com.huex.dto.Employee;

import pe.com.huex.entities.Employee;

public class EmployeeRetrieveDto {

    public EmployeeRetrieveDto() {
    }

    private Employee provider = null;

    public EmployeeRetrieveDto provider(Employee provider) {
        this.provider = provider;
        return this;
    }

    public void setEmployee(Employee provider) {
        this.provider = provider;
    }

    public Employee getEmployee() {
        return provider;
    }

}

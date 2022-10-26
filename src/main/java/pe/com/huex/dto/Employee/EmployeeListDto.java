package pe.com.huex.dto.Employee;

import java.util.List;

import pe.com.huex.entities.Employee;

public class EmployeeListDto {

    public EmployeeListDto() {
    }

    private List<Employee> providerList = null;

    public EmployeeListDto providerList(List<Employee> providerList) {
        this.providerList = providerList;
        return this;
    }

    public void setEmployeeList(List<Employee> providerList) {
        this.providerList = providerList;
    }

    public List<Employee> getEmployeeList() {
        return providerList;
    }

}

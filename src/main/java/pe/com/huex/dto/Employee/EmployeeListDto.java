package pe.com.huex.dto.Employee;

import java.util.List;

import pe.com.huex.entities.Employee;

public class EmployeeListDto {

    public EmployeeListDto() {
    }

    private List<Employee> employeeList = null;

    public EmployeeListDto employeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
        return this;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

}

package pe.com.huex.employees.services.resources.dtos.employees;

import java.util.ArrayList;
import java.util.List;

import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.services.resources.response.EmployeeResponseDto;

public class EmployeeListDto {

    public EmployeeListDto() {
    }

    private List<EmployeeResponseDto> employeeList = null;

    public EmployeeListDto employeeList(List<Employee> employeeList) {
        this.employeeList = new ArrayList<EmployeeResponseDto>();
        for (Employee emp : employeeList) {
            this.employeeList.add(new EmployeeResponseDto(emp));
        }
        return this;
    }

    public void setEmployeeList(List<EmployeeResponseDto> employeeList) {
        this.employeeList = employeeList;
    }

    public List<EmployeeResponseDto> getEmployeeList() {
        return employeeList;
    }

}

package pe.com.huex.employees.services.resources.response.employees;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.services.resources.dtos.EmployeeResponseDto;

@Data
@NoArgsConstructor
public class EmployeeListDto {
    private List<EmployeeResponseDto> employees = null;

    public EmployeeListDto employeeList(List<Employee> employeeList) {
        this.employees = new ArrayList<EmployeeResponseDto>();
        for (Employee emp : employeeList) {
            this.employees.add(new EmployeeResponseDto(emp));
        }
        return this;
    }
}

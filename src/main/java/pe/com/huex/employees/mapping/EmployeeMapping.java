package pe.com.huex.employees.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.services.resources.dtos.EmployeeDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapping extends ModelMapper implements Serializable {

    public EmployeeMapping() {
        super();
    }

    public List<EmployeeDto> modelList(List<Employee> modelList) {
        return modelList.stream().map(item -> this.map(item, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public Employee model(EmployeeDto employeeDto) {
        return this.map(employeeDto, Employee.class);
    }

    public EmployeeDto modelDto(Employee employee) {
        return this.map(employee, EmployeeDto.class);
    }
}

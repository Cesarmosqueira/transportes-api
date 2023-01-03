package pe.com.huex.employees.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeImplementMapping extends ModelMapper implements Serializable {

    public EmployeeImplementMapping() {
        super();
    }

    public List<EmployeeImplementDto> modelList(List<EmployeeImplement> modelList) {
        return modelList.stream().map(item -> this.map(item, EmployeeImplementDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeImplement model(EmployeeImplementDto employeeImplementDto) {

        return this.map(employeeImplementDto, EmployeeImplement.class);
    }

    public EmployeeImplementDto modelDto(EmployeeImplement employeeImplement) {

        return this.map(employeeImplement, EmployeeImplementDto.class);
    }
}

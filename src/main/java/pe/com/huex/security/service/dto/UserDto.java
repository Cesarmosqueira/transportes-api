package pe.com.huex.security.service.dto;

import lombok.Data;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.services.resources.dtos.EmployeeDto;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private EmployeeDto employee;
    private String userName;
    private String password;
    private Boolean active;
    private List<MenuDto> menus;
}

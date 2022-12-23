package pe.com.huex.security.service.dto;

import lombok.Data;
import pe.com.huex.employees.domain.entities.Employee;

@Data
public class UserDto {
    private Long id;
    private Employee employee;
    private String userName;
    private String password;
    private Long role;
    private Boolean active;
}

package pe.com.huex.customer.services.resources.dto;
import lombok.*;
import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.employees.domain.entities.Employee;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEmployeeDto {

    private Long id;

    private Customer customer;

    private Employee employee;

    private String status;

    private Date registerDate;

    private String observations;
}

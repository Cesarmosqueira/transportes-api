package pe.com.huex.customer.services.resources.dto;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEmployeeDto {

    private Long id;

    private Long idCustomer;

    private Long idEmployee;

    private String status;

    private Date registerDate;

    private String observations;
}

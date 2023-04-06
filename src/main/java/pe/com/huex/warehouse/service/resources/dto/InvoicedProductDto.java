package pe.com.huex.warehouse.service.resources.dto;

import lombok.*;
import pe.com.huex.customer.services.resources.dto.CustomerDto;


import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class InvoicedProductDto {

    private Long id;
    private CustomerDto customer;
    private String productDescription;
    private Double unitsStock;
    private String grr;
    private String invoice;
    private Date admissionDate;
    private Double priceSale;
}

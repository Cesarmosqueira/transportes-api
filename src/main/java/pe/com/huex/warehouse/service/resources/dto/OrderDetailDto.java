package pe.com.huex.warehouse.service.resources.dto;

import lombok.*;


import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {

    private Long id;
    private InvoicedProductDto invoicedProduct;
    private Date saleDate;
    private String seller;
    private String buyer;
    private Double unitPrice;
    private String observation;
}

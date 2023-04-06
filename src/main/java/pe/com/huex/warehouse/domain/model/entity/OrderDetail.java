package pe.com.huex.warehouse.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.customer.domain.entities.Customer;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiced_product_id",nullable = false)
    @JsonIgnore
    private InvoicedProduct invoicedProduct;

    @Column(name = "sale_date")
    private Date saleDate;
    @Column(name = "seller",length = 128)
    private String seller;
    @Column(name = "buyer",length = 128)
    private String buyer;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "observation")
    private String observation;

}

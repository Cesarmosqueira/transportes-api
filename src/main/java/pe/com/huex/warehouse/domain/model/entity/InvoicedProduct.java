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
@Table(name = "invoiced_product")
public class InvoicedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",nullable = false)
    @JsonIgnore
    private Customer customer;

    @Column(name = "product_description",length = 128,nullable = false)
    private String productDescription;

    @Column(name = "units_stock")
    private Double unitsStock;

    @Column(name = "grr",length = 128)
    private String grr;
    @Column(name = "invoice",length = 128)
    private String invoice;
    @Column(name = "admission_date")
    private Date admissionDate;
    @Column(name = "price_sale")
    private Double priceSale;

}

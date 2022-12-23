package pe.com.huex.providers.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tire_replacement")
public class TireReplacement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column(name = "replacement_date", nullable = false)
    private Date replacementDate;

    @Column(name = "tire_quantity",nullable = false)
    private Integer tireQuantity;

    @Column(name = "unit_price",nullable = false)
    private Double unitPrice;

    @Column(name = "total_price",nullable = false)
    private  Double totalPrice;

    @Column(name = "brand", length = 64)
    private String brand;
    @Column(name = "model", length = 64)
    private String model;
    @Column(name = "observation", length = 200)
    private String observation;



}

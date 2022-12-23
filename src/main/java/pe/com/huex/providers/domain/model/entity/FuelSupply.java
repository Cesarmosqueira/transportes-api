package pe.com.huex.providers.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "fuel_supply")
public class FuelSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column(name = "date_fuel", nullable = false)
    private Date dateFuel;

    @Column(name = "fuel_quantity",nullable = false)
    private Integer fuelQuantity;

    @Column(name = "gallon_price",nullable = false)
    private Double gallonPrice;

    @Column(name = "total_price",nullable = false)
    private Double totalPrice;

    @Column(name = "observation", length = 200)
    private String observation;


}

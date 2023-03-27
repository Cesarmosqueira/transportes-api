package pe.com.huex.providers.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "fuel_supply")
public class FuelSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnore
    private Provider provider;

    @Column(name = "date_fuel", nullable = false)
    private Date dateFuel;

    @Column(name = "fuel_quantity",nullable = false)
    private Integer fuelQuantity;

    @Column(name = "gallon_price",nullable = false)
    private Double gallonPrice;


    @Column(name = "observation", length = 200)
    private String observation;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "mileage", length = 1)
    private Long mileage;

    private String name;

    @OneToMany(mappedBy = "fuelSupply", cascade = CascadeType.ALL)
    private List<KardexFuel> kardexFuels = new ArrayList<>();
}

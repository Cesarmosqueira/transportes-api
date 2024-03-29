package pe.com.huex.providers.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.providers.domain.model.entity.FuelSupply;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "kardex_fuel")
public class KardexFuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tractPlate", nullable = false)
    private String tractPlate;

    @ManyToOne
    @JoinColumn(name = "id_fuel_supply", nullable = false)
    @JsonIgnore
    private FuelSupply fuelSupply;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "amount_fuel", nullable = false)
    private Integer amountFuel;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "duty_manager", length = 128)
    private String dutyManager;

    @Column(name = "operation", nullable = false, length = 1)
    private String operation;

    @Column(name = "unitPrice", nullable = false)
    private Double unitPrice;
}
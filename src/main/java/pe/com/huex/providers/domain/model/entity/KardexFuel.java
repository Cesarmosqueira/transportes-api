package pe.com.huex.providers.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.providers.domain.model.entity.FuelSupply;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "kardex_fuel")
public class KardexFuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    @JsonIgnore
    private TruckFleet truckFleet;

    @ManyToOne
    @JoinColumn(name = "id_fuel_supply", nullable = false)
    @JsonIgnore
    private FuelSupply fuelSupply;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "amount_fuel", nullable = false)
    private Long amountFuel;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "duty_manager", length = 40)
    private String dutyManager;
}
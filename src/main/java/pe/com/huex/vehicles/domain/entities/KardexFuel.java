package pe.com.huex.vehicles.domain.entities;

import lombok.*;

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

    @Column(name = "id_truck_fleet")
    private Long idTruckFleet;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "amount_fuel", nullable = false)
    private Integer amountFuel;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "duty_manager", length = 40)
    private String dutyManager;

}
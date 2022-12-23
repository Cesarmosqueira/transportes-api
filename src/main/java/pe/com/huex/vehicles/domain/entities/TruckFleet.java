package pe.com.huex.vehicles.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pe.com.huex.providers.domain.model.entity.Provider;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "truck_fleet")
public class TruckFleet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_Provider")
    private Long idProvider;

    @Column(name = "tract_plate", nullable = false, length = 6)
    private String tractPlate;

    @Column(name = "van_plate", length = 6)
    private String vanPlate;

    @Column(name = "brand", length = 10)
    private String brand;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "fabrication_date")
    private Date fabricationDate;

    @Column(name = "ton_number")
    private Double tonNumber;

    @Column(name = "axes")
    private Integer axes;

    @Column(name = "model", length = 30)
    private String model;

    @Column(name = "high_wide_long", length = 30)
    private String highWideLong;

    @Column(name = "fleet_type", length = 30)
    private String fleetType;
}
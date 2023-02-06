package pe.com.huex.vehicles.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "maintenance_oil")
public class MaintenanceOil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    @JsonIgnore
    private TruckFleet truckFleet;

    @Column(name = "change_type", length = 30,nullable = false)
    private String changeType;

    @Column(name = "place", length = 30,nullable = false)
    private String place;

    @Column(name = "date_change",nullable = false)
    private Date dateChange;

    @Column(name = "km_last",nullable = false)
    private Integer kmLast;

    @Column(name = "km_current",nullable = false)
    private Integer kmCurrent;

    @Column(name = "km_next",nullable = false)
    private Integer kmNext;

    @Column(name = "status")
    private String status;

    @Column(name = "date_current")
    private Date dateCurrent;

    @Column(name = "differences")
    private Integer differences;

}
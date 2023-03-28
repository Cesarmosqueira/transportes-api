package pe.com.huex.vehicles.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.providers.domain.model.entity.Provider;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "maintenance_oil")
public class MaintenanceOil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provider")
    @JsonIgnore
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    @JsonIgnore
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    @JsonIgnore
    private TruckFleet truckFleet;

    @Column(name = "change_type", length = 64,nullable = false)
    private String changeType;

    @Column(name = "place", length = 64,nullable = false)
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

    @Column(name = "change_km")
    private Double changeKm;

}
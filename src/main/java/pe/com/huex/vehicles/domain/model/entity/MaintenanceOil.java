package pe.com.huex.vehicles.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenance_oil")
public class MaintenanceOil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_truck_fleet")
    private Long idTruckFleet;

    @Column(name = "change_type", length = 30)
    private String changeType;

    @Column(name = "place", length = 30)
    private String place;

    @Column(name = "date_change")
    private Date dateChange;

    @Column(name = "km_last")
    private Integer kmLast;

    @Column(name = "km_current")
    private Integer kmCurrent;

    @Column(name = "km_next")
    private Integer kmNext;

    @Column(name = "status")
    private Integer status;

    @Column(name = "date_current")
    private Date dateCurrent;

    @Column(name = "differences")
    private Integer differences;

}
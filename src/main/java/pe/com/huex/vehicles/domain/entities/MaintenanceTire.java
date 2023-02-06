package pe.com.huex.vehicles.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "maintenance_tire")
public class MaintenanceTire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    @JsonIgnore
    private TruckFleet truckFleet;

    @Column(name = "date_review",nullable = false)
    private Date dateReview;

    @Column(name = "date_renewal",nullable = false)
    private Date dateRenewal;

    @Column(name = "status_tire", length = 30,nullable = false)
    private String statusTire;

}
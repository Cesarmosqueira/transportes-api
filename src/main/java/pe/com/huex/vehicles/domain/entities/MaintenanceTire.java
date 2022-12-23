package pe.com.huex.vehicles.domain.entities;

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

    @Column(name = "id_truck_fleet")
    private Long idTruckFleet;

    @Column(name = "date_review")
    private Date dateReview;

    @Column(name = "date_renewal")
    private Date dateRenewal;

    @Column(name = "status_tire", length = 30)
    private String statusTire;

}
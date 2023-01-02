package pe.com.huex.services.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "service_incident")
public class ServiceIncidents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tracking_service_id", nullable = false)
    private TrackingService trackingService;

    @Column(name = "grt")
    private String grt;

    @Column(name = "grr")
    private String grr;

    @Column(name = "order")
    private String order;

    @Column(name = "quantity_units")
    private String quantityUnits;


    @Column(name = "observation")
    private String observation;
}

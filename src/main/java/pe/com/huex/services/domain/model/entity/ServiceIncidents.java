package pe.com.huex.services.domain.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "service_incident")
public class ServiceIncidents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_service", nullable = false)
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

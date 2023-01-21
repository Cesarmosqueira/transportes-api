package pe.com.huex.services.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "service_incident")
public class ServiceIncidents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tracking_service_id", nullable = false)
    @JsonIgnore
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

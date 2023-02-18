package pe.com.huex.customer.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.services.domain.entities.TrackingService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    @JsonIgnore
    private Route route;

    @Column(nullable = true, length = 64)
    private String leadTime;

    @Column(nullable = true)
    private String tonNumber;

    @Column(nullable = true)
    private int volume;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = true, length = 200)
    private String observationRate;


    @OneToMany(mappedBy = "rate", cascade = CascadeType.ALL)
    private List<TrackingService> trackingServices = new ArrayList<>();

}

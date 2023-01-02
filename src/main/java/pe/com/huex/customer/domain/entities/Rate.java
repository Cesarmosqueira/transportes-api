package pe.com.huex.customer.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column(nullable = true, length = 64)
    private String leadTime;

    @Column(nullable = true)
    private int volume;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = true, length = 200)
    private String observationRate;

}

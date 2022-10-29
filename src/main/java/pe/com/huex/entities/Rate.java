package pe.com.huex.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "province_estivators")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rute_id", nullable = false)
    private Rute rute;

    @Column(nullable = true, length = 64)
    private String leadTime;

    @Column(nullable = true)
    private int volume;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = true, length = 200)
    private String observationRate;

}
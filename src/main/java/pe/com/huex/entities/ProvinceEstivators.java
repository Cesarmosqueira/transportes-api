package pe.com.huex.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "province_estivators")
public class ProvinceEstivators {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rute_id", nullable = false)
    private Rute rute;

    @Column(nullable = false, length =128)
    private String name;

    @Column(nullable = true, length = 32)
    private String phone;

    @Column(nullable = false)
    private double CostM3;

    @Column(nullable = true, length = 250)
    private String Observation;
}

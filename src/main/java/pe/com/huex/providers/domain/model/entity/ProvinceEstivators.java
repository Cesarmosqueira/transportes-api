package pe.com.huex.providers.domain.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customers.domain.model.entity.Rute;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column(nullable = false)
    private double CostM3;

    @Column(nullable = true, length = 250)
    private String Observation;
}

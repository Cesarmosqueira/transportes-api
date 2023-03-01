package pe.com.huex.customer.domain.entities;

import lombok.*;
import pe.com.huex.providers.domain.model.entity.ProvinceEstivators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String routeStart;

    @Column(nullable = false, length = 128)
    private String routeEnd;

    @Column(nullable = false, length = 32)
    private String zone;

    @Column(nullable = true)
    private double distanceKM;

    @Column(nullable = true, length = 32)
    private double gallons;

    // Relations
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ProvinceEstivators> provinceEstivators = new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
    private List<Rate> rates = new ArrayList<>();
}

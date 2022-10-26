package pe.com.huex.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rutes")
public class Rute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 64)
    private String routeStart;

    @Column(nullable = false, length = 64)
    private String routeEnd;

    @Column(nullable = false, length = 32)
    private String zone;

    @Column(nullable = true)
    private double distanceKM;

    @Column(nullable = true, length = 32)
    private double gallons;

}

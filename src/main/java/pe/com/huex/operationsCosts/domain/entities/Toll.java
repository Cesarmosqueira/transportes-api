package pe.com.huex.operationsCosts.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tolls")
public class Toll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "place",length = 128)
    private String place;
    @Column(name = "configuration",length = 128)
    private String configuration;
    @Column(name = "cost")
    private Double cost;
}

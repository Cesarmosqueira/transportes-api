package pe.com.huex.operationsCosts.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.customer.domain.entities.Route;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "route_tolls")
public class RouteToll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    @JsonIgnore
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toll_id")
    @JsonIgnore
    private Toll toll;

    @Column(name = "journey",length = 128)
    private String journey;




}

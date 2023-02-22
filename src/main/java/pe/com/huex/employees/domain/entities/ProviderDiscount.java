package pe.com.huex.employees.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.providers.domain.model.entity.Provider;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "provider_discount")
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    @JsonIgnore
    private Provider provider;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @Column(nullable = true, length = 512)
    private String observations;

    @Column(nullable = true, length = 64)
    private String status;

    @Column(nullable = true)
    private double charge;

}

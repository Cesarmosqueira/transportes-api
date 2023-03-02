package pe.com.huex.services.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "service_incident")
public class ServiceIncidents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_service_id", nullable = false)
    @JsonIgnore
    private TrackingService trackingService;

    @Column(name = "folio",length = 128)
    private String folio;

    @Column(name = "sku",length = 128)
    private String sku;

    @Column(name = "name_product",length = 255)
    private String nameProduct;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @Column(name = "observation_date")
    private Date observationDate;

    @Column(name = "damage_type",length = 128)
    private String damageType;

    @Column(name = "motive",length = 128)
    private String motive;

    @Column(name = "responsible",length = 128)
    private String responsible;

    @Column(name = "full_name",length = 128)
    private String fullName;

    @Column(name = "stored",length = 128)
    private String stored;

    @Column(name = "quantity_units",length = 64)
    private String quantityUnits;

    @Column(name = "observation",length = 255)
    private String observation;

    @Column(name = "grt",length = 64)
    private String grt;

    @Column(name = "grr",length = 64)
    private String grr;

    @Column(name = "order",length = 64)
    private String order;


}

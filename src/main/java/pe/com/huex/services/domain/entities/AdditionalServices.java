package pe.com.huex.services.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "additional_services")
public class AdditionalServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truck_fleet_id")
    @JsonIgnore
    private TruckFleet truckFleet;

    @Column(name = "resources",length = 128)
    private String resources;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "invoice_detail",length = 128)
    private String invoiceDetail;

    @Column(name = "status",length = 128)
    private String status;

    @Column(name = "observation",length = 255)
    private String observation;

    @Column(name = "person_request",length = 128)
    private String personRequest;


}

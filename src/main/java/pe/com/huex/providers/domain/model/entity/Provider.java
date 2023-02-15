package pe.com.huex.providers.domain.model.entity;

import lombok.*;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ruc", nullable = false, length = 16)
    private String ruc;

    @Column(name = "business_name", nullable = false, length = 128)
    private String businessName;

    @Column(name = "contact_name", nullable = false, length = 128)
    private String contactName;

    @Column(name = "email", length = 128)
    private String email;

    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "address", length = 128)
    private String address;

    @Column(name = "admission_date")
    private Date admissionDate;

    @Column(name = "bank_name", length = 128)
    private String bankName;

    @Column(name = "bank_account", length = 32)
    private String bankAccount;

    @Column(name = "interbank_account", length = 32)
    private String interbankAccount;

    @Column(name = "provider_type", length = 128)
    private String providerType;

    @Column(name = "observation", length = 200)
    private String observation;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<ProvinceEstivators> provinceEstivators = new ArrayList<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<TruckFleet> truckFleets = new ArrayList<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<TireReplacement> tireReplacement = new ArrayList<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<FuelSupply> fuelSupply = new ArrayList<>();
}

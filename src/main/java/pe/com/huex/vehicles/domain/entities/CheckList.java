package pe.com.huex.vehicles.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "check_list")
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    @JsonIgnore
    private TruckFleet truckFleet;

    @Column(name = "date")
    private Date date;

    @Column(name = "name_photo")
    private String namePhoto;

    @Column(name = "photo")
    private byte[] photo;


}
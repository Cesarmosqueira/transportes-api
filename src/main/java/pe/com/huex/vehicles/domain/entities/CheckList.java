package pe.com.huex.vehicles.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "check_list")
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_truck_fleet")
    private Long idTruckFleet;

    @Column(name = "date")
    private Date date;

    @Column(name = "name_photo")
    private String namePhoto;

    @Column(name = "photo")
    private byte[] photo;


}
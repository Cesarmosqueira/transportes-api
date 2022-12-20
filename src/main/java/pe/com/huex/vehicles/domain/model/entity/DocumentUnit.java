package pe.com.huex.vehicles.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documents_units")
public class DocumentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_truck_fleet")
    private Long idTruckFleet;

    @Column(name = "fire_extinguisher_expiration")
    private Date fireExtinguisherExpiration;

    @Column(name = "first_aid_kit_expiration")
    private Date firstAidKitExpiration;

    @Column(name = "technical_review_expiration")
    private Date technicalReviewExpiration;

    @Column(name = "name_photo_technical_review", length = 100)
    private String namePhotoTechnicalReview;

    @Column(name = "photo_technical_review")
    private byte[] photoTechnicalReview;

    @Column(name = "soat_expiration")
    private Date soatExpiration;

    @Column(name = "name_photo_soat", length = 100)
    private String namePhotoSoat;

    @Column(name = "photo_soat")
    private byte[] photoSoat;

    @Column(name = "mtc_expiration")
    private Date mtcExpiration;

    @Column(name = "name_photo_mtc", length = 100)
    private String namePhotoMtc;

    @Column(name = "photo_mtc")
    private byte[] photoMtc;

    @Column(name = "policy")
    private byte[] policy;

    @Column(name = "expiration_policy")
    private Date expirationPolicy;

    @Column(name = "name_photo_policy", length = 100)
    private String namePhotoPolicy;

    @Column(name = "photo_policy")
    private byte[] photoPolicy;

}
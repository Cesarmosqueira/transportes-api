package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DocumentUnitDto {
    private Long id;
    private Long idTruckFleet;
    private Date fireExtinguisherExpiration;
    private Date firstAidKitExpiration;
    private Date technicalReviewExpiration;
    private String namePhotoTechnicalReview;
    private byte[] photoTechnicalReview;
    private Date soatExpiration;
    private String nameSoatPhoto;
    private byte[] photoSoat;
    private Date mtcExpiration;
    private String namePhotoMtc;
    private byte[] photoMtc;
    private byte[] policy;
    private Date expirationPolicy;
    private String namePhotoPolicy;
    private byte[] photoPolicy;
}
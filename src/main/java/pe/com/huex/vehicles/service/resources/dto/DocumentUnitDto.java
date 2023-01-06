package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.Date;

@Getter
@Setter
public class DocumentUnitDto {
    private Long id;
    private TruckFleet truckFleet;
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
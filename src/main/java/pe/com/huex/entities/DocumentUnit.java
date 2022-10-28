package pe.com.huex.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "documents_units")
public class DocumentUnit {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_truck_fleet", nullable = false)
    private TruckFleet truckFleet;

    @Column(name = "fire_extinguisher_expiration")
    private Instant fireExtinguisherExpiration;

    @Column(name = "first_aid_kit_expiration")
    private Instant firstAidKitExpiration;

    @Column(name = "technical_review_expiration")
    private Instant technicalReviewExpiration;

    @Column(name = "photo_technical_review")
    private byte[] photoTechnicalReview;

    @Column(name = "soat_expiration")
    private Instant soatExpiration;

    @Column(name = "soat_photo")
    private byte[] soatPhoto;

    @Column(name = "mtc_expiration")
    private Instant mtcExpiration;

    @Column(name = "photo_mtc")
    private byte[] photoMtc;

    @Column(name = "policy", length = 30)
    private String policy;

    @Column(name = "expiration_policy")
    private Instant expirationPolicy;

    @Column(name = "photo_policy")
    private byte[] photoPolicy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TruckFleet getTruckFleet() {
        return truckFleet;
    }

    public void setTruckFleet(TruckFleet truckFleet) {
        this.truckFleet = truckFleet;
    }

    public Instant getFireExtinguisherExpiration() {
        return fireExtinguisherExpiration;
    }

    public void setFireExtinguisherExpiration(Instant fireExtinguisherExpiration) {
        this.fireExtinguisherExpiration = fireExtinguisherExpiration;
    }

    public Instant getFirstAidKitExpiration() {
        return firstAidKitExpiration;
    }

    public void setFirstAidKitExpiration(Instant firstAidKitExpiration) {
        this.firstAidKitExpiration = firstAidKitExpiration;
    }

    public Instant getTechnicalReviewExpiration() {
        return technicalReviewExpiration;
    }

    public void setTechnicalReviewExpiration(Instant technicalReviewExpiration) {
        this.technicalReviewExpiration = technicalReviewExpiration;
    }

    public byte[] getPhotoTechnicalReview() {
        return photoTechnicalReview;
    }

    public void setPhotoTechnicalReview(byte[] photoTechnicalReview) {
        this.photoTechnicalReview = photoTechnicalReview;
    }

    public Instant getSoatExpiration() {
        return soatExpiration;
    }

    public void setSoatExpiration(Instant soatExpiration) {
        this.soatExpiration = soatExpiration;
    }

    public byte[] getSoatPhoto() {
        return soatPhoto;
    }

    public void setSoatPhoto(byte[] soatPhoto) {
        this.soatPhoto = soatPhoto;
    }

    public Instant getMtcExpiration() {
        return mtcExpiration;
    }

    public void setMtcExpiration(Instant mtcExpiration) {
        this.mtcExpiration = mtcExpiration;
    }

    public byte[] getPhotoMtc() {
        return photoMtc;
    }

    public void setPhotoMtc(byte[] photoMtc) {
        this.photoMtc = photoMtc;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Instant getExpirationPolicy() {
        return expirationPolicy;
    }

    public void setExpirationPolicy(Instant expirationPolicy) {
        this.expirationPolicy = expirationPolicy;
    }

    public byte[] getPhotoPolicy() {
        return photoPolicy;
    }

    public void setPhotoPolicy(byte[] photoPolicy) {
        this.photoPolicy = photoPolicy;
    }

}
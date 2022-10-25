package pe.com.huex.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ruc", nullable = false, length = 12)
    private String ruc;

    @Column(name = "business_name", nullable = false, length = 30)
    private String businessName;

    @Column(name = "contact_name", nullable = false, length = 30)
    private String contactName;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "phone_number", length = 16)
    private String phoneNumber;

    @Column(name = "address", length = 64)
    private String address;

    @Column(name = "admission_date", nullable = false)
    private Date admissionDate;

    @Column(name = "bank_account", length = 30)
    private String bankAccount;

    @Column(name = "observation", length = 200)
    private String observation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

}
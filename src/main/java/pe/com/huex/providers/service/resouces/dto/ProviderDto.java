package pe.com.huex.providers.service.resouces.dto;

import lombok.*;

import java.util.Date;

@Data
public class ProviderDto {
    private Long id;

    private String ruc;

    private String businessName;

    private String contactName;

    private String email;

    private String phoneNumber;

    private String address;

    private Date admissionDate;

    private String bankAccount;

    private String observation;

}

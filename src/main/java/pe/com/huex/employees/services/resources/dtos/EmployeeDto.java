package pe.com.huex.employees.services.resources.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private Long id;
	private String fullName;
	private String documentType;
	private String dni;
	private String currentState;
	private String placeOfBirth;
	private Date birthDate;
	private String address;
	private String phoneNumber;
	private String email;
	private Date joinDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date ceaseDate;
	private String bankAccount;
	private String contractType;
	private String maritalStatus;
	private String pensionSystem;
	private int childrens;
	private String academicQualification;
	private String criminalRecords;
	private String kinhood;
	private String kinFullName;
	private String kinPhoneNumber;
	private double salary;
	private String role;
	private String licenseCategory;
	private Date licenseExpirationDate;
	private Date dniExpirationDate;
	private byte[] photoUrl;
}

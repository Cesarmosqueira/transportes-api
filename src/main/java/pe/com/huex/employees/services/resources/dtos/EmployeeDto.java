package pe.com.huex.employees.services.resources.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;
import pe.com.huex.customer.domain.entities.CustomerEmployee;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.domain.entities.EmployeeAttendance;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.security.domain.entities.User;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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

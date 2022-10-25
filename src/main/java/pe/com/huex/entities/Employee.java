package pe.com.huex.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employee")
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 256)
	private String fullName;

	@Column(nullable = false, length = 16)
	private String documentType;

	@Column(nullable = false, length = 16)
	private String dni;

	@Column(nullable = false, length = 16)
	private String currentState;

	@Column(nullable = true, length = 64)
	private String placeOfBirth;

	@Column(nullable = true)
	private Date birthDate;

	@Column(nullable = true, length = 64)
	private String address;

	@Column(nullable = false, length = 16)
	private String phoneNumber;

	@Column(nullable = true, length = 64)
	private String email;

	@Column(nullable = false, length = 64)
	private Date joinDate;

	@Column(nullable = true, length = 64)
	private Date ceaseDate;

	@Column(nullable = true, length = 32)
	private String bankAccount;

	@Column(nullable = true, length = 32)
	private String contractType;

	@Column(nullable = true, length = 32)
	private String maritalStatus;

	@Column(nullable = true, length = 32)
	private String pensionSystem;

	@Column(nullable = true)
	private int childrens;

	@Column(nullable = true, length = 32)
	private String academicQualification;

	@Column(nullable = true, length = 64)
	private String criminalRecords;

	@Column(nullable = true, length = 64)
	private String kinhood;

	@Column(nullable = true, length = 64)
	private String kinFullName;

	@Column(nullable = true, length = 16)
	private String kinPhoneNumber;

	@Column(nullable = true)
	private double salary;

	@Column(nullable = false, length = 32)
	private String role;

	@Column(nullable = true, length = 16)
	private String licenseCategory;

	@Column(nullable = true, length = 16)
	private Date licenseExpirationDate;

	@Column(nullable = true, length = 16)
	private Date dniExpirationDate;

	@Column(nullable = true, length = 256)
	private String photoUrl;

	// Relations
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmployeeAttendance> attendance = new ArrayList<>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EmployeeImplement> currentImplements = new ArrayList<>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EmployeeDiscount> discounts = new ArrayList<>();

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private ClientEmployee clientEmployee;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private EmployeeAuxiliar auxiliarEmployee;

}

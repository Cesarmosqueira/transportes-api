package pe.com.huex.employees.domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.profile.Fetch;
import pe.com.huex.customer.domain.entities.CustomerEmployee;
import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.security.domain.entities.User;
import pe.com.huex.services.domain.entities.TrackingService;
import pe.com.huex.vehicles.domain.entities.MaintenanceOil;

@Getter
@Setter
@Entity
@Table(name = "employee")
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 256)
	private String fullName;

	@Column(nullable = false, length = 32)
	private String documentType;

	@Column(nullable = false, length = 16)
	private String dni;

	@Column(nullable = false, length = 16)
	private String currentState;

	@Column(nullable = true, length = 128)
	private String placeOfBirth;

	@Column(nullable = true)
	private Date birthDate;

	@Column(nullable = true, length = 128)
	private String address;

	@Column(nullable = false, length = 32)
	private String phoneNumber;

	@Column(nullable = true, length = 128)
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

	@Column(nullable = true, length = 64)
	private String academicQualification;

	@Column(nullable = true, length = 64)
	private String criminalRecords;

	@Column(nullable = true, length = 128)
	private String kinhood;

	@Column(nullable = true, length = 128)
	private String kinFullName;

	@Column(nullable = true, length = 32)
	private String kinPhoneNumber;

	@Column(nullable = true)
	private double salary;

	@Column(nullable = false, length = 32)
	private String role;

	@Column(nullable = true, length = 32)
	private String licenseCategory;

	@Column(nullable = true, length = 16)
	private Date licenseExpirationDate;

	@Column(nullable = true, length = 16)
	private Date dniExpirationDate;

	@Column(nullable = true, length = 256)
	private byte[] photoUrl;

	// Relations
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmployeeAttendance> attendances = new ArrayList<>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<EmployeeImplement> employeeImplements = new ArrayList<>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<EmployeeDiscount> discounts = new ArrayList<>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CustomerEmployee> customerEmployees = new ArrayList<>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<MaintenanceOil> maintenanceOil = new ArrayList<>();

	@OneToMany(mappedBy = "driver", cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	private List<TrackingService> driverList = new ArrayList<>();

	@OneToMany(mappedBy = "copilot", cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	private List<TrackingService> copilotList = new ArrayList<>();

	@OneToMany(mappedBy = "stevedore", cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	private List<TrackingService> stevedoreList = new ArrayList<>();

}

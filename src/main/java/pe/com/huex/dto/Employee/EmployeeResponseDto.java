package pe.com.huex.dto.Employee;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.entities.Employee;

@Data
@NoArgsConstructor
public class EmployeeResponseDto {
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

	private String photoUrl;

	public EmployeeResponseDto(Employee employee) {
		this.setId(employee.getId());
		this.setFullName(employee.getFullName());
		this.setDocumentType(employee.getDocumentType());
		this.setDni(employee.getDni());
		this.setCurrentState(employee.getCurrentState());
		this.setPlaceOfBirth(employee.getPlaceOfBirth());
		this.setBirthDate(employee.getBirthDate());
		this.setAddress(employee.getAddress());
		this.setPhoneNumber(employee.getPhoneNumber());
		this.setEmail(employee.getEmail());
		this.setJoinDate(employee.getJoinDate());
		this.setCeaseDate(employee.getCeaseDate());
		this.setBankAccount(employee.getBankAccount());
		this.setContractType(employee.getContractType());
		this.setMaritalStatus(employee.getMaritalStatus());
		this.setPensionSystem(employee.getPensionSystem());
		this.setChildrens(employee.getChildrens());
		this.setAcademicQualification(employee.getAcademicQualification());
		this.setCriminalRecords(employee.getCriminalRecords());
		this.setKinhood(employee.getKinhood());
		this.setKinFullName(employee.getKinFullName());
		this.setKinPhoneNumber(employee.getKinPhoneNumber());
		this.setSalary(employee.getSalary());
		this.setRole(employee.getRole());
		this.setLicenseCategory(employee.getLicenseCategory());
		this.setLicenseExpirationDate(employee.getLicenseExpirationDate());
		this.setDniExpirationDate(employee.getDniExpirationDate());
		this.setPhotoUrl(employee.getPhotoUrl());
	}
}

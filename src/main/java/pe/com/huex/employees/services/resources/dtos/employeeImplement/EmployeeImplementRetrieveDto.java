package pe.com.huex.employees.services.resources.dtos.employeeImplement;

import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.services.resources.response.EmployeeImplementRelationDto;

public class EmployeeImplementRetrieveDto {

	public EmployeeImplementRetrieveDto() {
	}

	private EmployeeImplementRelationDto employeeImplement = null;

	public EmployeeImplementRetrieveDto employeeImplement(EmployeeImplement employeeImplement) {
		EmployeeImplementRelationDto employeeImplementDto = new EmployeeImplementRelationDto(employeeImplement);
		this.employeeImplement = employeeImplementDto;
		return this;
	}

	public void setEmployeeImplement(EmployeeImplementRelationDto employeeImplement) {
		this.employeeImplement = employeeImplement;
	}

	public EmployeeImplementRelationDto getEmployeeImplement() {
		return employeeImplement;
	}
}

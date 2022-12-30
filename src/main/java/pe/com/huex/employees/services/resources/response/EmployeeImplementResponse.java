package pe.com.huex.employees.services.resources.response;

import lombok.Getter;
import lombok.Setter;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementDto;

@Getter
@Setter
public class EmployeeImplementResponse {

	private EmployeeImplementDto employeeImplementDto = null;

	public EmployeeImplementResponse() {
	}

	public EmployeeImplementResponse employeeImplement(EmployeeImplement employeeImplement) {
		this.employeeImplementDto = new EmployeeImplementDto(employeeImplement);
		return this;
	}
}

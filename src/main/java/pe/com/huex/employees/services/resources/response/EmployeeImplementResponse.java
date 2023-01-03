package pe.com.huex.employees.services.resources.response;

import lombok.Getter;
import lombok.Setter;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementDto;
import pe.com.huex.employees.services.resources.dtos.ImplementDto;

@Getter
@Setter
public class EmployeeImplementResponse {

	private EmployeeImplementDto employeeImplement = null;

	public EmployeeImplementResponse employeeImplement(EmployeeImplementDto employeeImplement) {
		this.employeeImplement = employeeImplement;
		return this;
	}


}

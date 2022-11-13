package pe.com.huex.employees.services.resources.dtos.employeeImplement;

import lombok.Getter;
import lombok.Setter;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.services.resources.response.EmployeeImplementResponseDto;

@Getter
@Setter
public class EmployeeImplementRegisterDto {

	private EmployeeImplementResponseDto employeeImplementResponseDto = null;

	public EmployeeImplementRegisterDto() {
	}

	public EmployeeImplementRegisterDto employeeImplement(EmployeeImplement employeeImplement) {
		this.employeeImplementResponseDto = new EmployeeImplementResponseDto(employeeImplement);
		return this;
	}
}

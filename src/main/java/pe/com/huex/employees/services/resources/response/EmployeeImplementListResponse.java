package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementDto;
import pe.com.huex.employees.services.resources.dtos.ImplementDto;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeImplementListResponse {

	private List<EmployeeImplementDto> employeeImplement = null;

	public EmployeeImplementListResponse employeeImplement(List<EmployeeImplementDto> employeeImplement) {
		this.employeeImplement = employeeImplement;
		return this;
	}
}

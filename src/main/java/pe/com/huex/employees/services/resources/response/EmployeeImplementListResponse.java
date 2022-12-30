package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementRelationDto;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeImplementListResponse {

	private List<EmployeeImplementRelationDto> employeeImplements = null;

	public EmployeeImplementListResponse employeeImplements(List<EmployeeImplementRelationDto> employeeImplements) {
		this.employeeImplements = employeeImplements;
		return this;
	}
}

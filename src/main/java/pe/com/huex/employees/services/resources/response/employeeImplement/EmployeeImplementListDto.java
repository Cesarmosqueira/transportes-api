package pe.com.huex.employees.services.resources.response.employeeImplement;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementRelationDto;

@Data
@NoArgsConstructor
public class EmployeeImplementListDto {

	private List<EmployeeImplementRelationDto> employeeImplements = null;

	public EmployeeImplementListDto employeeImplementList(List<EmployeeImplement> employeeImplementList) {
		this.employeeImplements = new ArrayList<EmployeeImplementRelationDto>();
		for (EmployeeImplement emp : employeeImplementList) {
			this.employeeImplements.add(new EmployeeImplementRelationDto(emp));
		}
		return this;
	}
}

package pe.com.huex.employees.services.resources.dtos.employeeImplement;

import java.util.ArrayList;
import java.util.List;

import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.services.resources.response.EmployeeImplementRelationDto;

public class EmployeeImplementListDto {

	public EmployeeImplementListDto() {
	}

	private List<EmployeeImplementRelationDto> employeeImplementList = null;

	public EmployeeImplementListDto employeeImplementList(List<EmployeeImplement> employeeImplementList) {
		this.employeeImplementList = new ArrayList<EmployeeImplementRelationDto>();
		for (EmployeeImplement emp : employeeImplementList) {
			this.employeeImplementList.add(new EmployeeImplementRelationDto(emp));
		}
		return this;
	}

	public void setEmployeeImplementList(List<EmployeeImplementRelationDto> employeeImplementList) {
		this.employeeImplementList = employeeImplementList;
	}

	public List<EmployeeImplementRelationDto> getEmployeeImplementList() {
		return employeeImplementList;
	}

}

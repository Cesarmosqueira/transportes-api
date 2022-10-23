package transportes.api.Common;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
	public EntityDtoConverter(ModelMapper modelMapper) {
	}

	// public List<EmployeeDtoResponse> convertEmployeesToDto(List<Employee>
	// employeees) {
	// List<EmployeeDtoResponse> dtos = new ArrayList<EmployeeDtoResponse>();
	// for (Employee employee : employeees) {
	// dtos.add(new EmployeeDtoResponse(employee));
	// }
	// return dtos;
	// }

}

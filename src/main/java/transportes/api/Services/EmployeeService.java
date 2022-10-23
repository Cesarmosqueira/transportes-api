package transportes.api.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportes.api.Common.EntityDtoConverter;
import transportes.api.Entities.Employee;
import transportes.api.Repositories.EmployeeRepository;

@Transactional
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EntityDtoConverter entityDtoConverter;

	public Employee createEmployee(Employee employee) throws Exception {
		return employeeRepository.save(employee);
	}

	public Employee getEmployee(Long id) throws Exception {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new Exception("employee '" + id + "' no existe en la base de datos"));
	}

	public List<Employee> listEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Long id, Employee employee) throws Exception {
		employeeRepository.findById(id)
				.orElseThrow(() -> new Exception("trabajador '" + id + "' no existe en la base de datos"));

		employee.setId(id);
		return employeeRepository.save(employee);
	}
}

package pe.com.huex.employees.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.domain.persistence.IEmployeeRepository;
import pe.com.huex.employees.domain.service.IEmployeeService;
import pe.com.huex.employees.mapping.EmployeeMapping;
import pe.com.huex.employees.services.resources.dtos.EmployeeDto;
import pe.com.huex.employees.services.resources.response.EmployeeListResponse;
import pe.com.huex.employees.services.resources.response.EmployeeResponse;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class EmployeeService implements IEmployeeService {
	private static final String MESSAGE_INQUIRY_EMPLOYEE_SUCCESS = "La consulta de empleados fue exitoso";
	private static final String MESSAGE_INQUIRY_EMPLOYEE_WARN = "No se encontró ningún empleado registrado";

	private static final String MESSAGE_REGISTER_EMPLOYEE_SUCCESS = "El registro del empleado fue exitoso";
	private static final String MESSAGE_REGISTER_EMPLOYEE_WARN = "Ocurrió un error al registrar el empleado";

	private static final String MESSAGE_UPDATE_EMPLOYEE_SUCCESS = "La actualización de datos del empleado fue exitoso";
	private static final String MESSAGE_UPDATE_EMPLOYEE_WARN = "Ocurrió un error al actualizar los datos del empleado";

	private static final String MESSAGE_RETRIEVE_EMPLOYEE_SUCCESS = "La consulta del empleado fue exitoso";
	private static final String MESSAGE_RETRIEVE_EMPLOYEE_WARN = "No se encontró los datos del empleado";

	private static final String MESSAGE_DELETE_EMPLOYEE_SUCCESS = "Se eliminó correctamente el empleado";

	private static final String MESSAGE_DELETE_EMPLOYEE_WARN = "Ocurrió un error al eliminar el empleado";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	IEmployeeRepository employeeRepository;

	@Autowired
	EmployeeMapping employeeMapping;

	@Override
	public ResponseDto<EmployeeListResponse> listEmployees() {
		ResponseDto<EmployeeListResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<Employee> employeeList = employeeRepository.listEmployeeDesc();

			if (employeeList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_EMPLOYEE_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_EMPLOYEE_SUCCESS, INFO, idTransaccion)
					.totalRegistros(employeeList.size()));
			response.setDatos(new EmployeeListResponse().employees(employeeMapping.modelList(employeeList)));

		} catch (Exception ex) {
			log.error(MESSAGE_INQUIRY_EMPLOYEE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<EmployeeResponse> retrieveEmployee(Long id) {
		ResponseDto<EmployeeResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Employee> employeeList = employeeRepository.findById(id);

			if (employeeList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_EMPLOYEE_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_EMPLOYEE_SUCCESS, INFO, idTransaccion)
					.totalRegistros(1));
			response.setDatos(new EmployeeResponse().employee(employeeMapping.modelDto(employeeList.get())));

		} catch (Exception ex) {
			log.error(MESSAGE_RETRIEVE_EMPLOYEE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<EmployeeResponse> registerEmployee(EmployeeDto employeeDto) {
		ResponseDto<EmployeeResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Employee employeeResponse = employeeRepository.save(employeeMapping.model(employeeDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_EMPLOYEE_SUCCESS, INFO, idTransaccion));
			response.setDatos(new EmployeeResponse().employee(employeeMapping.modelDto(employeeResponse)));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_EMPLOYEE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<EmployeeResponse> updateEmployee(EmployeeDto employeeDto) {
		ResponseDto<EmployeeResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Employee> employeeList = employeeRepository.findById(employeeDto.getId());

			if (employeeList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_EMPLOYEE_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			Employee employeeResponse = employeeRepository.save(employeeMapping.model(employeeDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_EMPLOYEE_SUCCESS, INFO, idTransaccion));
			response.setDatos(new EmployeeResponse().employee(employeeMapping.modelDto(employeeResponse)));

		} catch (Exception ex) {
			log.error(MESSAGE_UPDATE_EMPLOYEE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto deleteEmployee(Long id) {
		ResponseDto response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			employeeRepository.deleteById(id);

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_EMPLOYEE_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));

		} catch (Exception ex) {
			log.error(MESSAGE_DELETE_EMPLOYEE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

}

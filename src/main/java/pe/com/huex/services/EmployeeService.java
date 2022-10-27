package pe.com.huex.services;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.dto.Employee.EmployeeListDto;
import pe.com.huex.dto.Employee.EmployeeRegisterDto;
import pe.com.huex.dto.Employee.EmployeeRetrieveDto;
import pe.com.huex.dto.Employee.EmployeeUpdateDto;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.entities.Employee;
import pe.com.huex.repositories.EmployeeRepository;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class EmployeeService {
	private static final String MESSAGE_INQUIRY_SUPPLIERS_SUCCESS = "La consulta de trabajadores fue exitoso";
	private static final String MESSAGE_INQUIRY_SUPPLIERS_WARN = "No se encontró ningún trabajador registrado";

	private static final String MESSAGE_REGISTER_SUPPLIERS_SUCCESS = "El registro del proeveedor fue exitoso";
	private static final String MESSAGE_REGISTER_SUPPLIERS_WARN = "Ocurrió un error al registrar al trabajador";

	private static final String MESSAGE_UPDATE_SUPPLIERS_SUCCESS = "La consulta de trabajadores fue exitoso";
	private static final String MESSAGE_UPDATE_SUPPLIERS_WARN = "Ocurrió un error al actualizar los datos del trabajador";

	private static final String MESSAGE_RETRIEVE_SUPPLIERS_SUCCESS = "La consulta del trabajador fue exitoso";
	private static final String MESSAGE_RETRIEVE_SUPPLIERS_WARN = "No se encontró los datos del trabajador";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseDto<EmployeeListDto> listEmployees() {
		ResponseDto<EmployeeListDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<Employee> employeeList = employeeRepository.findAll();

			if (employeeList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_SUPPLIERS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_SUPPLIERS_SUCCESS, INFO, idTransaccion)
							.totalRegistros(employeeList.size()));
			response.setDatos(new EmployeeListDto().employeeList(employeeList));

		} catch (Exception ex) {
			log.error("error al consultar trabajadores" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<EmployeeRetrieveDto> retrieveEmployees(Long id) {
		ResponseDto<EmployeeRetrieveDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Employee> employeeList = employeeRepository.findById(id);

			if (employeeList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_SUPPLIERS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_SUPPLIERS_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));
			response.setDatos(new EmployeeRetrieveDto().employee(employeeList.get()));

		} catch (Exception ex) {
			log.error("error al consultar trabajador" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<EmployeeRegisterDto> registerEmployees(Employee employee) {
		ResponseDto<EmployeeRegisterDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();
			System.out.println("bout to save");
			Employee employeeResponse = employeeRepository.save(employee);
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_SUPPLIERS_SUCCESS, INFO,
					idTransaccion));
			response.setDatos(new EmployeeRegisterDto().employee(employeeResponse));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_SUPPLIERS_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<EmployeeUpdateDto> updateEmployees(Long id, Employee employee) {
		ResponseDto<EmployeeUpdateDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Employee> employeeResponse = employeeRepository.findById(id);

			if (employeeResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_SUPPLIERS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			employee.setId(id);
			employeeRepository.save(employee);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_SUPPLIERS_SUCCESS, INFO, idTransaccion));
			response.setDatos(new EmployeeUpdateDto().employee(employee));

		} catch (Exception ex) {
			log.error("error al actualizar trabajador: " + ex);
			throw ex;
		}

		return response;
	}

}

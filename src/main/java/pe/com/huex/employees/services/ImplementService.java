package pe.com.huex.employees.services;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.domain.entities.Implement;
import pe.com.huex.employees.domain.persistence.EmployeeImplementRepository;
import pe.com.huex.employees.domain.persistence.EmployeeRepository;
import pe.com.huex.employees.domain.persistence.ImplementRepository;
import pe.com.huex.employees.services.resources.response.employeeImplement.EmployeeImplementRegisterDto;
import pe.com.huex.employees.services.resources.response.implement.ImplementDeleteDto;
import pe.com.huex.employees.services.resources.response.implement.ImplementListDto;
import pe.com.huex.employees.services.resources.response.implement.ImplementRegisterDto;
import pe.com.huex.employees.services.resources.response.implement.ImplementRetrieveDto;
import pe.com.huex.employees.services.resources.response.implement.ImplementUpdateDto;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementResponseDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class ImplementService {
	private static final String MESSAGE_INQUIRY_IMPLEMENTS_SUCCESS = "La consulta de implementos fue exitoso";
	private static final String MESSAGE_INQUIRY_IMPLEMENTS_WARN = "No se encontró ningún implemento registrado";

	private static final String MESSAGE_REGISTER_IMPLEMENTS_SUCCESS = "El registro del implemento fue exitoso";
	private static final String MESSAGE_REGISTER_IMPLEMENTS_WARN = "Ocurrió un error al registrar al implemento";

	private static final String MESSAGE_UPDATE_IMPLEMENTS_SUCCESS = "La consulta de implementos fue exitoso";
	private static final String MESSAGE_UPDATE_IMPLEMENTS_WARN = "Ocurrió un error al actualizar los datos del implemento";

	private static final String MESSAGE_DELETE_IMPLEMENTS_SUCCESS = "La eliminación del implemento fue exitosa";
	private static final String MESSAGE_DELETE_IMPLEMENTS_WARN = "Ocurrió un error al eliminar el implemento";

	private static final String MESSAGE_RETRIEVE_IMPLEMENTS_SUCCESS = "La consulta del implemento fue exitoso";
	private static final String MESSAGE_RETRIEVE_IMPLEMENTS_WARN = "No se encontró los datos del implemento";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	ImplementRepository implementRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeImplementRepository employeeImplementRepository;

	public ResponseDto<ImplementListDto> listImplements() {
		ResponseDto<ImplementListDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<Implement> relationList = implementRepository.findAll();

			if (relationList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_IMPLEMENTS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_IMPLEMENTS_SUCCESS, INFO, idTransaccion)
							.totalRegistros(relationList.size()));
			response.setDatos(new ImplementListDto().relationList(relationList));

		} catch (Exception ex) {
			log.error("error al consultar implementos" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<ImplementRetrieveDto> retrieveImplements(Long id) {
		ResponseDto<ImplementRetrieveDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Implement> relationList = implementRepository.findById(id);

			if (relationList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_IMPLEMENTS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_IMPLEMENTS_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));
			response.setDatos(new ImplementRetrieveDto().implement(relationList.get()));

		} catch (Exception ex) {
			log.error("error al consultar implemento" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<ImplementRegisterDto> registerImplements(Implement implement) {
		ResponseDto<ImplementRegisterDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();
			Implement implementResponse = implementRepository.save(implement);
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_IMPLEMENTS_SUCCESS, INFO,
					idTransaccion));
			response.setDatos(new ImplementRegisterDto().implement(implementResponse));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_IMPLEMENTS_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<ImplementUpdateDto> updateImplements(Long id, Implement implement) {
		ResponseDto<ImplementUpdateDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Implement> implementResponse = implementRepository.findById(id);

			if (implementResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_IMPLEMENTS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			implement.setId(id);
			implementRepository.save(implement);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_IMPLEMENTS_SUCCESS, INFO, idTransaccion));
			response.setDatos(new ImplementUpdateDto().implement(implement));

		} catch (Exception ex) {
			log.error("error al actualizar implemento: " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<ImplementDeleteDto> deleteImplements(Long id) {
		ResponseDto<ImplementDeleteDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Implement> implementResponse = implementRepository.findById(id);

			if (implementResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_DELETE_IMPLEMENTS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			implementRepository.deleteById(id);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_IMPLEMENTS_SUCCESS, INFO, idTransaccion));
			response.setDatos(new ImplementDeleteDto().implement(id));

		} catch (Exception ex) {
			log.error("error al actualizar implemento: " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<EmployeeImplementRegisterDto> assignImplements(
			EmployeeImplementResponseDto employeeImplementResponseDto) {
		ResponseDto<EmployeeImplementRegisterDto> response = new ResponseDto<>();
		String idTransaccion = UUID.randomUUID().toString();

		Optional<Employee> employeeResponse = employeeRepository.findById(employeeImplementResponseDto.getEmployeeId());
		Optional<Implement> implementResponse = implementRepository
				.findById(employeeImplementResponseDto.getImplementId());

		if (employeeResponse.isEmpty()) {
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_WARN, "No se encontro al trabajador", WARN, idTransaccion)
							.totalRegistros(0));
			return response;
		}
		if (implementResponse.isEmpty()) {
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_IMPLEMENTS_WARN, WARN, idTransaccion)
							.totalRegistros(0));
			return response;
		}

		try {
			EmployeeImplement employeeImplement = new EmployeeImplement();
			employeeImplement.setDate(employeeImplementResponseDto.getDate());
			employeeImplement.setObservations(employeeImplement.getObservations());
			employeeImplement.setEmployee(employeeResponse.get());
			employeeImplement.setImplement(implementResponse.get());

			employeeImplement = employeeImplementRepository.save(employeeImplement);

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, "La asignacion del implemento fue exitosa", INFO,
							idTransaccion));
			response.setDatos(new EmployeeImplementRegisterDto().employeeImplement(employeeImplement));
			return response;

		} catch (Exception ex) {
			log.error("Error al asignar al implemento" + ex);
			throw ex;

		}
	}

}

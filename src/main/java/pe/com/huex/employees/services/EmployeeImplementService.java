package pe.com.huex.employees.services;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.domain.entities.Implement;
import pe.com.huex.employees.domain.persistence.EmployeeImplementRepository;
import pe.com.huex.employees.domain.persistence.EmployeeRepository;
import pe.com.huex.employees.domain.persistence.ImplementRepository;
import pe.com.huex.employees.services.resources.dtos.employeeImplement.EmployeeImplementListDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class EmployeeImplementService {
	private static final String MESSAGE_REGISTER_RELATION_SUCCESS = "El registro de relacion fue exitoso";
	private static final String MESSAGE_REGISTER_RELATION_WARN = "Ocurrió un error al registrar la relacion";

	private static final String MESSAGE_INQUIRY_RELATION_SUCCESS = "El listado de las relaciones fue exitoso";
	private static final String MESSAGE_INQUIRY_RELATION_WARN = "Ocurrió un error al listar las relaciones";
	private static final String MESSAGE_INQUIRY_RELATION_ERROR = "El id ingresado no se encuentra en la base de datos";

	private static final String MESSAGE_UPDATE_RELATION_SUCCESS = "La actualizacion de relacion fue exitosa";
	private static final String MESSAGE_UPDATE_RELATION_WARN = "Ocurrió un error al actualizar la relacion";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	EmployeeImplementRepository relationRepository;

	@Autowired
	ImplementRepository implementRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseDto<EmployeeImplementListDto> listImplementAssignments(Long implementId) {
		ResponseDto<EmployeeImplementListDto> response = new ResponseDto<>();

		String idTransaction = UUID.randomUUID().toString();

		Optional<Implement> implementResponse = implementRepository.findById(implementId);
		if (implementResponse.isEmpty()) {
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_RELATION_ERROR, WARN, idTransaction)
							.totalRegistros(0));
			return response;
		}

		try {
			List<EmployeeImplement> relationList = relationRepository.listByImplement(implementId);

			if (relationList.isEmpty()) {
				response.meta(
						MetaDatosUtil
								.buildMetadatos(CODE_WARN, "No se encontraron trabajadores asignados a este implemento",
										WARN, idTransaction)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_RELATION_SUCCESS, INFO, idTransaction)
							.totalRegistros(relationList.size()));
			response.setDatos(new EmployeeImplementListDto().employeeImplementList(relationList));

		} catch (Exception ex) {
			log.error("error al consultar implementos" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<EmployeeImplementListDto> listEmployeeAssignments(Long employeeId) {
		ResponseDto<EmployeeImplementListDto> response = new ResponseDto<>();

		String idTransaction = UUID.randomUUID().toString();

		Optional<Employee> employeeResponse = employeeRepository.findById(employeeId);
		if (employeeResponse.isEmpty()) {
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_RELATION_ERROR, WARN, idTransaction)
							.totalRegistros(0));
			return response;
		}

		try {
			List<EmployeeImplement> relationList = relationRepository.listByEmployee(employeeId);

			if (relationList.isEmpty()) {
				response.meta(
						MetaDatosUtil
								.buildMetadatos(CODE_WARN, "Este trabajador no esta asignado a ningun implemento",
										WARN, idTransaction)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_RELATION_SUCCESS, INFO, idTransaction)
							.totalRegistros(relationList.size()));
			response.setDatos(new EmployeeImplementListDto().employeeImplementList(relationList));

		} catch (Exception ex) {
			log.error("error al consultar implementos" + ex);
			throw ex;
		}

		return response;
	}

}

package pe.com.huex.services;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.dto.Employee.EmployeeAttendanceRegisterDto;
import pe.com.huex.dto.Employee.EmployeeAttendanceResponseDto;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.entities.Employee;
import pe.com.huex.entities.EmployeeAttendance;
import pe.com.huex.repositories.EmployeeAttendanceRepository;
import pe.com.huex.repositories.EmployeeRepository;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class EmployeeAttendanceService {
	private static final String MESSAGE_REGISTER_ATTENDANCES_SUCCESS = "El registro de asistencia fue exitoso";
	private static final String MESSAGE_REGISTER_ATTENDANCES_WARN = "Ocurrió un error al registrar la asistencia";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	EmployeeAttendanceRepository employeeAttendanceRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseDto<EmployeeAttendanceRegisterDto> registerEmployeeAttendances(
			EmployeeAttendanceResponseDto employeeAttendanceRequestDto) throws Exception {
		ResponseDto<EmployeeAttendanceRegisterDto> response = new ResponseDto<>();

		// save the constructed attendance
		try {
			String idTransaccion = UUID.randomUUID().toString();
			Employee employee = employeeRepository.findById(employeeAttendanceRequestDto.getEmployee_id())
					.orElseThrow(() -> new Exception("El empleado indicado no existe"));

			EmployeeAttendance employeeAttendance = new EmployeeAttendance();
			employeeAttendance.setId(1L);
			employeeAttendance.setDate(employeeAttendanceRequestDto.getDate());
			employeeAttendance.setState(employeeAttendanceRequestDto.getState());
			employeeAttendance.setEmployee(employee);

			EmployeeAttendance employeeAttendanceResponse = employeeAttendanceRepository.save(employeeAttendance);

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_ATTENDANCES_SUCCESS, INFO,
					idTransaccion));
			response.setDatos(new EmployeeAttendanceRegisterDto().employeeAttendance(
					new EmployeeAttendanceResponseDto(employeeAttendanceResponse.getDate(),
							employeeAttendanceResponse.getState(),
							employeeAttendanceResponse.getEmployee().getId())));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_ATTENDANCES_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

}

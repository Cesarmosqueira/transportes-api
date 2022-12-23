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
import pe.com.huex.employees.domain.entities.EmployeeAttendance;
import pe.com.huex.employees.domain.persistence.AttendanceRepository;
import pe.com.huex.employees.domain.persistence.EmployeeRepository;
import pe.com.huex.employees.services.resources.response.attendance.AttendanceDeleteDto;
import pe.com.huex.employees.services.resources.response.attendance.AttendanceListDto;
import pe.com.huex.employees.services.resources.response.attendance.AttendanceRegisterDto;
import pe.com.huex.employees.services.resources.response.attendance.AttendanceUpdateDto;
import pe.com.huex.employees.services.resources.dtos.AttendanceResponseDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class AttendanceService {
	private static final String MESSAGE_REGISTER_ATTENDANCES_SUCCESS = "El registro de asistencia fue exitoso";
	private static final String MESSAGE_REGISTER_ATTENDANCES_WARN = "Ocurrió un error al registrar la asistencia";

	private static final String MESSAGE_UPDATE_ATTENDANCES_SUCCESS = "La actualizacion de asistencia fue exitosa";
	private static final String MESSAGE_UPDATE_ATTENDANCES_WARN = "Ocurrió un error al actualizar la asistencia";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	AttendanceRepository attendanceRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseDto<AttendanceRegisterDto> registerAttendances(
			AttendanceResponseDto employeeAttendanceRequestDto) throws Exception {
		ResponseDto<AttendanceRegisterDto> response = new ResponseDto<>();

		// save the constructed attendance
		String idTransaccion = UUID.randomUUID().toString();

		Optional<Employee> employeeResponse = employeeRepository
				.findById(employeeAttendanceRequestDto.getEmployee_id());

		if (employeeResponse.isEmpty()) {
			response.meta(
					MetaDatosUtil
							.buildMetadatos(CODE_WARN, "El empleado no existe", WARN, idTransaccion)
							.totalRegistros(0));
			return response;
		}

		EmployeeAttendance employeeAttendance = new EmployeeAttendance();
		employeeAttendance.setDate(employeeAttendanceRequestDto.getDate());
		employeeAttendance.setState(employeeAttendanceRequestDto.getState());
		employeeAttendance.setEmployee(employeeResponse.get());
		try {

			if (attendanceRepository.employeeAttendanceInDate(employeeResponse.get().getId(),
					employeeAttendanceRequestDto.getDate()) != 0) {

				response.meta(
						MetaDatosUtil
								.buildMetadatos(CODE_WARN, "El empleado ya tiene un registro para esa fecha", WARN,
										idTransaccion)
								.totalRegistros(0));
				return response;

			}
			EmployeeAttendance employeeAttendanceResponse = attendanceRepository.save(employeeAttendance);

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_ATTENDANCES_SUCCESS, INFO,
					idTransaccion));
			response.setDatos(new AttendanceRegisterDto().attendance(
					new AttendanceResponseDto(employeeAttendanceResponse.getDate(),
							employeeAttendanceResponse.getState(),
							employeeAttendanceResponse.getEmployee().getId())));
		} catch (Exception ex) {
			String actualMessage = ex.getMessage();
			System.out
					.println("\n == Actual message == \n" + actualMessage + "\n\n" + ex.getLocalizedMessage() + "\n\n");
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS,
					MESSAGE_REGISTER_ATTENDANCES_WARN + " (La fecha ya fue registrada)", INFO,
					idTransaccion));
			return response;
		}

		return response;
	}

	public ResponseDto<AttendanceUpdateDto> updateAttendances(
			AttendanceResponseDto employeeAttendance) {
		ResponseDto<AttendanceUpdateDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Employee> employeeResponse = employeeRepository.findById(employeeAttendance.getEmployee_id());

			if (employeeResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil
								.buildMetadatos(CODE_WARN, "El empleado no existe", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			Optional<EmployeeAttendance> attendanceResponse = attendanceRepository
					.findByDate(employeeAttendance.getDate(), employeeAttendance.getEmployee_id());

			if (attendanceResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil
								.buildMetadatos(CODE_WARN, "La asistencia especificada no existe", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			EmployeeAttendance employeeAttendance2 = attendanceResponse.get();
			employeeAttendance2.setDate(employeeAttendance.getDate());
			employeeAttendance2.setState(employeeAttendance.getState());
			employeeAttendance2.setEmployee(employeeResponse.get());

			attendanceRepository.save(employeeAttendance2);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_ATTENDANCES_SUCCESS, INFO,
							idTransaccion));
			response.setDatos(new AttendanceUpdateDto().attendance(employeeAttendance2));

		} catch (Exception ex) {
			log.error("error al actualizar la asistencia: " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<AttendanceListDto> listAttendances() {
		ResponseDto<AttendanceListDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<EmployeeAttendance> attendanceList = attendanceRepository.findAll();

			if (attendanceList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, "No se encontraron asistencias", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil
							.buildMetadatos(CODE_SUCCESS, "Se realizo la consulta exitosamente", INFO, idTransaccion)
							.totalRegistros(attendanceList.size()));
			response.setDatos(new AttendanceListDto().attendanceList(attendanceList));

		} catch (Exception ex) {
			log.error("error al consultar descuentos" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<AttendanceListDto> listAttendancesByEmployee(Long employeeId) {
		ResponseDto<AttendanceListDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Employee> employeeResponse = employeeRepository.findById(employeeId);
			if (employeeResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, "trabajador no existe", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			List<EmployeeAttendance> attendanceList = attendanceRepository.findByEmployee(employeeId);

			if (attendanceList.isEmpty()) {
				response.meta(
						MetaDatosUtil
								.buildMetadatos(CODE_WARN, "Este trabajador no presenta registros de asistencia", WARN,
										idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil
							.buildMetadatos(CODE_SUCCESS, "Se realizo la consulta exitosamente", INFO, idTransaccion)
							.totalRegistros(attendanceList.size()));
			response.setDatos(new AttendanceListDto().attendanceList(attendanceList));

		} catch (Exception ex) {
			log.error("error al consultar descuentos" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<AttendanceDeleteDto> deleteAttendance(Long id) {
		ResponseDto<AttendanceDeleteDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<EmployeeAttendance> attendanceResponse = attendanceRepository.findById(id);

			if (attendanceResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, "El descuento no existe", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			attendanceRepository.deleteById(id);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, "Se elimino el descuento", INFO, idTransaccion));
			response.setDatos(new AttendanceDeleteDto().attendance(attendanceResponse.get()));

		} catch (Exception ex) {
			log.error("error al actualizar attendanceo: " + ex);
			throw ex;
		}

		return response;
	}

}

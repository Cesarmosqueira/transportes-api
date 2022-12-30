package pe.com.huex.employees.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.employees.domain.entities.EmployeeAttendance;
import pe.com.huex.employees.domain.persistence.IAttendanceRepository;
import pe.com.huex.employees.domain.service.IAttendanceService;
import pe.com.huex.employees.mapping.AttendanceMapping;
import pe.com.huex.employees.services.resources.dtos.AttendanceDto;
import pe.com.huex.employees.services.resources.response.AttendanceListResponse;
import pe.com.huex.employees.services.resources.response.AttendanceResponse;
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
public class AttendanceService implements IAttendanceService {

	private static final String MESSAGE_INQUIRY_ATTENDANCE_SUCCESS = "La consulta de asistencia fue exitoso";
	private static final String MESSAGE_INQUIRY_ATTENDANCE_WARN = "No se encontró ningúna asistencia registrado";

	private static final String MESSAGE_REGISTER_ATTENDANCE_SUCCESS = "El registro del asistencia fue exitoso";
	private static final String MESSAGE_REGISTER_ATTENDANCE_WARN = "Ocurrió un error al registrar la asistencia";

	private static final String MESSAGE_UPDATE_ATTENDANCE_SUCCESS = "La actualización de datos de asistencia fue exitoso";
	private static final String MESSAGE_UPDATE_ATTENDANCE_WARN = "Ocurrió un error al actualizar los datos de la asistencia";

	private static final String MESSAGE_RETRIEVE_ATTENDANCE_SUCCESS = "La consulta de asistencia fue exitoso";
	private static final String MESSAGE_RETRIEVE_ATTENDANCE_WARN = "No se encontró los datos de la asistencia";

	private static final String MESSAGE_DELETE_ATTENDANCE_SUCCESS = "Se eliminó correctamente la asistencia";

	private static final String MESSAGE_DELETE_ATTENDANCE_WARN = "Ocurrió un error al eliminar la asistencia";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	IAttendanceRepository attendanceRepository;

	@Autowired
	AttendanceMapping attendanceMapping;

	@Override
	public ResponseDto<AttendanceListResponse> listAttendances() {
		ResponseDto<AttendanceListResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<EmployeeAttendance> attendanceList = attendanceRepository.findAll();

			if (attendanceList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_ATTENDANCE_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_ATTENDANCE_SUCCESS, INFO, idTransaccion)
					.totalRegistros(attendanceList.size()));
			response.setDatos(new AttendanceListResponse().attendances(attendanceMapping.modelList(attendanceList)));

		} catch (Exception ex) {
			log.error(MESSAGE_INQUIRY_ATTENDANCE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<AttendanceResponse> retrieveAttendance(Long id) {
		ResponseDto<AttendanceResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<EmployeeAttendance> attendanceList = attendanceRepository.findById(id);

			if (attendanceList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_ATTENDANCE_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_ATTENDANCE_SUCCESS, INFO, idTransaccion)
					.totalRegistros(1));
			response.setDatos(new AttendanceResponse().attendance(attendanceMapping.modelDto(attendanceList.get())));

		} catch (Exception ex) {
			log.error(MESSAGE_RETRIEVE_ATTENDANCE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<AttendanceResponse> registerAttendance(AttendanceDto attendanceDto) {
		ResponseDto<AttendanceResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			EmployeeAttendance attendanceResponse = attendanceRepository.save(attendanceMapping.model(attendanceDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_ATTENDANCE_SUCCESS, INFO, idTransaccion));
			response.setDatos(new AttendanceResponse().attendance(attendanceMapping.modelDto(attendanceResponse)));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_ATTENDANCE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<AttendanceResponse> updateAttendance(AttendanceDto attendanceDto) {
		ResponseDto<AttendanceResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<EmployeeAttendance> attendanceList = attendanceRepository.findById(attendanceDto.getId());

			if (attendanceList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_ATTENDANCE_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			EmployeeAttendance attendanceResponse = attendanceRepository.save(attendanceMapping.model(attendanceDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_ATTENDANCE_SUCCESS, INFO, idTransaccion));
			response.setDatos(new AttendanceResponse().attendance(attendanceMapping.modelDto(attendanceResponse)));

		} catch (Exception ex) {
			log.error(MESSAGE_UPDATE_ATTENDANCE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto deleteAttendance(Long id) {
		ResponseDto response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			attendanceRepository.deleteById(id);

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_ATTENDANCE_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));

		} catch (Exception ex) {
			log.error(MESSAGE_DELETE_ATTENDANCE_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}
}

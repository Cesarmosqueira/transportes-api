package pe.com.huex.employees.domain.service;

import pe.com.huex.employees.services.resources.dtos.AttendanceDto;
import pe.com.huex.employees.services.resources.response.AttendanceListResponse;
import pe.com.huex.employees.services.resources.response.AttendanceResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public interface IAttendanceService {

    ResponseDto<AttendanceListResponse> listAttendances();

    ResponseDto<AttendanceResponse> retrieveAttendance(Long id);

    ResponseDto<AttendanceResponse> registerAttendance(AttendanceDto attendanceDto) throws IOException;

    ResponseDto<AttendanceResponse> updateAttendance(AttendanceDto attendanceDto) throws IOException;

    ResponseDto deleteAttendance(Long id);

    ResponseDto<AttendanceListResponse> listEmployeeAttendanceByDate(String startDate, String endDate) throws ParseException;

}

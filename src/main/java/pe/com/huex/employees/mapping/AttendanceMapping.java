package pe.com.huex.employees.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.employees.domain.entities.EmployeeAttendance;
import pe.com.huex.employees.services.resources.dtos.AttendanceDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceMapping extends ModelMapper implements Serializable {

    public AttendanceMapping() {
        super();
    }

    public List<AttendanceDto> modelList(List<EmployeeAttendance> modelList) {
        return modelList.stream().map(item -> this.map(item, AttendanceDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeAttendance model(AttendanceDto attendanceDto) {
        return this.map(attendanceDto, EmployeeAttendance.class);
    }

    public AttendanceDto modelDto(EmployeeAttendance employeeAttendance) {
        return this.map(employeeAttendance, AttendanceDto.class);
    }
}

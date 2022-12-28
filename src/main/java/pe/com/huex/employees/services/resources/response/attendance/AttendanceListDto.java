package pe.com.huex.employees.services.resources.response.attendance;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.domain.entities.EmployeeAttendance;
import pe.com.huex.employees.services.resources.dtos.AttendanceResponseDto;
@Data
@NoArgsConstructor
public class AttendanceListDto {

    private List<AttendanceResponseDto> attendances = null;

    public AttendanceListDto attendanceList(List<EmployeeAttendance> attendanceList) {
        this.attendances = new ArrayList<>();
        for (EmployeeAttendance emp : attendanceList) {
            this.attendances.add(new AttendanceResponseDto(emp));
        }
        return this;
    }
}

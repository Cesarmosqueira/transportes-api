package pe.com.huex.employees.domain.dtos.attendance;

import java.util.ArrayList;
import java.util.List;

import pe.com.huex.employees.domain.entities.EmployeeAttendance;

public class AttendanceListDto {
    public AttendanceListDto() {
    }

    private List<AttendanceResponseDto> attendanceList = null;

    public AttendanceListDto attendanceList(List<EmployeeAttendance> attendanceList) {
        this.attendanceList = new ArrayList<AttendanceResponseDto>();
        for (EmployeeAttendance emp : attendanceList) {
            this.attendanceList.add(new AttendanceResponseDto(emp));
        }
        return this;
    }

    public void setAttendanceList(List<AttendanceResponseDto> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public List<AttendanceResponseDto> getAttendanceList() {
        return attendanceList;
    }
}

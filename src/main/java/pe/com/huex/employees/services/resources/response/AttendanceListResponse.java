package pe.com.huex.employees.services.resources.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.employees.services.resources.dtos.AttendanceDto;
@Data
@NoArgsConstructor
public class AttendanceListResponse {

    private List<AttendanceDto> attendances = null;

    public AttendanceListResponse attendances(List<AttendanceDto> attendanceList) {
        this.attendances = attendanceList;
        return this;
    }
}

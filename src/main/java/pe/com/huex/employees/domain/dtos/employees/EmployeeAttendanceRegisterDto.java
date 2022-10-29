package pe.com.huex.employees.domain.dtos.employees;

public class EmployeeAttendanceRegisterDto {
    private EmployeeAttendanceResponseDto employeeAttendance = null;

    public EmployeeAttendanceRegisterDto() {
    }

    public EmployeeAttendanceRegisterDto employeeAttendance(EmployeeAttendanceResponseDto employeeAttendance) {
        this.employeeAttendance = employeeAttendance;
        return this;
    }

    public EmployeeAttendanceResponseDto getEmployeeAttendance() {
        return employeeAttendance;
    }

    public void setEmployeeAttendance(EmployeeAttendanceResponseDto employeeAttendance) {
        this.employeeAttendance = employeeAttendance;
    }

}

package pe.com.huex.employees.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.huex.employees.domain.entities.EmployeeAttendance;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {

}

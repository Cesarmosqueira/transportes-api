package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.huex.entities.EmployeeAttendance;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {

}

package pe.com.huex.employees.domain.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.huex.employees.domain.entities.EmployeeAttendance;

public interface IAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {

	@Query(value = "SELECT * FROM employee_attendance e WHERE e.date = ?1 AND e.employee_id = ?2", nativeQuery = true)
	Optional<EmployeeAttendance> findByDate(Date date, Long employeeId);

	@Query(value = "SELECT * FROM employee_attendance ea WHERE ea.employee_id = ?1", nativeQuery = true)
	List<EmployeeAttendance> findByEmployee(Long employeeId);

	// Times that an employee has been registered in a specific date
	// 0 means that is ready to be registered and 1 means that it cant
	@Query(value = "select count(*) from employee_attendance where employee_id = ?1 and date = ?2", nativeQuery = true)
	int employeeAttendanceInDate(long employeeId, Date date);

	// Times that an employee has been registered in a specific date
	// 0 means that is ready to be registered and 1 means that it cant
	@Query(value = "select * from employee_attendance where employee_id = ?1 and date = ?2", nativeQuery = true)
	Optional<EmployeeAttendance> findByDate(long employeeId, Date date);

}

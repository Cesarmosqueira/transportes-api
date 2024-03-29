package pe.com.huex.employees.domain.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.services.domain.entities.TrackingService;

@Repository
public interface EmployeeImplementRepository extends JpaRepository<EmployeeImplement, Long> {

	@Query(value = "SELECT * FROM employee_implement ei order by ei.delivery_date desc", nativeQuery = true)
	List<EmployeeImplement> listEmployeeImplementDesc();

	@Query(value = "SELECT * FROM employee_implement ei WHERE ei.employee_id = ?1", nativeQuery = true)
	List<EmployeeImplement> listByEmployee(Long employeeId);

	@Query(value = "SELECT * FROM employee_implement ei WHERE ei.implement_id = ?1", nativeQuery = true)
	List<EmployeeImplement> listByImplement(Long implementId);

}

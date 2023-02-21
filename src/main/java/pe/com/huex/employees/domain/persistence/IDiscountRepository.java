
package pe.com.huex.employees.domain.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.services.domain.entities.TrackingService;

public interface IDiscountRepository extends JpaRepository<EmployeeDiscount, Long> {

	@Query(value = "SELECT * FROM employee_discount ed order by ed.date desc", nativeQuery = true)
	List<EmployeeDiscount> listEmployeeDiscountDesc();
	@Query(value = "SELECT * FROM employee_discount ed WHERE ed.employee_id = ?1", nativeQuery = true)
	List<EmployeeDiscount> findByEmployee(Long employeeId);

}

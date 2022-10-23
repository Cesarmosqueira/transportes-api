package transportes.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import transportes.api.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

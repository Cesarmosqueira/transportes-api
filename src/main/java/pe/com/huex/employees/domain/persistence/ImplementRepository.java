package pe.com.huex.employees.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.huex.employees.domain.entities.Implement;

public interface ImplementRepository extends JpaRepository<Implement, Long> {

}

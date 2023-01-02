package pe.com.huex.employees.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import pe.com.huex.employees.domain.entities.Implement;

@Repository
public interface IImplementRepository extends JpaRepository<Implement, Long> {

}

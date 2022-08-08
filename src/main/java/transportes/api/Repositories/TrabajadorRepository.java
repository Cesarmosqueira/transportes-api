package transportes.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import transportes.api.Entities.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

}

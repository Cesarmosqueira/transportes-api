package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.entities.ProvinceEstivators;

@Repository
public interface ProvinceEstivatorRepository extends JpaRepository<ProvinceEstivators,Long> {
}
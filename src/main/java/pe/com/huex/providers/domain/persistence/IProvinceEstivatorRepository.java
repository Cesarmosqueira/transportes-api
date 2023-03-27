package pe.com.huex.providers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.providers.domain.model.entity.ProvinceEstivators;

@Repository
public interface IProvinceEstivatorRepository extends JpaRepository<ProvinceEstivators,Long> {
}

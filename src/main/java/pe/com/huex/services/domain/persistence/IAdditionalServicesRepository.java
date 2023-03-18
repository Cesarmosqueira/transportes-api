package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.AdditionalServices;

@Repository
public interface IAdditionalServicesRepository extends JpaRepository<AdditionalServices,Long> {
}

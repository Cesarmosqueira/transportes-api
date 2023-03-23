package pe.com.huex.services.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.services.domain.entities.AdditionalServices;

import java.util.List;

@Repository
public interface IAdditionalServicesRepository extends JpaRepository<AdditionalServices,Long> {

    @Query(value = "SELECT*FROM additional_services ser order by ser.date_service desc", nativeQuery = true)
    List<AdditionalServices> listAdditionalServiceDesc();
}

package pe.com.huex.employees.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.domain.entities.ProviderDiscount;

import java.util.List;

@Repository
public interface IProviderDiscountRepository extends JpaRepository<ProviderDiscount,Long> {

    @Query(value = "SELECT * FROM provider_discount ed order by ed.date desc", nativeQuery = true)
    List<ProviderDiscount> listProviderDiscountDesc();
}

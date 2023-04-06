package pe.com.huex.warehouse.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.warehouse.domain.model.entity.OrderDetail;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}

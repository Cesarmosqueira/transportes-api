package pe.com.huex.warehouse.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.huex.warehouse.domain.model.entity.InvoicedProduct;

@Repository
public interface IInvoicedProductRepository extends JpaRepository<InvoicedProduct, Long> {
}

package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.huex.entities.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
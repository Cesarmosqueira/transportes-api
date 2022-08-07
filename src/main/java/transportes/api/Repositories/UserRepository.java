package transportes.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import transportes.api.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

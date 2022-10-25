package pe.com.huex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.huex.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

package transportes.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import transportes.api.Entities.User;
import transportes.api.Repositories.UserRepository;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void createUser() {
		System.out.println("Create User test starting...");
		User user = new User();
		user.setId(1);
		user.setUsername("admin");
		user.setPassword(encoder.encode("admin"));
		User u = userRepository.save(user);

		System.out.println("User created i guess");

	}

}

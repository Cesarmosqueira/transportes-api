package transportes.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import transportes.api.Entities.User;
import transportes.api.Repositories.EmployeeRepository;
import transportes.api.Repositories.UserRepository;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void createWorker() {

	}

}

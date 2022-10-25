package pe.com.huex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.com.huex.repositories.EmployeeRepository;
import pe.com.huex.repositories.UserRepository;

@SpringBootTest
class ApplicationTests {

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

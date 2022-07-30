package transportes.api.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("test")
public class Test {

	@GetMapping
	public ResponseEntity<String> test_function() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

}

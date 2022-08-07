package transportes.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("proveedores")
public class ProveedoresController {

	@GetMapping
	public ResponseEntity<String> getProvider() {
		return new ResponseEntity<>("HOmla", HttpStatus.OK);
	}

}
package pe.com.huex.employees.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.employees.domain.service.IImplementService;
import pe.com.huex.employees.services.resources.dtos.ImplementDto;
import pe.com.huex.employees.services.resources.response.ImplementListResponse;
import pe.com.huex.employees.services.resources.response.ImplementResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;

@RestController
@RequestMapping("implements")
public class ImplementController {

	@Autowired
	IImplementService implementService;

	@GetMapping
	public ResponseDto<ImplementListResponse> listImplements() {
		return implementService.listImplements();
	}

	@GetMapping("{id}")
	public ResponseDto<ImplementResponse> retrieveImplement(@PathVariable Long id) {
		return implementService.retrieveImplement(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ImplementResponse> registerImplement(@RequestBody ImplementDto implement)
			throws Exception {
		return implementService.registerImplement(implement);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ImplementResponse> updateImplement(
			@RequestBody ImplementDto implementDto) throws IOException {
		return implementService.updateImplement(implementDto);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto deleteImplement(@PathVariable Long id) {
		return implementService.deleteImplement(id);
	}

}

package pe.com.huex.employees.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.employees.domain.dtos.Implement.ImplementDeleteDto;
import pe.com.huex.employees.domain.dtos.Implement.ImplementListDto;
import pe.com.huex.employees.domain.dtos.Implement.ImplementRegisterDto;
import pe.com.huex.employees.domain.dtos.Implement.ImplementRetrieveDto;
import pe.com.huex.employees.domain.dtos.Implement.ImplementUpdateDto;
import pe.com.huex.employees.domain.entities.Implement;
import pe.com.huex.employees.services.ImplementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("implements")
public class ImplementController {

	@Autowired
	ImplementService implementService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ImplementListDto> listImplements() throws Exception {
		return implementService.listImplements();
	}

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ImplementRetrieveDto> retrieveImplements(@PathVariable Long id) throws Exception {
		return implementService.retrieveImplements(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ImplementRegisterDto> registerImplements(@RequestBody Implement implement) throws Exception {
		return implementService.registerImplements(implement);
	}

	@PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ImplementUpdateDto> updateImplements(@PathVariable Long id, @RequestBody Implement implement)
			throws Exception {
		return implementService.updateImplements(id, implement);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ImplementDeleteDto> deleteImplements(@PathVariable Long id)
			throws Exception {
		return implementService.deleteImplements(id);
	}

}

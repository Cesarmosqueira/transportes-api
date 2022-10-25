package pe.com.huex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.Provider;
import pe.com.huex.services.ProviderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("provider")
public class ProviderController {

	@Autowired
	ProviderService providerService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ProviderListDto> listProviders() throws Exception {
		return providerService.listProviders();
	}

	@GetMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ProviderRetrieveDto> retrieveProviders(@PathVariable Long id) throws Exception {
		return providerService.retrieveProviders(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ProviderRegisterDto> registerProviders(@RequestBody Provider provider) throws Exception {
		return providerService.registerProviders(provider);
	}

	@PutMapping(path ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto<ProviderUpdateDto> updateProviders(@PathVariable Long id, @RequestBody Provider provider) throws Exception {
		return providerService.updateProviders(id, provider);
	}

}

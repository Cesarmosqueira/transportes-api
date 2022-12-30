package pe.com.huex.employees.services;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.employees.domain.entities.Implement;
import pe.com.huex.employees.domain.persistence.IImplementRepository;
import pe.com.huex.employees.domain.service.IImplementService;
import pe.com.huex.employees.mapping.ImplementMapping;
import pe.com.huex.employees.services.resources.dtos.ImplementDto;
import pe.com.huex.employees.services.resources.response.ImplementListResponse;
import pe.com.huex.employees.services.resources.response.ImplementResponse;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class ImplementService implements IImplementService {
	private static final String MESSAGE_INQUIRY_IMPLEMENT_SUCCESS = "La consulta de implementos fue exitoso";
	private static final String MESSAGE_INQUIRY_IMPLEMENT_WARN = "No se encontró ningún implemento registrado";

	private static final String MESSAGE_REGISTER_IMPLEMENT_SUCCESS = "El registro del implemento fue exitoso";
	private static final String MESSAGE_REGISTER_IMPLEMENT_WARN = "Ocurrió un error al registrar el implemento";

	private static final String MESSAGE_UPDATE_IMPLEMENT_SUCCESS = "La actualización de datos del implemento fue exitoso";
	private static final String MESSAGE_UPDATE_IMPLEMENT_WARN = "Ocurrió un error al actualizar los datos del implemento";

	private static final String MESSAGE_RETRIEVE_IMPLEMENT_SUCCESS = "La consulta del implemento fue exitoso";
	private static final String MESSAGE_RETRIEVE_IMPLEMENT_WARN = "No se encontró los datos del implemento";

	private static final String MESSAGE_DELETE_IMPLEMENT_SUCCESS = "Se eliminó correctamente el implemento";

	private static final String MESSAGE_DELETE_IMPLEMENT_WARN = "Ocurrió un error al eliminar el implemento";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	IImplementRepository implementRepository;

	@Autowired
	ImplementMapping implementMapping;

	@Override
	public ResponseDto<ImplementListResponse> listImplements() {
		ResponseDto<ImplementListResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<Implement> implementList = implementRepository.findAll();

			if (implementList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_IMPLEMENT_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_IMPLEMENT_SUCCESS, INFO, idTransaccion)
					.totalRegistros(implementList.size()));
			response.setDatos(new ImplementListResponse().implementss(implementMapping.modelList(implementList)));

		} catch (Exception ex) {
			log.error(MESSAGE_INQUIRY_IMPLEMENT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<ImplementResponse> retrieveImplement(Long id) {
		ResponseDto<ImplementResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Implement> implementList = implementRepository.findById(id);

			if (implementList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_IMPLEMENT_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_IMPLEMENT_SUCCESS, INFO, idTransaccion)
					.totalRegistros(1));
			response.setDatos(new ImplementResponse().implement(implementMapping.modelDto(implementList.get())));

		} catch (Exception ex) {
			log.error(MESSAGE_RETRIEVE_IMPLEMENT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<ImplementResponse> registerImplement(ImplementDto implementDto) {
		ResponseDto<ImplementResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Implement implementResponse = implementRepository.save(implementMapping.model(implementDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_IMPLEMENT_SUCCESS, INFO, idTransaccion));
			response.setDatos(new ImplementResponse().implement(implementMapping.modelDto(implementResponse)));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_IMPLEMENT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<ImplementResponse> updateImplement(ImplementDto implementDto) {
		ResponseDto<ImplementResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Implement> implementList = implementRepository.findById(implementDto.getId());

			if (implementList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_IMPLEMENT_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			Implement implementResponse = implementRepository.save(implementMapping.model(implementDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_IMPLEMENT_SUCCESS, INFO, idTransaccion));
			response.setDatos(new ImplementResponse().implement(implementMapping.modelDto(implementResponse)));

		} catch (Exception ex) {
			log.error(MESSAGE_UPDATE_IMPLEMENT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto deleteImplement(Long id) {
		ResponseDto response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			implementRepository.deleteById(id);

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_IMPLEMENT_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));

		} catch (Exception ex) {
			log.error(MESSAGE_DELETE_IMPLEMENT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

}

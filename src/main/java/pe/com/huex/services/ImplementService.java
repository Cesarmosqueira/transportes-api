package pe.com.huex.services;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.dto.Implement.ImplementDeleteDto;
import pe.com.huex.dto.Implement.ImplementListDto;
import pe.com.huex.dto.Implement.ImplementRegisterDto;
import pe.com.huex.dto.Implement.ImplementRetrieveDto;
import pe.com.huex.dto.Implement.ImplementUpdateDto;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.entities.Implement;
import pe.com.huex.repositories.ImplementRepository;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class ImplementService {
	private static final String MESSAGE_INQUIRY_SUPPLIERS_SUCCESS = "La consulta de implementos fue exitoso";
	private static final String MESSAGE_INQUIRY_SUPPLIERS_WARN = "No se encontró ningún implemento registrado";

	private static final String MESSAGE_REGISTER_SUPPLIERS_SUCCESS = "El registro del proeveedor fue exitoso";
	private static final String MESSAGE_REGISTER_SUPPLIERS_WARN = "Ocurrió un error al registrar al implemento";

	private static final String MESSAGE_UPDATE_SUPPLIERS_SUCCESS = "La consulta de implementos fue exitoso";
	private static final String MESSAGE_UPDATE_SUPPLIERS_WARN = "Ocurrió un error al actualizar los datos del implemento";

	private static final String MESSAGE_DELETE_SUPPLIERS_SUCCESS = "La eliminación del implemento fue exitosa";
	private static final String MESSAGE_DELETE_SUPPLIERS_WARN = "Ocurrió un error al eliminar el implemento";

	private static final String MESSAGE_RETRIEVE_SUPPLIERS_SUCCESS = "La consulta del implemento fue exitoso";
	private static final String MESSAGE_RETRIEVE_SUPPLIERS_WARN = "No se encontró los datos del implemento";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	ImplementRepository implementRepository;

	public ResponseDto<ImplementListDto> listImplements() {
		ResponseDto<ImplementListDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<Implement> implementList = implementRepository.findAll();

			if (implementList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_SUPPLIERS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_SUPPLIERS_SUCCESS, INFO, idTransaccion)
							.totalRegistros(implementList.size()));
			response.setDatos(new ImplementListDto().implementList(implementList));

		} catch (Exception ex) {
			log.error("error al consultar implementos" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<ImplementRetrieveDto> retrieveImplements(Long id) {
		ResponseDto<ImplementRetrieveDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Implement> implementList = implementRepository.findById(id);

			if (implementList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_SUPPLIERS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_SUPPLIERS_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));
			response.setDatos(new ImplementRetrieveDto().implement(implementList.get()));

		} catch (Exception ex) {
			log.error("error al consultar implemento" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<ImplementRegisterDto> registerImplements(Implement implement) {
		ResponseDto<ImplementRegisterDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();
			System.out.println("bout to save");
			Implement implementResponse = implementRepository.save(implement);
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_SUPPLIERS_SUCCESS, INFO,
					idTransaccion));
			response.setDatos(new ImplementRegisterDto().implement(implementResponse));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_SUPPLIERS_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<ImplementUpdateDto> updateImplements(Long id, Implement implement) {
		ResponseDto<ImplementUpdateDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Implement> implementResponse = implementRepository.findById(id);

			if (implementResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_SUPPLIERS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			implement.setId(id);
			implementRepository.save(implement);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_SUPPLIERS_SUCCESS, INFO, idTransaccion));
			response.setDatos(new ImplementUpdateDto().implement(implement));

		} catch (Exception ex) {
			log.error("error al actualizar implemento: " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<ImplementDeleteDto> deleteImplements(Long id) {
		ResponseDto<ImplementDeleteDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Implement> implementResponse = implementRepository.findById(id);

			if (implementResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_DELETE_SUPPLIERS_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			implementRepository.deleteById(id);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_SUPPLIERS_SUCCESS, INFO, idTransaccion));
			response.setDatos(new ImplementDeleteDto().implement(id));

		} catch (Exception ex) {
			log.error("error al actualizar implemento: " + ex);
			throw ex;
		}

		return response;
	}

}

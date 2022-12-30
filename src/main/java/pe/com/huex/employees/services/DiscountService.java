package pe.com.huex.employees.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.domain.persistence.IDiscountRepository;
import pe.com.huex.employees.domain.service.IDiscountService;
import pe.com.huex.employees.mapping.DiscountMapping;
import pe.com.huex.employees.services.resources.dtos.DiscountDto;
import pe.com.huex.employees.services.resources.response.DiscountListResponse;
import pe.com.huex.employees.services.resources.response.DiscountResponse;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class DiscountService implements IDiscountService {
	private static final String MESSAGE_INQUIRY_DISCOUNT_SUCCESS = "La consulta de los descuentos fue exitoso";
	private static final String MESSAGE_INQUIRY_DISCOUNT_WARN = "No se encontró ningúna descuento registrado";

	private static final String MESSAGE_REGISTER_DISCOUNT_SUCCESS = "El registro del descuento fue exitoso";
	private static final String MESSAGE_REGISTER_DISCOUNT_WARN = "Ocurrió un error al registrar el descuento";

	private static final String MESSAGE_UPDATE_DISCOUNT_SUCCESS = "La actualización de datos del descuento fue exitoso";
	private static final String MESSAGE_UPDATE_DISCOUNT_WARN = "Ocurrió un error al actualizar los datos del descuento";

	private static final String MESSAGE_RETRIEVE_DISCOUNT_SUCCESS = "La consulta del descuento fue exitoso";
	private static final String MESSAGE_RETRIEVE_DISCOUNT_WARN = "No se encontró los datos del descuento";

	private static final String MESSAGE_DELETE_DISCOUNT_SUCCESS = "Se eliminó correctamente el descuento";

	private static final String MESSAGE_DELETE_DISCOUNT_WARN = "Ocurrió un error al eliminar el descuento";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	IDiscountRepository discountRepository;

	@Autowired
	DiscountMapping discountMapping;

	@Override
	public ResponseDto<DiscountListResponse> listDiscounts() {
		ResponseDto<DiscountListResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<EmployeeDiscount> discountList = discountRepository.findAll();

			if (discountList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_DISCOUNT_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_DISCOUNT_SUCCESS, INFO, idTransaccion)
					.totalRegistros(discountList.size()));
			response.setDatos(new DiscountListResponse().discounts(discountMapping.modelList(discountList)));

		} catch (Exception ex) {
			log.error(MESSAGE_INQUIRY_DISCOUNT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<DiscountResponse> retrieveDiscount(Long id) {
		ResponseDto<DiscountResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<EmployeeDiscount> discountList = discountRepository.findById(id);

			if (discountList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_DISCOUNT_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_DISCOUNT_SUCCESS, INFO, idTransaccion)
					.totalRegistros(1));
			response.setDatos(new DiscountResponse().discount(discountMapping.modelDto(discountList.get())));

		} catch (Exception ex) {
			log.error(MESSAGE_RETRIEVE_DISCOUNT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<DiscountResponse> registerDiscount(DiscountDto discountDto) {
		ResponseDto<DiscountResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			EmployeeDiscount discountResponse = discountRepository.save(discountMapping.model(discountDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_DISCOUNT_SUCCESS, INFO, idTransaccion));
			response.setDatos(new DiscountResponse().discount(discountMapping.modelDto(discountResponse)));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_DISCOUNT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<DiscountResponse> updateDiscount(DiscountDto discountDto) {
		ResponseDto<DiscountResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<EmployeeDiscount> discountList = discountRepository.findById(discountDto.getId());

			if (discountList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_DISCOUNT_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			EmployeeDiscount discountResponse = discountRepository.save(discountMapping.model(discountDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_DISCOUNT_SUCCESS, INFO, idTransaccion));
			response.setDatos(new DiscountResponse().discount(discountMapping.modelDto(discountResponse)));

		} catch (Exception ex) {
			log.error(MESSAGE_UPDATE_DISCOUNT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto deleteDiscount(Long id) {
		ResponseDto response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			discountRepository.deleteById(id);

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_DISCOUNT_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));

		} catch (Exception ex) {
			log.error(MESSAGE_DELETE_DISCOUNT_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

}

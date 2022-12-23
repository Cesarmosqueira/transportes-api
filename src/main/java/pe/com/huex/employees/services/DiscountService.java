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
import pe.com.huex.util.ResponseDto;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.domain.entities.EmployeeDiscount;
import pe.com.huex.employees.domain.persistence.DiscountRepository;
import pe.com.huex.employees.domain.persistence.EmployeeRepository;
import pe.com.huex.employees.services.resources.response.discount.DiscountDeleteDto;
import pe.com.huex.employees.services.resources.response.discount.DiscountListDto;
import pe.com.huex.employees.services.resources.response.discount.DiscountRegisterDto;
import pe.com.huex.employees.services.resources.dtos.DiscountResponseDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class DiscountService {
	private static final String MESSAGE_REGISTER_ATTENDANCES_SUCCESS = "El registro de asistencia fue exitoso";
	private static final String MESSAGE_REGISTER_ATTENDANCES_WARN = "Ocurrió un error al registrar la asistencia";

	private static final String MESSAGE_UPDATE_ATTENDANCES_SUCCESS = "La actualizacion de asistencia fue exitosa";
	private static final String MESSAGE_UPDATE_ATTENDANCES_WARN = "Ocurrió un error al actualizar la asistencia";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	DiscountRepository discountRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseDto<DiscountRegisterDto> registerDiscounts(
			DiscountResponseDto discountRequestDto) throws Exception {
		ResponseDto<DiscountRegisterDto> response = new ResponseDto<>();

		// save the constructed attendance
		String idTransaccion = UUID.randomUUID().toString();

		Optional<Employee> employee = employeeRepository.findById(discountRequestDto.getEmployeeId());
		if (employee.isEmpty()) {

			response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, "trabajador no existe", INFO, idTransaccion));
			return response;

		}

		EmployeeDiscount discount = new EmployeeDiscount(discountRequestDto, employee.get());
		try {

			EmployeeDiscount discountResponse = discountRepository.saveAndFlush(discount);
			discountRepository.save(discount);

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_ATTENDANCES_SUCCESS, INFO,
					idTransaccion));
			response.setDatos(new DiscountRegisterDto().discount(discountResponse));

		} catch (Exception ex) {
			String actualMessage = ex.getMessage();
			System.out
					.println("\n == Actual message == \n" + actualMessage + "\n\n" + ex.getLocalizedMessage() + "\n\n");
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS,
					MESSAGE_REGISTER_ATTENDANCES_WARN, INFO,
					idTransaccion));
			return response;

			// log.error(MESSAGE_REGISTER_ATTENDANCES_WARN + ": " + ex);
			// throw ex;
		}

		return response;
	}

	public ResponseDto<DiscountRegisterDto> updateDiscounts(Long id, DiscountResponseDto discount) {
		ResponseDto<DiscountRegisterDto> response = new ResponseDto<>();

		String idTransaccion = UUID.randomUUID().toString();
		try {
			Optional<EmployeeDiscount> discountResponse = discountRepository.findById(id);

			if (discountResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil
								.buildMetadatos(CODE_WARN, "El descuento especificado no existe", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			Optional<Employee> employeeResponse = employeeRepository.findById(discount.getEmployeeId());
			if (employeeResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, "trabajador no existe", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			EmployeeDiscount employeeDiscount = discountResponse.get();
			employeeDiscount.setDate(discount.getDate());
			employeeDiscount.setCharge(discount.getCharge());
			employeeDiscount.setEmployee(employeeResponse.get());
			employeeDiscount.setObservations(discount.getObservations());
			employeeDiscount = discountRepository.saveAndFlush(employeeDiscount);
			discountRepository.save(employeeDiscount);

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_ATTENDANCES_SUCCESS, INFO,
					idTransaccion));
			response.setDatos(new DiscountRegisterDto().discount(employeeDiscount));

		} catch (Exception ex) {
			String actualMessage = ex.getMessage();
			System.out
					.println("\n == Actual message == \n" + actualMessage + "\n\n" + ex.getLocalizedMessage() + "\n\n");
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS,
					MESSAGE_REGISTER_ATTENDANCES_WARN, INFO,
					idTransaccion));
			return response;

		}

		return response;
	}

	public ResponseDto<DiscountListDto> listDiscounts() {
		ResponseDto<DiscountListDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<EmployeeDiscount> discountList = discountRepository.findAll();

			if (discountList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, "No se encontraron descuentos", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil
							.buildMetadatos(CODE_SUCCESS, "Se realizo la consulta exitosamente", INFO, idTransaccion)
							.totalRegistros(discountList.size()));
			response.setDatos(new DiscountListDto().discountList(discountList));

		} catch (Exception ex) {
			log.error("error al consultar descuentos" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<DiscountListDto> listDiscountsByEmployee(Long employeeId) {
		ResponseDto<DiscountListDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Employee> employeeResponse = employeeRepository.findById(employeeId);
			if (employeeResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, "trabajador no existe", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			List<EmployeeDiscount> discountList = discountRepository.findByEmployee(employeeId);

			if (discountList.isEmpty()) {
				response.meta(
						MetaDatosUtil
								.buildMetadatos(CODE_WARN, "Este trabajador no presenta descuentos", WARN,
										idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil
							.buildMetadatos(CODE_SUCCESS, "Se realizo la consulta exitosamente", INFO, idTransaccion)
							.totalRegistros(discountList.size()));
			response.setDatos(new DiscountListDto().discountList(discountList));

		} catch (Exception ex) {
			log.error("error al consultar descuentos" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<DiscountDeleteDto> deleteDiscounts(Long id) {
		ResponseDto<DiscountDeleteDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<EmployeeDiscount> discountResponse = discountRepository.findById(id);

			if (discountResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, "El descuento no existe", WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			discountRepository.deleteById(id);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, "Se elimino el descuento", INFO, idTransaccion));
			response.setDatos(new DiscountDeleteDto().discount(discountResponse.get()));

		} catch (Exception ex) {
			log.error("error al actualizar discounto: " + ex);
			throw ex;
		}

		return response;
	}

}

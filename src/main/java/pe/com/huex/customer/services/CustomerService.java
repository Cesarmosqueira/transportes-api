package pe.com.huex.customer.services;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.domain.persistence.CustomerEmployeeRepository;
import pe.com.huex.customer.domain.persistence.CustomerRepository;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerDeleteDto;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerListDto;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerRegisterDto;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerRetrieveDto;
import pe.com.huex.customer.services.resources.customer.dtos.CustomerUpdateDto;
import pe.com.huex.customer.services.resources.response.CustomerResponseDto;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class CustomerService {
	private static final String MESSAGE_REGISTER_CUSTOMER_SUCCESS = "El registro del cliente fue exitoso";
	private static final String MESSAGE_REGISTER_CUSTOMER_WARN = "Ocurrió un error al registrar al cliente";

	private static final String MESSAGE_RETRIEVE_CUSTOMER_SUCCESS = "La consulta del cliente fue exitosa";
	private static final String MESSAGE_RETRIEVE_CUSTOMER_WARN = "Ocurrió un error al consultar al cliente";

	private static final String MESSAGE_INQUIRY_CUSTOMER_SUCCESS = "El listado de clientes fue exitoso";
	private static final String MESSAGE_INQUIRY_CUSTOMER_WARN = "Ocurrió un error al listar los clientes";

	private static final String MESSAGE_UPDATE_CUSTOMER_SUCCESS = "La actualizacion del cliente fue exitosa";
	private static final String MESSAGE_UPDATE_CUSTOMER_WARN = "No se encontro el cliente que se va a actualizar";

	private static final String MESSAGE_DELETE_CUSTOMER_SUCCESS = "La eliminacion del cliente fue exitosa";
	private static final String MESSAGE_DELETE_CUSTOMER_WARN = "Ocurrió un error al eliminar al cliente";

	private static final String CODE_SUCCESS = "0";

	private static final String CODE_WARN = "1";

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerEmployeeRepository customerEmployeeRepository;

	public ResponseDto<CustomerListDto> listCustomers() {
		ResponseDto<CustomerListDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			List<Customer> customerList = customerRepository.findAll();

			if (customerList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_CUSTOMER_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_CUSTOMER_SUCCESS, INFO, idTransaccion)
							.totalRegistros(customerList.size()));
			response.setDatos(new CustomerListDto().customerList(customerList));

		} catch (Exception ex) {
			log.error("error al consultar clientes" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<CustomerRetrieveDto> retrieveCustomers(Long id) {
		ResponseDto<CustomerRetrieveDto> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Customer> customerList = customerRepository.findById(id);

			if (customerList.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_CUSTOMER_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_CUSTOMER_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));
			response.setDatos(new CustomerRetrieveDto().customer(customerList.get()));

		} catch (Exception ex) {
			log.error("error al consultar cliente" + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<CustomerRegisterDto> registerCustomers(CustomerResponseDto customer) {
		ResponseDto<CustomerRegisterDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();
			Customer customerResponse = customerRepository.save(new Customer(customer));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_CUSTOMER_SUCCESS, INFO,
					idTransaccion));
			response.setDatos(new CustomerRegisterDto().customer(customerResponse));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_CUSTOMER_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<CustomerUpdateDto> updateCustomers(Long id, CustomerResponseDto customer) {
		ResponseDto<CustomerUpdateDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Customer> customerResponse = customerRepository.findById(id);

			if (customerResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_UPDATE_CUSTOMER_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			Customer customerInDb = new Customer(customer);
			customer.setId(id);
			customerRepository.saveAndFlush(customerInDb);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_CUSTOMER_SUCCESS, INFO, idTransaccion));
			response.setDatos(new CustomerUpdateDto().customer(customer));

		} catch (Exception ex) {
			log.error("error al actualizar cliente: " + ex);
			throw ex;
		}

		return response;
	}

	public ResponseDto<CustomerDeleteDto> deleteCustomers(Long id) {
		ResponseDto<CustomerDeleteDto> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Customer> customerResponse = customerRepository.findById(id);

			if (customerResponse.isEmpty()) {
				response.meta(
						MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_DELETE_CUSTOMER_WARN, WARN, idTransaccion)
								.totalRegistros(0));
				return response;
			}

			customerRepository.deleteById(id);
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_CUSTOMER_SUCCESS, INFO, idTransaccion));
			response.setDatos(new CustomerDeleteDto().customer(id));

		} catch (Exception ex) {
			log.error("error al actualizar cliente: " + ex);
			throw ex;
		}

		return response;
	}
}

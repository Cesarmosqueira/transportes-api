package pe.com.huex.customer.services;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pe.com.huex.customer.domain.entities.Customer;
import pe.com.huex.customer.domain.entities.CustomerEmployee;
import pe.com.huex.customer.domain.persistence.CustomerRepository;
import pe.com.huex.customer.domain.service.ICustomerService;
import pe.com.huex.customer.mapping.CustomerMapping;
import pe.com.huex.customer.services.resources.response.CustomerEmployeeListResponse;
import pe.com.huex.customer.services.resources.response.CustomerEmployeeResponse;
import pe.com.huex.customer.services.resources.response.CustomerListResponse;
import pe.com.huex.customer.services.resources.dto.CustomerDto;
import pe.com.huex.customer.services.resources.response.CustomerResponse;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class CustomerService implements ICustomerService {
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

	private final CustomerRepository customerRepository;

	private final CustomerMapping customerMapping;

	public CustomerService(CustomerRepository customerRepository, CustomerMapping customerMapping) {
		this.customerRepository = customerRepository;
		this.customerMapping = customerMapping;
	}


	@Override
	public ResponseDto<CustomerListResponse> listCustomer() {
		ResponseDto<CustomerListResponse> response = new ResponseDto<>();
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
			response.setDatos(new CustomerListResponse().customer(customerMapping.modelList(customerList)));

		} catch (Exception ex) {
			log.error(MESSAGE_INQUIRY_CUSTOMER_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<CustomerResponse> retrieveCustomer(Long id) {
		ResponseDto<CustomerResponse> response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Customer> customerList = customerRepository.findById(id);

			if (customerList.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_CUSTOMER_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_CUSTOMER_SUCCESS, INFO, idTransaccion)
					.totalRegistros(1));
			response.setDatos(new CustomerResponse().customer(customerMapping.modelDto(customerList.get())));

		} catch (Exception ex) {
			log.error("error al consultar clientes" + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<CustomerResponse> registerCustomer(CustomerDto customerDto) {
		ResponseDto<CustomerResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();
			Customer customerResponse = customerRepository.save(customerMapping.model(customerDto));
			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_CUSTOMER_SUCCESS, INFO, idTransaccion));
			response.setDatos(new CustomerResponse().customer(customerMapping.modelDto(customerResponse)));
		} catch (Exception ex) {
			log.error(MESSAGE_REGISTER_CUSTOMER_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto<CustomerResponse> updateCustomer(CustomerDto customerDto) {
		ResponseDto<CustomerResponse> response = new ResponseDto<>();

		try {
			String idTransaccion = UUID.randomUUID().toString();

			Optional<Customer> customerResponse = customerRepository.findById(customerDto.getId());

			if (customerResponse.isEmpty()) {
				response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_CUSTOMER_WARN, WARN, idTransaccion)
						.totalRegistros(0));
				return response;
			}

			customerRepository.save(customerMapping.model(customerDto));
			response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_CUSTOMER_SUCCESS, INFO, idTransaccion));
			response.setDatos(new CustomerResponse().customer(customerDto));

		} catch (Exception ex) {
			log.error(MESSAGE_UPDATE_CUSTOMER_WARN + ": " + ex);
			throw ex;
		}

		return response;
	}

	@Override
	public ResponseDto deleteCustomer(Long id) {
		ResponseDto response = new ResponseDto<>();
		try {
			String idTransaccion = UUID.randomUUID().toString();

			customerRepository.deleteById(id);

			response.meta(
					MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_CUSTOMER_SUCCESS, INFO, idTransaccion)
							.totalRegistros(1));

		} catch (Exception ex) {
			log.error(MESSAGE_RETRIEVE_CUSTOMER_WARN + ": " + ex);
			throw ex;
		}
		return response;
	}
}

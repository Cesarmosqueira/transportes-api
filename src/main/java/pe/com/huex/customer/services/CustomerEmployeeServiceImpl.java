package pe.com.huex.customer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.customer.domain.entities.CustomerEmployee;
import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.customer.domain.persistence.CustomerEmployeeRepository;
import pe.com.huex.customer.domain.service.ICustomerEmployeeService;
import pe.com.huex.customer.mapping.CustomerEmployeeMapping;
import pe.com.huex.customer.services.resources.dto.CustomerEmployeeDto;
import pe.com.huex.customer.services.resources.response.CustomerEmployeeListResponse;
import pe.com.huex.customer.services.resources.response.CustomerEmployeeResponse;
import pe.com.huex.customer.services.resources.response.RateResponse;
import pe.com.huex.services.domain.entities.ServiceMonitoring;
import pe.com.huex.services.service.resources.response.ServiceMonitoringListResponse;
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
public class CustomerEmployeeServiceImpl implements ICustomerEmployeeService {



    private static final String MESSAGE_INQUIRY_CUSTOMEREMPLOYEE_SUCCESS = "La consulta de Trabajador Apto fue exitoso";
    private static final String MESSAGE_INQUIRY_CUSTOMEREMPLOYEE_WARN = "No se encontró ningúna Trabajador Apto registrado";

    private static final String MESSAGE_REGISTER_CUSTOMEREMPLOYEE_SUCCESS = "El registro de Trabajador Apto fue exitoso";
    private static final String MESSAGE_REGISTER_CUSTOMEREMPLOYEE_WARN = "Ocurrió un error al registrar Trabajador Apto";

    private static final String MESSAGE_UPDATE_CUSTOMEREMPLOYEE_SUCCESS = "La actualización de datos de Trabajador Apto fue exitoso";
    private static final String MESSAGE_UPDATE_CUSTOMEREMPLOYEE_WARN = "Ocurrió un error al actualizar los datos de  Trabajador Apto";

    private static final String MESSAGE_RETRIEVE_CUSTOMEREMPLOYEE_SUCCESS = "La consulta de Trabajador Apto fue exitoso";
    private static final String MESSAGE_RETRIEVE_CUSTOMEREMPLOYEE_WARN = "No se encontró los datos de Trabajador Apto";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final CustomerEmployeeRepository customerEmployeeRepository;
    private final CustomerEmployeeMapping customerEmployeeMapping;

    public CustomerEmployeeServiceImpl(CustomerEmployeeRepository customerEmployeeRepository, CustomerEmployeeMapping customerEmployeeMapping) {
        this.customerEmployeeRepository = customerEmployeeRepository;
        this.customerEmployeeMapping = customerEmployeeMapping;
    }


    @Override
    public ResponseDto<CustomerEmployeeListResponse> listCustomerEmployee() {
        ResponseDto<CustomerEmployeeListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<CustomerEmployee> customerEmployeesList = customerEmployeeRepository.findAll();

            if (customerEmployeesList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_CUSTOMEREMPLOYEE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_CUSTOMEREMPLOYEE_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(customerEmployeesList.size()));
            response.setDatos(new CustomerEmployeeListResponse().customerEmployee(customerEmployeeMapping.modelList(customerEmployeesList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_CUSTOMEREMPLOYEE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<CustomerEmployeeResponse> retrieveCustomerEmployee(Long id) {
        ResponseDto<CustomerEmployeeResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<CustomerEmployee> customerEmployeeList = customerEmployeeRepository.findById(id);

            if (customerEmployeeList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_CUSTOMEREMPLOYEE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_CUSTOMEREMPLOYEE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new CustomerEmployeeResponse().customerEmployee(customerEmployeeMapping.modelDto(customerEmployeeList.get())));

        } catch (Exception ex) {
            log.error("error al consultar choferes aptos" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<CustomerEmployeeResponse> registerCustomerEmployee(CustomerEmployeeDto customerEmployeeDto) {
        ResponseDto<CustomerEmployeeResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            CustomerEmployee customerEmployeeResponse = customerEmployeeRepository.save(customerEmployeeMapping.model(customerEmployeeDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_CUSTOMEREMPLOYEE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new CustomerEmployeeResponse().customerEmployee(customerEmployeeMapping.modelDto(customerEmployeeResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_CUSTOMEREMPLOYEE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<CustomerEmployeeResponse> updateCustomerEmployee(CustomerEmployeeDto customerEmployeeDto) {
        ResponseDto<CustomerEmployeeResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<CustomerEmployee> customerEmployeeResponse = customerEmployeeRepository.findById(customerEmployeeDto.getId());

            if (customerEmployeeResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_CUSTOMEREMPLOYEE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            customerEmployeeRepository.save(customerEmployeeMapping.model(customerEmployeeDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_CUSTOMEREMPLOYEE_SUCCESS, INFO, idTransaccion));
            response.setDatos(new CustomerEmployeeResponse().customerEmployee(customerEmployeeDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_CUSTOMEREMPLOYEE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteCustomerEmployee(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            customerEmployeeRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_CUSTOMEREMPLOYEE_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_CUSTOMEREMPLOYEE_WARN + ": " + ex);
            throw ex;
        }
        return response;
    }
}

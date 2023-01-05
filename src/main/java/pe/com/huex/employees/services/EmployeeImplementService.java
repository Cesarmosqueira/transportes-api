package pe.com.huex.employees.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.employees.domain.entities.EmployeeImplement;
import pe.com.huex.employees.domain.persistence.EmployeeImplementRepository;
import pe.com.huex.employees.domain.service.IEmployeeImplementService;
import pe.com.huex.employees.mapping.EmployeeImplementMapping;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementDto;
import pe.com.huex.employees.services.resources.response.EmployeeImplementListResponse;
import pe.com.huex.employees.services.resources.response.EmployeeImplementResponse;
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
public class EmployeeImplementService implements IEmployeeImplementService {

    private static final String MESSAGE_INQUIRY_EMPLOYEEIMPLEMENT_SUCCESS = "La consulta de implementos entregados fue exitoso";
    private static final String MESSAGE_INQUIRY_EMPLOYEEIMPLEMENT_WARN = "No se encontró ningún implemento entregados registrado";

    private static final String MESSAGE_REGISTER_EMPLOYEEIMPLEMENT_SUCCESS = "El registro del implemento entregados fue exitoso";
    private static final String MESSAGE_REGISTER_EMPLOYEEIMPLEMENT_WARN = "Ocurrió un error al registrar el implemento entregados";

    private static final String MESSAGE_UPDATE_EMPLOYEEIMPLEMENT_SUCCESS = "La actualización de datos del implemento entregadosfue exitoso";
    private static final String MESSAGE_UPDATE_EMPLOYEEIMPLEMENT_WARN = "Ocurrió un error al actualizar los datos del implemento entregados";

    private static final String MESSAGE_RETRIEVE_EMPLOYEEIMPLEMENT_SUCCESS = "La consulta del implemento entregados fue exitoso";
    private static final String MESSAGE_RETRIEVE_EMPLOYEEIMPLEMENT_WARN = "No se encontró los datos del implemento entregados";

    private static final String MESSAGE_DELETE_EMPLOYEEIMPLEMENT_SUCCESS = "Se eliminó correctamente el implemento entregados";

    private static final String MESSAGE_DELETE_EMPLOYEEIMPLEMENT_WARN = "Ocurrió un error al eliminar el implemento entregados";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final EmployeeImplementMapping employeeImplementMapping;
    private final EmployeeImplementRepository employeeImplementRepository;

    public EmployeeImplementService(EmployeeImplementMapping employeeImplementMapping, EmployeeImplementRepository employeeImplementRepository) {
        this.employeeImplementMapping = employeeImplementMapping;
        this.employeeImplementRepository = employeeImplementRepository;
    }


    @Override
    public ResponseDto<EmployeeImplementListResponse> listEmployeeImplement() {
        ResponseDto<EmployeeImplementListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<EmployeeImplement> employeeImplementList = employeeImplementRepository.findAll();

            if (employeeImplementList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_EMPLOYEEIMPLEMENT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_EMPLOYEEIMPLEMENT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(employeeImplementList.size()));
            response.setDatos(new EmployeeImplementListResponse().employeeImplement(employeeImplementMapping.modelList(employeeImplementList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_EMPLOYEEIMPLEMENT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<EmployeeImplementResponse> retrieveEmployeeImplement(Long id) {
        ResponseDto<EmployeeImplementResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<EmployeeImplement> employeeImplementList = employeeImplementRepository.findById(id);

            if (employeeImplementList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_EMPLOYEEIMPLEMENT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_EMPLOYEEIMPLEMENT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new EmployeeImplementResponse().employeeImplement(employeeImplementMapping.modelDto(employeeImplementList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_EMPLOYEEIMPLEMENT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<EmployeeImplementResponse> registerEmployeeImplement(EmployeeImplementDto employeeImplementDto) {
        ResponseDto<EmployeeImplementResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            EmployeeImplement employeeImplementResponse = employeeImplementRepository.save(employeeImplementMapping.model(employeeImplementDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_EMPLOYEEIMPLEMENT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new EmployeeImplementResponse().employeeImplement(employeeImplementMapping.modelDto(employeeImplementResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_EMPLOYEEIMPLEMENT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<EmployeeImplementResponse> updateEmployeeImplement(EmployeeImplementDto employeeImplementDto) {
        ResponseDto<EmployeeImplementResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<EmployeeImplement> employeeImplementList = employeeImplementRepository.findById(employeeImplementDto.getId());

            if (employeeImplementList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_EMPLOYEEIMPLEMENT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            EmployeeImplement employeeImplementResponse = employeeImplementRepository.save(employeeImplementMapping.model(employeeImplementDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_EMPLOYEEIMPLEMENT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new EmployeeImplementResponse().employeeImplement(employeeImplementMapping.modelDto(employeeImplementResponse)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_EMPLOYEEIMPLEMENT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteEmployeeImplement(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            employeeImplementRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_EMPLOYEEIMPLEMENT_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_DELETE_EMPLOYEEIMPLEMENT_WARN + ": " + ex);
            throw ex;
        }
        return response;
    }
}

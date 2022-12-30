package pe.com.huex.services.service;

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
import pe.com.huex.services.domain.entities.ExpenseType;
import pe.com.huex.services.domain.persistence.ExpenseTypeRepository;
import pe.com.huex.services.domain.service.IExpenseTypeService;
import pe.com.huex.services.mapping.ExpenseTypeMapping;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;
import pe.com.huex.services.service.resources.response.ExpenseTypeListResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeResponse;
import pe.com.huex.util.MetaDatosUtil;

@Transactional
@Service
@Slf4j
public class ExpenseTypeService implements IExpenseTypeService {

    private static final String MESSAGE_INQUIRY_EXPENSETYPE_SUCCESS = "La consulta de tipo gasto fue exitoso";
    private static final String MESSAGE_INQUIRY_EXPENSETYPE_WARN = "No se encontró ningúna tipo gasto registrado";

    private static final String MESSAGE_REGISTER_EXPENSETYPE_SUCCESS = "El registro de tipo gasto fue exitoso";
    private static final String MESSAGE_REGISTER_RUTE_WARN = "Ocurrió un error al registrar  tipo gasto";

    private static final String MESSAGE_UPDATE_EXPENSETYPE_SUCCESS = "La actualización de datos de  tipo gasto fue exitoso";
    private static final String MESSAGE_UPDATE_RUTE_WARN = "Ocurrió un error al actualizar los datos de tipo gasto";

    private static final String MESSAGE_RETRIEVE_EXPENSETYPE_SUCCESS = "La consulta de tipo gasto fue exitoso";
    private static final String MESSAGE_RETRIEVE_EXPENSETYPE_WARN = "No se encontró los datos de  tipo gasto";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    ExpenseTypeMapping expenseTypeMapping;

    @Override
    public ResponseDto<ExpenseTypeListResponse> listExpenseType() {
        ResponseDto<ExpenseTypeListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<ExpenseType> expenseTypeList = expenseTypeRepository.findAll();

            if (expenseTypeList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_EXPENSETYPE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_EXPENSETYPE_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(expenseTypeList.size()));
            response.setDatos(new ExpenseTypeListResponse()
                    .expenseTypeList(expenseTypeMapping.modelList(expenseTypeList)));

        } catch (Exception ex) {
            log.error("error al consultar tipo gasto" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ExpenseTypeResponse> retrieveExpenseType(Long id) {
        ResponseDto<ExpenseTypeResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ExpenseType> expenseTypeList = expenseTypeRepository.findById(id);

            if (expenseTypeList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_EXPENSETYPE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_EXPENSETYPE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new ExpenseTypeResponse()
                    .expenseType(expenseTypeMapping.modelDto(expenseTypeList.get())));

        } catch (Exception ex) {
            log.error("error al consultar tipo gasto" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ExpenseTypeResponse> registerExpenseType(ExpenseTypeDto expenseTypeDto) {
        ResponseDto<ExpenseTypeResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            ExpenseType expenseTypeResponse = expenseTypeRepository.save(expenseTypeMapping.model(expenseTypeDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_EXPENSETYPE_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new ExpenseTypeResponse()
                    .expenseType(expenseTypeMapping.modelDto(expenseTypeResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_RUTE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<ExpenseTypeResponse> updateExpenseType(ExpenseTypeDto expenseTypeDto) {
        ResponseDto<ExpenseTypeResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<ExpenseType> expenseTypeResponse = expenseTypeRepository.findById(expenseTypeDto.getId());

            if (expenseTypeResponse.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_EXPENSETYPE_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            expenseTypeRepository.save(expenseTypeMapping.model(expenseTypeDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_EXPENSETYPE_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new ExpenseTypeResponse().expenseType(expenseTypeDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_RUTE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteExpenseType(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            expenseTypeRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_EXPENSETYPE_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_EXPENSETYPE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

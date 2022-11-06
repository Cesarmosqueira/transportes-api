package pe.com.huex.vehicles.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.vehicles.domain.model.entity.MaintenanceOil;
import pe.com.huex.vehicles.domain.persistence.IMaintenanceOilRepository;
import pe.com.huex.vehicles.domain.service.IMaintenanceOilService;
import pe.com.huex.vehicles.mapping.MaintenanceOilMapping;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceOilDto;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilListResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceOilUpdateResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class MaintenanceOilServiceImpl implements IMaintenanceOilService {

    private static final String MESSAGE_INQUIRY_MAINTENANCEOIL_SUCCESS = "La consulta de mantenimiento aceite fue exitoso";
    private static final String MESSAGE_INQUIRY_MAINTENANCEOIL_WARN = "No se encontró ningún mantenimiento aceite registrado";

    private static final String MESSAGE_REGISTER_MAINTENANCEOIL_SUCCESS = "El registro del mantenimiento aceite fue exitoso";
    private static final String MESSAGE_REGISTER_MAINTENANCEOIL_WARN = "Ocurrió un error al registrar el mantenimiento aceite";

    private static final String MESSAGE_UPDATE_MAINTENANCEOIL_SUCCESS = "La actualización de datos del mantenimiento aceite fue exitoso";
    private static final String MESSAGE_UPDATE_MAINTENANCEOIL_WARN = "Ocurrió un error al actualizar los datos del mantenimiento aceite";

    private static final String MESSAGE_RETRIEVE_MAINTENANCEOIL_SUCCESS = "La consulta del mantenimiento aceite fue exitoso";
    private static final String MESSAGE_RETRIEVE_MAINTENANCEOIL_WARN = "No se encontró los datos del mantenimiento aceite";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    IMaintenanceOilRepository maintenanceOilRepository;

    @Autowired
    MaintenanceOilMapping maintenanceOilMapping;

    @Override
    public ResponseDto<MaintenanceOilListResponse> listMaintenanceOils() {
        ResponseDto<MaintenanceOilListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<MaintenanceOil> maintenanceOilList = maintenanceOilRepository.findAll();

            if (maintenanceOilList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_MAINTENANCEOIL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_MAINTENANCEOIL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(maintenanceOilList.size()));
            response.setDatos(new MaintenanceOilListResponse()
                    .maintenanceOilList(maintenanceOilMapping.modelList(maintenanceOilList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_MAINTENANCEOIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<MaintenanceOilRetrieveResponse> retrieveMaintenanceOil(Long id) {
        ResponseDto<MaintenanceOilRetrieveResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<MaintenanceOil> maintenanceOilList = maintenanceOilRepository.findById(id);

            if (maintenanceOilList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_MAINTENANCEOIL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_MAINTENANCEOIL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new MaintenanceOilRetrieveResponse()
                    .maintenanceOil(maintenanceOilMapping.modelDto(maintenanceOilList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_MAINTENANCEOIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<MaintenanceOilRegisterResponse> registerMaintenanceOil(MaintenanceOilDto maintenanceOilDto) {
        ResponseDto<MaintenanceOilRegisterResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            MaintenanceOil maintenanceOil = maintenanceOilRepository
                    .save(maintenanceOilMapping.model(maintenanceOilDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_MAINTENANCEOIL_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new MaintenanceOilRegisterResponse()
                    .maintenanceOil(maintenanceOilMapping.modelDto(maintenanceOil)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_MAINTENANCEOIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<MaintenanceOilUpdateResponse> updateMaintenanceOil(MaintenanceOilDto maintenanceOilDto) {
        ResponseDto<MaintenanceOilUpdateResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            MaintenanceOil maintenanceOilResponse = maintenanceOilRepository.findById(maintenanceOilDto.getId()).get();

            if (Objects.isNull(maintenanceOilResponse)) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_MAINTENANCEOIL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            maintenanceOilRepository.save(maintenanceOilMapping.model(maintenanceOilDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_MAINTENANCEOIL_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new MaintenanceOilUpdateResponse().maintenanceOil(maintenanceOilDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_MAINTENANCEOIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

package pe.com.huex.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.MaintenanceOil;
import pe.com.huex.repositories.MaintenanceOilRepository;
import pe.com.huex.util.MetaDatosUtil;

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
public class MaintenanceOilService {

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
    MaintenanceOilRepository maintenanceOilRepository;

    public ResponseDto<MaintenanceOilListDto> listMaintenanceOils() {
        ResponseDto<MaintenanceOilListDto> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<MaintenanceOil> maintenanceOilList = maintenanceOilRepository.findAll();

            if (maintenanceOilList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_MAINTENANCEOIL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_MAINTENANCEOIL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(maintenanceOilList.size()));
            response.setDatos(new MaintenanceOilListDto().maintenanceOilList(maintenanceOilList));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_MAINTENANCEOIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<MaintenanceOilRetrieveDto> retrieveMaintenanceOil(Long id) {
        ResponseDto<MaintenanceOilRetrieveDto> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<MaintenanceOil> maintenanceOilList = maintenanceOilRepository.findById(id);

            if (maintenanceOilList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_MAINTENANCEOIL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_MAINTENANCEOIL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new MaintenanceOilRetrieveDto().maintenanceOil(maintenanceOilList.get()));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_MAINTENANCEOIL_WARN+ ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<MaintenanceOilRegisterDto> registerMaintenanceOil(MaintenanceOil maintenanceOil) {
        ResponseDto<MaintenanceOilRegisterDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            MaintenanceOil MaintenanceOilResponse = maintenanceOilRepository.save(maintenanceOil);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_MAINTENANCEOIL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new MaintenanceOilRegisterDto().maintenanceOil(MaintenanceOilResponse));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_MAINTENANCEOIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<MaintenanceOilUpdateDto> updateMaintenanceOil(Long id, MaintenanceOil maintenanceOil) {
        ResponseDto<MaintenanceOilUpdateDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            MaintenanceOil maintenanceOilResponse = maintenanceOilRepository.findById(id).get();

            if (Objects.isNull(maintenanceOilResponse)) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_MAINTENANCEOIL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            maintenanceOil.setId(id);
            maintenanceOilRepository.save(maintenanceOil);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_MAINTENANCEOIL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new MaintenanceOilUpdateDto().maintenanceOil(maintenanceOil));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_MAINTENANCEOIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

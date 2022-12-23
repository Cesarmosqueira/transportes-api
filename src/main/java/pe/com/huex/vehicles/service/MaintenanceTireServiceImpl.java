package pe.com.huex.vehicles.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.vehicles.domain.entities.MaintenanceTire;
import pe.com.huex.vehicles.domain.persistence.IMaintenanceTireRepository;
import pe.com.huex.vehicles.domain.service.IMaintenanceTireService;
import pe.com.huex.vehicles.mapping.MaintenanceTireMapping;
import pe.com.huex.vehicles.service.resources.dto.MaintenanceTireDto;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireListResponse;
import pe.com.huex.vehicles.service.resources.response.MaintenanceTireResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class MaintenanceTireServiceImpl implements IMaintenanceTireService {

    private static final String MESSAGE_INQUIRY_MAINTENANCETIRE_SUCCESS = "La consulta de mantenimiento de llanta fue exitoso";
    private static final String MESSAGE_INQUIRY_MAINTENANCETIRE_WARN = "No se encontró ningún mantenimiento de llanta registrado";

    private static final String MESSAGE_REGISTER_MAINTENANCETIRE_SUCCESS = "El registro del mantenimiento de llanta fue exitoso";
    private static final String MESSAGE_REGISTER_MAINTENANCETIRE_WARN = "Ocurrió un error al registrar el mantenimiento de llanta";

    private static final String MESSAGE_UPDATE_MAINTENANCETIRE_SUCCESS = "La actualización de datos del mantenimiento de llanta fue exitoso";
    private static final String MESSAGE_UPDATE_MAINTENANCETIRE_WARN = "Ocurrió un error al actualizar los datos del mantenimiento de llanta";

    private static final String MESSAGE_RETRIEVE_MAINTENANCETIRE_SUCCESS = "La consulta del mantenimiento de llanta fue exitoso";
    private static final String MESSAGE_RETRIEVE_MAINTENANCETIRE_WARN = "No se encontró los datos del mantenimiento de llanta";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    IMaintenanceTireRepository maintenanceTireRepository;

    @Autowired
    MaintenanceTireMapping maintenanceTireMapping;

    @Override
    public ResponseDto<MaintenanceTireListResponse> listMaintenanceTires() {
        ResponseDto<MaintenanceTireListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<MaintenanceTire> maintenanceTireList = maintenanceTireRepository.findAll();

            if (maintenanceTireList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_MAINTENANCETIRE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_MAINTENANCETIRE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(maintenanceTireList.size()));
            response.setDatos(new MaintenanceTireListResponse()
                    .maintenanceTireList(maintenanceTireMapping.modelList(maintenanceTireList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_MAINTENANCETIRE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<MaintenanceTireResponse> retrieveMaintenanceTire(Long id) {
        ResponseDto<MaintenanceTireResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<MaintenanceTire> maintenanceTireList = maintenanceTireRepository.findById(id);

            if (maintenanceTireList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_MAINTENANCETIRE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_MAINTENANCETIRE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new MaintenanceTireResponse()
                    .maintenanceTire(maintenanceTireMapping.modelDto(maintenanceTireList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_MAINTENANCETIRE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<MaintenanceTireResponse> registerMaintenanceTire(MaintenanceTireDto maintenanceTireDto) {
        ResponseDto<MaintenanceTireResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            MaintenanceTire maintenanceTire = maintenanceTireRepository
                    .save(maintenanceTireMapping.model(maintenanceTireDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_MAINTENANCETIRE_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new MaintenanceTireResponse()
                    .maintenanceTire(maintenanceTireMapping.modelDto(maintenanceTire)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_MAINTENANCETIRE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<MaintenanceTireResponse> updateMaintenanceTire(MaintenanceTireDto maintenanceTireDto) {
        ResponseDto<MaintenanceTireResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            MaintenanceTire maintenanceTireResponse = maintenanceTireRepository.findById(maintenanceTireDto.getId()).get();

            if (Objects.isNull(maintenanceTireResponse)) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_MAINTENANCETIRE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            maintenanceTireRepository.save(maintenanceTireMapping.model(maintenanceTireDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_MAINTENANCETIRE_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new MaintenanceTireResponse().maintenanceTire(maintenanceTireDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_MAINTENANCETIRE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<MaintenanceTireListResponse> listMaintenanceTiresByIdTruckFleet(Long id) {
        ResponseDto<MaintenanceTireListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<MaintenanceTire> maintenanceTireList = maintenanceTireRepository.findByIdTruckFleet(id);

            if (maintenanceTireList.isEmpty()) {
                response.meta(MetaDatosUtil
                        .buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_MAINTENANCETIRE_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_MAINTENANCETIRE_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(maintenanceTireList.size()));
            response.setDatos(new MaintenanceTireListResponse()
                    .maintenanceTireList(maintenanceTireMapping.modelList(maintenanceTireList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_MAINTENANCETIRE_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

}

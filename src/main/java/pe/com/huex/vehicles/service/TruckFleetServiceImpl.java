package pe.com.huex.vehicles.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.mapping.ProviderMapping;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.vehicles.domain.entities.TruckFleet;
import pe.com.huex.vehicles.domain.persistence.ITruckFleetRepository;
import pe.com.huex.vehicles.domain.service.ITruckFleetService;
import pe.com.huex.vehicles.mapping.TruckFleetMapping;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;
import pe.com.huex.vehicles.service.resources.response.TruckFleetListResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class TruckFleetServiceImpl implements ITruckFleetService {

    private static final String MESSAGE_INQUIRY_TRUCKFLEET_SUCCESS = "La consulta de camiones fue exitoso";
    private static final String MESSAGE_INQUIRY_TRUCKFLEET_WARN = "No se encontró ningún camión registrado";

    private static final String MESSAGE_REGISTER_TRUCKFLEET_SUCCESS = "El registro del camión fue exitoso";
    private static final String MESSAGE_REGISTER_TRUCKFLEET_WARN = "Ocurrió un error al registrar el camión";

    private static final String MESSAGE_UPDATE_TRUCKFLEET_SUCCESS = "La actualización de datos del camión fue exitoso";
    private static final String MESSAGE_UPDATE_TRUCKFLEET_WARN = "Ocurrió un error al actualizar los datos del camión";

    private static final String MESSAGE_RETRIEVE_TRUCKFLEET_SUCCESS = "La consulta del camión fue exitoso";
    private static final String MESSAGE_RETRIEVE_TRUCKFLEET_WARN = "No se encontró los datos del camión";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    ITruckFleetRepository truckFleetRepository;
    @Autowired
    TruckFleetMapping truckFleetMapping;

    @Autowired
    ProviderMapping providerMapping;

    @Override
    public ResponseDto<TruckFleetListResponse> listTruckFleets() {
        ResponseDto<TruckFleetListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<TruckFleet> truckFleetList = truckFleetRepository.findAll();

            if (truckFleetList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_TRUCKFLEET_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_TRUCKFLEET_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(truckFleetList.size()));
            response.setDatos(new TruckFleetListResponse().truckFleetList(truckFleetMapping.modelList(truckFleetList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_TRUCKFLEET_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TruckFleetResponse> retrieveTruckFleet(Long id) {
        ResponseDto<TruckFleetResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<TruckFleet> truckFleetList = truckFleetRepository.findById(id);

            if (truckFleetList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TRUCKFLEET_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_TRUCKFLEET_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));
            response.setDatos(
                    new TruckFleetResponse().truckFleet(truckFleetMapping.modelDto(truckFleetList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TRUCKFLEET_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TruckFleetResponse> registerTruckFleet(TruckFleetDto truckFleetDto) {
        ResponseDto<TruckFleetResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            TruckFleet truckFleet = truckFleetRepository.save(truckFleetMapping.model(truckFleetDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_TRUCKFLEET_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new TruckFleetResponse().truckFleet(truckFleetMapping.modelDto(truckFleet)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_TRUCKFLEET_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<TruckFleetResponse> updateTruckFleet(TruckFleetDto truckFleetDto) {
        ResponseDto<TruckFleetResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<TruckFleet> truckFleetList = truckFleetRepository.findById(truckFleetDto.getId());

            if (truckFleetList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TRUCKFLEET_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            TruckFleet truckFleet = truckFleetRepository.save(truckFleetMapping.model(truckFleetDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_TRUCKFLEET_SUCCESS, INFO, idTransaccion));
            response.setDatos(new TruckFleetResponse().truckFleet(truckFleetMapping.modelDto(truckFleet)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_TRUCKFLEET_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteTruckFleet(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

          truckFleetRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_TRUCKFLEET_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TRUCKFLEET_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

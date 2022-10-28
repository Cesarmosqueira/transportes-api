package pe.com.huex.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.TruckFleet;
import pe.com.huex.repositories.TruckFleetRepository;
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
public class TruckFleetService {

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
    TruckFleetRepository truckFleetRepository;

    public ResponseDto<TruckFleetListDto> listTruckFleets() {
        ResponseDto<TruckFleetListDto> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<TruckFleet> truckFleetList = truckFleetRepository.findAll();

            if (truckFleetList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_TRUCKFLEET_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_TRUCKFLEET_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(truckFleetList.size()));
            response.setDatos(new TruckFleetListDto().TruckFleetList(truckFleetList));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_TRUCKFLEET_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<TruckFleetRetrieveDto> retrieveTruckFleet(Long id) {
        ResponseDto<TruckFleetRetrieveDto> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<TruckFleet> truckFleetList = truckFleetRepository.findById(id);

            if (truckFleetList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TRUCKFLEET_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_TRUCKFLEET_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new TruckFleetRetrieveDto().truckFleet(truckFleetList.get()));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_TRUCKFLEET_WARN+ ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<TruckFleetRegisterDto> registerTruckFleet(TruckFleet truckFleet) {
        ResponseDto<TruckFleetRegisterDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            TruckFleet TruckFleetResponse = truckFleetRepository.save(truckFleet);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_TRUCKFLEET_SUCCESS, INFO, idTransaccion));
            response.setDatos(new TruckFleetRegisterDto().truckFleet(TruckFleetResponse));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_TRUCKFLEET_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<TruckFleetUpdateDto> updateTruckFleet(Long id, TruckFleet truckFleet) {
        ResponseDto<TruckFleetUpdateDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            TruckFleet truckFleetResponse = truckFleetRepository.findById(id).get();

            if (Objects.isNull(truckFleetResponse)) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_TRUCKFLEET_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            truckFleet.setId(id);
            truckFleetRepository.save(truckFleet);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_TRUCKFLEET_SUCCESS, INFO, idTransaccion));
            response.setDatos(new TruckFleetUpdateDto().truckFleet(truckFleet));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_TRUCKFLEET_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

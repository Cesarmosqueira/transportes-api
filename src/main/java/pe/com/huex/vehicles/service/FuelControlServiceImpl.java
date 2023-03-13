package pe.com.huex.vehicles.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.domain.entities.FuelControl;
import pe.com.huex.vehicles.domain.persistence.IFuelControlRepository;
import pe.com.huex.vehicles.domain.service.IFuelControlService;
import pe.com.huex.vehicles.mapping.FuelControlMapping;
import pe.com.huex.vehicles.service.resources.dto.FuelControlDto;
import pe.com.huex.vehicles.service.resources.response.FuelControlListResponse;
import pe.com.huex.vehicles.service.resources.response.FuelControlResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class FuelControlServiceImpl implements IFuelControlService {


    private static final String MESSAGE_INQUIRY_FUEL_CONTROL_SUCCESS = "La consulta de gasto combustible fue exitoso";
    private static final String MESSAGE_INQUIRY_FUEL_CONTROL_WARN = "No se encontró ningún gasto combustible registrado";

    private static final String MESSAGE_REGISTER_FUEL_CONTROL_SUCCESS = "El registro del gasto combustible fue exitoso";
    private static final String MESSAGE_REGISTER_FUEL_CONTROL_WARN = "Ocurrió un error al registrar el gasto combustible";

    private static final String MESSAGE_UPDATE_FUEL_CONTROL_SUCCESS = "La actualización de datos de gasto combustible fue exitoso";
    private static final String MESSAGE_UPDATE_FUEL_CONTROL_WARN = "Ocurrió un error al actualizar los datos de gasto combustible";

    private static final String MESSAGE_RETRIEVE_FUEL_CONTROL_SUCCESS = "La consulta de gasto combustible  fue exitoso";
    private static final String MESSAGE_RETRIEVE_FUEL_CONTROL_WARN = "No se encontró los datos del gasto combustible";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    private IFuelControlRepository fuelControlRepository;
    @Autowired
    private FuelControlMapping fuelControlMapping;


    @Override
    public ResponseDto<FuelControlListResponse> listFuelControl() {
        ResponseDto<FuelControlListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<FuelControl> fuelControlList = fuelControlRepository.listFuelControlDesc();

            if (fuelControlList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_FUEL_CONTROL_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_FUEL_CONTROL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(fuelControlList.size()));
            response.setDatos(new FuelControlListResponse().fuelControlList(fuelControlMapping.modelList(fuelControlList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_FUEL_CONTROL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }


    @Override
    public ResponseDto<FuelControlResponse> retrieveFuelControl(Long id) {

        ResponseDto<FuelControlResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<FuelControl> fuelControlList = fuelControlRepository.findById(id);

            if (fuelControlList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_FUEL_CONTROL_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_FUEL_CONTROL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));
            response.setDatos(
                    new FuelControlResponse().fuelControl(fuelControlMapping.modelDto(fuelControlList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_FUEL_CONTROL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<FuelControlResponse> registerFuelControl(FuelControlDto fuelControlDto) {

        ResponseDto<FuelControlResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            FuelControl fuelControl = fuelControlRepository.save(fuelControlMapping.model(fuelControlDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_FUEL_CONTROL_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new FuelControlResponse().fuelControl(fuelControlMapping.modelDto(fuelControl)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_FUEL_CONTROL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<FuelControlResponse> updateFuelControl(FuelControlDto fuelControlDto) {
        ResponseDto<FuelControlResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<FuelControl> fuelControlList = fuelControlRepository.findById(fuelControlDto.getId());

            if (fuelControlList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_FUEL_CONTROL_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            FuelControl fuelControl = fuelControlRepository.save(fuelControlMapping.model(fuelControlDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_FUEL_CONTROL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new FuelControlResponse().fuelControl(fuelControlMapping.modelDto(fuelControl)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_FUEL_CONTROL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteFuelControl(Long id) {

        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            fuelControlRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_FUEL_CONTROL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_FUEL_CONTROL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

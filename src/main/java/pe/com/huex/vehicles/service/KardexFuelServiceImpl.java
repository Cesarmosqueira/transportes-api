package pe.com.huex.vehicles.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.vehicles.domain.model.entity.KardexFuel;
import pe.com.huex.vehicles.domain.persistence.IKardexFuelRepository;
import pe.com.huex.vehicles.domain.service.IKardexFuelService;
import pe.com.huex.vehicles.mapping.KardexFuelMapping;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;
import pe.com.huex.vehicles.service.resources.response.KardexFuelListResponse;
import pe.com.huex.vehicles.service.resources.response.KardexFuelRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.KardexFuelRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.KardexFuelUpdateResponse;

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
public class KardexFuelServiceImpl implements IKardexFuelService {

    private static final String MESSAGE_INQUIRY_KARDEXFUEL_SUCCESS = "La consulta de kardex de combustible fue exitoso";
    private static final String MESSAGE_INQUIRY_KARDEXFUEL_WARN = "No se encontró ningún kardex de combustible registrado";

    private static final String MESSAGE_REGISTER_KARDEXFUEL_SUCCESS = "El registro del kardex de combustible fue exitoso";
    private static final String MESSAGE_REGISTER_KARDEXFUEL_WARN = "Ocurrió un error al registrar el kardex de combustible";

    private static final String MESSAGE_UPDATE_KARDEXFUEL_SUCCESS = "La actualización de datos del kardex de combustible fue exitoso";
    private static final String MESSAGE_UPDATE_KARDEXFUEL_WARN = "Ocurrió un error al actualizar los datos del kardex de combustible";

    private static final String MESSAGE_RETRIEVE_KARDEXFUEL_SUCCESS = "La consulta del kardex de combustible fue exitoso";
    private static final String MESSAGE_RETRIEVE_KARDEXFUEL_WARN = "No se encontró los datos del kardex de combustible";

    private static final String MESSAGE_DELETE_KARDEXFUEL_SUCCESS = "Se eliminó correctamente el registro combustible";
    private static final String MESSAGE_DELETE_KARDEXFUEL_WARN = "Ocurrió un error al eliminar el registro de combustible";
    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final IKardexFuelRepository kardexFuelRepository;

    private final KardexFuelMapping kardexFuelMapping;

    public KardexFuelServiceImpl(IKardexFuelRepository kardexFuelRepository, KardexFuelMapping kardexFuelMapping) {
        this.kardexFuelRepository = kardexFuelRepository;
        this.kardexFuelMapping = kardexFuelMapping;
    }

    @Override
    public ResponseDto<KardexFuelListResponse> listKardexFuels() {
        ResponseDto<KardexFuelListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<KardexFuel> kardexFuelList = kardexFuelRepository.findAll();

            if (kardexFuelList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_KARDEXFUEL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_KARDEXFUEL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(kardexFuelList.size()));
            response.setDatos(new KardexFuelListResponse().kardexFuelList(kardexFuelMapping.modelList(kardexFuelList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_KARDEXFUEL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<KardexFuelRetrieveResponse> retrieveKardexFuel(Long id) {
        ResponseDto<KardexFuelRetrieveResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<KardexFuel> kardexFuelList = kardexFuelRepository.findById(id);

            if (kardexFuelList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_KARDEXFUEL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_KARDEXFUEL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new KardexFuelRetrieveResponse().kardexFuel(kardexFuelMapping.modelDto(kardexFuelList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_KARDEXFUEL_WARN+ ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<KardexFuelRegisterResponse> registerKardexFuel(KardexFuelDto kardexFuelDto) {
        ResponseDto<KardexFuelRegisterResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            KardexFuel kardexFuel = kardexFuelRepository.save(kardexFuelMapping.model(kardexFuelDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_KARDEXFUEL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new KardexFuelRegisterResponse().kardexFuel(kardexFuelMapping.modelDto(kardexFuel)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_KARDEXFUEL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<KardexFuelUpdateResponse> updateKardexFuel(KardexFuelDto kardexFuelDto) {
        ResponseDto<KardexFuelUpdateResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            KardexFuel kardexFuel = kardexFuelRepository.findById(kardexFuelDto.getId()).get();

            if (Objects.isNull(kardexFuel)) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_KARDEXFUEL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            kardexFuelRepository.save( kardexFuelMapping.model(kardexFuelDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_KARDEXFUEL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new KardexFuelUpdateResponse().kardexFuel(kardexFuelDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_KARDEXFUEL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteKardexFuel(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            kardexFuelRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_KARDEXFUEL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_DELETE_KARDEXFUEL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<KardexFuelListResponse> listKardexFuelsByIdTruckFleet(Long id) {
        ResponseDto<KardexFuelListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<KardexFuel> kardexFuelList = kardexFuelRepository.findByIdTruckFleet(id);

            if (kardexFuelList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_KARDEXFUEL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_KARDEXFUEL_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(kardexFuelList.size()));
            response.setDatos(new KardexFuelListResponse().kardexFuelList(kardexFuelMapping.modelList(kardexFuelList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_KARDEXFUEL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

}

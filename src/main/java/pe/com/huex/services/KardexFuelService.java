package pe.com.huex.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.KardexFuel;
import pe.com.huex.repositories.KardexFuelRepository;
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
public class KardexFuelService {

    private static final String MESSAGE_INQUIRY_KARDEXFUEL_SUCCESS = "La consulta de kardex de combustible fue exitoso";
    private static final String MESSAGE_INQUIRY_KARDEXFUEL_WARN = "No se encontró ningún kardex de combustible registrado";

    private static final String MESSAGE_REGISTER_KARDEXFUEL_SUCCESS = "El registro del kardex de combustible fue exitoso";
    private static final String MESSAGE_REGISTER_KARDEXFUEL_WARN = "Ocurrió un error al registrar el kardex de combustible";

    private static final String MESSAGE_UPDATE_KARDEXFUEL_SUCCESS = "La actualización de datos del kardex de combustible fue exitoso";
    private static final String MESSAGE_UPDATE_KARDEXFUEL_WARN = "Ocurrió un error al actualizar los datos del kardex de combustible";

    private static final String MESSAGE_RETRIEVE_KARDEXFUEL_SUCCESS = "La consulta del kardex de combustible fue exitoso";
    private static final String MESSAGE_RETRIEVE_KARDEXFUEL_WARN = "No se encontró los datos del kardex de combustible";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    KardexFuelRepository kardexFuelRepository;

    public ResponseDto<KardexFuelListDto> listKardexFuels() {
        ResponseDto<KardexFuelListDto> response = new ResponseDto<>();
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
            response.setDatos(new KardexFuelListDto().kardexFuelList(kardexFuelList));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_KARDEXFUEL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<KardexFuelRetrieveDto> retrieveKardexFuel(Long id) {
        ResponseDto<KardexFuelRetrieveDto> response = new ResponseDto<>();
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
            response.setDatos(new KardexFuelRetrieveDto().kardexFuel(kardexFuelList.get()));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_KARDEXFUEL_WARN+ ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<KardexFuelRegisterDto> registerKardexFuel(KardexFuel kardexFuel) {
        ResponseDto<KardexFuelRegisterDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            KardexFuel KardexFuelResponse = kardexFuelRepository.save(kardexFuel);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_KARDEXFUEL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new KardexFuelRegisterDto().kardexFuel(KardexFuelResponse));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_KARDEXFUEL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<KardexFuelUpdateDto> updateKardexFuel(Long id, KardexFuel kardexFuel) {
        ResponseDto<KardexFuelUpdateDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            KardexFuel kardexFuelResponse = kardexFuelRepository.findById(id).get();

            if (Objects.isNull(kardexFuelResponse)) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_KARDEXFUEL_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            kardexFuel.setId(id);
            kardexFuelRepository.save(kardexFuel);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_KARDEXFUEL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new KardexFuelUpdateDto().kardexFuel(kardexFuel));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_KARDEXFUEL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

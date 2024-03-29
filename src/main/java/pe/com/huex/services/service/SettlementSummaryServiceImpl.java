package pe.com.huex.services.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.domain.entities.SettlementSummary;
import pe.com.huex.services.domain.persistence.SettlementSummaryRepository;
import pe.com.huex.services.domain.service.ISettlementSummaryService;
import pe.com.huex.services.mapping.SettlementSummaryMapping;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;
import pe.com.huex.services.service.resources.response.*;
import pe.com.huex.util.MetaDatosUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class SettlementSummaryServiceImpl implements ISettlementSummaryService {


    private static final String MESSAGE_INQUIRY_SETTLEMENT_SUMMARY_SUCCESS = "La consulta de Resumen de liquidacion fue exitoso";
    private static final String MESSAGE_INQUIRY_SETTLEMENT_SUMMARY_WARN = "No se encontró ningún Resumen de liquidacion registrado";

    private static final String MESSAGE_REGISTER_SETTLEMENT_SUMMARY_SUCCESS = "El registro del Resumen de liquidacion fue exitoso";
    private static final String MESSAGE_REGISTER_SETTLEMENT_SUMMARY_WARN = "Ocurrió un error al registrar el Resumen de liquidacion";

    private static final String MESSAGE_UPDATE_SETTLEMENT_SUMMARY_SUCCESS = "La actualización de datos del Resumen de liquidacion fue exitoso";
    private static final String MESSAGE_UPDATE_SETTLEMENT_SUMMARY_WARN = "Ocurrió un error al actualizar los datos del Resumen de liquidacion";

    private static final String MESSAGE_RETRIEVE_SETTLEMENT_SUMMARY_SUCCESS = "La consulta del Resumen de liquidacion fue exitoso";
    private static final String MESSAGE_RETRIEVE_SETTLEMENT_SUMMARY_WARN = "No se encontró los datos del Resumen de liquidacion";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";


    private final SettlementSummaryRepository settlementSummaryRepository;

    private final SettlementSummaryMapping settlementSummaryMapping;

    public SettlementSummaryServiceImpl(SettlementSummaryRepository settlementSummaryRepository, SettlementSummaryMapping settlementSummaryMapping) {
        this.settlementSummaryRepository = settlementSummaryRepository;
        this.settlementSummaryMapping = settlementSummaryMapping;
    }


    @Override
    public ResponseDto<SettlementSummaryListResponse> listSettlementSummary() {
        ResponseDto<SettlementSummaryListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<SettlementSummary> settlementSummaryList = settlementSummaryRepository.findAll();

            if (settlementSummaryList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_SETTLEMENT_SUMMARY_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_SETTLEMENT_SUMMARY_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(settlementSummaryList.size()));
            response.setDatos(new SettlementSummaryListResponse()
                    .settlementSummaryList(settlementSummaryMapping.modelList(settlementSummaryList)));

        } catch (Exception ex) {
            log.error("error al consultar resumen de liquidacion" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<SettlementSummaryResponse> retrieveSettlementSummary(Long id) {
        ResponseDto<SettlementSummaryResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<SettlementSummary> settlementSummaryList = settlementSummaryRepository.findById(id);

            if (settlementSummaryList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_SETTLEMENT_SUMMARY_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil
                    .buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_SETTLEMENT_SUMMARY_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new SettlementSummaryResponse()
                    .settlementSummary(settlementSummaryMapping.modelDto(settlementSummaryList.get())));

        } catch (Exception ex) {
            log.error("error al consultar resumen de liquidacion" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<SettlementSummaryResponse> registerSettlementSummary(SettlementSummaryDto settlementSummaryDto) {
        ResponseDto<SettlementSummaryResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            SettlementSummary settlementSummaryResponse = settlementSummaryRepository.save(settlementSummaryMapping.model(settlementSummaryDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_SETTLEMENT_SUMMARY_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new SettlementSummaryResponse()
                    .settlementSummary(settlementSummaryMapping.modelDto(settlementSummaryResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_SETTLEMENT_SUMMARY_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<SettlementSummaryResponse> updateSettlementSummary(SettlementSummaryDto settlementSummaryDto) {
        ResponseDto<SettlementSummaryResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<SettlementSummary> settlementSummaryResponse = settlementSummaryRepository.findById(settlementSummaryDto.getId());

            if (settlementSummaryResponse.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_SETTLEMENT_SUMMARY_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            settlementSummaryRepository.save(settlementSummaryMapping.model(settlementSummaryDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_SETTLEMENT_SUMMARY_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new SettlementSummaryResponse().settlementSummary(settlementSummaryDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_SETTLEMENT_SUMMARY_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteSettlementSummary(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            settlementSummaryRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_SETTLEMENT_SUMMARY_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_SETTLEMENT_SUMMARY_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<SettlementSummaryListResponse> listSettlementSummaryByIdTracking(Long id) {
        ResponseDto<SettlementSummaryListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<SettlementSummary> settlementSummaryList = settlementSummaryRepository.findByIdTracking(id);

            if (settlementSummaryList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_SETTLEMENT_SUMMARY_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_SETTLEMENT_SUMMARY_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(settlementSummaryList.size()));
            response.setDatos(new SettlementSummaryListResponse()
                    .settlementSummaryList(settlementSummaryMapping.modelList(settlementSummaryList)));

        } catch (Exception ex) {
            log.error("error al consultar resumen de liquidacion" + ex);
            throw ex;
        }

        return response;
    }
}

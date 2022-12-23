package pe.com.huex.providers.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.domain.model.entity.FuelSupply;
import pe.com.huex.providers.domain.persistence.FuelSupplyRepository;
import pe.com.huex.providers.domain.service.IFuelSupplyService;
import pe.com.huex.providers.mapping.FuelSupplyMapping;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;
import pe.com.huex.providers.service.resouces.response.*;
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
public class FuelSupplyImpl implements IFuelSupplyService {


    private static final String MESSAGE_INQUIRY_FUEL_SUPPLY_SUCCESS = "La consulta de abastecimiento combustible fue exitoso";
    private static final String MESSAGE_INQUIRY_FUEL_SUPPLY_WARN = "No se encontró ningún abastecimiento combustible registrado";

    private static final String MESSAGE_REGISTER_FUEL_SUPPLY_SUCCESS = "El registro de abastecimiento combustible fue exitoso";
    private static final String MESSAGE_REGISTER_FUEL_SUPPLY_WARN = "Ocurrió un error al registrar al abastecimiento combustible";

    private static final String MESSAGE_UPDATE_FUEL_SUPPLY_SUCCESS = "La actualización de datos del abastecimiento combustible fue exitoso";
    private static final String MESSAGE_UPDATE_FUEL_SUPPLY_WARN = "Ocurrió un error al actualizar los datos del abastecimiento combustible";

    private static final String MESSAGE_RETRIEVE_FUEL_SUPPLY_SUCCESS = "La consulta del abastecimiento combustible fue exitoso";
    private static final String MESSAGE_RETRIEVE_FUEL_SUPPLY_WARN = "No se encontró los datos del abastecimiento combustible";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";


    private final FuelSupplyRepository fuelSupplyRepository;
    private final FuelSupplyMapping fuelSupplyMapping;

    public FuelSupplyImpl(FuelSupplyRepository fuelSupplyRepository, FuelSupplyMapping fuelSupplyMapping) {
        this.fuelSupplyRepository = fuelSupplyRepository;
        this.fuelSupplyMapping = fuelSupplyMapping;
    }


    @Override
    public ResponseDto<FuelSupplyListResponse> listFuelSupply() {
        ResponseDto<FuelSupplyListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();
            List<FuelSupply> fuelSupplyList = fuelSupplyRepository.findAll();

            if (fuelSupplyList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_FUEL_SUPPLY_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_FUEL_SUPPLY_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(fuelSupplyList.size()));
            response.setDatos(new FuelSupplyListResponse().fuelSupplyListResponse(fuelSupplyMapping.modelList(fuelSupplyList)));

        } catch (Exception ex) {
            log.error("error al consultar Abastecimiento combustible" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<FuelSupplyResponse> retrieveFuelSupply(Long id) {
        ResponseDto<FuelSupplyResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<FuelSupply> fuelSupplyList = fuelSupplyRepository.findById(id);

            if (fuelSupplyList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_FUEL_SUPPLY_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_FUEL_SUPPLY_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new FuelSupplyResponse().fuelSupply(fuelSupplyMapping.modelDto(fuelSupplyList.get())));

        } catch (Exception ex) {
            log.error("error al consultar Abastecimiento combustible" + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<FuelSupplyResponse> registerFuelSupply(FuelSupplyDto fuelSupplyDto) {
        ResponseDto<FuelSupplyResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            FuelSupply fuelSupplyResponse = fuelSupplyRepository.save(fuelSupplyMapping.model(fuelSupplyDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_FUEL_SUPPLY_SUCCESS, INFO, idTransaccion));
            response.setDatos(new FuelSupplyResponse().fuelSupply(fuelSupplyMapping.modelDto(fuelSupplyResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_FUEL_SUPPLY_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<FuelSupplyResponse> updateFuelSupply(FuelSupplyDto fuelSupplyDto) {
        ResponseDto<FuelSupplyResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<FuelSupply> fuelSupplyResponse = fuelSupplyRepository.findById(fuelSupplyDto.getId());

            if (fuelSupplyResponse.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_FUEL_SUPPLY_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            fuelSupplyRepository.save(fuelSupplyMapping.model(fuelSupplyDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_FUEL_SUPPLY_SUCCESS, INFO, idTransaccion));
            response.setDatos(new FuelSupplyResponse().fuelSupply(fuelSupplyDto));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_FUEL_SUPPLY_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

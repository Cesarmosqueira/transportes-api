package pe.com.huex.vehicles.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;
import pe.com.huex.vehicles.service.resources.response.*;

public interface IKardexFuelService {

    ResponseDto<KardexFuelListResponse> listKardexFuels();

    ResponseDto<KardexFuelResponse> retrieveKardexFuel(Long id);

    ResponseDto<KardexFuelResponse> registerKardexFuel(KardexFuelDto kardexFuelDto);

    ResponseDto<KardexFuelResponse> updateKardexFuel(KardexFuelDto kardexFuelDto);

    ResponseDto deleteKardexFuel(Long id);

    ResponseDto<KardexFuelListResponse> listKardexFuelsByIdTruckFleet(Long id);

}

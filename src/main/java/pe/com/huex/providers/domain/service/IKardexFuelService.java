package pe.com.huex.providers.domain.service;

import pe.com.huex.providers.service.resouces.response.KardexFuelListResponse;
import pe.com.huex.providers.service.resouces.response.KardexFuelResponse;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.KardexFuelDto;

public interface IKardexFuelService {

    ResponseDto<KardexFuelListResponse> listKardexFuels();

    ResponseDto<KardexFuelResponse> retrieveKardexFuel(Long id);

    ResponseDto<KardexFuelResponse> registerKardexFuel(KardexFuelDto kardexFuelDto);

    ResponseDto<KardexFuelResponse> updateKardexFuel(KardexFuelDto kardexFuelDto);

    ResponseDto deleteKardexFuel(Long id);

    ResponseDto<KardexFuelListResponse> listKardexFuelsByIdTruckFleet(Long id);

}

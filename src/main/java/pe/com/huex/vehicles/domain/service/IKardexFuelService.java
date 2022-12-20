package pe.com.huex.vehicles.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;
import pe.com.huex.vehicles.service.resources.response.*;

public interface IKardexFuelService {

    ResponseDto<KardexFuelListResponse> listKardexFuels();

    ResponseDto<KardexFuelRetrieveResponse> retrieveKardexFuel(Long id);

    ResponseDto<KardexFuelRegisterResponse> registerKardexFuel(KardexFuelDto kardexFuelDto);

    ResponseDto<KardexFuelUpdateResponse> updateKardexFuel(KardexFuelDto kardexFuelDto);

    ResponseDto deleteKardexFuel(Long id);

    ResponseDto<KardexFuelListResponse> listKardexFuelsByIdTruckFleet(Long id);

}

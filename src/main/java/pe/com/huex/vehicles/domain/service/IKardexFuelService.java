package pe.com.huex.vehicles.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.KardexFuelDto;
import pe.com.huex.vehicles.service.resources.response.KardexFuelListResponse;
import pe.com.huex.vehicles.service.resources.response.KardexFuelRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.KardexFuelRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.KardexFuelUpdateResponse;

public interface IKardexFuelService {

    ResponseDto<KardexFuelListResponse> listKardexFuels();

    ResponseDto<KardexFuelRetrieveResponse> retrieveKardexFuel(Long id);

    ResponseDto<KardexFuelRegisterResponse> registerKardexFuel(KardexFuelDto kardexFuelDto);

    ResponseDto<KardexFuelUpdateResponse> updateKardexFuel(KardexFuelDto kardexFuelDto);

}

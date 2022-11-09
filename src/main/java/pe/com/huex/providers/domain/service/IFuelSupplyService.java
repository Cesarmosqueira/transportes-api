package pe.com.huex.providers.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;
import pe.com.huex.providers.service.resouces.response.*;

public interface IFuelSupplyService {

    ResponseDto<FuelSupplyListResponse> listFuelSupply();

    ResponseDto<FuelSupplyRetrieveResponse> retrieveFuelSupply(Long id);

    ResponseDto<FuelSupplyRegisterResponse> registerFuelSupply(FuelSupplyDto fuelSupplyDto);

    ResponseDto<FuelSupplyUpdateResponse> updateFuelSupply(FuelSupplyDto fuelSupplyDto);
}

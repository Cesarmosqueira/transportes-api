package pe.com.huex.providers.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.FuelSupplyDto;
import pe.com.huex.providers.service.resouces.response.*;

public interface IFuelSupplyService {

    ResponseDto<FuelSupplyListResponse> listFuelSupply();
    ResponseDto<FuelSupplyListResponse> lisFuelSupplyAvailable();
    ResponseDto<FuelSupplyResponse> retrieveFuelSupply(Long id);

    ResponseDto<FuelSupplyResponse> registerFuelSupply(FuelSupplyDto fuelSupplyDto);

    ResponseDto<FuelSupplyResponse> updateFuelSupply(FuelSupplyDto fuelSupplyDto);

    ResponseDto deleteFuelSupply(Long id);

}

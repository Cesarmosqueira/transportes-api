package pe.com.huex.vehicles.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.FuelControlDto;
import pe.com.huex.vehicles.service.resources.response.FuelControlListResponse;
import pe.com.huex.vehicles.service.resources.response.FuelControlResponse;

public interface IFuelControlService {

    ResponseDto<FuelControlListResponse> listFuelControl();

    ResponseDto<FuelControlResponse>retrieveFuelControl(Long id);

    ResponseDto<FuelControlResponse>registerFuelControl(FuelControlDto fuelControlDto);

    ResponseDto<FuelControlResponse>updateFuelControl(FuelControlDto fuelControlDto);

    ResponseDto deleteFuelControl(Long id);

}

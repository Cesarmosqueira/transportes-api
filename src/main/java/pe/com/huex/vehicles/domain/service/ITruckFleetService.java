package pe.com.huex.vehicles.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;
import pe.com.huex.vehicles.service.resources.response.TruckFleetListResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetUpdateResponse;

public interface ITruckFleetService {

    ResponseDto<TruckFleetListResponse> listTruckFleets();

    ResponseDto<TruckFleetRetrieveResponse> retrieveTruckFleet(Long id);

    ResponseDto<TruckFleetRegisterResponse> registerTruckFleet(TruckFleetDto truckFleetDto);

    ResponseDto<TruckFleetUpdateResponse> updateTruckFleet(TruckFleetDto truckFleetDto);

    ResponseDto deleteTruckFleet(Long id);

}

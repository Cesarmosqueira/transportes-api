package pe.com.huex.vehicles.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;
import pe.com.huex.vehicles.service.resources.response.TruckFleetListResponse;
import pe.com.huex.vehicles.service.resources.response.TruckFleetResponse;

public interface ITruckFleetService {

    ResponseDto<TruckFleetListResponse> listTruckFleets();

    ResponseDto<TruckFleetResponse> retrieveTruckFleet(Long id);

    ResponseDto<TruckFleetResponse> registerTruckFleet(TruckFleetDto truckFleetDto);

    ResponseDto<TruckFleetResponse> updateTruckFleet(TruckFleetDto truckFleetDto);

    ResponseDto deleteTruckFleet(Long id);

}

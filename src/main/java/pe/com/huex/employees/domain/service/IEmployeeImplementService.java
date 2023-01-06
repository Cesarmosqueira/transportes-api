package pe.com.huex.employees.domain.service;

import pe.com.huex.employees.services.resources.dtos.EmployeeImplementDto;
import pe.com.huex.employees.services.resources.response.EmployeeImplementListResponse;
import pe.com.huex.employees.services.resources.response.EmployeeImplementResponse;

import pe.com.huex.util.ResponseDto;
public interface IEmployeeImplementService {

    ResponseDto<EmployeeImplementListResponse> listEmployeeImplement();
    ResponseDto<EmployeeImplementResponse> retrieveEmployeeImplement(Long id);
    ResponseDto<EmployeeImplementResponse> registerEmployeeImplement(EmployeeImplementDto employeeImplementDto) ;
    ResponseDto<EmployeeImplementResponse> updateEmployeeImplement(EmployeeImplementDto employeeImplementDto) ;
    ResponseDto deleteEmployeeImplement(Long id);
}

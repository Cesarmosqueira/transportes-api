package pe.com.huex.employees.domain.service;

import pe.com.huex.employees.services.resources.dtos.EmployeeDto;
import pe.com.huex.employees.services.resources.response.EmployeeListResponse;
import pe.com.huex.employees.services.resources.response.EmployeeResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;

public interface IEmployeeService {
    ResponseDto<EmployeeListResponse> listEmployees();

    ResponseDto<EmployeeResponse> retrieveEmployee(Long id);

    ResponseDto<EmployeeResponse> registerEmployee(EmployeeDto employeeDto) throws IOException;

    ResponseDto<EmployeeResponse> updateEmployee(EmployeeDto employeeDto) throws IOException;

    ResponseDto deleteEmployee(Long id);
}

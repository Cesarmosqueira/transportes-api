package pe.com.huex.employees.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.employees.domain.service.IEmployeeImplementService;
import pe.com.huex.employees.services.resources.dtos.EmployeeImplementDto;
import pe.com.huex.employees.services.resources.response.EmployeeImplementListResponse;
import pe.com.huex.employees.services.resources.response.EmployeeImplementResponse;

import pe.com.huex.util.ResponseDto;

import java.io.IOException;

@RestController
@RequestMapping("employee_implements")
public class EmployeeImplementController {

    private final IEmployeeImplementService employeeImplementService;

    public EmployeeImplementController(IEmployeeImplementService employeeImplementService) {
        this.employeeImplementService = employeeImplementService;
    }

    @GetMapping
    public ResponseDto<EmployeeImplementListResponse> listEmployeeImplement() {
        return employeeImplementService.listEmployeeImplement();
    }

    @GetMapping("{id}")
    public ResponseDto<EmployeeImplementResponse> retrieveEmployeeImplement(@PathVariable Long id) {
        return employeeImplementService.retrieveEmployeeImplement(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<EmployeeImplementResponse> registerEmployeeImplement(@RequestBody EmployeeImplementDto employeeImplementDto)
            throws Exception {
        return employeeImplementService.registerEmployeeImplement(employeeImplementDto);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<EmployeeImplementResponse> updateEmployeeImplement(@RequestBody EmployeeImplementDto employeeImplementDto) throws IOException {
        return employeeImplementService.updateEmployeeImplement(employeeImplementDto);
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto deleteEmployeeImplement(@PathVariable Long id) {

        return employeeImplementService.deleteEmployeeImplement(id);
    }
}

package pe.com.huex.employees.domain.service;

import pe.com.huex.employees.services.resources.dtos.ImplementDto;
import pe.com.huex.employees.services.resources.response.ImplementListResponse;
import pe.com.huex.employees.services.resources.response.ImplementResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;

public interface IImplementService {
    ResponseDto<ImplementListResponse> listImplements();

    ResponseDto<ImplementResponse> retrieveImplement(Long id);

    ResponseDto<ImplementResponse> registerImplement(ImplementDto implementDto) throws IOException;

    ResponseDto<ImplementResponse> updateImplement(ImplementDto implementDto) throws IOException;

    ResponseDto deleteImplement(Long id);
}

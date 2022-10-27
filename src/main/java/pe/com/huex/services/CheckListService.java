package pe.com.huex.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.*;
import pe.com.huex.entities.CheckList;
import pe.com.huex.repositories.CheckListRepository;
import pe.com.huex.util.MetaDatosUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

@Transactional
@Service
@Slf4j
public class CheckListService {

    private static final String MESSAGE_INQUIRY_CHECKLIST_SUCCESS = "La consulta de check lists fue exitoso";
    private static final String MESSAGE_INQUIRY_CHECKLIST_WARN = "No se encontró ningún check list registrado";

    private static final String MESSAGE_REGISTER_CHECKLIST_SUCCESS = "El registro del check list fue exitoso";
    private static final String MESSAGE_REGISTER_CHECKLIST_WARN = "Ocurrió un error al registrar el check list";

    private static final String MESSAGE_UPDATE_CHECKLIST_SUCCESS = "La actualización de datos del check list fue exitoso";
    private static final String MESSAGE_UPDATE_CHECKLIST_WARN = "Ocurrió un error al actualizar los datos del check list";

    private static final String MESSAGE_RETRIEVE_CHECKLIST_SUCCESS = "La consulta del check list fue exitoso";
    private static final String MESSAGE_RETRIEVE_CHECKLIST_WARN = "No se encontró los datos del check list";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    CheckListRepository checkListRepository;

    public ResponseDto<CheckListListDto> listCheckLists() {
        ResponseDto<CheckListListDto> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<CheckList> checkListList = checkListRepository.findAll();

            if (checkListList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_CHECKLIST_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_CHECKLIST_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(checkListList.size()));
            response.setDatos(new CheckListListDto().checkList(checkListList));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<CheckListRetrieveDto> retrieveCheckList(Long id) {
        ResponseDto<CheckListRetrieveDto> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<CheckList> checkListList = checkListRepository.findById(id);

            if (checkListList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_CHECKLIST_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_CHECKLIST_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new CheckListRetrieveDto().checkList(checkListList.get()));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_CHECKLIST_WARN+ ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<CheckListRegisterDto> registerCheckList(MultipartFile file, String checkList) throws IOException {
        ResponseDto<CheckListRegisterDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            CheckList request = Try.of(() -> new ObjectMapper().readValue(checkList, CheckList.class))
                    .getOrNull();
            request.setPhoto(file.getBytes());
            request.setNamePhoto(file.getResource().getFilename());
            CheckList CheckListResponse = checkListRepository.save(request);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_CHECKLIST_SUCCESS, INFO, idTransaccion));
            response.setDatos(new CheckListRegisterDto().checkList(CheckListResponse));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<CheckListUpdateDto> updateCheckList(Long id, CheckList checkList) {
        ResponseDto<CheckListUpdateDto> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            CheckList checkListResponse = checkListRepository.findById(id).get();

            if (Objects.isNull(checkListResponse)) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_CHECKLIST_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            checkList.setId(id);
            checkListRepository.save(checkList);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_CHECKLIST_SUCCESS, INFO, idTransaccion));
            response.setDatos(new CheckListUpdateDto().checkList(checkList));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

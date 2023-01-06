package pe.com.huex.vehicles.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.vehicles.domain.entities.CheckList;
import pe.com.huex.vehicles.domain.persistence.ICheckListRepository;
import pe.com.huex.vehicles.domain.service.ICheckListService;
import pe.com.huex.vehicles.mapping.CheckListMapping;
import pe.com.huex.vehicles.service.resources.dto.CheckListDto;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;
import pe.com.huex.vehicles.service.resources.response.CheckListListResponse;
import pe.com.huex.vehicles.service.resources.response.CheckListResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Service
@Slf4j
public class CheckListServiceImpl implements ICheckListService {

    private static final String MESSAGE_INQUIRY_CHECKLIST_SUCCESS = "La consulta de check lists fue exitoso";
    private static final String MESSAGE_INQUIRY_CHECKLIST_WARN = "No se encontró ningún check list registrado";

    private static final String MESSAGE_REGISTER_CHECKLIST_SUCCESS = "El registro del check list fue exitoso";
    private static final String MESSAGE_REGISTER_CHECKLIST_WARN = "Ocurrió un error al registrar el check list";

    private static final String MESSAGE_UPDATE_CHECKLIST_SUCCESS = "La actualización de datos del check list fue exitoso";
    private static final String MESSAGE_UPDATE_CHECKLIST_WARN = "Ocurrió un error al actualizar los datos del check list";

    private static final String MESSAGE_RETRIEVE_CHECKLIST_SUCCESS = "La consulta del check list fue exitoso";
    private static final String MESSAGE_RETRIEVE_CHECKLIST_WARN = "No se encontró los datos del check list";

    private static final String MESSAGE_DELETE_CHECKLIST_SUCCESS = "Se eliminó correctamente el check list";

    private static final String MESSAGE_DELETE_CHECKLIST_WARN = "Ocurrió un error al eliminar el check list";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    ICheckListRepository checkListRepository;

    @Autowired
    CheckListMapping checkListMapping;


    @Override
    public ResponseDto<CheckListListResponse> listCheckLists() {
        ResponseDto<CheckListListResponse> response = new ResponseDto<>();
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
            response.setDatos(new CheckListListResponse().checkList(checkListMapping.modelList(checkListList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<CheckListResponse> retrieveCheckList(Long id) {
        ResponseDto<CheckListResponse> response = new ResponseDto<>();
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
            response.setDatos(new CheckListResponse().checkList(checkListMapping.modelDto(checkListList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<CheckListResponse> registerCheckList(CheckListDto checkListDto) throws IOException {
        ResponseDto<CheckListResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            CheckList checkListResponse = checkListRepository.save(checkListMapping.model(checkListDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_CHECKLIST_SUCCESS, INFO, idTransaccion));
            response.setDatos(new CheckListResponse().checkList(checkListMapping.modelDto(checkListResponse)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<CheckListResponse> updateCheckList(CheckListDto checkListDto) throws IOException {
        ResponseDto<CheckListResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<CheckList> checkListList = checkListRepository.findById(checkListDto.getId());

            if (checkListList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_CHECKLIST_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            CheckList checkListResponse = checkListRepository.save(checkListMapping.model(checkListDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_CHECKLIST_SUCCESS, INFO, idTransaccion));
            response.setDatos(new CheckListResponse().checkList(checkListMapping.modelDto(checkListResponse)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteCheckList(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            checkListRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_CHECKLIST_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_DELETE_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<CheckListListResponse> listCheckListsByIdTruckFleet(Long id) {
        ResponseDto<CheckListListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<CheckList> checkListList = checkListRepository.findByIdTruckFleet(id);

            if (checkListList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_CHECKLIST_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_CHECKLIST_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(checkListList.size()));
            response.setDatos(new CheckListListResponse().checkList(checkListMapping.modelList(checkListList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_CHECKLIST_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}
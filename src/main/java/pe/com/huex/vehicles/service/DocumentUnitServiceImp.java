package pe.com.huex.vehicles.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.vehicles.domain.model.entity.CheckList;
import pe.com.huex.vehicles.domain.model.entity.DocumentUnit;
import pe.com.huex.vehicles.domain.persistence.IDocumentUnitRepository;
import pe.com.huex.vehicles.domain.service.IDocumentUnitService;
import pe.com.huex.vehicles.mapping.DocumentUnitMapping;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitListResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitRegisterResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitRetrieveResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitUpdateResponse;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.dto.Response.MensajeServicio.TipoEnum.WARN;

@Service
@Slf4j
public class DocumentUnitServiceImp implements IDocumentUnitService {

    private static final String MESSAGE_INQUIRY_DOCUMENTUNIT_SUCCESS = "La consulta de documentos de la unidad fue exitoso";
    private static final String MESSAGE_INQUIRY_DOCUMENTUNIT_WARN = "No se encontró ningún documento de la unidad registrado";

    private static final String MESSAGE_REGISTER_DOCUMENTUNIT_SUCCESS = "El registro del documento de la unidad fue exitoso";
    private static final String MESSAGE_REGISTER_DOCUMENTUNIT_WARN = "Ocurrió un error al registrar el documento de la unidad";

    private static final String MESSAGE_UPDATE_DOCUMENTUNIT_SUCCESS = "La actualización de datos del documento de la unidad fue exitoso";
    private static final String MESSAGE_UPDATE_DOCUMENTUNIT_WARN = "Ocurrió un error al actualizar los datos del documento de la unidad";

    private static final String MESSAGE_RETRIEVE_DOCUMENTUNIT_SUCCESS = "La consulta del documento de la unidad fue exitoso";
    private static final String MESSAGE_RETRIEVE_DOCUMENTUNIT_WARN = "No se encontró los datos del documento de la unidad";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    IDocumentUnitRepository documentsUnitRepository;

    @Autowired
    DocumentUnitMapping documentUnitMapping;

    public ResponseDto<DocumentUnitListResponse> listDocumentUnits() {
        ResponseDto<DocumentUnitListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<DocumentUnit> documentUnitList = documentsUnitRepository.findAll();

            if (documentUnitList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_DOCUMENTUNIT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_DOCUMENTUNIT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(documentUnitList.size()));
            response.setDatos(new DocumentUnitListResponse().documentUnitList(documentUnitMapping.modelList(documentUnitList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_DOCUMENTUNIT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<DocumentUnitRetrieveResponse> retrieveDocumentUnit(Long id) {
        ResponseDto<DocumentUnitRetrieveResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<DocumentUnit> documentUnitList = documentsUnitRepository.findById(id);

            if (documentUnitList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_DOCUMENTUNIT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_DOCUMENTUNIT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(1));
            response.setDatos(new DocumentUnitRetrieveResponse().documentUnit(documentUnitMapping.modelDto(documentUnitList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_DOCUMENTUNIT_WARN+ ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<DocumentUnitRegisterResponse> registerDocumentUnit(MultipartFile photoTechnicalReview,
                                                                          MultipartFile photoSoat,
                                                                          MultipartFile photoMtc,
                                                                          MultipartFile photoPolicy,
                                                                          String documentUnitDto) throws IOException {
        ResponseDto<DocumentUnitRegisterResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            DocumentUnit request = Try.of(() -> new ObjectMapper().readValue(documentUnitDto, DocumentUnit.class))
                    .getOrNull();

            request.setNamePhotoTechnicalReview(photoTechnicalReview.getResource().getFilename());
            request.setPhotoTechnicalReview(photoTechnicalReview.getBytes());
            request.setNamePhotoSoat(photoSoat.getResource().getFilename());
            request.setPhotoSoat(photoSoat.getBytes());
            request.setNamePhotoMtc(photoMtc.getResource().getFilename());
            request.setPhotoMtc(photoMtc.getBytes());
            request.setNamePhotoPolicy(photoPolicy.getResource().getFilename());
            request.setPhotoPolicy(photoPolicy.getBytes());
            DocumentUnit documentUnit = documentsUnitRepository.save(request);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_DOCUMENTUNIT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new DocumentUnitRegisterResponse().documentUnit(documentUnitMapping.modelDto(documentUnit)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_DOCUMENTUNIT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<DocumentUnitUpdateResponse> updateDocumentUnit(MultipartFile photoTechnicalReview,
                                                                      MultipartFile photoSoat,
                                                                      MultipartFile photoMtc,
                                                                      MultipartFile photoPolicy,
                                                                      String documentUnitDto) throws IOException {
        ResponseDto<DocumentUnitUpdateResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            DocumentUnit request = Try.of(() -> new ObjectMapper().readValue(documentUnitDto, DocumentUnit.class))
                    .getOrNull();

            Optional<DocumentUnit> documentUnit = documentsUnitRepository.findById(request.getId());

            if (documentUnit.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_DOCUMENTUNIT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            request.setNamePhotoTechnicalReview(photoTechnicalReview.getResource().getFilename());
            request.setPhotoTechnicalReview(photoTechnicalReview.getBytes());
            request.setNamePhotoSoat(photoSoat.getResource().getFilename());
            request.setPhotoSoat(photoSoat.getBytes());
            request.setNamePhotoMtc(photoMtc.getResource().getFilename());
            request.setPhotoMtc(photoMtc.getBytes());
            request.setNamePhotoPolicy(photoPolicy.getResource().getFilename());
            request.setPhotoPolicy(photoPolicy.getBytes());
            DocumentUnit documentUnitSave = documentsUnitRepository.save(request);
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_DOCUMENTUNIT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new DocumentUnitUpdateResponse().documentUnit(documentUnitMapping.modelDto(documentUnitSave)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_DOCUMENTUNIT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}
package pe.com.huex.vehicles.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.vehicles.domain.entities.DocumentUnit;
import pe.com.huex.vehicles.domain.persistence.IDocumentUnitRepository;
import pe.com.huex.vehicles.domain.service.IDocumentUnitService;
import pe.com.huex.vehicles.mapping.DocumentUnitMapping;
import pe.com.huex.vehicles.service.resources.dto.DocumentUnitDto;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitListResponse;
import pe.com.huex.vehicles.service.resources.response.DocumentUnitResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

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

    private static final String MESSAGE_DELETE_DOCUMENTUNIT_SUCCESS = "Se eliminó correctamente el documento";
    private static final String MESSAGE_DELETE_DOCUMENTUNIT_WARN = "Ocurrió un error al eliminar el documento";

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

    public ResponseDto<DocumentUnitListResponse> listDocumentUnitsByIdTruckFleet(Long id){
        ResponseDto<DocumentUnitListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<DocumentUnit> documentUnitList = documentsUnitRepository.findByIdTruckFleet(id);

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
    public ResponseDto<DocumentUnitResponse> retrieveDocumentUnit(Long id) {
        ResponseDto<DocumentUnitResponse> response = new ResponseDto<>();
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
            response.setDatos(new DocumentUnitResponse().documentUnit(documentUnitMapping.modelDto(documentUnitList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_DOCUMENTUNIT_WARN+ ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<DocumentUnitResponse> registerDocumentUnit(DocumentUnitDto documentUnitDto) throws IOException {
        ResponseDto<DocumentUnitResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            DocumentUnit documentUnit = documentsUnitRepository.save(documentUnitMapping.model(documentUnitDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_DOCUMENTUNIT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new DocumentUnitResponse().documentUnit(documentUnitMapping.modelDto(documentUnit)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_DOCUMENTUNIT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<DocumentUnitResponse> updateDocumentUnit(DocumentUnitDto documentUnitDto) throws IOException {
        ResponseDto<DocumentUnitResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<DocumentUnit> documentUnit = documentsUnitRepository.findById(documentUnitDto.getId());

            if (documentUnit.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_DOCUMENTUNIT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            DocumentUnit documentUnitSave = documentsUnitRepository.save(documentUnitMapping.model(documentUnitDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_DOCUMENTUNIT_SUCCESS, INFO, idTransaccion));
            response.setDatos(new DocumentUnitResponse().documentUnit(documentUnitMapping.modelDto(documentUnitSave)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_DOCUMENTUNIT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteDocumentUnit(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            documentsUnitRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_DELETE_DOCUMENTUNIT_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_DELETE_DOCUMENTUNIT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    public ResponseDto<DocumentUnitListResponse> listDocumentUnitsExpiration() {
        ResponseDto<DocumentUnitListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<DocumentUnit> documentUnitList = documentsUnitRepository.findAll();

            if (documentUnitList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_DOCUMENTUNIT_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            List<DocumentUnit> documentUnitListExpiration = new ArrayList<>();

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            Date actualDate = cal.getTime();

            documentUnitList.forEach(doc -> {
                DocumentUnit documentUnit = new DocumentUnit();
                documentUnit.setTruckFleet(doc.getTruckFleet());
                boolean register = false;
                if(doc.getExpirationPolicy().before(actualDate)){
                    documentUnit.setExpirationPolicy(doc.getExpirationPolicy());
                    register = true;
                }

                if(doc.getFireExtinguisherExpiration().before(actualDate)){
                    documentUnit.setFireExtinguisherExpiration(doc.getFireExtinguisherExpiration());
                    register = true;
                }

                if(doc.getFirstAidKitExpiration().before(actualDate)){
                    documentUnit.setFirstAidKitExpiration(doc.getFirstAidKitExpiration());
                    register = true;
                }

                if(doc.getMtcExpiration().before(actualDate)){
                    documentUnit.setMtcExpiration(doc.getMtcExpiration());
                    register = true;
                }

                if(doc.getSoatExpiration().before(actualDate)){
                    documentUnit.setSoatExpiration(doc.getSoatExpiration());
                    register = true;
                }

                if(doc.getTechnicalReviewExpiration().before(actualDate)){
                    documentUnit.setTechnicalReviewExpiration(doc.getTechnicalReviewExpiration());
                    register = true;
                }

                if(register){
                    documentUnitListExpiration.add(documentUnit);
                }
            } );

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_DOCUMENTUNIT_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(documentUnitList.size()));
            response.setDatos(new DocumentUnitListResponse().documentUnitList(documentUnitMapping.modelList(documentUnitListExpiration)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_DOCUMENTUNIT_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}
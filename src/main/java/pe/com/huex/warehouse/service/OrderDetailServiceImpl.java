package pe.com.huex.warehouse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.warehouse.domain.model.entity.InvoicedProduct;
import pe.com.huex.warehouse.domain.model.entity.OrderDetail;
import pe.com.huex.warehouse.domain.persistence.IOrderDetailRepository;
import pe.com.huex.warehouse.domain.service.IOrderDetailService;
import pe.com.huex.warehouse.mapping.OrderDetailMapping;
import pe.com.huex.warehouse.service.resources.dto.OrderDetailDto;
import pe.com.huex.warehouse.service.resources.response.InvoicedProductListResponse;
import pe.com.huex.warehouse.service.resources.response.InvoicedProductResponse;
import pe.com.huex.warehouse.service.resources.response.OrderDetailListResponse;
import pe.com.huex.warehouse.service.resources.response.OrderDetailResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;


@Transactional
@Service
@Slf4j
public class OrderDetailServiceImpl implements IOrderDetailService {

    private static final String MESSAGE_INQUIRY_ORDER_DETAIL_SUCCESS = "La consulta del detalle de la orden fue exitoso";
    private static final String MESSAGE_INQUIRY_ORDER_DETAIL_WARN = "No se encontró ningún orden registrado";

    private static final String MESSAGE_REGISTER_ORDER_DETAIL_SUCCESS = "El registro de la orden fue exitoso";
    private static final String MESSAGE_REGISTER_ORDER_DETAIL_WARN = "Ocurrió un error al registrar el detalle de la orden";

    private static final String MESSAGE_UPDATE_ORDER_DETAIL_SUCCESS = "La actualización de datos del detalle de la orden fue exitoso";
    private static final String MESSAGE_UPDATE_ORDER_DETAIL_WARN = "Ocurrió un error al actualizar el detalle de la orden ";

    private static final String MESSAGE_RETRIEVE_ORDER_DETAIL_SUCCESS = "La consulta del detalle de la orden fue exitoso";
    private static final String MESSAGE_RETRIEVE_ORDER_DETAIL_WARN = "No se encontró los datos del detalle de la orden";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    private final IOrderDetailRepository orderDetailRepository;

    private final OrderDetailMapping orderDetailMapping;

    public OrderDetailServiceImpl(IOrderDetailRepository orderDetailRepository, OrderDetailMapping orderDetailMapping) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailMapping = orderDetailMapping;
    }


    @Override
    public ResponseDto<OrderDetailListResponse> listOrderDetail() {
        ResponseDto<OrderDetailListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<OrderDetail> orderDetailList = orderDetailRepository.findAll();

            if (orderDetailList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_ORDER_DETAIL_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_ORDER_DETAIL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(orderDetailList.size()));
            response.setDatos(new OrderDetailListResponse().orderDetail(orderDetailMapping.modelList(orderDetailList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_ORDER_DETAIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<OrderDetailResponse> retrieveOrderDetail(Long id) {
        ResponseDto<OrderDetailResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<OrderDetail> orderDetailList = orderDetailRepository.findById(id);

            if (orderDetailList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_ORDER_DETAIL_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_ORDER_DETAIL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));
            response.setDatos(
                    new OrderDetailResponse().orderDetail(orderDetailMapping.modelDto(orderDetailList.get())));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_ORDER_DETAIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<OrderDetailResponse> registerOrderDetail(OrderDetailDto orderDetailDto) {
        ResponseDto<OrderDetailResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();
            OrderDetail orderDetail = orderDetailRepository.save(orderDetailMapping.model(orderDetailDto));
            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_REGISTER_ORDER_DETAIL_SUCCESS, INFO,
                    idTransaccion));
            response.setDatos(new OrderDetailResponse().orderDetail(orderDetailMapping.modelDto(orderDetail)));
        } catch (Exception ex) {
            log.error(MESSAGE_REGISTER_ORDER_DETAIL_WARN
                    + ": " + ex);
            throw ex;
        }
        return response;
    }

    @Override
    public ResponseDto<OrderDetailResponse> updateOrderDetail(OrderDetailDto orderDetailDto) {
        ResponseDto<OrderDetailResponse> response = new ResponseDto<>();

        try {
            String idTransaccion = UUID.randomUUID().toString();

            Optional<OrderDetail> orderDetailList = orderDetailRepository.findById(orderDetailDto.getId());

            if (orderDetailList.isEmpty()) {
                response.meta(
                        MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_RETRIEVE_ORDER_DETAIL_WARN, WARN, idTransaccion)
                                .totalRegistros(0));
                return response;
            }

            OrderDetail orderDetail = orderDetailRepository.save(orderDetailMapping.model(orderDetailDto));
            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_UPDATE_ORDER_DETAIL_SUCCESS, INFO, idTransaccion));
            response.setDatos(new OrderDetailResponse().orderDetail(orderDetailMapping.modelDto(orderDetail)));

        } catch (Exception ex) {
            log.error(MESSAGE_UPDATE_ORDER_DETAIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto deleteOrderDetail(Long id) {
        ResponseDto response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            orderDetailRepository.deleteById(id);

            response.meta(
                    MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_RETRIEVE_ORDER_DETAIL_SUCCESS, INFO, idTransaccion)
                            .totalRegistros(1));

        } catch (Exception ex) {
            log.error(MESSAGE_RETRIEVE_ORDER_DETAIL_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}

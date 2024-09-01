package app.vercel.mohammedelyousfi.payment_service.presistance.mapper;


import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentRequest;
import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentResponse;
import app.vercel.mohammedelyousfi.payment_service.presistance.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    @Mapping(source = "bookingResponse.id" , target = "bookingId")
    Payment toPayment(PaymentRequest paymentRequest);



    PaymentResponse toPaymentResponse(Payment payment);

    List<PaymentResponse> toPaymentResponseList(List<Payment> payments);

    List<Payment> toPaymentList(List<PaymentRequest> paymentRequests);
}

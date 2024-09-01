package app.vercel.mohammedelyousfi.payment_service.domain.service;


import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentRequest;
import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentResponse;

public interface PaymentService {
    Long createPayment(PaymentRequest paymentRequest);
}

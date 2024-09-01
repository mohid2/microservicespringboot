package app.vercel.mohammedelyousfi.payment_service.domain.repository;

import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentRequest;
import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentResponse;

public interface PaymentRepository {

    PaymentResponse savePayment(PaymentRequest paymentRequest);
}

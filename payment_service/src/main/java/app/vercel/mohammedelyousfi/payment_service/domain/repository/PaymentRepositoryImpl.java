package app.vercel.mohammedelyousfi.payment_service.domain.repository;

import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentRequest;
import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentResponse;
import app.vercel.mohammedelyousfi.payment_service.presistance.mapper.PaymentMapper;
import app.vercel.mohammedelyousfi.payment_service.presistance.repository.PaymentMySQLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentMySQLRepository paymentMySQLRepository;
    private final PaymentMapper paymentMapper;


    @Override
    public PaymentResponse savePayment(PaymentRequest paymentRequest) {
        return paymentMapper.toPaymentResponse(paymentMySQLRepository.save(paymentMapper.toPayment(paymentRequest)));
    }
}

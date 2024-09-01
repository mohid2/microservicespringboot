package app.vercel.mohammedelyousfi.payment_service.domain.service;

import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentNotification;
import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentRequest;
import app.vercel.mohammedelyousfi.payment_service.domain.model.PaymentResponse;
import app.vercel.mohammedelyousfi.payment_service.domain.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, PaymentNotification> kafkaTemplate;

    @Override
    public Long createPayment(PaymentRequest paymentRequest) {
        log.info("Payment request received: {}", paymentRequest);
       Long paymentId = paymentRepository.savePayment(paymentRequest).getId();
        // Enviar notificación
        Message<PaymentNotification> message = MessageBuilder.withPayload(PaymentNotification.builder()
                        .paymentRequest(paymentRequest)
                        .message("Payment received successfully")
                        .build())
                .setHeader(KafkaHeaders.TOPIC,"payment-topic")
                .build();
        kafkaTemplate.send(message );
        return paymentId;
    }
}

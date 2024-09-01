package app.vercel.mohammedelyousfi.booking_service.client;

import app.vercel.mohammedelyousfi.booking_service.client.model.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentClient {

    @PostMapping("/api/v1/payments")
     Long requestPayment(@RequestBody PaymentRequest request);
}

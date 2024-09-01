package app.vercel.mohammedelyousfi.payment_service.presistance.repository;

import app.vercel.mohammedelyousfi.payment_service.presistance.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMySQLRepository extends JpaRepository<Payment, Long> {

}

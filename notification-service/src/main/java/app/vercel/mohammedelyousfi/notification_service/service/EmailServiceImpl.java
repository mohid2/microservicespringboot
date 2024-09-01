package app.vercel.mohammedelyousfi.notification_service.service;

import app.vercel.mohammedelyousfi.notification_service.model.BookingNotification;
import app.vercel.mohammedelyousfi.notification_service.model.UserNotification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements IEmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private final ObjectMapper objectMapper;



    private String getTemplateEmail(Object notification) throws IOException {
        Context context = new Context();

        // Decidir qué plantilla utilizar según el tipo de notificación
        String templateName;
        if (notification instanceof UserNotification) {
            UserNotification userNotification = (UserNotification) notification;
            context.setVariable("userNotification", userNotification);
            templateName = "user-notification-email";
        } else if (notification instanceof BookingNotification) {
            BookingNotification bookingNotification = (BookingNotification) notification;
            context.setVariable("bookingNotification", bookingNotification);
            templateName = "booking-notification-email";
        } else {
            throw new IllegalArgumentException("Unsupported notification type");
        }

        return templateEngine.process(templateName, context);
    }


    @Override
    @KafkaListener( topics = "user-created")
    public void sendEmailUserNotification(String message) throws JsonProcessingException {
        log.info("Enviando correo: {}", message);
        UserNotification userNotification = objectMapper.readValue(message, UserNotification.class);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());
            helper.setTo(userNotification.getUserResponse().getEmail());
            helper.setSubject(userNotification.getMessage());
            String templateEmailHtml = getTemplateEmail(userNotification);
            helper.setText(templateEmailHtml, true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
    @Override
    @KafkaListener( topics = "booking-created")
    public void sendEmailBookingNotification(String message) throws JsonProcessingException {
        log.info("Enviando correo: {}", message);
        BookingNotification bookingNotification = objectMapper.readValue(message, BookingNotification.class);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());
            helper.setTo(bookingNotification.getBookingResponse().getUser().getEmail());
            helper.setSubject(bookingNotification.getMessage());
            String templateEmailHtml = getTemplateEmail(bookingNotification);
            helper.setText(templateEmailHtml, true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
}

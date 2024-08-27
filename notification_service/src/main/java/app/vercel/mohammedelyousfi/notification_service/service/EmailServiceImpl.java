package app.vercel.mohammedelyousfi.notification_service.service;

import app.vercel.mohammedelyousfi.notification_service.model.UserNotification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
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



    private String getTemplateEmail(UserNotification userNotification) throws IOException {
        Context context = new Context();
        context.setVariable("userNotification", userNotification);
        return templateEngine.process("email", context);
    }

    @Override
    @KafkaListener( topics = "user-created")
    public void sendEmail(String message) throws JsonProcessingException {
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

}

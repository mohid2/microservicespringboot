package app.vercel.mohammedelyousfi.notification_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    private final String email="";

    private final String password="";

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Ejemplo: smtp.gmail.com
        properties.put("mail.smtp.port", "587"); // Ejemplo: 587
        return properties;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(getMailProperties());
        mailSender.setUsername(email);
        mailSender.setPassword(password);
        try {
            // Test connection to ensure settings are correct
            mailSender.testConnection();
        } catch (Exception e) {
            // Log and handle connection issues
            System.err.println("Error al probar la conexión del servidor de correo: " + e.getMessage());
        }
        return mailSender;
    }

}

package app.vercel.mohammedelyousfi.notification_service.service;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface IEmailService {

    void sendEmail( String message) throws JsonProcessingException;
}

package app.vercel.mohammedelyousfi.notification_service.service;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface IEmailService {

    void sendEmailUserNotification( String message) throws JsonProcessingException;
    void sendEmailBookingNotification(String message) throws JsonProcessingException;
}

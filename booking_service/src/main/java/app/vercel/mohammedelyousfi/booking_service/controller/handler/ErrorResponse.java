package app.vercel.mohammedelyousfi.booking_service.controller.handler;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {}

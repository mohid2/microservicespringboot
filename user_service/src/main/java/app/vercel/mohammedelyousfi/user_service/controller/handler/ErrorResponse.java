package app.vercel.mohammedelyousfi.user_service.controller.handler;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {}

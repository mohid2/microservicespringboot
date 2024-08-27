package app.vercel.mohammedelyousfi.user_service.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransmissionType {
    MANUAL("Manual Transmission"),
    AUTOMATIC("Automatic Transmission"),
    CVT("Continuously Variable Transmission (CVT)"),
    SEMI_AUTOMATIC("Semi-Automatic Transmission");

    private final String description;
}
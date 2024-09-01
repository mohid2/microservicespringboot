package app.vercel.mohammedelyousfi.notification_service.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SteeringType {
    HYDRAULIC("Hydraulic"),
    ELECTROHYDRAULIC("Electrohydraulic"),
    ELECTRIC("Electric");

    private final String displayName;
}
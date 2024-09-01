package app.vercel.mohammedelyousfi.payment_service.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    SPORT("Sport"),
    LUXURY("Luxury"),
    SUPERCAR("Supercar"),
    HYPERCAR("Hypercar"),
    LUXURY_SUV("Luxury Suv"),
    CLASSIC_CAR("Classic Car"),
    LIMOUSINE("Limousine"),
    CUSTOM_CAR("Custom Car"),
    COLLECTORS_CAR("Collectors Car"),
    LUXURY_ARMORED("Luxury Armored"),
    TRUCK("Truck");

    private final String category;
}
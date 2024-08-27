package app.vercel.mohammedelyousfi.car_service.domain.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException() {
    }
}

package app.vercel.mohammedelyousfi.booking_service.domain.exception;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(String message) {
        super(message);
    }

    public BookingNotFoundException() {
    }
}

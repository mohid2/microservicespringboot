package app.vercel.mohammedelyousfi.booking_service.presistance.mapper;


import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingRequest;
import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingResponse;
import app.vercel.mohammedelyousfi.booking_service.presistance.entity.Booking;
import org.mapstruct.Mapper;


import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {


    @Mapping(target = "id",ignore = true)
    @Mapping(target = "car", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "carId", source = "carId")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "pickupDate", source = "pickupDate")
    @Mapping(target = "returnDate", source = "returnDate")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    Booking toBooking(BookingRequest bookingRequest);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "carId", source = "carId")
    @Mapping(target = "pickupDate", source = "pickupDate")
    @Mapping(target = "returnDate", source = "returnDate")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    @Mapping(target = "totalBookingDuration", expression = "java(booking.getReturnDate().toEpochDay() - booking.getPickupDate().toEpochDay())")
    @Mapping(target = "userId", source = "userId")
    BookingResponse toBookingResponse(Booking booking);

    List<BookingResponse> toBookingResponses(List<Booking> bookings);

    List<Booking> toBookingList(List<BookingRequest> bookingRequests);

}

package app.vercel.mohammedelyousfi.booking_service.presistance.mapper;


import app.vercel.mohammedelyousfi.booking_service.domain.dto.BookingDTO;
import app.vercel.mohammedelyousfi.booking_service.presistance.entity.Booking;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {


    @Mapping(source = "car.chassisSerialNumber", target = "carId")
    @Mapping(source = "user.id", target = "userId")
    Booking toBooking(BookingDTO bookingDTO);

    BookingDTO toBookingDTO(Booking booking);

    List<BookingDTO> toBookingDTOList(List<Booking> bookings);

    List<Booking> toBookingList(List<BookingDTO> bookingDTOS);

}

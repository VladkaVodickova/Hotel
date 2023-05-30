package engeto.java.lesson2;

import java.math.BigDecimal;
import java.util.List;

public class BookingList_Main {
    public static void main(String[] args) {
        Guest guestId1 = new Guest("Adéla","Malíková", "13.3.1993");
        Guest guestId2 = new Guest("Jana", "Dvořáčková", "5.5.1995");

        HotelRoom room1 = new HotelRoom(1,1,true, true, new BigDecimal("1000"));
        HotelRoom room2 = new HotelRoom(2, 1, true,true, new BigDecimal("1000"));
        HotelRoom room3 = new HotelRoom(3,3,false,true, new BigDecimal("2400"));

        BookingOfRoom bookingId1 = new BookingOfRoom(1,"19.7.2021", "26.7.2021", List.of(room1), List.of(guestId1));
        BookingOfRoom bookingId2 = new BookingOfRoom(2,"1.9.2021","14.9.2021", List.of(room3), List.of(guestId1,guestId2));

        System.out.println(bookingId1.getDescription()+bookingId2.getDescription());
    }
}

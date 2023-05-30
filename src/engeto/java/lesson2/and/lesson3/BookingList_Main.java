package engeto.java.lesson2.and.lesson3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingList_Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        BookingManager bookingManager = new BookingManager();

        Guest guestId1 = new Guest("Adéla","Malíková", "13.3.1993");
        Guest guestId2 = new Guest("Jana", "Dvořáčková", "5.5.1995");
        Guest guestId3 = new Guest("Karel", "Dvořák","15.5.1990");
        Guest guestId4 = new Guest("Karel", "Dvořák", "3.1.1979");
        Guest guestId5 = new Guest("Cestovní kancelář ABC");
        Guest guestId6 = new Guest("Alena", "Krásová", "1.1.1991");

        HotelRoom room1 = new HotelRoom(1,1,true, true, new BigDecimal("1000"));
        HotelRoom room2 = new HotelRoom(2, 1, true,true, new BigDecimal("1000"));
        HotelRoom room3 = new HotelRoom(3,3,false,true, new BigDecimal("2400"));

        Booking bookingId1 = new Booking("19.7.2021", "26.7.2021", List.of(room1), List.of(guestId1));
        Booking bookingId2 = new Booking("1.9.2021","14.9.2021", List.of(room3), List.of(guestId1,guestId2));
        Booking bookingId3 = new Booking("1.6.2023","7.6.2023", Booking.TypeOfVacation.WORKING,List.of(room3),List.of(guestId3));
        Booking bookingId4 = new Booking("18.8.2023","21.8.2023", Booking.TypeOfVacation.RECREATIONAL,List.of(room2),List.of(guestId4));
        bookingManager.add(List.of(bookingId1,bookingId2,bookingId3,bookingId4));

        LocalDate ABCreservationDates = LocalDate.of(2023,6,1);;

        for (int i = 0; i<30;i++){
            Booking newBooking = new Booking(ABCreservationDates.format(formatter),ABCreservationDates.plusDays(1).format(formatter),List.of(room2),List.of(guestId5));
            bookingManager.add(newBooking);

            ABCreservationDates = ABCreservationDates.plusDays(1);
        }


        LocalDate AKrasovaReservationDates = LocalDate.of(2023,6,1);
        ABCreservationDates = LocalDate.of(2023,8,1);

        for (int i = 0; i<7;i++){
            Booking newBookingAK = new Booking(AKrasovaReservationDates.format(formatter), AKrasovaReservationDates.plusDays(4).format(formatter),List.of(room1),List.of(guestId6));
            bookingManager.add(newBookingAK);
            AKrasovaReservationDates = AKrasovaReservationDates.plusMonths(1);
        }

        for (int i = 0; i<4;i++){
            Booking newBookingABC = new Booking(ABCreservationDates.format(formatter),ABCreservationDates.plusDays(3).format(formatter),List.of(room2),List.of(guestId5));
            bookingManager.add(newBookingABC);
            ABCreservationDates = ABCreservationDates.plusDays(7);
        }

        System.out.println(bookingManager.getDescription()
                +"\n"+bookingManager.getNumberOfBookings()+"\n"+bookingManager.getNumberOfWorkingBookings()
                +"\n"+bookingManager.getAverageNumberOfGuests()+"\n"+bookingManager.getFirstEightRecreationalBookings()
                +"\n"+bookingManager.getNumberOfOneDayStaysBookings()+"\n"+bookingManager.getNumberOfTwoDaysStaysBookings()
                +"\n"+bookingManager.getNumberOfMoreThanTwoDaysStaysBookings()+"\n"+bookingManager.getPriceOfBooking());
    }
}

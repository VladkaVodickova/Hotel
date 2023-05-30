package engeto.java.lesson2.and.lesson3;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

    public BookingManager(){
        bookingList = new ArrayList<>();
    }

    public List<Booking> getBookingOfRoomList() {
        return bookingList;
    }

    public void add (Booking newBooking){
        bookingList.add(newBooking);
    }

    public void add (List<Booking> newBookingList){
        bookingList.addAll(newBookingList);
    }

    public String getDescription (){
        StringBuilder description = new StringBuilder();
        for (Booking booking : bookingList){
            //description.append(booking.getDescription()).append("\n");
            description.append(booking.getDescription());
        }
        //description.append("\n-----------------------------------------------------------------------------------------------------------------------\n");
        return description.toString();
    }
    public int getNumberOfBookings (){
        /*int numberOfBookings = 1 ;
        for (Booking booking : bookingList) {
             numberOfBookings++;
        }
        //return "\n"+ "Number of bookings: " + numberOfBookings + "\n\n";
        return numberOfBookings;
         */
        return bookingList.size();
    }

    public String getNumberOfWorkingBookings (){
        int numberOFWorkingBookings = 0 ;
        for (Booking booking : bookingList) {
            if (booking.getTypeOfVacationForGuest()== Booking.TypeOfVacation.WORKING){
                numberOFWorkingBookings++;
            }
        }
        return "\n"+ "Number of working bookings: " + numberOFWorkingBookings + "\n\n";
    }

    public double getAverageNumberOfGuests(){
        double numberOfGuests = 0;
        for (Booking booking: bookingList){
            numberOfGuests += booking.getGuestsList().size();
        }
        return numberOfGuests/(double) getNumberOfBookings();
    }
    public String getFirstEightRecreationalBookings(){
        StringBuilder listOfFirstEightRecreationalBookings = new StringBuilder();
        int counter = 0;
        for (Booking booking : bookingList) {
            if (booking.getTypeOfVacationForGuest()== Booking.TypeOfVacation.RECREATIONAL){
                listOfFirstEightRecreationalBookings.append(booking.getDescription());
                counter++;
            }
            if (counter==8){
                break;
            }
        }
        return listOfFirstEightRecreationalBookings.toString();
    }

    public int getNumberOfOneDayStaysBookings (){
        int numberOfOneDayBookings = 0 ;
        for (Booking booking : bookingList) {
            if (booking.getStartOfBooking().plusDays(1).format(formatter).equals(booking.getEndOfBooking().format(formatter))){
                numberOfOneDayBookings++;
            }
        }
        return numberOfOneDayBookings;
    }

    public int getNumberOfTwoDaysStaysBookings(){
        int numberOfTwoDayBookings = 0 ;
        for (Booking booking : bookingList) {
            if (booking.getStartOfBooking().plusDays(2).format(formatter).equals(booking.getEndOfBooking().format(formatter))){
                numberOfTwoDayBookings++;
            }
        }
        return numberOfTwoDayBookings;
    }

    public int getNumberOfMoreThanTwoDaysStaysBookings(){
        int numberOfMoreThanTwoDaysStaysBookings = 0 ;
        for (Booking booking : bookingList) {
            if (ChronoUnit.DAYS.between(booking.getStartOfBooking(), booking.getEndOfBooking()) > 2){
                numberOfMoreThanTwoDaysStaysBookings++;
            }
        }
        return numberOfMoreThanTwoDaysStaysBookings;
    }

    public String getPriceOfBooking (){
        StringBuilder priceOfBooking = new StringBuilder();
        for (Booking booking: bookingList) {
            priceOfBooking.append(booking.getDescriptionForPricing()).append(booking.getNumberOfDays())
                    .append(" night(s) from  ").append(booking.getStartOfBooking()).append(" for ").append(booking.getPrice())
                    .append(" Kč").append("\n");
        }
        return priceOfBooking.toString() + "\n";
    }
}

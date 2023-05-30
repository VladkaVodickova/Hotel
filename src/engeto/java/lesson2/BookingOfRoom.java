package engeto.java.lesson2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingOfRoom {
    public enum TypeOfVacation {
        WORKING,
        RECREATIONAL
    }

    private int numberOfGuests;
    private LocalDate startOfBooking;
    private LocalDate endOfBooking;
    private TypeOfVacation typeOfVacationForGuest;
    private List<HotelRoom> hotelRoomList;
    private List<Guest> guestList;

    public BookingOfRoom(int numberOfGuests, String startOfBookingStr, String endOfBookingStr, TypeOfVacation typeOfVacationForGuest, List<HotelRoom> hotelRoomList, List<Guest> guestList) {
        setNumberOfGuests(numberOfGuests);
        setStartOfBooking(startOfBookingStr);
        setEndOfBooking(endOfBookingStr);
        this.typeOfVacationForGuest = typeOfVacationForGuest;
        this.hotelRoomList = hotelRoomList;
        this.guestList = guestList;
    }

    public BookingOfRoom(int numberOfGuests, String startOfBookingStr, String endOfBookingStr, List<HotelRoom> hotelRoomList, List<Guest> guestList) {
        setNumberOfGuests(numberOfGuests);
        setStartOfBooking(startOfBookingStr);
        setEndOfBooking(endOfBookingStr);
        this.hotelRoomList = hotelRoomList;
        this.guestList = guestList;
    }

    //getters
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public LocalDate getStartOfBooking() {
        return startOfBooking;
    }

    public LocalDate getEndOfBooking() {
        return endOfBooking;
    }

    public TypeOfVacation getTypeOfVacationForGuest() {
        return typeOfVacationForGuest;
    }

    public List<HotelRoom> getHotelRoomsList() {
        return hotelRoomList;
    }

    public List<Guest> getGuestsList() {
        return guestList;
    }

    //setters
    public void setNumberOfGuests(int numberOfGuests) {
        if(numberOfGuests > 0 && numberOfGuests <= 10){
            this.numberOfGuests = numberOfGuests;
        } else {
            throw new IllegalArgumentException("Enter valid number of quests which is from 1 to 10.");
        }
    }

    public void setStartOfBooking(String startOfBookingStr) {
        // pozn. pro kontrolujiciho - vlozila bych sem podminku, aby sli vytvorit pouze objednavky ode dneska dale do budoucnosti,
        // kdyby se vsak stalo, ze v hotelu nekdy spadne system, tak by neslo nikdy zpetne zapsat takovou objednavku,
        // proto to necham pouze takto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate startOfBooking = LocalDate.parse(startOfBookingStr, formatter);
        this.startOfBooking = startOfBooking;
    }

    public void setEndOfBooking(String endOfBookingStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate endOfBooking = LocalDate.parse(endOfBookingStr, formatter);
        if (endOfBooking.isAfter(startOfBooking)){
            this.endOfBooking = endOfBooking;
        } else {
         throw new IllegalArgumentException("Enter valid end of booking period. This date needs to be after the start of the booking.");
        }
    }

    public void setTypeOfVacationForGuest(TypeOfVacation typeOfVacationForGuest) {
        this.typeOfVacationForGuest = typeOfVacationForGuest;
    }

    public void setHotelRoomsList(List<HotelRoom> hotelRoomList) {
        this.hotelRoomList = hotelRoomList;
    }

    public void setGuestsList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public String getDescription (){
        StringBuilder description = new StringBuilder();
        description.append("Number of Guest: ").append(this.numberOfGuests).append(" ");
        for (Guest guest : guestList){
            description.append(guest.getDescription()).append("\n");
        }
        for (HotelRoom room : hotelRoomList){
            description.append(room.getDescription()).append("\n");
        }
        description.append("Start of the Booking: ").append(startOfBooking).append("\tEnd of the Booking: ").append(endOfBooking).append("\n-----------------------------------------------------------------------------------------------------------------------\n");
        return description.toString();
    }
}

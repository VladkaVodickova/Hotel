package engeto.java.lesson2.and.lesson3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Booking {
    public enum TypeOfVacation {
        WORKING,
        RECREATIONAL
    }

    private LocalDate startOfBooking;
    private LocalDate endOfBooking;
    private TypeOfVacation typeOfVacationForGuest;
    private List<HotelRoom> hotelRoomList;
    private List<Guest> guestList;

    public Booking(String startOfBookingStr, String endOfBookingStr, TypeOfVacation typeOfVacationForGuest, List<HotelRoom> hotelRoomList, List<Guest> guestList) {
        setStartOfBooking(startOfBookingStr);
        setEndOfBooking(endOfBookingStr);
        this.typeOfVacationForGuest = typeOfVacationForGuest;
        this.hotelRoomList = hotelRoomList;
        this.guestList = guestList;
    }

    public Booking(String startOfBookingStr, String endOfBookingStr, List<HotelRoom> hotelRoomList, List<Guest> guestList) {
        setStartOfBooking(startOfBookingStr);
        setEndOfBooking(endOfBookingStr);
        this.hotelRoomList = hotelRoomList;
        this.guestList = guestList;
    }

    //getters

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
        description.append("\n").append(startOfBooking).append(" to ").append(endOfBooking).append(": ");
        for (Guest guest : guestList){
            //description.append(guest.getDescription()).append("\n");
            description.append(guest.getDescription());
        }
        for (HotelRoom room : hotelRoomList){
            //description.append(room.getDescription()).append("\n");
            description.append(room.getDescription());
        }
        //description.append("Start of the Booking: ").append(startOfBooking).append("\tEnd of the Booking: ").append(endOfBooking).append("\n-----------------------------------------------------------------------------------------------------------------------\n");
        return description.toString();
    }

    public BigDecimal getNumberOfDays(){
        BigDecimal numberOfDays = new BigDecimal(ChronoUnit.DAYS.between(getStartOfBooking(), getEndOfBooking())) ;
        return numberOfDays;
    }

    public BigDecimal getPrice(){
        BigDecimal price = new BigDecimal(0);
        for (HotelRoom room: hotelRoomList){
           price = price.add(room.getPricePerNight()) ;
           price = price.multiply(getNumberOfDays());
        }
        return price;
    }

    public String getDescriptionForPricing (){
        StringBuilder description = new StringBuilder();
        for (Guest guest : guestList){
            description.append(guest.getDescriptionForPricing());
        }
        for (HotelRoom room : hotelRoomList){
            description.append(room.getDescriptionForPricing());
        }
        return description.toString();
    }
    /* námět na úpravu:
    setStartOfBooking ... je nějaký důvod, proč datum zadávat jako textový řetězec?
    Chápal bych, pokud by se to četlo ze vstupního pole v GUI nebo ze souboru.
    Ta metoda tedy určitě smysl dává. Ale pokud ta data zadáváš v kódu, tak bych tam dal jako parametr normálně LocalDate.
    (Rozumím tomu tak, že tam chceš zadávat datum v národním formátu, nikoli v anglickém. OK, ale stejně bych tam primárně dával objekty LocalDate.)
     */
}

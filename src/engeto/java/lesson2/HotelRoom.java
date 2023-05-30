package engeto.java.lesson2;

import java.math.BigDecimal;

public class HotelRoom {
    private int numberOfHotelRoom;
    private int numberOfBeds;
    private boolean haveBalcony;
    private boolean haveViewToSea;
    private BigDecimal pricePerNight;

    public HotelRoom(int numberOfHotelRoom, int numberOfBeds, boolean haveBalcony, boolean haveViewToSea, BigDecimal pricePerNight) {
        setNumberOfHotelRoom(numberOfHotelRoom);
        setNumberOfBeds(numberOfBeds);
        this.haveBalcony = haveBalcony;
        this.haveViewToSea = haveViewToSea;
        setPricePerNight(pricePerNight);
    }

    //getter
    public int getNumberOfHotelRoom() {
        return numberOfHotelRoom;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isHaveBalcony() {
        return haveBalcony;
    }

    public boolean isHaveViewToSea() {
        return haveViewToSea;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    //setter
    public void setNumberOfHotelRoom(int numberOfHotelRoom) {
        if (numberOfHotelRoom > 0){
            this.numberOfHotelRoom = numberOfHotelRoom;
        } else {
            throw new IllegalArgumentException("Enter correct room number.");
        }
    }

    public void setNumberOfBeds(int numberOfBeds) {
        if (numberOfBeds > 0){
            this.numberOfBeds = numberOfBeds;
        } else {
            throw new IllegalArgumentException("Enter correct number of beds.");
        }
    }

    public void setHaveBalcony(boolean haveBalcony) {
        this.haveBalcony = haveBalcony;
    }

    public void setHaveViewToSea(boolean haveViewToSea) {
        this.haveViewToSea = haveViewToSea;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        if (pricePerNight.compareTo(BigDecimal.ZERO) > 0 && pricePerNight.compareTo(new BigDecimal("1000000")) < 0 ){
            this.pricePerNight = pricePerNight;
        } else {
            throw new IllegalArgumentException("Enter correct price of room per night.");
        }
    }

    public String getDescription (){
            return "\nRoom Number: " + this.numberOfHotelRoom + "\tNumber of Beds: " + this.numberOfBeds + "\tHave Balcony: " + this.haveBalcony + "\tHave View to a Sea: " + this.haveViewToSea + "\nPrice per Night: " + this.pricePerNight + " Kč";
        }
}


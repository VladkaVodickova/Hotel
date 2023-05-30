package engeto.java.lesson2.and.lesson3;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String nameOfTravelCompany;
    private String firstName;
    private String lastName;
    private String fullName;
    private LocalDate dateOfBirth;

    //constructor of must information
    public Guest(String firstName, String lastName, String dateOfBirthStr){
        setFirstName(firstName);
        setLastName(lastName);
        fullName = firstName + " " + lastName;
        setDateOfBirth(dateOfBirthStr);
    }
    public Guest (String nameOfTravelCompany){
        setNameOfTravelCompany(nameOfTravelCompany);
    }

    //getters
    public String getNameOfTravelCompany() {
        return nameOfTravelCompany;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        //if (dateOfBirth==null){return null;}
        Period period = Period.between(dateOfBirth, LocalDate.now());
        return period.getYears();
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    //setters
    public void setNameOfTravelCompany(String nameOfTravelCompany) {
        if (nameOfTravelCompany.isEmpty()){
            throw new IllegalArgumentException("Enter valid company name.");
        }

        this.nameOfTravelCompany = nameOfTravelCompany;
    }

    public void setFirstName(String firstName){
        if (firstName.isEmpty()){
            throw new IllegalArgumentException("Enter valid first name.");
        }

        this.firstName=firstName;
    }

    public void setLastName(String lastName){
        if (lastName.isEmpty()){
            throw new IllegalArgumentException("Enter valid last name.");
        }

        this.lastName=lastName;
    }

    public void setDateOfBirth(String dateOfBirthStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
        if (dateOfBirth.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Enter correct date of birth.");
        } else {
            this.dateOfBirth=dateOfBirth;
        }
    }

    public String getDescription (){
        if (fullName == null){
            //return "\nName:" + this.nameOfTravelCompany;
            return this.nameOfTravelCompany;
        }
        //return "\nName:" + this.fullName + "\nDate of Birth: " + this.dateOfBirth + "\nAge: " + getAge();
        return this.fullName + " (" + this.dateOfBirth + ") ";
    }

    public String getDescriptionForPricing (){
        if (fullName == null){
            //return "\nName:" + this.nameOfTravelCompany;
            return this.nameOfTravelCompany + " ";
        }
        //return "\nName:" + this.fullName + "\nDate of Birth: " + this.dateOfBirth + "\nAge: " + getAge();
        return this.fullName + " ";
    }
}

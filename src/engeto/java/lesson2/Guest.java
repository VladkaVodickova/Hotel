package engeto.java.lesson2;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Guest {
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

    //getters
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        Period period = Period.between(dateOfBirth, LocalDate.now());
        int age = period.getYears();
        return age;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    //setters
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
            return "\nName:" + this.fullName + "\nDate of Birth: " + this.dateOfBirth + "\nAge: " + getAge();
    }
}
//nutne dodelat metodu na spocitani veku

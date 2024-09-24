package Coursework;

public class Customer {
    private String firstName;
    private String lastName;

    // Getting the first name using the getter method
    public String getFirstName() {
        return firstName;
    }

    // Getter method to retrieve the last name
    public String getLastName() {
        return lastName;
    }

    // Setter method to set the first name
    public void setFirstName(String Fname) {
        this.firstName = Fname;
    }

    // Setter method to set the last name
    public void setLastName(String Lname) {
        this.lastName = Lname;
    }
}
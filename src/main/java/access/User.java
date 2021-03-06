package access;

public class User {

    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private String password;


    public User() {
        name = "";
        surName = "";
        phoneNumber = "";
        email = "";
        password = "";
    }

    @Override
    public String toString() {
        return "  1. First name: " + name + "\n" +
                "  2. Last name: " + surName + "\n" +
                "  3. Phone Number: " + phoneNumber + "\n" +
                "  4. Email: " + email + "\n" +
                "  5. Password: " + password + "\n";
    }

    //----------- Getters & Setters -----------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return surName;
    }

    public void setLastName(String surName) {
        this.surName = surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
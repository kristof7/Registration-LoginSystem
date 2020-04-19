package access;

public class Admin {

    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private String password;

    public Admin(String name, String surName, String phoneNumber, String email, String password) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return  "  1. First name: " + name + "\n" +
                "  2. Last name: " + surName + "\n" +
                "  3. Phone Number: " + phoneNumber + "\n" +
                "  4. Email: " + email + "\n" +
                "  5. Password: " + password + "\n";
    }

    //----------- Getters & Setters -----------
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}

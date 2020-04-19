package access;

import java.util.Scanner;

public class Registration {
    Scanner scanner = new Scanner(System.in);
    private boolean isTrue = true;

    // ----------------- Registration methods -----------------
    public void userSetName(User user) {

        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("1. First name: ");
                String name = scanner.nextLine();
                user.setName(name);
                System.out.println(user);
                System.out.println("Your name is: " + name);
                System.out.println("----------------------------------------");
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetLastName(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("2. Last name: ");
                String lastName = scanner.nextLine();
                user.setLastName(lastName);
                System.out.println(user);
                System.out.println("Your last name is: " + lastName);
                System.out.println("----------------------------------------");
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetPhoneNumber(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("3. Phone number: ");
                String phoneNumber = scanner.nextLine();
                user.setPhoneNumber(phoneNumber);
                System.out.println(user);
                System.out.println("Your phone number is: " + phoneNumber);
                System.out.println("----------------------------------------");
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetEmail(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("4. Email: ");
                String email;
                do {
                    email = scanner.nextLine();
                    if (!Check.checkEmail(email)) {
                        System.out.println("Your email is not valid, try again: ");
                        isTrue = false;
                    } else isTrue = true;
                } while (!isTrue);
                user.setEmail(email);
                System.out.println(user);
                System.out.println("Your email is: " + email);
                System.out.println("----------------------------------------");
                if (Check.checkEmail(email)) {
                    isTrue = true;
                } else isTrue = false;
                System.out.println("Email is not valid");
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }

    public void userSetPassword(User user) {
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("5. Password: ");
                String password = scanner.nextLine();
                user.setPassword(password);
                System.out.println(user);
                System.out.println("Your password is: " + password);
                System.out.println("----------------------------------------");
            } catch (Exception e) {
                System.out.println("its not valid value");
                isTrue = false;
            }
        } while (!isTrue);
    }
}
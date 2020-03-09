package accountAccess;

import menu.Menu;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationService extends User {

    public static void registration() throws IOException {

        System.out.println("\n" + "CREATE AN ACCOUNT" + "\n");
        System.out.println("To register, fill in the fields below:");
        System.out.println("----------------------------------------");

        User user = new User();
        userRegistration(user);
    }

    public static void userRegistration(User user) throws IOException {
        Users users = JsonConverterUsers.readUsersJsonFile();

        Scanner scanner;

        boolean isRegistrationValid = true;
        boolean isReturn;
        int choose = 1;
        do {
            Registration registration = new Registration();

            System.out.println("Choose number: ");
            System.out.println("1 First name: " + user.getName());
            System.out.println("2 Last name: " + user.getLastName());
            System.out.println("3 Phone number: " + user.getPhoneNumber());
            System.out.println("4 Email(used to login): " + user.getEmail());
            System.out.println("5 Password: " + user.getPassword());
            System.out.println("6 Save");
            System.out.println("7 Exit");
            do {
                try {
                    scanner = new Scanner(System.in);
                    choose = scanner.nextInt();
                    isReturn = false;
                } catch (Exception e) {
                    System.out.println("Wrong value");
                    isReturn = true;
                }
            } while (isReturn);

            switch (choose) {
                case 1:
                    registration.userSetName(user);
                    userRegistration(user);
                case 2:
                    registration.userSetLastName(user);
                    userRegistration(user);
                case 3:
                    registration.userSetPhoneNumber(user);
                    userRegistration(user);
                case 4:
                    registration.userSetEmail(user);
                    userRegistration(user);
                case 5:
                    registration.userSetPassword(user);
                    userRegistration(user);
                case 6:
                    scanner = new Scanner(System.in);
                    System.out.println("Your account:");
                    System.out.println(user);
                    System.out.println("Is it correct? (y/n)");

                    System.out.println("----------------------------------------");
                    String isCorrect = scanner.nextLine();

                    if (isCorrect.equals("y") || isCorrect.equals("Y")) {
                        users.add(user);
                        JsonConverterUsers.saveUsersToJsonFile(users);

                        System.out.println("Number of users: " + users.getUsers().size());
                        System.out.println("Thank you, your account has been registered :)");
                        System.out.println("Would you like to register new account? (y/n)");
                        isCorrect = scanner.nextLine();
                        System.out.println("----------------------------------------");
                        if (isCorrect.equals("y") || isCorrect.equals("Y")) {
                            RegistrationService.registration();
                        }
                    } else if (isCorrect.equals("n") || isCorrect.equals("N")) {
                        isRegistrationValid = false;
                        userRegistration(user);
                    }
                case 7:

            }

        } while (!isRegistrationValid);
        Menu.showMainMenu();
    }

}

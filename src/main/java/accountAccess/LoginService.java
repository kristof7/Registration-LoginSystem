package accountAccess;

import menu.LoggedUserMenu;
import menu.Menu;

import java.io.IOException;
import java.util.Scanner;

public class LoginService extends User {

    static Scanner scanner = new Scanner(System.in);

    public static void login() throws IOException {
        System.out.println("Login to your account");
        System.out.println("Choose number: ");
        System.out.println("1 Login ");
        System.out.println("2 Exit ");

        boolean isReturn;
        int choose = 0;
        do {
            try {
                scanner = new Scanner(System.in);
                choose = scanner.nextInt();
                isReturn = false;
            } catch (Exception e) {
                System.out.println("Wrong value, try again: ");
                isReturn = true;
            }
        } while (isReturn);

        switch (choose) {
            case 1:
                userLogin();
            case 2:
                Menu.showMainMenu();
        }
    }

    public static void userLogin() {
        scanner = new Scanner(System.in);
        Users users = JsonConverterUsers.readUsersJsonFile();
        boolean isLogged = false;
        do {
            System.out.println("Enter e-mail:");
            String email = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();

            for (int i = 0; i < users.getUsers().size(); i++) {
                boolean isTrueEmail = users.getUsers().get(i).getEmail().equals(email) && Check.checkEmail(users.getUsers().get(i).getEmail());
                boolean isTruePass = users.getUsers().get(i).getPassword().equals(password);
                if (isTrueEmail && isTruePass) {
                    System.out.println("Login successful..");
                    LoggedUserMenu.showUserMenu();
                    isLogged = true;
                    break;
                } else
                    isLogged = false;
            }
            if (isLogged == false) {
                System.out.println("Wrong login or password");
            }
        } while (!isLogged);
    }
}

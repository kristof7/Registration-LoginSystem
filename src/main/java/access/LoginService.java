package access;

import menu.LoggedUserMenu;
import menu.Menu;

import java.io.IOException;
import java.util.Scanner;

public class LoginService extends User {

    static Scanner scanner = new Scanner(System.in);

    public static void login() throws IOException {
        System.out.println("Login to your account");
        System.out.println("Choose number: ");
        System.out.println("1 Login as Administrator ");
        System.out.println("2 Login as User ");
        System.out.println("3 Return to main menu ");

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
                adminLogin();
            case 2:
                userLogin();
            case 3:
                Menu.showMainMenu();
        }
    }

    public static void userLogin() {
        scanner = new Scanner(System.in);
        Users users = JsonConverterUsers.readUsersJsonFile();
        boolean isLogged = false;
        do {
            System.out.println("Enter Login(Your name)");
            String login = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();

            for (int i = 0; i < users.getUsers().size(); i++) {
                boolean isTrueName = users.getUsers().get(i).getName().equals(login);
                boolean isTruePass = users.getUsers().get(i).getPassword().equals(password);
                if (isTrueName && isTruePass) {
                    System.out.println("Login Successful..");
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
    public static void adminLogin() {
        scanner = new Scanner(System.in);
        Admins admins = JsonConverterAdmins.readAdminsJsonFile();
        boolean isLogged = false;
        do {
            System.out.println("Enter Login(Your name)");
            String login = scanner.nextLine();
            System.out.println("Wpisz hasło:");
            String password = scanner.nextLine();

            for (int i = 0; i < admins.getAdmins().size(); i++) {
                boolean isTrueName = admins.getAdmins().get(i).getName().equals(login);
                boolean isTruePass = admins.getAdmins().get(i).getPassword().equals(password);
                if (isTrueName && isTruePass) {
                    System.out.println("Logowanie poprawne...");
                    LoggedUserMenu.showUserMenu();
                    isLogged = true;
                    break;
                } else
                    isLogged = false;
            }
            if (isLogged == false) {
                System.out.println("Zły login lub hasło");
            }
        } while (!isLogged);
    }
}

package menu;

import access.LoginService;
import access.RegistrationService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner inputValue = new Scanner(System.in);

    public static void showMainMenu() throws IOException {
        Scanner scanner;
        System.out.println("1 Register new account ");
        System.out.println("2 Log in ");
        boolean isReturn;
        int choose = 1;
        do {
            try {
                scanner = new Scanner(System.in);
                choose = scanner.nextInt();
                isReturn = false;
            } catch (Exception e) {
                System.out.println("Something went wrong.. ");
                isReturn = true;
            }
        } while (isReturn);

        switch (choose) {
            case 1:
                RegistrationService.registration();
            case 2:
                try {
                    LoginService.login();
                } catch (Exception e) {
                    System.out.println("something went wrong..");
                }
        }
    }
}

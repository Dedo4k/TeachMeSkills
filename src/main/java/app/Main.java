package app;

import app.service.IOService;
import app.service.ManageService;
import app.service.MenuService;

public class Main {

    static IOService ioService = new IOService();
    static MenuService menuService = new MenuService();
    static ManageService manageService = new ManageService();
    static boolean flag = true;

    public static void main(String[] args) {

        while (flag) {
            System.out.println("\nMenu:");
            menuService.mainMenu();
            int choice = ioService.getInt();
            switch (choice) {
                case 1: {
                    System.out.println("\nAll people:");
                    manageService.printAllPeople();
                    break;
                }
                case 2: {
                    System.out.println("\nPosition list:");
                    manageService.printAllPositions();
                    break;
                }
                case 3: {
                    System.out.println("\nShop list:");
                    manageService.printAllShops();
                    break;
                }
                case 4: {
                    System.out.println("\nManage menu:");
                    menuService.manageMenu();
                    choice = ioService.getInt();
                    switch (choice) {
                        case 1: {
                            manageService.managePeople();
                            break;
                        }
                        case 2: {
                            manageService.managePositions();
                            break;
                        }
                        case 3: {
                            manageService.manageShops();
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    flag = false;
                    break;
                }
            }
        }
    }
}

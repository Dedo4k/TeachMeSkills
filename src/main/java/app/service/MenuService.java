package app.service;

public class MenuService {

    public void mainMenu() {
        System.out.println("[1] Print all people.");
        System.out.println("[2] Print position list.");
        System.out.println("[3] Print shop list.");
        System.out.println("[4] Manage menu.");
        System.out.println("[5] Exit.");
    }

    public void manageMenu() {
        System.out.println("[1] People manage.");
        System.out.println("[2] Position manage.");
        System.out.println("[3] Shop manage.");
    }

    public void managePeople() {
        System.out.println("[1] Add new person.");
        System.out.println("[2] Get person.");
        System.out.println("[3] Update person.");
        System.out.println("[4] Delete person.");
        System.out.println("[5] Exit.");
    }

    public void managePosition() {
        System.out.println("[1] Add new position.");
        System.out.println("[2] Get position.");
        System.out.println("[3] Update position.");
        System.out.println("[4] Delete position.");
        System.out.println("[5] Exit.");
    }

    public void manageShop() {
        System.out.println("[1] Add new shop.");
        System.out.println("[2] Get shop.");
        System.out.println("[3] Update shop.");
        System.out.println("[4] Delete shop.");
        System.out.println("[5] Exit.");
    }
}

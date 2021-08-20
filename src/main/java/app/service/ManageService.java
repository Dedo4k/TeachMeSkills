package app.service;

import app.dao.PersonDAO;
import app.dao.PositionDAO;
import app.dao.ShopDAO;
import app.model.Person;
import app.model.Position;
import app.model.Shop;

import java.util.Scanner;

public class ManageService {

    private final PersonDAO personDAO = new PersonDAO();
    private final PositionDAO positionDAO = new PositionDAO();
    private final ShopDAO shopDAO = new ShopDAO();
    private final MenuService menuService = new MenuService();
    private final IOService ioService = new IOService();

    public void printAllPeople() {
        personDAO.readAll().forEach(System.out::println);
    }

    public void printAllPositions() {
        positionDAO.readAll().forEach(System.out::println);
    }

    public void printAllShops() {
        shopDAO.readAll().forEach(System.out::println);
    }

    public void managePeople() {
        boolean flag = true;
        while (flag) {
            System.out.println("\nPeople manage menu:");
            menuService.managePeople();
            int choice = ioService.getInt();
            switch (choice) {
                case 1: {
                    addNewPerson();
                    break;
                }
                case 2: {
                    getPerson();
                    break;
                }
                case 3: {
                    updatePerson();
                    break;
                }
                case 4: {
                    deletePerson();
                    break;
                }
                case 5: {
                    flag = false;
                    break;
                }
            }
        }
    }

    public void managePositions() {
        boolean flag = true;
        while (flag) {
            System.out.println("\nPositions manage menu:");
            menuService.managePosition();
            int choice = ioService.getInt();
            switch (choice) {
                case 1: {
                    addNewPosition();
                    break;
                }
                case 2: {
                    getPosition();
                    break;
                }
                case 3: {
                    updatePosition();
                    break;
                }
                case 4: {
                    deletePosition();
                    break;
                }
                case 5: {
                    flag = false;
                    break;
                }
            }
        }
    }

    public void manageShops() {
        boolean flag = true;
        while (flag) {
            System.out.println("\nShops manage menu:");
            menuService.manageShop();
            int choice = ioService.getInt();
            switch (choice) {
                case 1: {
                    addNewShop();
                    break;
                }
                case 2: {
                    getShop();
                    break;
                }
                case 3: {
                    updateShop();
                    break;
                }
                case 4: {
                    deleteShop();
                    break;
                }
                case 5: {
                    flag = false;
                    break;
                }
            }
        }
    }

    private void addNewPerson() {
        Person person = new Person();
        System.out.print("\nEnter name: ");
        String firstName = new Scanner(System.in).nextLine();
//        String firstName = ioService.getString();         //хз почему не работает
        System.out.print("Choose a position:\n");
        printAllPositions();
        int choice = ioService.getInt();
        Position position = (Position) positionDAO.read(choice);
        if(position == null) {
            System.out.println("Position with id=" + choice + " doesn't exist.");
            return;
        }
        person.setFirstName(firstName);
        person.setPositionId(position.getId());
        personDAO.insert(person);
    }

    private void getPerson() {
        System.out.print("\nEnter person id: ");
        int id = ioService.getInt();
        Person person = (Person) personDAO.read(id);
        if(person == null) {
            System.out.println("Person with id=" + id + " doesn't exist.");
            return;
        }
        System.out.println(person.toString());
    }

    private void updatePerson() {
        System.out.print("\nEnter person id to update: ");
        int id = ioService.getInt();
        Person person = new Person();
        System.out.print("Enter name: ");
        String firstName = new Scanner(System.in).nextLine();
//        String firstName = ioService.getString();
        System.out.print("Choose a position:\n");
        printAllPositions();
        int choice = ioService.getInt();
        Position position = (Position) positionDAO.read(choice);
        if(position == null) {
            System.out.println("Position with id=" + choice + " doesn't exist.");
            return;
        }
        person.setFirstName(firstName);
        person.setPositionId(position.getId());
        personDAO.update(id, person);
    }

    private void deletePerson() {
        System.out.print("\nEnter person id to delete: ");
        int id = ioService.getInt();
        personDAO.delete(id);
    }

    private void addNewPosition() {
        Position position = new Position();
        System.out.print("\nEnter position: ");
        String positionName = new Scanner(System.in).nextLine();
//        String firstName = ioService.getString();         //хз почему не работает
        System.out.print("Choose a shop:\n");
        printAllShops();
        int choice = ioService.getInt();
        Shop shop = (Shop) shopDAO.read(choice);
        if(shop == null) {
            System.out.println("Shop with id=" + choice + " doesn't exist.");
            return;
        }
        position.setPosition(positionName);
        position.setShopId(shop.getId());
        positionDAO.insert(position);
    }

    private void getPosition() {
        System.out.print("\nEnter position id: ");
        int id = ioService.getInt();
        Position position = (Position) positionDAO.read(id);
        if(position == null) {
            System.out.println("Position with id=" + id + " doesn't exist.");
            return;
        }
        System.out.println(position.toString());
    }

    private void updatePosition() {
        System.out.print("\nEnter position id to update: ");
        int id = ioService.getInt();
        Position position = new Position();
        System.out.print("\nEnter position: ");
        String positionName = new Scanner(System.in).nextLine();
//        String firstName = ioService.getString();         //хз почему не работает
        System.out.print("Choose a shop:\n");
        printAllShops();
        int choice = ioService.getInt();
        Shop shop = (Shop) shopDAO.read(choice);
        if(shop == null) {
            System.out.println("Shop with id=" + choice + " doesn't exist.");
            return;
        }
        position.setPosition(positionName);
        position.setShopId(shop.getId());
        positionDAO.update(id, position);
    }

    private void deletePosition() {
        System.out.print("\nEnter position id to delete: ");
        int id = ioService.getInt();
        positionDAO.delete(id);
    }

    private void addNewShop() {
        Shop shop = new Shop();
        System.out.print("\nEnter title: ");
        String shopName = new Scanner(System.in).nextLine();
//        String firstName = ioService.getString();         //хз почему не работает
        shop.setTitle(shopName);
        shopDAO.insert(shop);
    }

    private void getShop() {
        System.out.print("\nEnter shop id: ");
        int id = ioService.getInt();
        Shop shop = (Shop) shopDAO.read(id);
        if(shop == null) {
            System.out.println("Shop with id=" + id + " doesn't exist.");
            return;
        }
        System.out.println(shop.toString());
    }

    private void updateShop() {
        System.out.print("\nEnter shop id to update: ");
        int id = ioService.getInt();
        Shop shop = new Shop();
        System.out.print("\nEnter title: ");
        String shopName = new Scanner(System.in).nextLine();
//        String firstName = ioService.getString();         //хз почему не работает
        shop.setTitle(shopName);
        shopDAO.update(id, shop);
    }

    private void deleteShop() {
        System.out.print("\nEnter shop id to delete: ");
        int id = ioService.getInt();
        shopDAO.delete(id);
    }
}

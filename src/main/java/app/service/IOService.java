package app.service;

import java.util.Scanner;

public class IOService {

    private static final Scanner sc = new Scanner(System.in);

    public int getInt() {
        while (!sc.hasNextInt()) {
            sc.next();
        }
        return sc.nextInt();
    }

    public String getString() {
        while (!sc.hasNextLine()) {
            sc.next();
        }
        return sc.nextLine();
    }
}

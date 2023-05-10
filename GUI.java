import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GUI {
    private DataBase DB = new DataBase();

    GUI() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    DB.RegisterUser(scanner);
                    break;
                case 2:
                    DB.Login(scanner);
                    break;
                case 3:
                    DB.save();
                    System.exit(0);

                    break;
                case 4:
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}